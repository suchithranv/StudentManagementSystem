package com.sm.helper;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import com.sm.api.Student;

import jakarta.servlet.http.HttpServletResponse;

public class UserPDFExporter {
	
	 private List<Student> listUsers;
     
	    public UserPDFExporter(List<Student> listUsers) {
	        this.listUsers = listUsers;
	    }
	 
	    public void writeTableHeader(PdfPTable table) {
	        PdfPCell cell = new PdfPCell();
	        cell.setBackgroundColor(Color.BLUE);
	        cell.setPadding(5);
	       
	         
	        Font font = FontFactory.getFont(FontFactory.HELVETICA);
	        font.setColor(Color.WHITE);
	        font.setSize(12);
	         
	        cell.setPhrase(new Phrase("ID", font));   
	        table.addCell(cell);
	         
	        cell.setPhrase(new Phrase("Roll No", font));
	        table.addCell(cell);
	         
	        cell.setPhrase(new Phrase("First Name", font));
	        table.addCell(cell);
	        
	        cell.setPhrase(new Phrase("Last Name", font));
	        table.addCell(cell);
	        
	        cell.setPhrase(new Phrase("DOB", font));
	        table.addCell(cell);
	         
	        cell.setPhrase(new Phrase("Gender", font));
	        table.addCell(cell);
	        
	        cell.setPhrase(new Phrase("Email", font));
	        table.addCell(cell);
	        
	        cell.setPhrase(new Phrase("Mobile", font));
	        table.addCell(cell);
	        
	        cell.setPhrase(new Phrase("Course", font));
	        table.addCell(cell);
	         
	        cell.setPhrase(new Phrase("Country", font));
	        table.addCell(cell); 
	        
	       
	    }
	     
	    public void writeTableData(PdfPTable table) {
	
	        for (Student user : listUsers) {
	            table.addCell(String.valueOf(user.getId()));
	            table.addCell(String.valueOf(user.getRollno()));
	            table.addCell(user.getFname());
	            table.addCell(user.getLname());
	            table.addCell(user.getDob());
	            table.addCell(user.getGender());
	            table.addCell(user.getEmail());
	            table.addCell(String.valueOf(user.getMobile()));
	            table.addCell(user.getCourse());
	            table.addCell(user.getCountry());
	           
	        }
	    }
	     
	    public void export(HttpServletResponse response) throws DocumentException, IOException {
	        Document document = new Document(PageSize.A4);
	        PdfWriter.getInstance(document, response.getOutputStream());
	         
	        document.open();
	        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	        font.setSize(18);
	        font.setColor(Color.BLUE);
	         
	        Paragraph p = new Paragraph("List of Students", font);
	        p.setAlignment(Paragraph.ALIGN_CENTER);
	         
	        document.add(p);
	         
	        PdfPTable table = new PdfPTable(10);
	        table.setWidthPercentage(108f);
	        table.setWidths(new float[] {1.0f, 1.8f, 2.5f, 1.9f, 3.0f, 2.4f, 4.0f, 3.1f, 2.2f, 2.5f});
	        table.setSpacingBefore(10);
	         
	        writeTableHeader(table);
	        writeTableData(table);
	         
	        document.add(table);
	         
	        document.close();
	         
	    }

}
