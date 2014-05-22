package com.pku.serviceImpl.user;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pku.dao.user.DataAccessNodeDAO;
import com.pku.pojo.DataAccessNode;
import com.pku.pojo.DataCenter;
import com.pku.service.user.DataAccessNodeService;
@Service("dataAccessNodeService")
public class DataAccessNodeServiceImpl implements DataAccessNodeService{
private DataAccessNodeDAO dataAccessNodeDAO;
	
	public DataAccessNodeDAO getDataAccessNodeDAO() {
	return dataAccessNodeDAO;
}

public void setDataAccessNodeDAO(DataAccessNodeDAO dataAccessNodeDAO) {
	this.dataAccessNodeDAO = dataAccessNodeDAO;
}

	public void entry(DataAccessNode dataAccessNode) throws Exception {
		dataAccessNodeDAO.save(dataAccessNode);
	}

	public DataCenter findDataCenterById(int i) throws Exception{
		DataCenter dataCenter = dataAccessNodeDAO.findDataCenterById(i);
		return dataCenter;
	}

	@Override
	public List<DataAccessNode> findAll() throws Exception {
		return dataAccessNodeDAO.findAll();
	}
	
	@Override
	public DataAccessNode findDataAccessNodeById(int id) throws Exception {
		return dataAccessNodeDAO.findDataAccessNodeById(id);
	}
	
	@Override
	public void update(DataAccessNode dataAccessNode) throws Exception {
		dataAccessNodeDAO.update(dataAccessNode);
	}
	
	
	//add by Zhang Yu
		public List findbyAll() {
			// TODO Auto-generated method stub
			return dataAccessNodeDAO.findAllDataAccessNode();
		}

		public List findbyId(int num) {
			// TODO Auto-generated method stub
			return dataAccessNodeDAO.findById(num);
		}

		public int totalNum() {
			// TODO Auto-generated method stub
			return dataAccessNodeDAO.totalNum();
		}

		public int reviewNum() {
			// TODO Auto-generated method stub
			return dataAccessNodeDAO.reviewNum();
		}

		public int unreviewNum() {
			// TODO Auto-generated method stub
			return dataAccessNodeDAO.unreviewNum();
		}

		public List findReviewedList() {
			// TODO Auto-generated method stub
			return dataAccessNodeDAO.findReviewedList();
		}

		public List findUnreviewedList() {
			// TODO Auto-generated method stub
			return dataAccessNodeDAO.findUnreviewedList();
		}

		public List findDReviewedList() {
			// TODO Auto-generated method stub
			return dataAccessNodeDAO.findDReviewedList();
		}

		public void updateDReview(DataAccessNode dataAccessNode) {
			// TODO Auto-generated method stub
			dataAccessNodeDAO.updateDReview(dataAccessNode);
		}

		public void updateUnReview(DataAccessNode dataAccessNode) {
			// TODO Auto-generated method stub
			dataAccessNodeDAO.updateUnReview(dataAccessNode);
			
		}

		public boolean findPass(String name) {
			// TODO Auto-generated method stub
			return dataAccessNodeDAO.findPass(name);
		}

		public int findByid(int num) {
			// TODO Auto-generated method stub
			return dataAccessNodeDAO.findByid(num);
		}

		public String findIpAddr(String name) {
			// TODO Auto-generated method stub
			return dataAccessNodeDAO.findIpAddr(name);
		}
}
