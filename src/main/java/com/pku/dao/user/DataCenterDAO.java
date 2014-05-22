package com.pku.dao.user;

import java.sql.SQLException;
import java.util.List;

import com.pku.pojo.DataCenter;

public interface DataCenterDAO {
	
	public void save(DataCenter dataCenter) throws SQLException;

	public List<DataCenter> findAll() throws Exception;
	
	public DataCenter findDataCenterById(int id) throws Exception;

	public void update(DataCenter dataCenter) throws Exception;
	
	//add by zhangyu
	public List findAllDataCenter();//查询所有DataCenter实例
	public List findById(int num);
	public int findByid(int num);//获取状态
	public int totalNum();
	public int reviewNum();
	public int unreviewNum();
	public List findReviewedList();
	public List findUnreviewedList();
	public List findDReviewedList();
	public boolean findPass(String name);//通过名称来查询是否通过审核
	public String findIpAddr(String name);
	public void updateDReview(DataCenter dataCenter);
	public void updateUnReview(DataCenter dataCenter);


}
