package org.learning.basic_template.dao;

import java.util.List;

import org.learning.basic_template.model.Auditable;

public interface GenericDao<K,E extends Auditable<K>> {

	K save(E e);
	E findOne(K k);
	List<E> getAll();
	boolean delete(E e);
	String getTableName();
}
