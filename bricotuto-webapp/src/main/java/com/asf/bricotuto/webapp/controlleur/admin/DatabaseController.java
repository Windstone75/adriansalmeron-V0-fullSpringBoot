package com.asf.bricotuto.webapp.controlleur.admin;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import com.asf.bricotuto.model.bean.User.AppUser;
import com.asf.bricotuto.model.bean.User.Role;
import com.asf.bricotuto.webapp.service.admin.RoleAdminService;
import com.asf.bricotuto.webapp.service.admin.UserAdminService;

@Controller
public class DatabaseController {
	
	private  UserAdminService uService = new UserAdminService();
	private RoleAdminService rService = new RoleAdminService();
	
	@GetMapping(value = { "/admin/database/userTable","/{locale:en|fr|es}/admin/userTable"})
    public ModelAndView UserTableAdminPage() {
		List<AppUser> users = uService.getListUser();
        return new ModelAndView("admin/database/userTable/home","users",users);
    }

	
	@GetMapping(value = { "/admin/database/roleTable","/{locale:en|fr|es}/admin/database/roleTable"})
	public ModelAndView RoleTableAdminPage() {
		List<Role> roles = rService.getListRole();
        return new ModelAndView("admin/database/roleTable/home","roles",roles);
		
	}

}
