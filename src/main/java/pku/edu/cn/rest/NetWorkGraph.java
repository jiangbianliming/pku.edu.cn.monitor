package pku.edu.cn.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import pku.edu.cn.Entity.MetadataNode;
import pku.edu.cn.listener.Notifier;

public class NetWorkGraph {
	/** 
	* @Title: addNode 
	* @Description: 节点动态添加
	* @param 
	* @return Boolean    返回类型 
	* @throws 
	*/
	@POST
	@Path("/addnode")
	@Consumes("application/json")
	@Produces("application/json")
	public Boolean addNode(MetadataNode metadata){
		System.out.println(metadata.getAuthor());
//		Notifier.getNotifier().fireAddNode(metadata);
		return true;
	}
	/** 
	* @Title: centerChanged 
	* @Description: 主中心改变
	* @param ip:变化后的主中心ip
	* @return Boolean    返回类型 
	* @throws 
	*/
	@GET
	@Path("/centerchange")
	@Consumes("application/json")
	@Produces("application/json")
	public Boolean centerChanged(@QueryParam("ip") String ip){
		System.out.println(ip);
//		Notifier.getNotifier().fireMainCenterChanged(ip);
		return true;
	}
	
	
	@GET
	@Path("/test")
	@Consumes("application/json")
	@Produces("application/json")
	public Boolean test(){
		System.out.println("进来了");
		return true;
	}
//	@POST
//	@Path("/amination")
//	@Consumes("application/json")
//	@Produces("application/json")
//	public Boolean Amination(@FormParam("logdata") String logDataJson){
//		Notifier.getNotifier().fireAmination(logDataJson);
//		return true;
//	}
//	@POST
//	@Path("/nodeChanged")
//	@Consumes("application/json")
//	@Produces("application/json")
//	public Boolean nodeChanged(@FormParam("nodedata") String nodedata){
//		Notifier.getNotifier().fireNodeChanged(nodedata);
//		return true;
//	}
}
