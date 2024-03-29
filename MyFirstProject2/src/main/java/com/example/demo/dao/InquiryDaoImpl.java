package com.example.demo.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Inquiry;

@Repository
public class InquiryDaoImpl implements InquiryDao {
	
	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public InquiryDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public void insertInquiry(Inquiry inquiry) {
		String sql = "INSERT INTO inquiry(name, email, contents, created) VALUES(?,?,?,?)";
		jdbcTemplate.update(sql,inquiry.getName(),inquiry.getEmail(),inquiry.getContents(),inquiry.getCreated());
	}

	@Override
	public List<Inquiry> getAll() {
		String sql = "SELECT id, name, email,contents, created FROM inquiry";
		List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);
		List<Inquiry> list = new ArrayList<Inquiry>();
		for(Map<String, Object> result : resultList) {
			Inquiry inquiry = new Inquiry();
			inquiry.setId((int)result.get("id"));
			inquiry.setEmail((String)result.get("email"));
			inquiry.setName((String)result.get("name"));
			inquiry.setContents((String)result.get("contents"));
			inquiry.setCreated(((Timestamp)result.get("created")).toLocalDateTime());
			list.add(inquiry);
		}
		return list;
	}

	@Override
	public int updateInquiry(Inquiry inquiry) {
		String sql = "UPDATE inquiry SET name = ?, email = ?, contents = ? WHERE id = ?";
		return jdbcTemplate.update(sql,inquiry.getName(),inquiry.getEmail(),inquiry.getContents(),inquiry.getId());
	}

}
