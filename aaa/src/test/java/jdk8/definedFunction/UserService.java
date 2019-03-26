package jdk8.definedFunction;
/**
 * abstracte方法只能有一个
 * @author user
 *
 * @param <T>
 */
@FunctionalInterface
public interface UserService<T> {
	
	public T updaetT(T t);

	// 默认方法
	public default void test1() {

	}

	public default void test1(String s) {

	}
}
