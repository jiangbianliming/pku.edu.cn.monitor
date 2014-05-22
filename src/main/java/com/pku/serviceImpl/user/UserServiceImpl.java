package com.pku.serviceImpl.user;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pku.dao.user.UserDAO;
import com.pku.pojo.DataAccessNode;
import com.pku.pojo.DataCenter;
import com.pku.pojo.User;
import com.pku.service.user.UserService;

@Service("userService")
//将本类以id为userService纳入容器
public class UserServiceImpl implements UserService{
	private UserDAO userDao;//让spring容器找HibernateUserDAOImpl，通过setUserDAO注入，这里可以直接用
	
	public void register(User user) throws Exception {//原来在RegistAction中
		//保存用户信息
		userDao.save(user);
	}
	
	public UserDAO getUserDao() {
		return userDao;
	}

	//按类型匹配查找，会找到HibernateUserDAOImpl注入
	@Autowired
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	@Override
	public boolean validate(User user) throws Exception {
        
		return userDao.validate(user);
	}
	
	public List<DataCenter> findAllDataCenters() throws Exception{
		return userDao.findAllDataCenters();
	}
	
	public List<DataAccessNode> findAllAccessNodes() throws Exception{
		return userDao.findAllAccessNodes();
	}
}