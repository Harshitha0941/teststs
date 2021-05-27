package com.hcl.employee.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class ConnectionUtil {
	public static JdbcTemplate getConnection() {
	ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
	JdbcTemplate jdbcTemplate= (JdbcTemplate) context.getBean("jdbcTemplate");
	System.out.println(jdbcTemplate);
	return jdbcTemplate;
}
}