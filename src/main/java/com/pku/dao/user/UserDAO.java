package com.pku.dao.user;

import java.sql.SQLException;
import java.util.List;

import com.pku.pojo.DataAccessNode;
import com.pku.pojo.DataCenter;
import com.pku.pojo.User;

//将数据库的各种操作抽象出来成为一个接口，DAOImpl类去实现该接口，具体实现该接口中的方法
//这样要是数据库的DAO操作想用别的方法实现也可以，接口不用改，改具体实现类即可
public interface UserDAO {
	public User findByName(String name) throws Exception;

	public boolean validate(User user)throws Exception;
    
	public List<DataCenter> findAllDataCenters() throws Exception;
	
	public List<DataAccessNode> findAllAccessNodes() throws Exception;

	public void save(User user) throws Exception;
}
