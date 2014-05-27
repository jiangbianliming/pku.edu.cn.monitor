package pku.edu.cn.listener.handler;

import java.io.IOException;
import java.util.ArrayList;

import javax.websocket.Session;

import com.sever.websockets.WebSocket;

import pku.edu.cn.listener.ServerListenerAdapter;



public class NodeChangedHandler extends ServerListenerAdapter {


	@Override
	public void nodeChanged(String nodeJson) {
		// TODO Auto-generated method stub
		if(WebSocket.list.size()==0){
			System.out.println("û����");
			return;
		}
		ArrayList<Session> delSession = new ArrayList<Session>();
		for(Session session:WebSocket.list){
			if(session.isOpen()){
				System.out.println("session is open");
				try {
					System.out.println("���ͳ�ȥ��");
					session.getBasicRemote().sendText(nodeJson);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else{
				delSession.add(session);
			}
		}
		if(delSession.size()>0){
			WebSocket.list.removeAll(delSession);
			System.out.println("session removed");
		}
		
		
	}
}
