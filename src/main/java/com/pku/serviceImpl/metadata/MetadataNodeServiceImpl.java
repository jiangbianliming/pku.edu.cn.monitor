package com.pku.serviceImpl.metadata;

import org.springframework.stereotype.Service;

import com.pku.dao.metadata.MetadataNodeDAO;
import com.pku.pojo.MetadataNode;
import com.pku.service.metadata.MetadataNodeService;
@Service("metadataNodeService")
public class MetadataNodeServiceImpl implements MetadataNodeService {
	
	private MetadataNodeDAO metadataNodeDAO;
	

	public MetadataNodeDAO getMetadataNodeDAO() {
		return metadataNodeDAO;
	}


	public void setMetadataNodeDAO(MetadataNodeDAO metadataNodeDAO) {
		this.metadataNodeDAO = metadataNodeDAO;
	}


	public void save(MetadataNode metadataNode) throws Exception {
		metadataNodeDAO.save(metadataNode);
	}

}
