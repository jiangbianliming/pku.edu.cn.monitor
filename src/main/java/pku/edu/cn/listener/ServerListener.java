package pku.edu.cn.listener;

public interface ServerListener {

	void nodeChanged(String nodeJson);
//	void AddNode(MetadataNode metadataNode);
	void mainCenterChanged(String ip);
	void Animation(String json);
}
