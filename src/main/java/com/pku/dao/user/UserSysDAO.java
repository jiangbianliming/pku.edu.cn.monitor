package com.pku.dao.user;

import java.sql.SQLException;
import java.util.List;

import com.pku.pojo.DataAccessNode;
import com.pku.pojo.UserSystem;

public interface UserSysDAO {
	public void save(UserSystem userSystem) throws SQLException;

	public DataAccessNode findAccessNodeById(int id) throws Exception;

	public List<UserSystem> findAll() throws Exception;
	
	public UserSystem findUserSystemById(int id) throws Exception;
	
	public void update(UserSystem userSystem) throws Exception;
	
	//add by zhangyu
	public List findAllUserSys();
	public List findById(int num);
	public int findByid(int num);//获取状态
	public int totalNum();
	public int reviewNum();
	public int unreviewNum();
	public List findReviewedList();
	public List findUnreviewedList();
	public List findDReviewedList();
	public void updateDReview(UserSystem userSystem);
	public void updateUnReview(UserSystem userSystem);

	

	
}
