package com.test.niteesh.dao;

import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.test.niteesh.entity.ApplicationProperty;

@Repository
public class InfiniDAO {

	@Autowired
	protected JdbcTemplate jdbcTemplate;

	@Autowired
	protected JdbcTemplate jdbcTemplateRead;
	
	private static final String GET_APP_PROPERTIES_BASE = "SELECT ID,  CLIENT_ID,  NAME,  VALUE,  DESCRIPTION FROM T_APPLICATION_PROPERTY ";
	private static final Logger logger = Logger.getLogger(InfiniDAO.class);
	
    public List<ApplicationProperty> getAllProps(String token) {
		logger.info("InfiniDAO.getAllProps called");
		try {
			return jdbcTemplate.query(GET_APP_PROPERTIES_BASE,
					new BeanPropertyRowMapper<ApplicationProperty>(ApplicationProperty.class));
		} catch (Exception ex) {
			logger.error("InfiniDAO.getAllProps exception", ex);
		}
		logger.info("InfiniDAO.getAllProps exit");
		return Collections.emptyList();
    }
}
