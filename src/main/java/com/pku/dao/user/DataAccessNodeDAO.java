package com.pku.dao.user;

import java.sql.SQLException;
import java.util.List;

import com.pku.pojo.DataAccessNode;
import com.pku.pojo.DataCenter;

public interface DataAccessNodeDAO {
	public void save(DataAccessNode dataAccessNode) throws SQLException;
	
	public List<DataCenter> findAllDataCenter() throws SQLException;

	public DataCenter findDataCenterById(int i) throws Exception;

	public List<DataAccessNode> findAll() throws Exception;
	
	public DataAccessNode findDataAccessNodeById(int id) throws Exception;
	
	public void update(DataAccessNode dataAccessNode) throws Exception;
	
	
	//add by zhangyu
	public List findAllDataAccessNode();
	public List findById(int num);
	public int findByid(int num);//获取状态
	public int totalNum();
	public int reviewNum();
	public int unreviewNum();
	public List findReviewedList();
	public List findUnreviewedList();
	public List findDReviewedList();
	public String findIpAddr(String name);
	public boolean findPass(String name);
	public void updateDReview(DataAccessNode dataAccessNode);
	public void updateUnReview(DataAccessNode dataAccessNode);

	

	
}
