package pku.edu.cn.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import pku.edu.cn.Entity.MetadataNode;
import pku.edu.cn.listener.Notifier;

public class NetWork {
	@POST
	@Path("/addnode")
	@Consumes("application/text")
	@Produces("application/json")
	public Boolean addNode(MetadataNode metadata){
		System.out.println("进来了！");
//		Notifier.getNotifier().fireAddNode(metadata);
		return true;
	}
	@GET
	@Path("/centerchange")
	@Consumes("application/text")
	@Produces("application/json")
	public Boolean centerChanged(@QueryParam("ip") String ip){
		System.out.println(ip);
//		Notifier.getNotifier().fireMainCenterChanged(ip);
		return true;
	}
	@POST
	@Path("/amination")
	@Consumes("application/text")
	@Produces("application/json")
	public Boolean Amination(@FormParam("logdata") String logDataJson){
		Notifier.getNotifier().fireAmination(logDataJson);
		return true;
	}
	@POST
	@Path("/nodeChanged")
	@Consumes("application/text")
	@Produces("application/json")
	public Boolean nodeChanged(@FormParam("nodedata") String nodedata){
		Notifier.getNotifier().fireNodeChanged(nodedata);
		return true;
	}
}
