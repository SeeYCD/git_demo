package quick.aaa.demo;

import quick.aaa.interfaces.InnerDemo;

public class AnonymityDemo {
	public void demoAnonymity(InnerDemo innerD){
		innerD.doDoSome();
	}
	public static void main(String[] args) {
		AnonymityDemo ad=new AnonymityDemo();
		final String dd="canshu";
		ad.demoAnonymity(new InnerDemo(){
 			@Override
			public void doDoSome() {
 				System.out.println(dd);
				System.out.println("内部匿名类测试ok哦");
 			}
 		});
	}

}
