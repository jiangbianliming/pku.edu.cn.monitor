package pku.edu.cn.logmine;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

public class LogParser {
	public LogParser(){
		
	}
	public String parseLog(String line){
		
		Map<String,LogInfo> map = new HashMap<String,LogInfo>();
		String tmp = line.substring(line.indexOf("LocalIp"));
		String splitTmp[] = tmp.split(";");
		System.out.println(splitTmp.length);
		System.out.println(splitTmp[0]);
		String localIp = splitTmp[0].substring(splitTmp[0].indexOf("=")+1);
		System.out.println(localIp);
		String remoteIp = splitTmp[1].substring(splitTmp[1].indexOf("=")+1);
		System.out.println(remoteIp);
		String state = splitTmp[2].substring(splitTmp[2].indexOf("=")+1,splitTmp[2].indexOf("\""));
		System.out.println(state);
		LogInfo info = new LogInfo();
		
		info.setLocalIp(localIp.trim());
		info.setRemoteIp(remoteIp.trim());
		info.setState(state.trim());
		info.setMessage(line);
		if(state.trim().equals("success")){
			map.put("success", info);
		}
		else{
			map.put("failure", info);
		}
		Map<String,Object> logMap = new HashMap<String,Object>();
		logMap.put("log", map);
		JSONObject jsonObject = JSONObject.fromObject(logMap);
		return jsonObject.toString();
	}
	public static void main(String args[]){
		LogParser parser = new LogParser();
		System.out.println(parser.parseLog("363  [main] INFO  com.serverAgent.ServerAgent - End:ServerAgent method;LocalIp=192.168.213.235;RemoteIP=192.168.213.231;State=success\",\"xxxxxxxxxxxxxx"));
	}
}
