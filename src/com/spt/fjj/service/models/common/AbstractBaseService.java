package com.spt.fjj.service.models.common;

import java.sql.Connection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.jdbc.datasource.ConnectionHolder;
import org.springframework.jdbc.datasource.JdbcTransactionObjectSupport;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionStatus;


public abstract class AbstractBaseService {
	protected static final Log logger = getLog();

	protected static Log getLog() {
		return LogFactory.getLog(new Object() {
			public String getClassName() {
				String clazz = this.getClass().getName();
				return clazz.substring(0, clazz.lastIndexOf('$'));
			}
		}.getClassName());
	}

	protected static Log getLog(Class c) {
		return LogFactory.getLog(c);
	}

	final private Connection getConnection(TransactionStatus ts) {
		JdbcTransactionObjectSupport j = (JdbcTransactionObjectSupport) ((DefaultTransactionStatus) ts).getTransaction();
		ConnectionHolder ch = j.getConnectionHolder();
		return ch.getConnection();

	}


}
