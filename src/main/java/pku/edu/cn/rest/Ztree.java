package pku.edu.cn.rest;

import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import pku.edu.cn.Entity.ZtreeNode;
import pku.edu.cn.conn.MetaData;
import net.sf.json.JSONArray;

@Consumes("application/json")
@Produces("application/json")
public class Ztree {
	
	@Context
	HttpServletRequest request;
	
	@POST
	@Path("/ztreenodes")
	public String getZtree() throws IOException{
		
		MetaData meta = new MetaData();
		ResultSet rs = meta.getMetadata();
		List<ZtreeNode> list = new ArrayList<ZtreeNode>(); 
		ZtreeNode rootNode = new ZtreeNode("root","xx","数据中心服务",true,"root","../assets/ico/fy.png");
		Map<String,Integer> nodeTree = new HashMap<String,Integer>();
		list.add(rootNode);
		try {
			while(rs.next()){
				ZtreeNode node = new ZtreeNode();
				if(rs.getString("upIpAddr")!=null){
					if("0".equals(rs.getString("nodeKind"))){	
						node.setName("用户系统");
						node.setOpen(false);
						node.setStdname("用户系统");
						node.setIcon("../assets/img/treeicon/yhxt.PNG");
					}
					else{
						node.setName("数据访问节点");
						node.setOpen(true);
						node.setStdname("数据访问节点");
						node.setIcon("../assets/img/treeicon/sjfwjd.PNG");
					}
					if(nodeTree.containsKey(rs.getString("upIpAddr"))){
						int tmp = (int)nodeTree.get(rs.getString("upIpAddr"));					
						int tmpValue = tmp+1;
						System.out.println(tmpValue);
						nodeTree.put(rs.getString("upIpAddr"), tmpValue);
					}
					else{
						nodeTree.put(rs.getString("upIpAddr"),1);
					}
					node.setId(rs.getString("ipAddr"));
					node.setpId(rs.getString("upIpAddr"));
					
					list.add(node);
				}
				else{
					if(!nodeTree.containsKey("root")){
						nodeTree.put("root", 1);
					}
					else{
						int tmp = (int) nodeTree.get("root");
						int tmpValue = tmp+1;
						System.out.println(tmpValue);
						nodeTree.put("root", tmpValue);
					}
					List<String> iplist = meta.getDataCenterIpList();
//					InitZnodeInfo info = new InitZnodeInfo();
//					String mainCenter = info.getLeader(iplist);
					if("".equals(rs.getString("ipAddr"))){
						node.setName("");
					}
					else{
						node.setName("数据中心");
					}
					node.setStdname("数据中心");
					node.setOpen(true);
					node.setId(rs.getString("ipAddr"));
					node.setpId("root");
					node.setIcon("../assets/img/treeicon/sjzx.PNG");
					list.add(node);
				}	
			}
			Iterator iter = nodeTree.entrySet().iterator();
			
			while(iter.hasNext()){
				Map.Entry entry = (Map.Entry) iter.next();
				Object key = entry.getKey();
				Object value = entry.getValue();
				for(ZtreeNode tmpnode:list){
					if(key.equals(tmpnode.getId())){
						tmpnode.setName(tmpnode.getName()+"("+value+")");
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONArray jsonObject = JSONArray.fromObject(list);
		return jsonObject.toString();
	}
	
	@POST
	@Path("/ztreenode")
	public String getTreeNode(){
		 String name = request.getParameter("class");
	        String method = request.getParameter("method");
	        String args = request.getParameter("args");
	        System.out.println(method);
	        if(name != null && method != null){
	            try{
	                Class cls = Class.forName(name);
	                Object[] parames = !args.equals("") ? args.split(";") : null;
	                Object obj = cls.newInstance();
	                Method[] methods = cls.getMethods();      
	                for(Method m:methods){
	                    System.out.println(m.getName());
	                    if(m.getName().equals(method)){
	                        Object result = parames != null ? m.invoke(obj,parames) : m.invoke(obj); 
	                        return result.toString();
	                    }
	                }    
	            }
	            catch(Exception e){
	                e.printStackTrace();
	            }  
	        }
	        return null;
	}
}
