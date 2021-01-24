package com.asf.bricotuto.webapp.controlleur.admin;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.asf.bricotuto.model.bean.User.AppUser;
import com.asf.bricotuto.model.bean.User.Role;
import com.asf.bricotuto.webapp.service.user.UserService;

@Controller
public class TableAdminController {
	
	private  UserService uService = new UserService();
	
	@RequestMapping(value = { "/admin/userTableAdmin","/{locale:en|fr|es}/admin/userTableAdmin"}, method = RequestMethod.GET)
    public ModelAndView UserTableAdminPage() {
		List<AppUser> users = uService.getListUser();
        return new ModelAndView("admin/userTableAdmin","users",users);
    }

	
	@RequestMapping(value = { "/admin/roleTableAdmin","/{locale:en|fr|es}/admin/roleTableAdmin"}, method = RequestMethod.GET)
	public ModelAndView RoleTableAdminPage() {
		List<Role> roles = uService.getListRole();
        return new ModelAndView("admin/roleTableAdmin","roles",roles);
		
	}

}
