package com.hcrh.hibernatedemo.dao.impl;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.hcrh.hibernatedemo.dao.DemoJpaEntity;


/**
 * 复杂动态的SQL,使用EntityManager的native方法，通用
 * 
 * @author chen
 *
 */
@Repository
public class DemoJpaEntityImpl implements DemoJpaEntity {
	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings({"rawtypes", "unchecked" })
	@Override
	public List<Object[]> findResult(String sql, Map map) {
		Query query=entityManager.createNativeQuery(sql);
		if(map.size()>0) {
			Set<Entry> entrys=map.entrySet();
			for(Entry e:entrys) {
				query.setParameter((String) e.getKey(),e.getValue());
 			}
		}
		return query.getResultList();
	}
	
}
