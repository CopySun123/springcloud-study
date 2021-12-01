package com.copysun.exportservice.controller;

import com.copysun.exportservice.domain.Student;
import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hspcadmin
 */
@RestController
public class ExportJxlsController {


	@PostMapping(value = "/export")
	public void jxlsExport(HttpServletRequest request, HttpServletResponse response) {
		List<Student> students=new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Student student=new Student("学生"+i,"小明"+i, LocalDate.now());
			students.add(student);
		}
		try {
			System.out.println("=========================");

			InputStream is=new ClassPathResource("templates/StudentExportExcel.xls").getInputStream();
			OutputStream os=response.getOutputStream();
			response.addHeader("Content-Disposition", "attachment;filename=" + "StudentExportExcel.xls");
			response.setContentType("application/octet-stream");

			Context context=new Context();
			context.putVar("students",students);
			JxlsHelper.getInstance().processTemplate(is,os,context);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
