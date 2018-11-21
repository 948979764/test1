package cn.bdqn.service;

import java.util.List;

import cn.bdqn.pojo.Bill;
import cn.bdqn.pojo.Provider;
import cn.bdqn.util.PageBean;

public interface ProviderService {

	List<Provider> findAll();

	PageBean<Provider> findByPage(String queryProCode, String queryProName,
			Integer pageNo, int pageSize);

	int addProv(Provider prov);

	Provider findById(Integer id);

	int updateModify(Provider prov);

	int delById(Integer uid);

	

}
