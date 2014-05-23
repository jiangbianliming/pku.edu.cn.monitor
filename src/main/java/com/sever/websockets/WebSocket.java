package com.sever.websockets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import pku.edu.cn.json.JsonHelper;

@ServerEndpoint("/websocket")
public class WebSocket {
 
	public static List<Session> list = Collections.synchronizedList(new ArrayList<Session>());

/*	一个session是一个socket连接，将session保存在list，推送时遍历list，推送消息
*/	
	@OnMessage
    public void onMessage(String message, Session session) 
    	throws IOException, InterruptedException {
//		客户端连接推送拓扑图json数据
		synchronized(list){
		      for(Session client : list){
		    	  if(client.isOpen()){
		    		  client.getBasicRemote().sendText(JsonHelper.getJsonData());
		    		 // client.getBasicRemote().sendBinary(JsonHelper.getJsonData());		    	
		    	  }
		      }
		    }
    }
	
	@OnOpen
    public void onOpen (Session session) {
		System.out.println("session added");
		list.add(session);
    }

    @OnClose
    public void onClose (Session session) {
    	list.remove(session);
    	System.out.println("session removed");
    	
    }
}
