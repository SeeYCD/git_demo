package quick.aaa.inner;

import quick.aaa.demo.App;

public class OutClass {
	private App app=new App();
	public static  final  int s=22;
	public static String s2="s2";
	private static App appS=new App();

	static {
		System.out.println("OutClass加载了");
		System.out.println("OutClass加载了s:"+s);
		System.out.println("OutClass加载了s2:"+s2);
 	}

	public OutClass() {
		System.out.println("OutClass无参构造");
	}
	public OutClass(String sss) {
		System.out.println("sss");
	}
	/**
	 * 普通内部类
	 * @author user
	 *
	 */
	class Inner1 {
		 public Inner1(){
			 new OutClass("Inner1实例");
		 }
	}
	/**
	 * 静态内部
	 * @author user
	 *
	 */
	static class InnerStatic {
		private final static String s="22";
 		static {
			System.out.println("InnerStatic加载了");
		}
	}
	
}
