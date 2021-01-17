package com.asf.bricotuto.webapp.controlleur;

import java.util.Map;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.asf.bricotuto.model.bean.User.User;
import com.asf.bricotuto.webapp.service.user.UserService;

@Controller
@RequestMapping(value = "/login")
public class Connection {

   @RequestMapping(method = RequestMethod.GET)
   public String vueConnection(Map<String, Object> model) {
       User userForm = new User();    
       model.put("userForm", userForm);        
       return "login";
   }
    
   @RequestMapping(method = RequestMethod.POST)
   public String processConection(@ModelAttribute("userForm") User user,
           Map<String, Object> model) {
     
	   UserService uControlleur =new UserService();
	   if (uControlleur.verifieridentifiant(user.getLogin(), user.getPassword())!=null){
		   model.put("resultat","felicitation vous etes connecté");	        
	       return "index";
	   }
      return "login";
   }
}
