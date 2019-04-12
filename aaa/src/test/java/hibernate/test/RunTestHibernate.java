package hibernate.test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.junit4.SpringRunner;

import com.hcrh.hibernatedemo.AaaApplication;
import com.hcrh.hibernatedemo.dao.DemoJpaEntity;
import com.hcrh.hibernatedemo.dao.UserRepository;
import com.hcrh.hibernatedemo.entity.User;
import com.hcrh.hibernatedemo.service.UserService2;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { AaaApplication.class })
public class RunTestHibernate {
	private Logger log = LoggerFactory.getLogger(RunTestHibernate.class);
	@Resource
	private UserRepository userRepository;
	@Resource
	private UserService2 us2;

	@Resource
	DemoJpaEntity demoJpa;
	/**
	 * 查看代理
	 */
//	@Test
	public void testUserRepositoryClass() {
		for (Object[] o : userRepository.findAllUser()) {
			System.out.println(o[0]);
		}

// 		for(Method m:userRepository.getClass().getDeclaredMethods()) {
// 	 		System.out.println(m.getName());
//  		}

//		System.out.println(userRepository.getClass()); 
//		System.out.println(userRepository instanceof CrudRepository);
//		上面俩句输出结果如下,JDK动态代理
//		class com.sun.proxy.$Proxy100
//		true
	}

	/**
	 * Hibernate管理的对象有三种状态： 1.持久态 session、数据库中含有 2.离线态 session中已经删除，数据库中含有 3.瞬时态
	 * 新建的对象
	 * 
	 * spring-data-JPA持久化的测试 1.save方法提交后，对象处于离线态
	 * 2.find方法查询出来的对象，在缓存中有保存，属于持久态；set属性，会调用select比较，update更新；
	 */
//	@Test
	public void testTransient() {
		User user = new User();// 瞬时态，数据库、session缓存都没有；离线状态是创建的对象在数据库中存在，缓存中没有
		user.setId(1l);
		user.setName("transientdemo001");
		us2.save(user);
		// 调用save方法会先判断是否存在，存在执行update否则insert;执行后，
		// save提交到数据库中了；save之后是否是持久态？在上述方法中us2.save（）进行测试；
		// save后的数据，对象已经提交到数据库，
		System.out.println(userRepository.findById(1l));
		us2.findById(1l);// 在事务中，先查询出一个user，是持久化，在改变其name，方法结束事务提交，name改变是否生效；
		// name值已经改变到数据库中，说明查询出的user是持久态
		System.out.println(userRepository.findById(1l));
	}

	@Transactional
	public User setNameUser(User user) {
		user.setName("0000011");
		return user;
	}

	/**
	 * 测试通过find方法查询的数据的状态
	 */
//	@Test
	public void testPersistent() {
		User user = null;
		user = userRepository.findById(1l);
		int i = (int) (Math.random() * 10);
		user.setName("ddd-h-up" + i);// 因为不是在事务中处理变更的值并没有保存在数据库中
		System.out.println("demo-jieshu------------------------------");
	}

//	@Test
	public void testUpdate() {
		System.out.println(us2.updateAgeByName("Jack", 4));
		System.out.println(userRepository.findName2("Jack"));
	}

	@Test
	public void testUpdateList() {
		String sql=" select id ,age ,name from user where id=:id";
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("id", "1");
		List<Object[]> lis=demoJpa.findResult(sql, map);
		for(Object[] o:lis) {
			System.out.println(o.length);
 		}
		List<User> list = new ArrayList<User>();
		User u = null;
		for (int i = 10; i < 20; i++) {
			u = new User();
			u.setAge(i);
			u.setName("name" + i);
			list.add(u);
		}
//		userRepository.saveAll(list);
	}
}
