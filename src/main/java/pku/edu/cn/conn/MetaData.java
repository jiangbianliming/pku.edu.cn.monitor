package pku.edu.cn.conn;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pku.edu.cn.Entity.ZtreeNode;

public class MetaData {

	public ResultSet getMetadata() {
		String sql = "select * from meta_view";
		Connection conn = DbConnection.getConnection();
		Statement stat;
		ResultSet rs = null;
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet getCenterMetadata() {
		String sql = "select * from meta_view where nodeKind ='2'";
		Connection conn = DbConnection.getConnection();
		ResultSet rs = null;
		try {
			Statement stat = conn.createStatement();
			rs = stat.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
//	public ResultSet getAccessNodeByCenterIp(String ip){
//		String sql = "select * from meta_view where upIPAddr='"+ip+"'";
//		Connection conn = DbConnection.getConnection();
//		ResultSet rs =null;
//		try {
//			Statement stat =conn.createStatement();
//			rs=stat.executeQuery(sql);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return rs;
//	}

	public List<ZtreeNode> getAccessNodeByCenterIp(String ip){
		String sql = "select * from meta_view where upIPAddr='"+ip+"'";
		Connection conn = DbConnection.getConnection();
		List<ZtreeNode> list = new ArrayList<ZtreeNode>();
		ResultSet rs =null;
		try {
			Statement stat =conn.createStatement();
			rs=stat.executeQuery(sql);
			while(rs.next()){
				ZtreeNode node = new ZtreeNode();
				node.setId(rs.getString("t_ipAddr"));
				node.setpId(ip);
				node.setName(rs.getString("accessNodeName"));
				node.setOpen(true);
				node.setStdname("访问节点");
				node.setIcon("./asset/img/treeicon/sjfwjd.PNG");
				list.add(node);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public List<ZtreeNode> getSysNodeByAccessIp(String ip){
		String sql = "select * from meta_view where upIPAddr='"+ip+"'";
		Connection conn = DbConnection.getConnection();
		List<ZtreeNode> list = new ArrayList<ZtreeNode>();
		try {
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()){
				ZtreeNode node = new ZtreeNode();
				node.setId(rs.getString("t_ipAddr"));
				node.setpId(ip);
				node.setName(rs.getString("userSysName"));
				node.setOpen(true);
				node.setStdname("用户系统");
				node.setIcon("./asset/img/treeicon/yhxt.PNG");
				list.add(node);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public List<String> getDataCenterIpList() {
		List<String> list = new ArrayList<String>();
		String sql = "select t_ipAddr from meta_view where nodeKind ='2' ";
		Connection conn = DbConnection.getConnection();
		try {
			Statement stmt= conn.createStatement();;
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				list.add(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public static void main(String args[]) {
		MetaData meta = new MetaData();
		
	}
}
