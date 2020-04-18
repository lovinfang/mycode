package com.geektime.spring.data.druiddemo;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootApplication
//@Slf4j
public class DruidDemoApplication implements CommandLineRunner {

	private Logger log = LoggerFactory.getLogger(DruidDemoApplication.class);

	@Autowired
	private DataSource dataSource;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(DruidDemoApplication.class, args);
	}

	public void run(String... args) throws Exception {
		log.info(dataSource.toString());
	}

}
