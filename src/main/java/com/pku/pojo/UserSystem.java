package com.pku.pojo;

import java.io.Serializable;
import java.util.Date;

public class UserSystem implements Serializable{
	private int id;
	private String userSysName;
	private String organization;
	private String phyAddr;
	private String ipAddr;
	private String upperDataAccessNode;
	private String state;
	private String sysType;
	private Date createTime;
	private String comment;
	
	
	
	public UserSystem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserSystem(int id, String userSysName, String organization,
			String phyAddr, String ipAddr, String upperDataAccessNode,
			String state, String sysType, Date createTime, String comment) {
		super();
		this.id = id;
		this.userSysName = userSysName;
		this.organization = organization;
		this.phyAddr = phyAddr;
		this.ipAddr = ipAddr;
		this.upperDataAccessNode = upperDataAccessNode;
		this.state = state;
		this.sysType = sysType;
		this.createTime = createTime;
		this.comment = comment;
	}

	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getSysType() {
		return sysType;
	}
	public void setSysType(String sysType) {
		this.sysType = sysType;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserSysName() {
		return userSysName;
	}
	public void setUserSysName(String userSysName) {
		this.userSysName = userSysName;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public String getPhyAddr() {
		return phyAddr;
	}
	public void setPhyAddr(String phyAddr) {
		this.phyAddr = phyAddr;
	}
	public String getIpAddr() {
		return ipAddr;
	}
	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}
	public String getUpperDataAccessNode() {
		return upperDataAccessNode;
	}
	public void setUpperDataAccessNode(String upperDataAccessNode) {
		this.upperDataAccessNode = upperDataAccessNode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
