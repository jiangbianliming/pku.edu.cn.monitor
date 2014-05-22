package com.pku.service.user;

import java.util.List;

import com.pku.pojo.DataCenter;


public interface DataCenterService {
	public void entry(DataCenter dataCenter) throws Exception;

	public List<DataCenter> findAll() throws Exception;
	
	public DataCenter findDataCenterById(int id) throws Exception;

	public void update(DataCenter dataCenter) throws Exception;
	
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
	public void updateDReview(DataCenter dataCenter);
	public void updateUnreview(DataCenter dataCenter);
}
