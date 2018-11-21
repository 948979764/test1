package cn.bdqn.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.bdqn.pojo.Bill;
import cn.bdqn.pojo.Provider;
import cn.bdqn.service.ProviderService;


@Controller
@RequestMapping(value="/provider")
public class ProviderController2 {

	
	@Resource(name = "providerService")
	private ProviderService providerService;
	
	 //��ʾ������Ϣ   
    @RequestMapping(value ="/view/{id}")
    public String  providerView(
    		@PathVariable
    		Integer  id,   		
    		Model model
    		){    	
    	Provider provider=providerService.findById(id);
    	model.addAttribute("provider", provider);
    	return "providerview";
    }
  //��ʾ�޸���Ϣ
    @RequestMapping(value ="/modify/{id}")
    public String  billModify(
    		@PathVariable
    		Integer  id,   		
    		Model model
    		){    	
    	Provider provider=providerService.findById(id);
    	model.addAttribute("provider", provider);
    	return "providermodify";
    }
 // ɾ���û�
  	@RequestMapping(value ="/del/{uid}")
  	@ResponseBody
  	public Object delprovider(
  			@PathVariable//��PathVariableע���ȡid
  			Integer uid,
  			HttpServletRequest request){
  		Map<String, String> retmap = new HashMap<String, String>();
  		//System.out.println(uid);
  		if(uid==null){
  			retmap.put("ret", "notexist");
  		}else{
  		int ret=providerService.delById(uid);
  		if(ret>0){
  			retmap.put("ret", "true");
  		}else {
  			retmap.put("ret", "false");
  		}
  		}
  		return retmap;
  	}
}
