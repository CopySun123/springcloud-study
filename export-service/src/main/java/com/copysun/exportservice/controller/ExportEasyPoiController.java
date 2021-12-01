package com.copysun.exportservice.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.copysun.exportservice.domain.Student;
import com.copysun.exportservice.domain.Student2;
import org.apache.poi.ss.usermodel.Workbook;
import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
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
public class ExportEasyPoiController {

	@PostMapping(value = "/export2")
	public void easyPoiExport(HttpServletRequest request, HttpServletResponse response) {
		List<Student2> students=new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Student2 student2=new Student2("学生"+i,"小明"+i,"1",LocalDate.now());
			students.add(student2);
		}
		try {
			response.setContentType("application/octet-stream");
			response.addHeader("Content-Disposition", "attachment;filename=" + "Student2ExportExcel.xls");
			ServletOutputStream outputStream = response.getOutputStream();
			Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("计算机一班学生", "学生"), Student2.class, students);
			workbook.write(outputStream);
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}


	}
}
