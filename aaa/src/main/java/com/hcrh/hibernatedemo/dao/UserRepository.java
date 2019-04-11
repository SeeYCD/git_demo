package com.hcrh.hibernatedemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hcrh.hibernatedemo.entity.User;

/**
 * 继承JPArepository
 * 
 * @author chen
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	public User findById(Long id);

	@SuppressWarnings("unchecked")
	public User save(User user);

	// 使用jpql时，直接查询对象User
	@Query(value = "SELECT u FROM User u WHERE name=:name") // :paramname配置参数名称
	public User findName(@Param("name") String name);

	//使用本地查询，直接编写SQL，使用数据库user表名，设置nativeQuery = true
	@Query(value = " SELECT * FROM user u WHERE name=:name ", nativeQuery = true)
	public User findName3(@Param("name") String name);
	
	// 可以通过参数的位置来匹配
	@Query(value = "SELECT u FROM User u WHERE name= ?1") 
	public User findName2(String name);

	//modifying 增加这个注解会执行update 这个注解的需要在事务中才能执行，不然报错 Executing an update/delete query
	@Modifying 
	@Query(value = "UPDATE  User SET age= ?2 WHERE name= ?1")
	public Integer updateAgeByName(String name, Integer age);

	//批量更新
	@Query(" select id,age,age from User u ")
	public List<Object[]> findAllUser();

}
