package com.asf.adriansalmeron.webapp.controlleur.admin.database;

import java.util.Date;

import javax.validation.Valid;

import com.asf.adriansalmeron.webapp.service.admin.RoleAdminService;
import com.asf.adriansalmeron.webapp.service.admin.UserAdminService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.asf.adriansalmeron.model.bean.User.AppUser;
import com.asf.adriansalmeron.model.exception.FunctionalException;

@Controller
@RequestMapping("/admin/database/userTable")
public class UserTableController {
	
	private RoleAdminService roleAdminService = new RoleAdminService();
	private UserAdminService userAdminService = new UserAdminService();
	private String viewHomeMapping = "admin/database/userTable";

	/**
	 * Show Add User Form
	 * 
	 * @param user
	 * @return
	 */
	@GetMapping("/add")
	public ModelAndView showAddUserForm(AppUser user) {
		return new ModelAndView(viewHomeMapping + "/addUser", "user", user);
	}

	/**
	 * Add User
	 * 
	 * @param user
	 * @param result
	 * @return
	 */
	@PostMapping("/add")
	public ModelAndView addUser(@Valid AppUser user, BindingResult result,final RedirectAttributes redirectAttributes) {
		ModelAndView modelAndView = new ModelAndView(viewHomeMapping + "/addUser", "user", user);
		Boolean isPasswordMatch = !user.getPassword().equals(user.getMatchingPassword());
		String messageflashSuccess = "Add User " + user.getEmail() + " successfully!";
		try {
			if (result.hasErrors() || isPasswordMatch) {
				// Verification password Match
				if (!user.getPassword().equals(user.getMatchingPassword())) {
					modelAndView.addObject("errorform", "Password don't match");
				}				
				return modelAndView;
			}
			user.setInscriptionDt(new Date());
			userAdminService.addUser(user);
			
			redirectAttributes.addFlashAttribute("flashSuccess",messageflashSuccess);
			return new ModelAndView("redirect:/admin/database/userTable");
			
		} catch (FunctionalException funcEx) {
			modelAndView.addObject("errorform", funcEx.getMessage());
			return modelAndView;
		}
	}

	/**
	 * Show Update User Form
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/update/{id}")
	public ModelAndView showUpdateUserForm(@PathVariable("id") long id) {
		ModelAndView modelAndView = new ModelAndView(viewHomeMapping + "/updateUser");
		AppUser user=userAdminService.findbyID(id);
		modelAndView.addObject("user",user);
		modelAndView.addObject("listeRoleNameUser",userAdminService.getlistRoleNameByUserId(id));		
		modelAndView.addObject("listeRole",roleAdminService.getListRole());
		return modelAndView;
	}

	/**
	 * Update User
	 * 
	 * @param id
	 * @param user
	 * @param result
	 * @return
	 */
	@PostMapping("/update/{id}")
	public ModelAndView updateUser(@PathVariable("id") long id,@Valid AppUser user, BindingResult result,ModelAndView modelAndView,final RedirectAttributes redirectAttributes) {
		//fields disable
		user.setUserId(id);	
		modelAndView = new ModelAndView(viewHomeMapping + "/updateUser", "user", user);
		String messageflash = "Update User with id ( " + id + " ) successfully!";
		
		try {
			AppUser usertmp=userAdminService.findbyID(id);
			user.setRoles(usertmp.getRoles());
			if (result.hasErrors()) {	
				return modelAndView;
			}
			userAdminService.updateUser(user);
			redirectAttributes.addFlashAttribute("flashSuccess",messageflash);
			return new ModelAndView("redirect:/admin/database/userTable");
			
		} catch (FunctionalException funcEx) {
			modelAndView.addObject("errorform", funcEx.getMessage());			
			return modelAndView;
		}
	}

	/**
	 * Delete User
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/delete/{id}")
	public ModelAndView deleteRole(@PathVariable("id") long id,final RedirectAttributes redirectAttributes) {
		String messageflash = "Delete User with id ( " + id + " ) successfully!";
		userAdminService.deleteUserById(id);		
		
		redirectAttributes.addFlashAttribute("flashSuccess",messageflash);
		return new ModelAndView("redirect:/admin/database/userTable");
	}

}