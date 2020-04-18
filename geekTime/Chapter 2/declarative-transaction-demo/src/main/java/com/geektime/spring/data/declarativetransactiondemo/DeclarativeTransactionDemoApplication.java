package com.geektime.spring.data.declarativetransactiondemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement(mode = AdviceMode.PROXY)
public class DeclarativeTransactionDemoApplication implements CommandLineRunner {

	private Logger log = LoggerFactory.getLogger(DeclarativeTransactionDemoApplication.class);

	@Autowired
	private FooService fooService;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(DeclarativeTransactionDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		fooService.insertRecord();
//		log.info("AAA {}",
//				jdbcTemplate
//						.queryForObject("SELECT COUNT(*) FROM FOO WHERE BAR='AAA'", Long.class));
//
//		try {
//			fooService.insertThenRollback();
//		} catch (Exception e) {
//			log.info("BBB {}",
//					jdbcTemplate
//							.queryForObject("SELECT COUNT(*) FROM FOO WHERE BAR='BBB'", Long.class));
//		}
//
//		try {
//			fooService.invokeInsertThenRollback();
//		} catch (Exception e) {
//			log.info("BBB {}",
//					jdbcTemplate
//							.queryForObject("SELECT COUNT(*) FROM FOO WHERE BAR='BBB'", Long.class));
//		}

		try {
			fooService.invokeInsertWithTransaction();
		} catch (Exception e) {
			log.info("AAA {}",
					jdbcTemplate
							.queryForObject("SELECT COUNT(*) FROM FOO WHERE BAR='AAA'", Long.class));
			log.info("BBB {}",
					jdbcTemplate
							.queryForObject("SELECT COUNT(*) FROM FOO WHERE BAR='BBB'", Long.class));
		}
	}
}
