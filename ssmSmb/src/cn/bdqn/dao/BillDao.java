package cn.bdqn.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.bdqn.pojo.Bill;
 

public interface BillDao {

	List<Bill> findAll();

	 

	List<Bill> findByPage(			
			@Param("queryProductName")
			String  queryProductName,
			@Param("queryProviderId")
			Integer queryProviderId,
			@Param("queryIsPayment")
			Integer queryIsPayment,
			@Param("from")
			int from,
			@Param("pageSize")
			int pageSize);



	 



	int getTotalCount(
			@Param("queryProductName")
			String queryProductName,
			@Param("queryIsPayment")
			Integer queryIsPayment,
			@Param("queryProviderId")
			Integer queryProviderId);


	int addBill(Bill bill);



	Bill findById(int id);



	int updateModify(Bill bill);

 

	int delbill(Integer uid);

	 

	 
}
