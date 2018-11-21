package cn.bdqn.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.bdqn.pojo.Bill;
import cn.bdqn.pojo.Provider;

public interface ProviderDao {
	//查询所有供应商
		List<Provider> findAll();

		int getTotalCount(
				@Param("queryProCode")
				String queryProCode,
				@Param("queryProName")
				String queryProName);

		List<Provider> findByPage(
				@Param("queryProName")
				String queryProName, 
				@Param("queryProCode")
				String queryProCode,
				@Param("from")
				int from, 
				@Param("pageSize")
				int pageSize);

		int addProv(Provider prov);

		Provider findById(Integer id);

		int updateModify(Provider prov);

		int delById(Integer uid);

		
}
