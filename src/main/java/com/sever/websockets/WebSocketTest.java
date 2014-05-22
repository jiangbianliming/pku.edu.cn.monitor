package com.sever.websockets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import pku.edu.cn.test.TestJsonHelper;

@ServerEndpoint("/websocket")
public class WebSocketTest {
	
	 
	public static List<Session> list = Collections.synchronizedList(new ArrayList<Session>());

	@OnMessage
    public void onMessage(String message, Session session) 
    	throws IOException, InterruptedException {
		
		// Print the client message for testing purposes
//		System.out.println("Received: " + message);
//		
//		// Send the first message to the client
//		session.getBasicRemote().sendText("This is the first server message");
//		
//		// Send 3 messages to the client every 5 seconds
//	
//		int sentMessages = 0;
//		while(sentMessages < 3){
//			Thread.sleep(5000);
//			session.getBasicRemote().
//				sendText("This is an intermediate server message. Count: " 
//					+ sentMessages);
//			sentMessages++;
//		}
//		
//		// Send a final message to the client
		session.getBasicRemote().sendText(TestJsonHelper.getJsonData());
		list.add(session);
		System.out.println("session added");
    }
	
	@OnOpen
    public void onOpen () {
        System.out.println("Client connected");
    }

    @OnClose
    public void onClose () {
    	System.out.println("Connection closed");
    }
}
