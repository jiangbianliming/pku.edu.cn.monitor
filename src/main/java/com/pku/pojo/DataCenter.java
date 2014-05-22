package com.pku.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class DataCenter implements Serializable{
	//Fields
	private Integer id;
	private String dataCenterName;
	private String dataCenterCapacity;
	private String ipAddr;
	private String dataCenterServiceCapacity;
	private String priority;
	private String state;
	private Date createTime;
	private String phyAddr;
	private String comment;
	
	



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





	
	
	public DataCenter(Integer id, String dataCenterName,
			String dataCenterCapacity, String ipAddr,
			String dataCenterServiceCapacity, String priority, String state,
			Date createTime, String phyAddr, String comment) {
		super();
		this.id = id;
		this.dataCenterName = dataCenterName;
		this.dataCenterCapacity = dataCenterCapacity;
		this.ipAddr = ipAddr;
		this.dataCenterServiceCapacity = dataCenterServiceCapacity;
		this.priority = priority;
		this.state = state;
		this.createTime = createTime;
		this.phyAddr = phyAddr;
		this.comment = comment;
	}


	public DataCenter() {
	}



	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDataCenterName() {
		return this.dataCenterName;
	}

	public void setDataCenterName(String dataCenterName) {
		this.dataCenterName = dataCenterName;
	}

	public String getDataCenterCapacity() {
		return this.dataCenterCapacity;
	}

	public void setDataCenterCapacity(String dataCenterCapacity) {
		this.dataCenterCapacity = dataCenterCapacity;
	}

	public String getIpAddr() {
		return this.ipAddr;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

	public String getPriority() {
		return this.priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getDataCenterServiceCapacity() {
		return dataCenterServiceCapacity;
	}

	public void setDataCenterServiceCapacity(String dataCenterServiceCapacity) {
		this.dataCenterServiceCapacity = dataCenterServiceCapacity;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public String getPhyAddr() {
		return phyAddr;
	}



	public void setPhyAddr(String phyAddr) {
		this.phyAddr = phyAddr;
	}
	
}
