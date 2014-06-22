package pku.edu.cn.rest;


import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

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
	@POST
	@Path("/adddatacenternode")
	@Consumes("application/x-www-form-urlencoded")
	@Produces("application/json")
	public Boolean addCenterNode(@FormParam("id") int id,
			@FormParam("dataCenterName") String dataCenterName,
			@FormParam("dataCenterCapacity") String dataCenterCapacity,
			@FormParam("ipAddr") String ipAddr,
			@FormParam("priority") String priority,
			@FormParam("dataCenterServiceCapacity") String dataCenterServiceCapacity,
			@FormParam("state") String state,
			@FormParam("createTime") String createTime,
			@FormParam("phyAddr") String phyAddr,
			@FormParam("cComment") String cComment,
			@FormParam("mainCenter") String mainCenter){
		MetadataNode meta = new MetadataNode();
//		meta.setAuthor(author);
//		meta.setCreateTime(new Date());
		meta.setDataKind("");
		meta.setId(id);
		meta.setIpAddr(ipAddr);
		meta.setNodeKind("2");
		meta.setPhyAddr(phyAddr);
		meta.setStatus("0");
//		meta.setUpIpaddr(null);
		System.out.println(meta.toString());
//		Notifier.getNotifier().fireAddNode(meta);
		return true;
	}
	@POST
	@Path("/adddataaccessnode")
	@Consumes("application/x-www-form-urlencoded")
	@Produces("application/json")
	public Boolean addDANode(@FormParam("id") int id,
			@FormParam("accessNodeName") String accessNodeName,
			@FormParam("accessNodeCapacity") String accessNodeCapacity,
			@FormParam("accessNodeKind") String accessNodeKind,
			@FormParam("ipAddr") String ipAddr,
			@FormParam("upperDataCenter") String upperDataCenter,
			@FormParam("accessNodeServiceCapacity") String accessNodeServiceCapacity,
			@FormParam("priority") String priority,
			@FormParam("state") String state,
			@FormParam("createTime") String createTime,
			@FormParam("phyAddr") String phyAddr,
			@FormParam("aComment") String aComment){
		MetadataNode meta = new MetadataNode();
//		meta.setAuthor(author);
//		meta.setCreateTime(new Date());
		meta.setDataKind("");
		meta.setId(id);
		meta.setIpAddr(ipAddr);
		meta.setNodeKind("1");
		meta.setPhyAddr(phyAddr);
		meta.setStatus("0");
		meta.setUpIpaddr(upperDataCenter);
		System.out.println(meta.toString());
//		Notifier.getNotifier().fireAddNode(meta);
		return true;
	}
	@POST
	@Path("/addusernode")
	@Consumes("application/x-www-form-urlencoded")
	@Produces("application/json")
	public Boolean addUserNode(@FormParam("id") int id,
			@FormParam("userSysName") String userSysName,
			@FormParam("organization") String organization,
			@FormParam("phyAddr") String phyAddr,
			@FormParam("ipAddr") String ipAddr,
			@FormParam("upperDataAccessNode") String upperDataAccessNode,
			@FormParam("state") String state,
			@FormParam("sysType") String sysType,
			@FormParam("createTime") String createTime,
			@FormParam("uComment") String uComment){
		MetadataNode meta = new MetadataNode();
//		meta.setAuthor(author);
//		meta.setCreateTime(new Date());
		meta.setDataKind("");
		meta.setId(id);
		meta.setIpAddr(ipAddr);
		meta.setNodeKind("0");
		meta.setPhyAddr(phyAddr);
		meta.setStatus("0");
		meta.setUpIpaddr(upperDataAccessNode);
		System.out.println(meta.toString());
//		Notifier.getNotifier().fireAddNode(meta);
		return true;
	}
	/** 
	* @Title: centerChanged 
	* @Description: 主中心改变
	* @param ip:变化后的主中心ip
	* @return Boolean    返回类型 
	* @throws 
	*/
	@POST
	@Path("/centerchange")
	@Consumes("application/x-www-form-urlencoded")
	@Produces("application/json")
	public Boolean centerChanged(@FormParam("ip") String ip){
		System.out.println(ip);
//		Notifier.getNotifier().fireMainCenterChanged(ip);
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
