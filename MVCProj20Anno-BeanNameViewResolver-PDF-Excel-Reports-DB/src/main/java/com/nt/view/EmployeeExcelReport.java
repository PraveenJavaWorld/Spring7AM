package com.nt.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.nt.model.Employee;

@Component("excelReport")
public class EmployeeExcelReport extends AbstractXlsView {
	
	private static int i;

	@Override
	public void buildExcelDocument(Map<String, Object> map, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		//read Model data
		List<Employee> listEmps = (List<Employee>) map.get("listEmps");
		//create Sheet
		Sheet sheet = workbook.createSheet("Sheet1");
		//add cells to sheet
		listEmps.forEach(emp->{
			Row row = sheet.createRow(i);
			row.createCell(1).setCellValue(emp.getEmpno());
			row.createCell(2).setCellValue(emp.getEname());
			row.createCell(3).setCellValue(emp.getJob());
			row.createCell(4).setCellValue(emp.getSal());
			row.createCell(5).setCellValue(emp.getDeptno());
			i++;
		});

	}

}
