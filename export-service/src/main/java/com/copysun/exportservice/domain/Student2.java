package com.copysun.exportservice.domain;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

/**
 * @author hspcadmin
 */
@Data
@AllArgsConstructor
public class Student2 {

	@Excel(name = "学生学号")
	private String id;

	@Excel(name = "学生姓名")
	private String name;

	@Excel(name="性别",replace ={"男_1","女_2"} ,suffix = "生", isImportField = "true_st")
	private String sex;

	@Excel(name = "生日",format = "yyyy-MM-dd")
	private LocalDate birthday;
}
