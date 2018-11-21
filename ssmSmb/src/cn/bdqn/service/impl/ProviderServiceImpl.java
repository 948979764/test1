package cn.bdqn.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

 
import cn.bdqn.dao.ProviderDao;
import cn.bdqn.pojo.Bill;
import cn.bdqn.pojo.Provider;
import cn.bdqn.pojo.User;
import cn.bdqn.service.ProviderService;
import cn.bdqn.util.PageBean;
@Service("providerService")
public class ProviderServiceImpl implements ProviderService{
	@Resource(name="providerDao")
	private ProviderDao providerDao;

	public List<Provider> findAll() {
		// TODO Auto-generated method stub
		return providerDao.findAll();
	}

	public PageBean<Provider> findByPage(String queryProCode, String queryProName,Integer pageNo, int pageSize){
			PageBean<Provider> pageBean=new PageBean<Provider>();
	  pageBean.setPageSize(pageSize);
	  int totalCount=providerDao.getTotalCount(queryProCode,queryProName);
	  pageBean.setTotalCount(totalCount);
	  pageBean.setPageNo(pageNo); 
	  int  from=(pageBean.getPageNo()-1)*pageSize;
	  List<Provider> pageList=providerDao.findByPage(queryProName,queryProCode,from,pageSize);
	   pageBean.setPageList(pageList);
	   
	return pageBean;
	}

	public int addProv(Provider prov) {
		// TODO Auto-generated method stub
		return providerDao.addProv(prov);
	}

	public Provider findById(Integer id) {
		// TODO Auto-generated method stub
		return providerDao.findById(id);
	}

	public int updateModify(Provider prov) {
		// TODO Auto-generated method stub
		return providerDao.updateModify(prov);
	}

	public int delById(Integer uid) {
		// TODO Auto-generated method stub
		return providerDao.delById(uid);
	}

	

}
