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

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import pku.edu.cn.Entity.ZtreeNode;
import pku.edu.cn.conn.MetaData;
import net.sf.json.JSONArray;


/**
 * @author jiangchao
 *
 */
public class Ztree {
	
	private static final int MAINCENTER=1;
	private static final String USERSYS="0";
	private static final String ACCESSNODE = "1";
//	private static final String DATACENTER = "2";
	
	/** 
	* @Title: getZtree 
	* @Description: 获得ztree树的json数据
	* @param 
	* @return String    返回类型 
	* @throws 
	*/
	@POST
	@Path("/ztreenodes")
	@Consumes("application/json")
	@Produces("application/json")
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
				if(rs.getString("upipAddr")!=null){
					if(USERSYS.equals(rs.getString("nodeKind"))){	
						node.setName("用户系统("+rs.getString("t_phyAddr")+")");
						node.setOpen(false);
						node.setStdname("用户系统");
						node.setIcon("../assets/img/treeicon/yhxt.PNG");
					}
					else{
						node.setName("数据访问节点("+rs.getString("t_phyAddr")+")");
						node.setOpen(true);
						node.setStdname("数据访问节点");
						node.setIcon("../assets/img/treeicon/sjfwjd.PNG");
					}
					if(nodeTree.containsKey(rs.getString("upipAddr"))){
						int tmp = (int)nodeTree.get(rs.getString("upipAddr"));					
						int tmpValue = tmp+1;
						System.out.println(tmpValue);
						nodeTree.put(rs.getString("upipAddr"), tmpValue);
					}
					else{
						nodeTree.put(rs.getString("upipAddr"),1);
					}
					node.setId(rs.getString("t_ipAddr"));
					node.setpId(rs.getString("upipAddr"));
					
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
					if(MAINCENTER==rs.getInt("maincenter")){
						node.setName("主数据中心("+rs.getString("t_phyAddr")+")");
					}
					else{
						node.setName("数据中心("+rs.getString("t_phyAddr")+")");
					}
					node.setStdname("数据中心");
					node.setOpen(true);
					node.setId(rs.getString("t_ipAddr"));
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
	
	/** 
	* @Title: getTreeNode 
	* @Description: 通过反射机制获得ztree节点详细信息。
	* @param name：反射对应的类名，method:反射对应的方法名。args:反射对应的参数
	* @return String    返回类型 
	* @throws 
	*/
	@POST
	@Path("/ztreenode")
	@Consumes("application/x-www-form-urlencoded")
	@Produces("application/json")
	public String getTreeNode(@FormParam("class") String name,@FormParam("method") String method,@FormParam("args") String args){
			System.out.println(name);
			System.out.println(method);
			System.out.println(args);
	        if(name != null && method != null){
	            try{
	                Class cls = Class.forName(name);
	                Object[] parames = !args.equals("") ? args.split(";") : null;
	                Object obj = cls.newInstance();
	                Method[] methods = cls.getMethods();      
	                for(Method m:methods){
	                    System.out.println(m.getName());
	                    if(m.getName().equals(method)){
	                    	System.out.println("xxxxxxxxxxx");
	                        Object result = parames != null ? m.invoke(obj,parames) : m.invoke(obj); 
	                        System.out.println(result.toString());
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
