package com.copysun.exportservice.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

/**
 * @author hspcadmin
 */
@Data
@AllArgsConstructor
public class Student {

	private String id;

	private String name;

	private LocalDate birthday;
}
