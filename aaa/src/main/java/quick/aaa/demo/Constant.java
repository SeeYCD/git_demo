package quick.aaa.demo;

public class Constant {
	public static void main(String[] args) {
		/*for(int i=0;i<50000000;i++){
			String d="ss"+i;
			System.out.println(d);
		}*/
		String s="1";
 		String ff=("11"+s).intern();
		String ff2=("11"+s);
		String ss="111";
//		System.out.println(ss);
		System.out.println(ff==ss);
		System.out.println(ff2==ss);
 // 		System.out.println("11"+s=="111");
	}

}
