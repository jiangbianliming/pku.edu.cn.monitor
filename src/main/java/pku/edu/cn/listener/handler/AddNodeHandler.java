//
//
//import java.io.IOException;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.json.JsonObject;
//import javax.websocket.Session;
//
//import pku.edu.cn.Entity.Edges;
//import pku.edu.cn.Entity.Node;
//import pku.edu.cn.conn.MetaData;
//import pku.edu.cn.json.JsonHelper;
//
//import com.pku.pojo.MetadataNode;
//import com.server.listener.ServerListenerAdapter;
//import com.sever.websockets.WebSocketTest;
//
//public class AddNodeHandler extends ServerListenerAdapter{
//
//	@Override
//	public void AddNode(MetadataNode metadataNode) {
//		// TODO Auto-generated method stub
//		if(WebSocketTest.list.size()==0){
//			System.out.println("û����");
//			return;
//		}
//		ArrayList<Session> delSession = new ArrayList<Session>();
//		delSession.clear();
//		JsonHelper help = new JsonHelper();
//		String json =null;
//		Node node = new Node();
//		node.setId(metadataNode.getIpAddr());
//		node.setColor("rgb(0,255,0)");
//		node.setName(metadataNode.getIpAddr());
//		if(metadataNode.getNodeKind().equals("0")){
//			node.setName("用户系统");
//			node.setShape("sphere");
//			node.setColor("rgb(0,255,0)");
//			node.setSize("1");
//		}
//		else if(metadataNode.getNodeKind().equals("1")){
//			node.setName("数据访问节点");
//			node.setShape("square");
//			node.setColor("rgb(255,0,0)");
//			node.setSize("1");
//		}
//		else{
//			node.setName("数据中心");
//			node.setShape("star");
//			node.setColor("rgb(255,255,0)");
//			node.setSize("1");
//		}
//		node.setGroup(metadataNode.getNodeKind());
//		
//		if(metadataNode.getUpIpaddr()!=null){
//			List edgeList = new ArrayList<>();
//			Edges edge = new Edges();
//			edge.setId1(metadataNode.getIpAddr());
//			edge.setId2(metadataNode.getUpIpaddr());
//			edge.setColor("rgb(0,255,0)");
//			edge.setType("line");
//			edgeList.add(edge);
//			json = help.getAddNodeJson(node, edgeList);
//			System.out.println(json);
//		}
//		else{
//			MetaData meta = new MetaData();
//			ResultSet rs = meta.getCenterMetadata();
//			List edgeList = new ArrayList<>();
//			try {
//				while(rs.next()){
//					if(!(metadataNode.getIpAddr().equals(rs.getString("ipAddr")))){
//						Edges edge = new Edges();
//						edge.setId1(metadataNode.getIpAddr());
//						edge.setId2(rs.getString("ipAddr"));
//						edge.setColor("rgb(0,255,0)");
//						edge.setType("line");	
//						edgeList.add(edge);	
//					}			
//				}
//				json = help.getAddNodeJson(node, edgeList);
//				System.out.println(json);
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		for(Session session:WebSocketTest.list){
//			if(session.isOpen()){
//				System.out.println("session is open");
//				try {
//					session.getBasicRemote().sendText(json);
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			else{
//				delSession.add(session);
//			}
//		}
//		if(delSession.size()>0){
//			WebSocketTest.list.removeAll(delSession);
//			System.out.println("session removed");
//		}
//	}
//	
//}