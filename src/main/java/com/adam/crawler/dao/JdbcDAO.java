package com.adam.crawler.dao;


import java.util.HashMap;
import java.util.List;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.annotation.Transactional;

public class JdbcDAO extends JdbcDaoSupport {

	@Transactional
	public List<java.util.Map<String,Object>> findAll () {
		StringBuilder sqlText = new StringBuilder();
		sqlText.append("SELECT T1.* FROM WEB_SITES T1");
		
		List<java.util.Map<String, Object>> list = super.getJdbcTemplate().queryForList(sqlText.toString());
		
		return list;
	}
	
	public void saveWebSite (String url) {
		StringBuilder sqlText = new StringBuilder();
		sqlText.append("INSERT INTO web_sites (url) VALUES (?)");
		
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("url", url);
		
		super.getJdbcTemplate().update(sqlText.toString(), params);
	}
	
}
