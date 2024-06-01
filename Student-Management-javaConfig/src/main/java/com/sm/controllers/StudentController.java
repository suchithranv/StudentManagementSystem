package com.sm.controllers;

import java.awt.Color;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


//controller will talk with service layer

import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

//This is a presentation layer. controller job is to return the view.

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.sm.api.ChatData;
import com.sm.api.Student;
import com.sm.helper.UserExcelExporter;
import com.sm.helper.UserPDFExporter;
import com.sm.service.CreateChart;
import com.sm.service.StudentService;

import fusioncharts.FusionCharts;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class StudentController {

	private static final Logger log = LogManager.getLogger(StudentController.class.getName()); 
	// getName will return the class name

	@Autowired // it will inject "new StudentServiceImpl();" here
	private StudentService studentService;
	
	@Autowired // it will inject "new CreateChart();" here
	private CreateChart createChart;

	@Autowired
	private JavaMailSender mailSender;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String start() {
		log.info("------------------start method is called on / mapping");
		return "login";

	}

	@RequestMapping(value = "/showLogin", method = RequestMethod.GET)
	public String showLogin() {
		log.info("------------------showLogin() method is called on /showLogin mapping");
		return "login";

	}

	
	@RequestMapping(value = "/showDashboard", method = RequestMethod.GET)
	public ModelAndView showDashboard() {
		log.info("------------------showDashboard method is called on /dashboardPage mapping");
		
		 // fetch student data from the database based on course
	    List<ChatData> chartDataList1 = studentService.groupStudentDataByCourse();
	    log.info("chartDataList1 :" +chartDataList1);
	    
	    List<ChatData> chartDataList2 = studentService.groupStudentDataByCountry();
	    log.info("chartDataList2 :" +chartDataList2);
	    
	    FusionCharts firstChart = createChart.prepareChart1(chartDataList1);    
	    FusionCharts secondChart = createChart.prepareChart2(chartDataList2);
	    FusionCharts thirdChart = createChart.prepareChart3(chartDataList2);
	    FusionCharts fourthChart = createChart.prepareChart4(chartDataList1);

        ModelAndView mav = new ModelAndView("dashboard"); 
        mav.addObject("chartData1", firstChart.render()); 
        mav.addObject("chartData2", secondChart.render());
        mav.addObject("chartData3", thirdChart.render());
        mav.addObject("chartData4", fourthChart.render());
        return mav;
	}

	
	
	@RequestMapping(value = "/showImport", method = RequestMethod.GET)
	public String showImport() {
		log.info("------------------showImport method is called on /showImport mapping");
		return "import-user";
	}

	@RequestMapping(value = "/processLogin", method = RequestMethod.POST)
	public String processLogin() {
		log.info("------------------processLogin method is called on /processLogin mapping");
		return "process-login";
	}
	

	@RequestMapping(value = "/processLogout", method = RequestMethod.GET)
	public String processLogout() {
		log.info("------------------procesLogout method is called on /processLogout mapping");
		return "logout";
	}

	
	@RequestMapping(value = "/processStudentLogout", method = RequestMethod.GET)
	public String processStudentLogout() {
		log.info("------------------processStudentLogout method is called on /processStudentLogout mapping");
		return "student-logout";
	}

	@RequestMapping(value = "/processStudentLogin", method = RequestMethod.POST)
	public String processStudentLogin(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpServletRequest request) {
		log.info("------------------processStudentLogin method is called on /processStudentLogin mapping");
		Student student = studentService.findByEmailAndPassword(email, password);
				if (student != null) {
					String name = student.getFname();
					HttpSession session1 = request.getSession();
					session1.setAttribute("Stname", name);
				      return "redirect:/studentInfo?emailid=" + email;
				    } else {
				      model.addAttribute("error", "Invalid username or password.");
				      return "login";
				    }
		
	}
	
	
	@RequestMapping(value = "/studentInfo", method = RequestMethod.GET)
	public String studentInfo(@RequestParam("emailid") String email, Model model) {
		log.info("------------------studentInfo method is called on /studentInfo mapping");
		Student student = studentService.getStudentByEmail(email);
		model.addAttribute("student", student);
		return "student-info";
	}
	
	
	@RequestMapping(value = "/showStudent", method = RequestMethod.GET)
	public String showStudentList(Model model) {

		log.info("------------------showStudentList method is called on /showStudent mapping");
		log.debug("------------------Calling StudentService class method called loadStudents()");
		// call StudentService method to get the data, for that create
		// implementation/interface object
		List<Student> studentList = studentService.loadStudents();

		log.info("------------------adding the captured value to model");
		// adding the captured value to model
		model.addAttribute("students", studentList);

		log.info("------------------set the studentList with model object and send it to student-list view");
		// set the studentList with model object and send it to view
		return "student-list";

	}

	@RequestMapping(value = "/addStudent", method = RequestMethod.GET)
	public String addStudent(Model model) {

		log.info("------------------addStudent method is called on /addStudent mapping");
		log.info("------------------creating Student object");
		Student student = new Student();

		log.info("------------------set the student with model object and send it to add-update-student view");
		model.addAttribute("student", student); // here Student class is used as DTO

		return "add-update-student";

	}

	@RequestMapping(value = "/saveStudent", method = RequestMethod.POST)
	// this saveStudent can be called through the addStudent or through the updateStudent,
	// if user do add operation then id should not be there, if he do update then id should be there.
	public String saveStudent(HttpSession session, @ModelAttribute("student") Student student, @RequestParam("multipartFile") MultipartFile multipartFile, Model model) throws IOException {
		log.info("------------------saveStudent method is called on /saveStudent mapping");
	    
		// controller will capture data from user, that data will be sent to Service-DAOlayer
		// get data from url , set this data to pojo , once we get the hold of that object, we can save that object
		// data binding will happen in this object : student 
		// this object must be saved to db
		model.addAttribute("multipartFile", multipartFile);
		//String loggedUser = (String) session.getAttribute("Sname");
		multipartFile = student.getMultipartFile();
        String name = multipartFile.getOriginalFilename();
		log.info("image name is  : " + name);
		//String filename = loggedUser + "_" +name;
        
		if(name != null && !name.isEmpty()) {
			try {
				String path = "C:/Users/admin/eclipse-workspace/Student-Management-javaConfig/src/main/webapp/resources/images";
				File dir = new File(path);
				log.info("directory path  : " + dir);

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath() + File.separator + name);
				log.info("server file path  : " + serverFile);

				//model.addAttribute("imagePath", serverFile);
				byte[] bytes = multipartFile.getBytes();
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// do a condition check
		// if user doesnt have an id do insert
		// if user have the id do update
		if (student.getId() == 0) {
			// do an insert
			log.info("------------------------ student id is 0, so do insert");
			log.debug("------------------------ calling saveStudent() method of StudentService class");	
			
			student.setImage(multipartFile.getBytes());
			student.setImageName(multipartFile.getOriginalFilename());
			String recipient  = student.getEmail();
			String newname  = student.getFname();
			String subject = "Account Creation";
			String message = "Hi " +newname +". Your account has been successfully created!!";
			studentService.saveStudent(student); // do a Service-DAO call to save this student object
			// Create a new MimeMessage object
			MimeMessage msg = mailSender.createMimeMessage();
			try {
				MimeMessageHelper helper = new MimeMessageHelper(msg, true);
				helper.setTo(recipient);
				helper.setSubject(subject);
				helper.setText(message);

				mailSender.send(msg);
				
			} catch (MessagingException e) {
				e.printStackTrace();
			}
			
		} else {
			// do an update
			log.info("------------------------ student id is not 0, so do update");
			log.debug("------------------------ calling update() method of StudentService class");
			log.info("--------------student information that is getting updated :" +student);
			if(name.isEmpty()) {
				int id = student.getId();
				int rollno = student.getRollno();
				String fname = student.getFname();
				String lname = student.getLname();
				String dob = student.getDob();
				String gender = student.getGender();
				String email = student.getEmail();
				String password = student.getPassword();
				Long mobile = student.getMobile();
				String course = student.getCourse();
				String country = student.getCountry();
				Student student1 = new Student(id, rollno, fname, lname, dob, gender, email, password, mobile, course, country);
				studentService.update1(student1);
			}else {
			student.setImage(multipartFile.getBytes());
			student.setImageName(multipartFile.getOriginalFilename());
			studentService.update(student);
			}
		}
		// return "redirect:/thankyou"; // in order to avoid refresh problem, redirect
		// user to thank you page
		return "redirect:/showStudent";
	}
	
	@ResponseBody
	@RequestMapping(value = "/thankyou", method = RequestMethod.GET)
	public String thankyou() {
		return "thank you ";
	}



	// Create a controller method to handle the form submission
	@RequestMapping(value = "/importExcel", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE }, method = RequestMethod.POST)
	public String importExcel(@RequestParam("excelFile") MultipartFile file) throws IOException {
		log.info("------------------importExcel method is called on /importExcel mapping");

		// Read the Excel file using the POI library
		XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		Row row;
		// Save the data to the MySQL database using JDBC Template or Hibernate
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			row = sheet.getRow(i);
			int id = (int) row.getCell(0).getNumericCellValue();
			int rollNo = (int) row.getCell(1).getNumericCellValue();
			String fname = row.getCell(2).getStringCellValue();
			String lname = row.getCell(3).getStringCellValue();
			Date date = row.getCell(4).getDateCellValue();
			String gender = row.getCell(5).getStringCellValue();
			String email = row.getCell(6).getStringCellValue();
			String password = row.getCell(7).getStringCellValue();
			Long mobile = (long) row.getCell(8).getNumericCellValue();
			String course = row.getCell(9).getStringCellValue();
			String country = row.getCell(10).getStringCellValue();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			String dob = dateFormat.format(date);
			// Save to the database using JDBC Template or Hibernate
			Student student = new Student(id, rollNo, fname, lname, dob, gender, email, password, mobile, course, country);
			studentService.saveStudent(student);

			log.info("Import rows " + i);
		}
		workbook.close();
		return "redirect:/showStudent";
	}

	@ResponseBody
	@RequestMapping(value = "/exportPdf", method = RequestMethod.GET)
	public String exportPdf(HttpServletResponse response, Model model) throws DocumentException, IOException {

		log.info("------------------ exportPdf method is called on / exportPdf mapping");

		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=students_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue); // download PDF with a given filename

		// Getting data from database
		List<Student> rows = studentService.loadStudents();

		UserPDFExporter exporter = new UserPDFExporter(rows);
		exporter.export(response);

		return "redirect:/showStudent";
	}

	@ResponseBody
	@RequestMapping(value = "/exportExcel", method = RequestMethod.GET)
	public String exportExcel(HttpServletResponse response, Model model) throws DocumentException, IOException {

		log.info("------------------ exportExcel method is called on /exportExcel mapping");

		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=students_" + currentDateTime + ".xlsx";
		response.setHeader(headerKey, headerValue); // download PDF with a given filename

		// Getting data from database
		List<Student> rows = studentService.loadStudents();
		log.info("fetched the list successfully");
		UserExcelExporter excelExporter = new UserExcelExporter(rows);
		excelExporter.export(response);

		return "redirect:/showStudent";
	}

	@RequestMapping(value = "/updateStudent", method = RequestMethod.POST)
	public String updateStudent(@RequestParam("ids") int ids,  Model model) throws IOException {

		log.info("------------------updateStudent method is called on /updateStudent mapping");
		// here Student class is used as DTO, spring will create the empty object for
		// Student

		// but we should give the user object who clicked on update button instead of
		// empty object
		// for that get the query parameter from url using @RequestParam

		// in controller we are making service call - studentService.getStudent(id)
		log.debug("------------------------ calling getStudent() method of StudentService class");
		Student stu = studentService.getStudent(ids);
		//String imageName = studentService.getImageById(ids);
		//log.debug("imageName : " +imageName);
		// instead of above we can do this
		//model.addAttribute("imageName", imageName);
		model.addAttribute("student", stu);
		return "add-update-student";
	}

	@RequestMapping(value = "/deleteStudent", method = RequestMethod.GET)
	public String deleteStudent(@RequestParam("userID") int id) {

		log.info("------------------deleteStudent method is called on /deleteStudent mapping");
		// capture the id of student whom u r trying to delete
		// once captured the id, do a service call to delete the student
		log.debug("------------------------ calling delete() method of StudentService class");
		studentService.delete(id);
		return "redirect:/showStudent";

	}

	@RequestMapping(value = "/sendEmail", method = RequestMethod.POST)
	public String sendEmail(@RequestParam String to)throws IOException {
        
		String subject = "Student List Data";
		String message = "Hi,\r\n"
				+ "\r\n"
				+ "  Please find the attached document.\r\n"
				+ "\r\n"
				+ "Regards,\r\n"
				+ "Suchithra NV";
				
		// for logging
		log.info("emailTo: " + to);
		log.info("subject: " + subject);
		log.info("message: " + message);

		// Generate the PDF

		// Getting data from database
		List<Student> rows = studentService.loadStudents();
		log.info("fetched the list successfully");

		Document document = new Document(PageSize.A4);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PdfWriter.getInstance(document, baos);

		document.open();
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(18);
		font.setColor(Color.BLUE);

		Paragraph p = new Paragraph("List of Students", font);
		p.setAlignment(Paragraph.ALIGN_CENTER);

		document.add(p);

		PdfPTable table = new PdfPTable(10);
		table.setWidthPercentage(108f);
		table.setWidths(new float[] { 1.0f, 1.8f, 2.5f, 1.9f, 3.0f, 2.4f, 4.0f, 3.1f, 2.2f, 2.5f });
		table.setSpacingBefore(10);

		UserPDFExporter pdf = new UserPDFExporter(rows);
		pdf.writeTableHeader(table);
		pdf.writeTableData(table);
		document.add(table);
		document.close();

		// Save the PDF to a temporary file location

		// The createTempFile method generates a unique temporary file name in the
		// system's default temporary directory.
		// prefix is "temp" and the suffix is ".pdf"
		// resulting temporary file : "temp1234567890.pdf"
		// the numbers are a randomly generated sequence to ensure uniqueness.
		File tempFile = File.createTempFile("temp", ".pdf");
		FileOutputStream fos = new FileOutputStream(tempFile);
		fos.write(baos.toByteArray());
		fos.close();

		// Create a new MimeMessage object
		MimeMessage msg = mailSender.createMimeMessage();

		try {
			// Use the MimeMessageHelper class to set the email details
			MimeMessageHelper helper = new MimeMessageHelper(msg, true);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(message);

			FileSystemResource pdfFile = new FileSystemResource(tempFile);
			helper.addAttachment("Students_List.pdf", pdfFile);

			// Send the email
			mailSender.send(msg);

			// Delete the temporary file
			tempFile.delete();

		} catch (MessagingException e) {
			e.printStackTrace();
		}

		return "redirect:/showStudent";
	}

	@RequestMapping(value = "/deleteSelection", method = RequestMethod.POST)
	public String deleteSelection(@RequestParam("ids") int[] ids) {
		log.info("------------------deleteSelection method is called on /deleteSelection mapping");

		log.debug("------------------------ calling deleteSelection method of StudentService class");
		studentService.deleteSelection(ids);
		return "redirect:/showStudent";
	}

}
