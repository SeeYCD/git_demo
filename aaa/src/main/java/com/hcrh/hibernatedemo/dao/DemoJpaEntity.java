package com.hcrh.hibernatedemo.dao;

import java.util.List;
import java.util.Map;

/**
 * 继承JPArepository
 * 
 * @author chen
 *
 */

public interface DemoJpaEntity  {
	//自定义封装JPA的本地方法，通用查询
	public List<Object[]> findResult(String sql,@SuppressWarnings("rawtypes") Map map);
}
