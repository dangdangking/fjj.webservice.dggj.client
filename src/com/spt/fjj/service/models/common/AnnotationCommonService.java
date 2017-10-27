package com.spt.fjj.service.models.common;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Component;

@Component
public abstract class AnnotationCommonService extends CommonService {
	@Resource
	private DataSource	dataSource;
	
	@PostConstruct
	public void readyForJdbcTemplate() {
		this.setDataSource(dataSource);
	}
}
