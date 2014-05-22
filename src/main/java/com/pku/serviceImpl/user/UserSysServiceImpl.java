package com.pku.serviceImpl.user;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pku.dao.user.UserSysDAO;
import com.pku.pojo.DataAccessNode;
import com.pku.pojo.DataCenter;
import com.pku.pojo.UserSystem;
import com.pku.service.user.UserSysService;

@Service("userSysService")
public class UserSysServiceImpl implements UserSysService{
   private UserSysDAO userSysDAO;
	
	public void entry(UserSystem userSystem) throws Exception {
		userSysDAO.save(userSystem);
	}

	public UserSysDAO getUserSysDAO() {
		return userSysDAO;
	}

	public void setUserSysDAO(UserSysDAO userSysDAO) {
		this.userSysDAO = userSysDAO;
	}

	@Override
	public DataAccessNode findAccessNodeById(int i)throws Exception {
		DataAccessNode dataAccessNode = userSysDAO.findAccessNodeById(i);
		return dataAccessNode;
	}

	@Override
	public List<UserSystem> findAll() throws Exception {
		return userSysDAO.findAll();
	}
	
	public UserSystem findUserSystemById(int id) throws Exception{
		return userSysDAO.findUserSystemById(id);
	}
	
	@Override
	public void update(UserSystem userSystem) throws Exception {
		userSysDAO.update(userSystem);
	}
	
	
	//add by zhangyu
		public List findbyAll() {
			// TODO Auto-generated method stub
			return userSysDAO.findAllUserSys();
		}

		public List findbyId(int num) {
			// TODO Auto-generated method stub
			return userSysDAO.findById(num);
		}

		public int totalNum() {
			// TODO Auto-generated method stub
			return userSysDAO.totalNum();
		}

		public int reviewNum() {
			// TODO Auto-generated method stub
			return userSysDAO.reviewNum();
		}

		public int unreviewNum() {
			// TODO Auto-generated method stub
			return userSysDAO.unreviewNum();
		}

		public List findReviewedList() {
			// TODO Auto-generated method stub
			return userSysDAO.findReviewedList();
		}

		public List findUnreviewedList() {
			// TODO Auto-generated method stub
			return userSysDAO.findUnreviewedList();
		}

		public List findDReviewedList() {
			// TODO Auto-generated method stub
			return userSysDAO.findDReviewedList();
		}

		public void updateDReview(UserSystem userSystem) {
			// TODO Auto-generated method stub
			userSysDAO.updateDReview(userSystem);
		}

		public void updateUnReview(UserSystem userSystem) {
			// TODO Auto-generated method stub
			userSysDAO.updateUnReview(userSystem);
		}

		public int findByid(int num) {
			// TODO Auto-generated method stub
			return userSysDAO.findByid(num);
		}
}
