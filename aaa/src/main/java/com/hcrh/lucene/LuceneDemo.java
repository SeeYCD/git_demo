package com.hcrh.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.store.Directory;

public class LuceneDemo {
 
	public static void main(String[] args) {
		String[] ids = { "1", "2", "3", "4", "5", "6" };

		String[] names = { "zs", "ls", "ww", "hl", "wq", "bb" };

		String[] emails = { "zs@qq.com", "zs@baidu.com", "zs@126.com", "zs@sina.com", "zs@163.com", "zs@google.com" };

		String[] contents = {
				"She had been shopping with her Mom in Wal-Mart. She must have been "
						+ "6 years old, this beautiful brown haired, freckle-faced image of innocence. "
						+ "It was pouring outside. The kind of rain that gushes over the top of rain gutters, "
						+ "so much in a hurry to hit the Earth, it has no time to flow down the spout.",
				"We all stood there under the awning and just inside the door of the Wal-Mart. "
						+ "We all waited, some patiently, others irritated, because nature messed up their hurried day. I am always mesmerized by rainfall. "
						+ "I get lost in the sound and sight of the heavens washing away the dirt and dust of the world. Memories of running, splashing so carefree as a child come pouring in as a welcome reprieve from the worries of my day.",
				"Her voice was so sweet as it broke the hypnotic trance we were all caught in, Mom, let's run through the rain. she said.",
				"The entire crowd stopped dead silent. I swear you couldn't hear anything but the rain. We all stood silently. No one came or left in the next few minutes. Mom paused and thought for a moment about what she would say.",
				"Now some would laugh it off and scold her for being silly. Some might even ignore what was said. But this was a moment of affirmation in a young child's life. Time when innocent trust can be nurtured so that it will bloom into faith.",
				"To everything there is a season and a time to every purpose under heaven. I hope you still take the time to run through the rain." };
	
		//1.创建Directory 
		//索引存放目录
		String indexPath = "D:\\CRH\\lucene\\luceneIndex\\";
//		Directory dir = LuceneUtils
//				.openFSDirectory(indexPath);
		//也可以存放到内存 
		//Directory  directory = new RAMDirectory();
		//2.创建分词器
		Analyzer analyzer = new SmartChineseAnalyzer();
	}

}
