package com.pku.pojo;

import java.io.Serializable;
import java.util.Date;

public class MetadataNode implements Serializable {
	
	// Fields

		private Integer id;
		private String phyAddr;
		private String ipAddr;
		private String nodeKind;
		private String dataKind;
		private String upIpaddr;
		private String author;
		private Date createTime;
		private String status;
		
		// Constructors

		/** default constructor */
		public MetadataNode() {
		}

		/** minimal constructor */
		public MetadataNode(String phyAddr, String ipAddr, String nodeKind,
				String author, Date createTime) {
			this.phyAddr = phyAddr;
			this.ipAddr = ipAddr;
			this.nodeKind = nodeKind;
			this.author = author;
			this.createTime = createTime;
		}

		/** full constructor */
		public MetadataNode(String phyAddr, String ipAddr, String nodeKind,
				String dataKind, String upIpaddr, String author, Date createTime,
				String status) {
			this.phyAddr = phyAddr;
			this.ipAddr = ipAddr;
			this.nodeKind = nodeKind;
			this.dataKind = dataKind;
			this.upIpaddr = upIpaddr;
			this.author = author;
			this.createTime = createTime;
			this.status = status;
		}

		// Property accessors

		public Integer getId() {
			return this.id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getPhyAddr() {
			return this.phyAddr;
		}

		public void setPhyAddr(String phyAddr) {
			this.phyAddr = phyAddr;
		}

		public String getIpAddr() {
			return this.ipAddr;
		}

		public void setIpAddr(String ipAddr) {
			this.ipAddr = ipAddr;
		}

		public String getNodeKind() {
			return this.nodeKind;
		}

		public void setNodeKind(String nodeKind) {
			this.nodeKind = nodeKind;
		}

		public String getDataKind() {
			return this.dataKind;
		}

		public void setDataKind(String dataKind) {
			this.dataKind = dataKind;
		}

		public String getUpIpaddr() {
			return this.upIpaddr;
		}

		public void setUpIpaddr(String upIpaddr) {
			this.upIpaddr = upIpaddr;
		}

		public String getAuthor() {
			return this.author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public Date getCreateTime() {
			return this.createTime;
		}

		public void setCreateTime(Date createTime) {
			this.createTime = createTime;
		}

		public String getStatus() {
			return this.status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

}
