package com.hcrh.hibernatedemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "age")
	protected Integer age;

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [age=" + age + ", id=" + id + ", name=" + name + "]";
	}

}
