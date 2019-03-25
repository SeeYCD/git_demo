package com.hcrh.hibernatedemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hcrh.hibernatedemo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	public User findById(Long id);

	@SuppressWarnings("unchecked")
	public User save(User user);

	@Query(value = "SELECT u FROM User u WHERE name=:name")
//    @Query(value =" SELECT * FROM user u WHERE name=:name " ,nativeQuery = true)
	public User findName(@Param("name") String name);

	@Query(value = "SELECT u FROM User u WHERE name= ?1")
	public User findName2(String name);

	@Modifying//增加这个注解会执行update  这个注解的需要在事务中才能执行，不然报错 Executing an update/delete query
	@Query(value = "UPDATE  User SET age= ?2 WHERE name= ?1")
	public Integer updateAgeByName(String name,Integer age );
}
