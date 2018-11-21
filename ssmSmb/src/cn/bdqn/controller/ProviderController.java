package cn.bdqn.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.bdqn.pojo.Bill;
import cn.bdqn.pojo.Provider;
import cn.bdqn.pojo.User;
import cn.bdqn.service.ProviderService;
import cn.bdqn.util.PageBean;


@Controller
public class ProviderController {

	
	@Resource(name = "providerService")
	private ProviderService providerService;
	
	// 显示所有商品信息
    @RequestMapping(value ="/providerList.html")
    
	public String showProvider(
			@RequestParam(required = false, defaultValue = "1") Integer pageNo,
			@RequestParam(required = false) String queryProCode,
			@RequestParam(required = false) String queryProName,			 
			Model model
			){
    	try {
			if (queryProName != null){
			 queryProName = new String(queryProName.getBytes("ISO-8859-1"),
						"UTF-8");}
			else if(queryProCode != null){
				queryProCode = new String(queryProCode.getBytes("ISO-8859-1"),
							"UTF-8");
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	int pageSize = 5;
		PageBean<Provider> pageBean = providerService.findByPage(
				queryProCode,queryProName,pageNo, pageSize
				);
    	//List<Provider> providerList=providerService.findAll();
    	 model.addAttribute("pageBean",pageBean);
    	// model.addAttribute("providerList",providerList);
    	 model.addAttribute("queryProCode",queryProCode);
    	 model.addAttribute("queryProName",queryProName);
    	 
    	return "providerlist";
    }
    
 // 显示添加用户页面
    @RequestMapping(value ="/addProvider.html")
    public String providerAdd(){
    	
    	return "provideradd";
    }
    
    //处理新增订单   
    @RequestMapping(value ="/provideradd.html")
    public String addProvider(
    	Provider prov,
    	HttpSession session
    		){
    	User userLogin = (User) session.getAttribute("userSession");
    	prov.setCreatedBy(userLogin.getId());
    	prov.setCreationDate(new Date());
    	int ret=providerService.addProv(prov);
    	if (ret > 0) {
			return "redirect:providerList.html";
		} else {
			return "error";
		}

    }
    
   
    //处理修改信息
    @RequestMapping(value ="/updateProvider.html")
    public String  addModify(
    		Provider prov,
        	HttpSession session
    		){    	
    	User userLogin=(User)session.getAttribute("userSession");
    	prov.setCreatedBy(userLogin.getId());
    	prov.setCreationDate(new Date());
    	int ret=providerService.updateModify(prov);
    	if (ret > 0) {
			return "redirect:providerList.html";
		} else {
			return "error";
		}

    }
    
    
    
}
