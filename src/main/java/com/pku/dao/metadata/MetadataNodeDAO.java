package com.pku.dao.metadata;

import java.sql.SQLException;

import com.pku.pojo.MetadataNode;

public interface MetadataNodeDAO {
	
	//保存到数据库中
	public void save(MetadataNode metadataNode) throws SQLException;

}
