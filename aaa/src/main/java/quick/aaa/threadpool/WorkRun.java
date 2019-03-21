package quick.aaa.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class WorkRun {
	private static ThreadPoolExecutor threadPool = null;

	/**
	 * 内部类
	 * @author user
	 *
	 */
	private static class WorkRunInner {
		private static ExecutorService executors = Executors
				.newFixedThreadPool(2);
	}

	public static void getTreadhPool() {
		if (threadPool == null) {
			threadPool = (ThreadPoolExecutor) WorkRunInner.executors;
		}
	}

	public static ThreadPoolExecutor getTreadhPoolExecutor() {
		getTreadhPool();
		return threadPool;
	}

	public static void execute(final int i) {
 		threadPool.execute(new Runnable() {
			@Override
			public void run() {
				for (int j = 0; j <= 100; j++) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + ":"
							+ i);
				}
			}
		});
	}

	public static Future<String> submit(final int i){
		
		Future<String> future = threadPool.submit(new Callable<String>() {
			@Override
			public String call() throws Exception {
				//一个线程执行时跑错，不会影响其他的任务
				if(i==3){
					String s=null;
					s.lastIndexOf(1);
				}
				for (int j = 0; j <= 10; j++) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + ":"
							+ i);
				}
				return String.valueOf(i);
			}
		});
		return future;
	}
}
