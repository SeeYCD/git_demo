package quick.aaa.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

import org.junit.Test;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import quick.aaa.designPattern.SinglePattern;
import quick.aaa.threadpool.WorkRun;

 
/**
 * Hello world!
 *
 */
public class App {
	public App(){
		System.out.println("App实例");
	}
	public static void main(String[] args) {
// 		WorkRun.getTreadhPool();
// 		List<Future<String>> list=new ArrayList<Future<String>>();
//		for (int i = 0; i < 10; i++) {
//			Future<String>  futrue = WorkRun.submit(i);
// 			list.add(futrue);
//			WorkRun.execute(i);
//		}
//		WorkRun.getTreadhPoolExecutor().shutdown();
//		for(Future<String> f:list){
//			try {
//				System.out.println(f.get());
//			} catch (InterruptedException e) {
// 				e.printStackTrace();
//			} catch (ExecutionException e) {
// 				e.printStackTrace();
//			}
//		}
		
//		WorkRun.getTreadhPool();
//		for (int i = 0; i < 10; i++) {
//			WorkRun.execute(i);
//  		}
//		ThreadPoolExecutor threds=WorkRun.getTreadhPoolExecutor();
// 		while(!threds.getQueue().isEmpty()){
// 			try {
//				Thread.sleep(2000);
//			} catch (InterruptedException e) {
// 				e.printStackTrace();
//			}
//			System.out.println("ok is not empty");
// 		};
//		System.out.println("ok is empty");
//		WorkRun.getTreadhPoolExecutor().shutdown();
		ThreadPoolExecutor taskExecutors=(ThreadPoolExecutor) Executors.newFixedThreadPool(10);
//		taskExecutors.setWaitForTasksToCompleteOnShutdown(true);
//		taskExecutors.setCorePoolSize(10);
//		taskExecutors.setMaxPoolSize(5);
//		taskExecutors.setQueueCapacity(100);
		for(int i=0;i<100;i++){
			if(i==11){
				taskExecutors.shutdownNow();
				break;
			}
			taskExecutors.execute(new Runnable(){
				public void run(){
					for(int i=0;i<100;i++){
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
 							e.printStackTrace();
						}
						 System.out.println(Thread.currentThread().getName()+":"+i);
					}
				}
			});
		}
//		taskExecutors.shutdown();
 	}
	@Test
	
	public void test1(){
 		WorkRun.getTreadhPool();
		for (int i = 0; i < 10; i++) {
			WorkRun.execute(i);
  		}
		ThreadPoolExecutor threds=WorkRun.getTreadhPoolExecutor();
 		if(threds.getQueue().isEmpty()){
			System.out.println("ok is empty");
			WorkRun.getTreadhPoolExecutor().shutdown();
 		};
		System.out.println("ok is not  empty");
 	}
}
