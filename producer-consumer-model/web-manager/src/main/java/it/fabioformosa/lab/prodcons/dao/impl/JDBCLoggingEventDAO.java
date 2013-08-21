package it.fabioformosa.lab.prodcons.dao.impl;

import it.fabioformosa.lab.prodcons.dao.LoggingEventHelper;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class JDBCLoggingEventDAO extends JdbcDaoSupport implements
		LoggingEventHelper {

	@Override
	public void resetLogs() {
		String sql = "truncate logging_event_property";
		getJdbcTemplate().update(sql);

		sql = "truncate logging_event_exception";
		getJdbcTemplate().update(sql);

		sql = "delete from logging_event";
		getJdbcTemplate().update(sql);

	}

}
