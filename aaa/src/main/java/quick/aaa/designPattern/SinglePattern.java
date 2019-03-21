package quick.aaa.designPattern;
/**
 * 静态内部类,实现单例模式
 */
public class SinglePattern {
	private static SinglePattern  singleP=null;
	private  SinglePattern(){
		System.out.println("new oneTime SinglePattern!");
	}
 	private static class InnerClass{
		private static SinglePattern singleInner=new SinglePattern();
	}
 	public static SinglePattern getInstance(){
		singleP=InnerClass.singleInner;
		return singleP;
 	}
}
