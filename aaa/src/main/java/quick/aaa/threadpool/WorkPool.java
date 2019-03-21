package quick.aaa.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class WorkPool {
	@SuppressWarnings("unused")
	private static ThreadPoolExecutor threadPool=null;
	private static class WorkRunInner{
		private static ExecutorService executors=
				Executors.newFixedThreadPool(2);
	}
	public static void getTreadhPool(){
 		threadPool=(ThreadPoolExecutor) WorkRunInner.executors;
 	}

}
