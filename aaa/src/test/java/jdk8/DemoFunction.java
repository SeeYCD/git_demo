package jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.Test;

import com.hcrh.hibernatedemo.entity.User;

import jdk8.definedFunction.UserService;

/**
 * Lambda表达式基础语法,Java8中引入新的操作符"->" 
 * Lambda表达式分为左右两部分: 
  *  左:Lambda表达式的参数列表
  *  右:Lambda表达式中所需执行的功能,即Lambda体
 * 
 * @author user
 *
 */

public class DemoFunction {
	public static void main(String[] args) {
		// Runnable\Consumer都是函数式接口
		// 1.语法格式一：无参，无返回值，Lambda 体只需一条语句
		Runnable run = () -> System.out.println("hello lambda");
		Thread th = new Thread(() -> System.out.println("hello lambda"));
		th.start();
		// 2.语法格式二：Lambda 需要一个参数
		Consumer<String> con = (t) -> System.out.println(t);
		con.accept("hello lambda con ");
		// 3.语法格式三：Lambda 只需要一个参数时，参数的小括号可以省略
		Consumer<String> con2 = t -> System.out.println(t);
		con2.accept("hello lambda con2 ");
		// 4.语法格式四：Lambda 需要两个参数，并且有返回值
		Comparator<Integer> comparator1 = (x, y) -> {
			System.out.println("x-y结果是:" + (x - y));
			return Integer.compare(x, y);
		};
		System.out.println(comparator1.compare(1, 2));
		// 5.语法格式五：当 Lambda 体只有一条语句时，return 与大括号可以省略
		Comparator<Integer> comparator2 = (x, y) -> Integer.compare(x, y);
		System.out.println(comparator2.compare(2, 21));
		//

	}

	@Test
	public void testDefinedFcuntion() {
		UserService<User> us = u -> {
			System.out.println("原姓名：" + u.getName());
			u.setName(u.getName() + "tdf");
			System.out.println("变更姓名：" + u.getName());
			return u;
		};
	}

}


/**
 * 内置的四个函数式接口
 */
class TestFunction {

    //Consumer<T>消费型接口
    @Test
    public void test1(){
        cost(666, (m) -> System.out.println("共消费:" + m + "元"));
    }

    public void cost(double money,Consumer<Double> con){
        con.accept(money);
    }

    //Supplier<T> 供给型接口
    @Test
    public void test2(){
        List<Integer> list = getNumList(8, () -> (int)(Math.random() * 100));
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    //产生指定数量的整数,放入集合中
    public List<Integer> getNumList(int num,Supplier<Integer> sup){
        List<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < num; i++) {
            Integer n = sup.get();
            list.add(n);
        }

        return list;
    }

    //Function<T,R> 函数型接口
    @Test
    public void test3(){
        String string = strHandler(" 函数型接口测试 ", (str) -> str.trim().substring(0, 5));
        System.out.println(string);
    }

    //用于处理字符串
    public String strHandler(String str,Function<String, String> fun){
        return fun.apply(str);
    }

    //Predicate<T> 断言型接口
    @Test
    public void test4(){
        List<String> list = Arrays.asList("hello","Lambda","ok");
        List<String> strList = filterStr(list, (s) -> s.length() > 3);
        for (String string : strList) {
            System.out.println(string);
        }
    }

    //将满足条件的字符串,放入集合中
    public List<String> filterStr(List<String> list, Predicate<String> pre){
        List<String> strList = new ArrayList<>();

        for (String str : list) {
            if (pre.test(str)) {
                strList.add(str);
            }
        }
        return strList;
    }
}

