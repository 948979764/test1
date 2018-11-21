package cn.bdqn.service;

import java.util.List;

import cn.bdqn.pojo.Bill;
import cn.bdqn.util.PageBean;

public interface BillService {

	List<Bill> findAll();

	 

	PageBean<Bill> findByPage(String queryProductName, Integer queryProviderId,
			Integer	queryIsPayment,Integer pageNo, int pageSize);

	int addBill(Bill bill);



	Bill findById(int parseInt);



	 



	int updateModify(Bill bill);



	int delById(Integer uid);


 
}
