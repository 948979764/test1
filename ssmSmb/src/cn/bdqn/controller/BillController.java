package cn.bdqn.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.bdqn.pojo.Bill;
import cn.bdqn.pojo.Provider;
import cn.bdqn.pojo.User;
import cn.bdqn.service.BillService;
import cn.bdqn.service.ProviderService;
import cn.bdqn.util.PageBean;


@Controller
 
public class BillController {
	@Resource(name = "billService")
	private BillService billService;
	@Resource(name = "providerService")
	private ProviderService providerService;
	
	// ��ʾ������Ʒ������Ϣ
    @RequestMapping(value ="/billList.html")
	public String showBill(
			@RequestParam(required = false, defaultValue = "1") Integer pageNo,
			@RequestParam(required = false) String queryProductName,
			@RequestParam(required = false) Integer queryProviderId,
			@RequestParam(required = false) Integer queryIsPayment,
			Model model
			){
    	try {
			if (queryProductName != null)
				queryProductName = new String(queryProductName.getBytes("ISO-8859-1"),
						"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	int pageSize = 5;
		PageBean<Bill> pageBean = billService.findByPage(
				queryProductName,queryProviderId,queryIsPayment,pageNo, pageSize
				);
    	List<Provider> providerList=providerService.findAll();
    	 model.addAttribute("pageBean",pageBean);
    	 model.addAttribute("providerList",providerList);
    	 model.addAttribute("queryProductName",queryProductName);
    	 model.addAttribute("queryProviderId",queryProviderId);
    	 model.addAttribute("queryIsPayment",queryIsPayment);
    	return "billlist";
    }
   
 // ��ʾ����û�ҳ��
    @RequestMapping(value ="/billadd.html")
    public String billAdd(){
    	
    	return "billadd";
    }
    
    //��ʾ���й�Ӧ��    
    @RequestMapping(value ="/getProviderList")
    @ResponseBody  //��ʹ�����ע�ⷽ���ķ��ؽ��
    public List<Provider> showProvider(){
    	List<Provider> providerList=providerService.findAll();
    	return providerList;
    }
    
    //������������   
    @RequestMapping(value ="/addbill.html")
    public String addBill(
    	Bill bill,
    	HttpSession session
    		){
    	User userLogin = (User) session.getAttribute("userSession");
    	bill.setCreatedBy(userLogin.getId());
    	bill.setCreationDate(new Date());
    	int ret=billService.addBill(bill);
    	if (ret > 0) {
			return "redirect:billList.html";
		} else {
			return "error";
		}

    }
 
    //�����޸���Ϣ
      @RequestMapping(value ="/updatemodify.html")
      public String  addModify(
      		 Bill bill,   		
      		HttpSession session
      		){    	
      	User userLogin=(User)session.getAttribute("userSession");
      	bill.setCreatedBy(userLogin.getId());
      	bill.setCreationDate(new Date());
      	int ret=billService.updateModify(bill);
      	if (ret > 0) {
  			return "redirect:billList.html";
  		} else {
  			return "error";
  		}

      }
     
    
}
