package pku.edu.cn.Entity;

import java.sql.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MetadataNode {

	private Integer id;
	private String phyAddr;
	private String ipAddr;
	private String nodeKind;
	private String dataKind;
	private String upIpaddr;
	private String author;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getNodeKind() {
		return nodeKind;
	}
	public void setNodeKind(String nodeKind) {
		this.nodeKind = nodeKind;
	}
	public String getDataKind() {
		return dataKind;
	}
	public void setDataKind(String dataKind) {
		this.dataKind = dataKind;
	}
	public String getUpIpaddr() {
		return upIpaddr;
	}
	public void setUpIpaddr(String upIpaddr) {
		this.upIpaddr = upIpaddr;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	private Date createTime;
	private String status;
}
