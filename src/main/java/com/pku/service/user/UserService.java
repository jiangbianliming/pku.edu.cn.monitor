package com.pku.service.user;

import java.util.List;

import com.pku.pojo.DataAccessNode;
import com.pku.pojo.DataCenter;
import com.pku.pojo.User;

//抽取出原来UserAction的业务逻辑，Service让Action去调
public interface UserService {
	public void register(User user) throws Exception;

	public boolean validate(User user) throws Exception;
	
	public List<DataCenter> findAllDataCenters() throws Exception;
	
	public List<DataAccessNode> findAllAccessNodes() throws Exception;
	
	
}
