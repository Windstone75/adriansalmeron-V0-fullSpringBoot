package com.asf.bricotuto.webapp.controlleur.admin.database;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.asf.bricotuto.model.bean.User.AppUser;
import com.asf.bricotuto.model.bean.User.Role;
import com.asf.bricotuto.webapp.service.admin.RoleAdminService;
import com.asf.bricotuto.webapp.service.admin.UserAdminService;

@Controller
public class TableAdminController {
	
	private  UserAdminService uService = new UserAdminService();
	private RoleAdminService rService = new RoleAdminService();
	
	@RequestMapping(value = { "/admin/userTableAdmin","/{locale:en|fr|es}/admin/userTableAdmin"}, method = RequestMethod.GET)
    public ModelAndView UserTableAdminPage() {
		List<AppUser> users = uService.getListUser();
		System.out.println("nb user :"+users.size());
        return new ModelAndView("admin/userTableAdmin","users",users);
    }

	
	@RequestMapping(value = { "/admin/roleTableAdmin","/{locale:en|fr|es}/admin/roleTableAdmin"}, method = RequestMethod.GET)
	public ModelAndView RoleTableAdminPage() {
		List<Role> roles = rService.getListRole();
        return new ModelAndView("admin/roleTableAdmin","roles",roles);
		
	}

}
