package com.asf.bricotuto.webapp.rest.resource.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.asf.bricotuto.business.impl.ManagerFactory;
import com.asf.bricotuto.webapp.rest.resource.AbstractResource;
import com.asf.formationtuto.model.bean.User.User;


@Controller
public class UserController extends AbstractResource{
	
    @GetMapping({"/", "/user"})
    
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="") String name) {
    	
    	User vUser = getManagerFactory().getUserManager().getUser(3);
        model.addAttribute("name", vUser.getLogin());
        
        return "hello";
    }
}
