package org.learning.basic_template.dao;

import org.learning.basic_template.model.Auditable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class GenericDaoImpl implements GenericDao {

    @Autowired
    NamedParameterJdbcTemplate nJdbcTemplate;


    @Override
    public Long save(Auditable auditable) {
        SimpleJdbcInsert simpleInsert = new SimpleJdbcInsert(nJdbcTemplate.getJdbcTemplate()).withTableName(getTableName());
        simpleInsert.setGeneratedKeyName("ID");
        Number id = simpleInsert.executeAndReturnKey(getSqlParameterSource(auditable));
        return id.longValue();
    }

    @Override
    public Auditable findOne(Long aLong) {
        Map map = new HashMap<String,String>(1);
        map.put("id", aLong);
        return (Auditable)nJdbcTemplate.queryForObject(getFindOneQuery(), map, getRowMapper());
    }

    @Override
    public List<Auditable> getAll() {
        return nJdbcTemplate.query(getFindAllQuery(), getRowMapper());
    }

    @Override
    public boolean delete(Auditable e) {
        Map map = new HashMap<String,String>(1);
        map.put("id", e.getId());
        int count = nJdbcTemplate.update(getDeleteQuery(),map);
        if (1 == count)
            return true;
        return false;
    }


    @Override
    public String getFindOneQuery() {
        return new StringBuilder("SELECT * FROM ").append(getTableName()).append(" WHERE ID:id").toString();
    }

    @Override
    public String getDeleteQuery() {
        return new StringBuilder("DELETE * FROM ").append(getTableName()).append(" WHERE ID:id").toString();
    }

    @Override
    public String getFindAllQuery() {
        return new StringBuilder("SELECT * FROM ").append(getTableName()).toString();
    }


}
