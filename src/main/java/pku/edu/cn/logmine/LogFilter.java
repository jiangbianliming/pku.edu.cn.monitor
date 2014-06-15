package pku.edu.cn.logmine;

public class LogFilter {
	public LogFilter(){
		
	}

	public boolean isNeeded(String line) {
		// TODO Auto-generated method stub
		if(line.contains("LocalIp")&&line.contains("RemoteIP")&&line.contains("State")){
			return true;
		}
		return false;
	}
	public static void main(String args[]){
		LogFilter filter = new LogFilter();
		System.out.print(filter.isNeeded("363  [main] INFO  com.serverAgent.ServerAgent - End:ServerAgent method;LocalIp=192.168.213.235;RemoteIP=192.168.213.231;State=success,xxxxx"));
	}
}