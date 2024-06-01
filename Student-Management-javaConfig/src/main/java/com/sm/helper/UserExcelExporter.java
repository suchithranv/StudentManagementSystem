package com.sm.helper;


import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.sm.api.Student;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;


public class UserExcelExporter {
    
	private static final Logger log = LogManager.getLogger(UserExcelExporter.class.getName());
	
	
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<Student> listUsers;
     
    public UserExcelExporter(List<Student> listUsers) {
        log.info("called export excel constructor");
        this.listUsers = listUsers;
        workbook = new XSSFWorkbook();
        log.info("Created workbook");
    }
 
 
    private void writeHeaderLine() {
    	log.info("called header lines method");
    	// create one sheet 
        sheet = workbook.createSheet("Students");
         
        Row row = sheet.createRow(0);
         
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
        
        // create row as a header
        createCell(row, 0, "ID", style); 
        createCell(row, 1, "Roll No", style);
        createCell(row, 2, "First Name", style);
        createCell(row, 3, "Last Name", style);       
        createCell(row, 4, "Dob", style);   
        createCell(row, 5, "Gender", style);
        createCell(row, 6, "Email", style);
        createCell(row, 7, "Mobile", style);
        createCell(row, 8, "Course", style);
        createCell(row, 9, "Country", style);
       
        log.info("header created");
         
    }
     
    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
    	
    	log.info("called create cell method");
    	
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        }else if (value instanceof Long) {
            cell.setCellValue((Long) value);
        }else if (value instanceof Date) {
            cell.setCellValue((Date) value);
        }else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }
     
    private void writeDataLines() {
    	log.info("called data lines method");
        int rowCount = 1;
 
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);
                 
        for (Student user : listUsers) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
             
            createCell(row, columnCount++, user.getId(), style);
            createCell(row, columnCount++, user.getRollno(), style);
            createCell(row, columnCount++, user.getFname(), style);
            createCell(row, columnCount++, user.getLname(), style);
            createCell(row, columnCount++, user.getDob(), style);
            createCell(row, columnCount++, user.getGender(), style);
            createCell(row, columnCount++, user.getEmail(), style);
            createCell(row, columnCount++, user.getMobile(), style);
            createCell(row, columnCount++, user.getCourse(), style);
            createCell(row, columnCount++, user.getCountry(), style);
            
            log.info("created data");
             
        }
    }
     
    public void export(HttpServletResponse response) throws IOException {
    	 log.info("called export method");
        writeHeaderLine();
        writeDataLines();
        log.info("done");
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
         
        outputStream.close();
         
    }

}
