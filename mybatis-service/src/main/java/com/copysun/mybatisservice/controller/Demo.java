package com.copysun.mybatisservice.controller;

import java.math.BigDecimal;

public class Demo {
		public static void main(String[] args){

			BigDecimal bigDecimal=new BigDecimal("0.0000001");
			System.out.println(bigDecimal.toPlainString());
			System.out.println(new BigDecimal("0.0000015"));

		}
	}
