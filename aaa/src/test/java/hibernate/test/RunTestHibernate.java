package hibernate.test;

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
import com.hcrh.hibernatedemo.dao.UserRepository;
import com.hcrh.hibernatedemo.entity.User;
import com.hcrh.hibernatedemo.service.UserService2;


@RunWith(SpringRunner.class)
@SpringBootTest(classes= {AaaApplication.class})
public class RunTestHibernate {
	private Logger log=LoggerFactory.getLogger(RunTestHibernate.class);
	@Resource
	private UserRepository ur;
	@Resource
	private UserService2 us2;
	
//	@Test
	public void testUserRepositoryClass() {
		System.out.println(ur.getClass()); 
		System.out.println(ur instanceof CrudRepository);
 	}
	
	/**
	 * spring-data-JPA持久化的测试
	 * 1.save方法提交后，对象处于离线态
	 * 2.find方法查询出来的对象，在缓存中有保存，属于持久态；set属性，会调用select比较，update更新；
	 */
//	@Test
	public void testTransient() {
		User user=new User();//瞬时态，数据库、session缓存都没有；离线状态是创建的对象在数据库中存在，缓存中没有
		user.setId(1l);
		user.setName("transientdemo001"); 
		us2.save(user);
		//调用save方法会先判断是否存在，存在执行update否则insert;执行后，
		//save提交到数据库中了；save之后是否是持久态？在上述方法中us2.save（）进行测试；
		//save后的数据，对象已经提交到数据库，
 		System.out.println(ur.findById(1l));
 		us2.findById(1l);//在事务中，先查询出一个user，是持久化，在改变其name，方法结束事务提交，name改变是否生效；
		//name值已经改变到数据库中，说明查询出的user是持久态
    	System.out.println(ur.findById(1l));
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
		User user=null;
 		user=ur.findById(1l);
 		int i=(int) (Math.random()*10);
		user.setName("ddd-h-up"+i);//因为不是在事务中处理变更的值并没有保存在数据库中
 		System.out.println("demo-jieshu------------------------------");
 	}
	
	@Test
	public void testUpdate() {
		System.out.println(us2.updateAgeByName("Jack",4));
		System.out.println(ur.findName2("Jack"));
  	}
}
