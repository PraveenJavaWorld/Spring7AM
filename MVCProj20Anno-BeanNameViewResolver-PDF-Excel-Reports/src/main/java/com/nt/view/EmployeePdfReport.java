package com.nt.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import com.nt.model.Employee;

@Component("pdfReport")
public class EmployeePdfReport extends AbstractPdfView {

	@Override
	public void buildPdfDocument(Map<String, Object> map, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//read Model data
		List<Employee> listEmps = (List<Employee>) map.get("listEmps");
		//add paragraph
		Paragraph para = new Paragraph("Employees Report",new Font(Font.BOLD));
		document.add(para);
		//add table
		Table table = new Table(5,listEmps.size());
		for(Employee emp:listEmps) {
			table.addCell(String.valueOf(emp.getEid()));
			table.addCell(emp.getName());
			table.addCell(emp.getAddress());
			table.addCell(emp.getJob());
			table.addCell(String.valueOf(emp.getSalary()));
		}
		document.add(table);
	}

}
