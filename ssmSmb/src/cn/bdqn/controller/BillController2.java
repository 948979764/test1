package cn.bdqn.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.bdqn.pojo.Bill;
import cn.bdqn.pojo.Provider;
import cn.bdqn.pojo.User;
import cn.bdqn.service.BillService;
import cn.bdqn.service.ProviderService;



@Controller
@RequestMapping(value="/bill")
public class BillController2 {
	
	@Resource(name = "billService")
	private BillService billService;
	
	 
	 //��ʾ������Ϣ   
    @RequestMapping(value ="/view/{id}")
    public String  billView(
    		@PathVariable
    		Integer  id,   		
    		Model model
    		){    	
    	Bill bill=billService.findById(id);
    	model.addAttribute("bill", bill);
    	return "billview";
    }
    //��ʾ�޸���Ϣ
    @RequestMapping(value ="/modify/{id}")
    public String  billModify(
    		@PathVariable
    		Integer  id,   		
    		Model model
    		){    	
    	Bill bill=billService.findById(id);
    	model.addAttribute("bill", bill);
    	return "billmodify";
    }
    
 // ɾ���û�
 	@RequestMapping(value ="/dell/{uid}")
 	@ResponseBody
 	public Object delbill(
 			@PathVariable//��PathVariableע���ȡid
 			Integer uid,
 			HttpServletRequest request){
 		Map<String, String> retmap = new HashMap<String, String>();
 		//System.out.println(uid);
 		if(uid==null){
 			retmap.put("ret", "notexist");
 		}else{
 		int ret=billService.delById(uid);
 		if(ret>0){
 			retmap.put("ret", "true");
 		}else {
 			retmap.put("ret", "false");
 		}
 		}
 		return retmap;
 	}
}
