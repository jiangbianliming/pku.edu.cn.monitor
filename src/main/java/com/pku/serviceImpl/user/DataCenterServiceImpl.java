package com.pku.serviceImpl.user;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pku.dao.user.DataCenterDAO;
import com.pku.pojo.DataCenter;
import com.pku.service.user.DataCenterService;

@Service("dataCenterService")
public class DataCenterServiceImpl implements DataCenterService {
	
    private DataCenterDAO dataCenterDAO;

	public void entry(DataCenter dataCenter) throws Exception {
		dataCenterDAO.save(dataCenter);
	}

	public DataCenterDAO getDataCenterDAO() {
		return dataCenterDAO;
	}

	public void setDataCenterDAO(DataCenterDAO dataCenterDAO) {
		this.dataCenterDAO = dataCenterDAO;
	}

	@Override
	public List<DataCenter> findAll() throws Exception {
		return dataCenterDAO.findAll();
	}
	
	@Override
	public DataCenter findDataCenterById(int id) throws Exception {
		return dataCenterDAO.findDataCenterById(id);
	}

	@Override
	public void update(DataCenter dataCenter) throws Exception {
		dataCenterDAO.update(dataCenter);
	}
	
	//add by zhang yu
		public List findbyAll() {
			// TODO Auto-generated method stub
			return dataCenterDAO.findAllDataCenter();
		}

		public List findbyId(int num) {
			// TODO Auto-generated method stub
			return dataCenterDAO.findById(num);
		}

		public int totalNum() {
			// TODO Auto-generated method stub
			return dataCenterDAO.totalNum();
		}

		public int reviewNum() {
			// TODO Auto-generated method stub
			return dataCenterDAO.reviewNum();
		}

		public int unreviewNum() {
			// TODO Auto-generated method stub
			return dataCenterDAO.unreviewNum();
		}

		public List findReviewedList() {
			// TODO Auto-generated method stub
			return dataCenterDAO.findReviewedList();
		}

		public List findUnreviewedList() {
			// TODO Auto-generated method stub
			return dataCenterDAO.findUnreviewedList();
		}

		public List findDReviewedList() {
			// TODO Auto-generated method stub
			return dataCenterDAO.findDReviewedList();
		}

		public void updateDReview(DataCenter dataCenter) {
			// TODO Auto-generated method stub
			dataCenterDAO.updateDReview(dataCenter);
			
		}

		public void updateUnreview(DataCenter dataCenter) {
			// TODO Auto-generated method stub
			dataCenterDAO.updateUnReview(dataCenter);
		}

		public boolean findPass(String name) {
			// TODO Auto-generated method stub
			return dataCenterDAO.findPass(name);
		}

		public int findByid(int num) {
			// TODO Auto-generated method stub
			return dataCenterDAO.findByid(num);
		}

		public String findIpAddr(String name) {
			// TODO Auto-generated method stub
			return dataCenterDAO.findIpAddr(name);
		}
}
