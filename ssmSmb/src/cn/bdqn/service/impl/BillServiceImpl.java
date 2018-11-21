package cn.bdqn.service.impl;
 

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

 

import cn.bdqn.dao.BillDao;
import cn.bdqn.pojo.Bill;
 
import cn.bdqn.service.BillService;
import cn.bdqn.util.PageBean;
@Service("billService")
public class BillServiceImpl implements BillService{
	@Resource(name="billDao")
	private BillDao BillDao;

	public List<Bill> findAll() {
		// TODO Auto-generated method stub
		return BillDao.findAll();
	}

	/*public PageBean<Bill> findByPage(Integer pageNo, int pageSize) {
		PageBean<Bill> pageBean=new PageBean<Bill>();
		  pageBean.setPageSize(pageSize);
		  int totalCount=BillDao.getTotalCount();
		  pageBean.setTotalCount(totalCount);
		  pageBean.setPageNo(pageNo); 
		  int  from=(pageBean.getPageNo()-1)*pageSize;
		  List<Bill> pageList=BillDao.findByPage(from,pageSize);
		   pageBean.setPageList(pageList);
		return pageBean;
	}*/

	public PageBean<Bill> findByPage(String queryProductName,
			Integer queryProviderId, Integer queryIsPayment,Integer pageNo, int pageSize) {
		PageBean<Bill> pageBean=new PageBean<Bill>();
		  pageBean.setPageSize(pageSize);
		  int totalCount=BillDao.getTotalCount(queryProductName,queryProviderId,queryIsPayment);
		  pageBean.setTotalCount(totalCount);
		  pageBean.setPageNo(pageNo); 
		  int  from=(pageBean.getPageNo()-1)*pageSize;
		  List<Bill> pageList=BillDao.findByPage(queryProductName,queryProviderId,queryIsPayment,from,pageSize);
		   pageBean.setPageList(pageList);
		return pageBean;
	}
	public int addBill(Bill bill) {
		// TODO Auto-generated method stub
		return BillDao.addBill(bill);
	}

	public Bill findById(int id) {
		// TODO Auto-generated method stub
		return BillDao.findById(id);
	}

	public int updateModify(Bill bill) {
		// TODO Auto-generated method stub
		return BillDao.updateModify(bill);
	}

	public int delById(Integer uid) {
		// TODO Auto-generated method stub
		return BillDao.delbill(uid);
	}

	 
	
}
