package jdk8;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import com.hcrh.hibernatedemo.entity.User;

/**
 * 方法的引用
 * 
 * @author user 三种主要使用情况： 对象::实例方法 类::静态方法 类::实例方法
 * 
 *         方法引用:若Lambda 体中的内容有方法已经实现了,我们可以使用 "方法引用"的方式
 */
public class DemoMethod {
	public static void main(String[] args) {
		// 1.println方法已经实现
		Consumer<String> con = (x) -> System.out.println(x);
		con.accept("demo");
		// 方法引用,对象::实例方法名
		Consumer<String> consumer = System.out::println;
		consumer.accept("demo2");
		// 2.调用自定义的方法
		User user = new User();
		user.setName("aym");
		user.setAge(1);
		Supplier<String> supplier = () -> user.getName();
		String str = supplier.get();
		System.out.println(str);
		Supplier<Integer> sup = user::getAge;
		Integer age = sup.get();
		System.out.println(age);
		// 类::静态方法名
		Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
		System.out.println(com.compare(1, 2));
		Comparator<Integer> com2 = Integer::compare;
		System.out.println(com2.compare(1, 2));

		// 类::实例方法名 //使用条件:第一个参数是实例方法调用者,第二个参数是实例方法的参数
		BiPredicate<String, String> bp = (x, y) -> x.equals(y);
		System.out.println(bp.test("1", "1"));
		bp = String::equals;
		System.out.println(bp.test("2", "3"));

		// 构造器的引用
		Supplier<User> su = () -> new User();
		System.out.println(su.get());

		su = User::new;
		System.out.println(su.get());

		//构造函数引用
		Function<Integer, JdkmodelUser> fun = (x) -> new JdkmodelUser(x);
		System.out.println(fun.apply(10));
		
        BiFunction<String, Integer, JdkmodelUser> biF= JdkmodelUser :: new;
        System.out.println(biF.apply("jack", 12));
        
        //数组引用
        Function<Integer, String[]> fs=n->new String[n];
        System.out.println(fs.apply(20).length);
        fs=String[]::new;
        System.out.println(fs.apply(200).length);        
	}

}

class JdkmodelUser {
	private String name;
	private int age;
	private String email;

	public JdkmodelUser(int age) {
		this.age=age;
	}

	public JdkmodelUser(String name, int age) {
		this.name=name;
		this.age=age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "JdkmodelUser [name=" + name + ", age=" + age + ", email=" + email + "]";
	}
}
