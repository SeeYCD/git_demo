package com.hcrh.hibernatedemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // 集成了responsebody
@RequestMapping(value = "/d")
@SpringBootApplication(scanBasePackages = { "com.hcrh.hibernatedemo.service", "com.hcrh.hibernatedemo", // 打war部署需要扫描controller
		"com.hcrh.hibernatedemo.dao" })
@EntityScan(basePackages = { "com.hcrh.hibernatedemo.entity" }) // 扫描实体包
@EnableJpaRepositories // 开启jpa的注解
public class AaaApplication extends SpringBootServletInitializer {
	private static Logger log = LoggerFactory.getLogger(AaaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AaaApplication.class, args);
//		entitymanager 管理的创建通过jdk动态代理实现；返回的代理对象
//		SharedEntityManagerBean
//		public static EntityManager createSharedEntityManager(EntityManagerFactory emf, @Nullable Map<?, ?> properties,
//				boolean synchronizedWithTransaction, Class<?>... entityManagerInterfaces) {
//
//			ClassLoader cl = null;
//			if (emf instanceof EntityManagerFactoryInfo) {
//				cl = ((EntityManagerFactoryInfo) emf).getBeanClassLoader();
//			}
//			Class<?>[] ifcs = new Class<?>[entityManagerInterfaces.length + 1];
//			System.arraycopy(entityManagerInterfaces, 0, ifcs, 0, entityManagerInterfaces.length);
//			ifcs[entityManagerInterfaces.length] = EntityManagerProxy.class;
//			return (EntityManager) Proxy.newProxyInstance(
//					(cl != null ? cl : SharedEntityManagerCreator.class.getClassLoader()),
//					ifcs, new SharedEntityManagerInvocationHandler(emf, properties, synchronizedWithTransaction));
//		}
	}

	/**
	 * 部署tomcat
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return super.configure(builder);
	}

	@GetMapping(value = "/helloWorld")
	public String helloWorld(@RequestParam String ss) {
		System.out.println(ss);
		return "ok";
	}

}
