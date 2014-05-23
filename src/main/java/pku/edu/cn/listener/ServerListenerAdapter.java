package pku.edu.cn.listener;



public abstract class ServerListenerAdapter implements ServerListener {
	 public void nodeChanged(String nodeJson){}
//	 public void AddNode(MetadataNode metadataNode){}
	 public void mainCenterChanged(String ip){}
	 public void Animation(String json){};
}
