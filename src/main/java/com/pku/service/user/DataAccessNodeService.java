package com.pku.service.user;

import java.util.List;

import com.pku.pojo.DataAccessNode;
import com.pku.pojo.DataCenter;

public interface DataAccessNodeService {
	public void entry(DataAccessNode dataAccessNode) throws Exception;

	public DataCenter findDataCenterById(int i) throws Exception;

	public List<DataAccessNode> findAll() throws Exception;
	
	public DataAccessNode findDataAccessNodeById(int id) throws Exception;
	
	public void update(DataAccessNode dataAccessNode) throws Exception;
	
	
	//add by zhangyu
	public List findbyAll();
	public List findbyId(int num);
	public int findByid(int num);
	public int totalNum();
	public int reviewNum();
	public int unreviewNum();
	public List findReviewedList();
	public List findUnreviewedList();
	public List findDReviewedList();
	public boolean findPass(String name);
	public String findIpAddr(String name);
	public void updateDReview(DataAccessNode dataAccessNode);
	public void updateUnReview(DataAccessNode dataAccessNode);
}
