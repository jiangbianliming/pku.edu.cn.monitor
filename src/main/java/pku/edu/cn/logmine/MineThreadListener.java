package pku.edu.cn.logmine;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import pku.edu.cn.conn.DbConnection;

public class MineThreadListener implements ServletContextListener {
	static BufferedReader br = null;
    static String line = null;
	static StringBuffer buf = new StringBuffer();
//	static String FILENAME = "/var/log/lilu/result.log";
	static String FILENAME = "/Users/admin/Desktop/pku.edu.cn.monitor/src/main/java/pku/edu/cn/logmine/test.log";
	static String lastLine = null;
	private Mine thread;
	
//	static{
//		Properties props = new Properties();
//		try {
//			InputStream in =DbConnection.class.getResourceAsStream("logMine.properties");
//			props.load(in);
//			FILENAME = props.getProperty("filepath");
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		if (thread != null && thread.isInterrupted()) {  
			thread.interrupt();
        }  
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		String str = null;  
        if (str == null && thread == null) {  
        	try {
				br = new BufferedReader(new FileReader(FILENAME));
        	try {
    			while ((line = br.readLine()) != null) {
    				lastLine = line;
    			}
    			System.out.println("file read end !");
        	try {
				thread = new Mine(FILENAME,br,line);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
        	} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
        	} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	thread.start();
        }  
	}

}
