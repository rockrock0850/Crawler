package com.adam.crawler.main;

import java.io.IOException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.adam.crawler.dao.JdbcDAO;
import com.adam.crawler.util.CrawlerUtil;

public class App {
	
	@SuppressWarnings("resource")
	public static void main (String[] args) throws IOException {
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		
		JdbcDAO jdbcDao = (JdbcDAO) context.getBean("jdbcDAO");
		
		List<String> hrefs = CrawlerUtil.getHrefs("http://www.58b.tv");
		for (String href : hrefs) {
			System.out.println(href);
		}
	}
	
}
