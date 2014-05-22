package com.pku.pojo;

import java.io.Serializable;
import java.util.Date;

public class DataAccessNode implements Serializable{
	private int id;
	private String accessNodeName;
	private String accessNodeCapacity;
	private String accessNodeKind;
	private String ipAddr;
	private String upperDataCenter;
	private String accessNodeServiceCapacity;
	private String priority;
	private String state;
	private Date createTime;
	private String phyAddr;
	private String comment;
	
	public DataAccessNode() {
		super();
	}
	public DataAccessNode(int id, String accessNodeName,
			String accessNodeCapacity, String accessNodeKind, String ipAddr,
			String upperDataCenter, String accessNodeServiceCapacity,
			String priority, String state, Date createTime, String phyAddr, String comment) {
		super();
		this.id = id;
		this.accessNodeName = accessNodeName;
		this.accessNodeCapacity = accessNodeCapacity;
		this.accessNodeKind = accessNodeKind;
		this.ipAddr = ipAddr;
		this.upperDataCenter = upperDataCenter;
		this.accessNodeServiceCapacity = accessNodeServiceCapacity;
		this.priority = priority;
		this.state = state;
		this.createTime = createTime;
		this.phyAddr = phyAddr;
		this.comment = comment;
	}

	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getPhyAddr() {
		return phyAddr;
	}
	public void setPhyAddr(String phyAddr) {
		this.phyAddr = phyAddr;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccessNodeName() {
		return accessNodeName;
	}
	public void setAccessNodeName(String accessNodeName) {
		this.accessNodeName = accessNodeName;
	}
	public String getAccessNodeCapacity() {
		return accessNodeCapacity;
	}
	public void setAccessNodeCapacity(String accessNodeCapacity) {
		this.accessNodeCapacity = accessNodeCapacity;
	}
	public String getAccessNodeKind() {
		return accessNodeKind;
	}
	public void setAccessNodeKind(String accessNodeKind) {
		this.accessNodeKind = accessNodeKind;
	}
	public String getIpAddr() {
		return ipAddr;
	}
	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}
	public String getUpperDataCenter() {
		return upperDataCenter;
	}
	public void setUpperDataCenter(String upperDataCenter) {
		this.upperDataCenter = upperDataCenter;
	}
	public String getAccessNodeServiceCapacity() {
		return accessNodeServiceCapacity;
	}
	public void setAccessNodeServiceCapacity(String accessNodeServiceCapacity) {
		this.accessNodeServiceCapacity = accessNodeServiceCapacity;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
}
