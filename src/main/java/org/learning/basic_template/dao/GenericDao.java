package org.learning.basic_template.dao;

import java.util.List;

import org.learning.basic_template.model.Auditable;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public interface GenericDao<K extends Long,E extends Auditable<K>> {

	K save(E e);
	E findOne(K k);
	List<E> getAll();
	boolean delete(E e);
	String getTableName();
	String getFindOneQuery();
	String getFindAllQuery();
	String getDeleteQuery();
	SqlParameterSource getSqlParameterSource(E e);
	RowMapper getRowMapper();

}
