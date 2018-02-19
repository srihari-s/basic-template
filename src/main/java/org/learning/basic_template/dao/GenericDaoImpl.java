package org.learning.basic_template.dao;

import java.util.List;

import org.learning.basic_template.model.Auditable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

public abstract class GenericDaoImpl implements GenericDao<Long, Auditable<Long>> {

	@Autowired
	NamedParameterJdbcTemplate nJdbcTemplate;
	
	@Override
	public Long save(Auditable<Long> e) {
		// TODO Auto-generated method stub
	
		SimpleJdbcInsert simpleInsert = new SimpleJdbcInsert(nJdbcTemplate.getJdbcTemplate()).withTableName(getTableName());
		simpleInsert.setGeneratedKeyName("ID");
		//simpleInsert.executeAndReturnKey(parameterSource);
		return null;
	}

	@Override
	public Auditable<Long> findOne(Long k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Auditable<Long>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Auditable<Long> e) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}
