package com.pku.util;

import java.sql.*;

import com.pku.pojo.DataCenter;

public class CreateCenterTable {
	
//		public static void main(String[] args) {
//			DataCenter datacenter = new DataCenter();
//			datacenter.setDataCenterName("test3");
//			create(datacenter);
//		}
		public static void create(DataCenter dataCenter){
			
			try {
				DbUtil.init();
				Connection conn 
					= DbUtil.getConnection();
				Statement stmt 
					= conn.createStatement();
				String sql = "CREATE TABLE " + dataCenter.getDataCenterName()+
						     "(id int(11) NOT NULL AUTO_INCREMENT,"+
                             "accessNodeName  varchar(200) NOT NULL,"+
                             "accessNodeCapacity  varchar(200) DEFAULT NULL," +
                             "accessNodeKind  varchar(50) NOT NULL," +
                             "ipAddr  varchar(100) DEFAULT NULL," +
                             "upperDataCenterName  varchar(100) NOT NULL,"+
                             "upperDataCenterIp varchar(100) NOT NULL,"+
                             "state varchar(50) DEFAULT NULL," +
                             "phyAddr  varchar(500) DEFAULT NULL," +
                             "PRIMARY KEY (id)" +
                             ")CHARSET=utf8;";
				stmt.executeUpdate(sql);
				
				DbUtil.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}

		public static void insert1(){
			try {
				DbUtil.init();
				Connection conn 
					= DbUtil.getConnection();
				String sql = "insert into users_ning" +
						"(id, password, name)" +
						" values(myseq_ning.nextval, ?, ?)";

				PreparedStatement preStmt
					= conn.prepareStatement(sql);
				preStmt.setString(1, "xyza");
				preStmt.setString(2, "peter");
				preStmt.execute();
				
				DbUtil.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}

		public static void update(){
			try {
				DbUtil.init();
				Connection conn 
					= DbUtil.getConnection();
				String sql = "update users_ning set name = ?," +
						"phone = ?, password = ?, " +
						"email = ? where id = ?";
				//Ԥ����
				PreparedStatement preStmt
					= conn.prepareStatement(sql);
				preStmt.setString(1, "jerry");
				preStmt.setString(2, "1360000");
				preStmt.setString(3, "top");
				preStmt.setString(4, "jerry@1.com");
				preStmt.setInt(5, 151);
				preStmt.execute();
				
				DbUtil.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		public static void delete(){
			Connection conn = null;
			try {
				DbUtil.init();
				conn 
					= DbUtil.getConnection();

				conn.setAutoCommit(false);

				String sql = "delete from users_ning" +
						" where id = ?";
				PreparedStatement pStmt 
					= conn.prepareStatement(sql);
				pStmt.setInt(1, 151);
				pStmt.execute();

				conn.commit();
				DbUtil.close(conn);
			} catch (SQLException e) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
			
			

		}

	

}
