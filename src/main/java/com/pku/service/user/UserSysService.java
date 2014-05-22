package com.pku.service.user;

import java.util.List;

import com.pku.pojo.DataAccessNode;
import com.pku.pojo.DataCenter;
import com.pku.pojo.UserSystem;

public interface UserSysService {
	public void entry(UserSystem userSystem) throws Exception;

	public DataAccessNode findAccessNodeById(int i) throws Exception;

	public List<UserSystem> findAll() throws Exception;
	
	public UserSystem findUserSystemById(int id) throws Exception;
	
	public void update(UserSystem userSystem) throws Exception;
	
	
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
	public void updateDReview(UserSystem userSystem);
	public void updateUnReview(UserSystem userSystem);
}
