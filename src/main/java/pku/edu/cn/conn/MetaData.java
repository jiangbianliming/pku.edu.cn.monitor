package pku.edu.cn.conn;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
		System.out.println(meta.getDataCenterIpList().size());	
	}
}
