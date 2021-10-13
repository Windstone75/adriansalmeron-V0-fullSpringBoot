package com.asf.adriansalmeron.webapp.controlleur.admin.database;

import javax.validation.Valid;

import com.asf.adriansalmeron.webapp.service.admin.RoleAdminService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.asf.adriansalmeron.model.bean.User.Role;
import com.asf.adriansalmeron.model.exception.FunctionalException;

@Controller
@RequestMapping("/admin/database/roleTable")
public class RoleTableController {

	private RoleAdminService roleAdminService = new RoleAdminService();
	private String viewHomeMapping = "admin/database/roleTable";

	/**
	 * Show Add role Form
	 * 
	 * @param role
	 * @return
	 */
	@GetMapping("/add")
	public ModelAndView showAddRoleForm(Role role) {
		return new ModelAndView(viewHomeMapping + "/addRole", "role", role);
	}

	/**
	 * Add role
	 * 
	 * @param role
	 * @param result
	 * @param modelAndView
	 * @return
	 */
	@PostMapping("/add")
	public ModelAndView addRole(@Valid Role role, BindingResult result, ModelAndView modelAndView,
			final RedirectAttributes redirectAttributes) {
		String messageflashSuccess = "Add role " + role.getName() + " successfully!";
		modelAndView = new ModelAndView(viewHomeMapping + "/addRole", "role", role);
		try {
			if (result.hasErrors()) {
				return modelAndView;
			}
			roleAdminService.addRole(role);

			redirectAttributes.addFlashAttribute("flashSuccess", messageflashSuccess);
			return new ModelAndView("redirect:/admin/database/roleTable");
		} catch (FunctionalException funcEx) {
			modelAndView.addObject("errorform", funcEx.getMessage());
			return modelAndView;
		}
	}

	/**
	 * Show update Role Form
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/update/{id}")
	public ModelAndView showUpdateRoleForm(@PathVariable("id") long id) {
		return new ModelAndView(viewHomeMapping + "/updateRole", "role", roleAdminService.findbyID(id));
	}

	/**
	 * Update Role
	 * 
	 * @param id
	 * @param role
	 * @param result
	 * @return
	 */
	@PostMapping("/update/{id}")
	public ModelAndView updateRole(@PathVariable("id") long id, @Valid Role role, BindingResult result,
			ModelAndView modelAndView, final RedirectAttributes redirectAttributes) {
		
		String messageflash = "Update role with id ( " + id + " ) successfully!";
		modelAndView = new ModelAndView(viewHomeMapping + "/updateRole");
		//fields disable
		role.setRoleId(id);	
		try {

			if (result.hasErrors()) {
				
				modelAndView.addObject("role",roleAdminService.findbyID(id));
				return modelAndView;
			}
			redirectAttributes.addFlashAttribute("flashSuccess", messageflash);
			roleAdminService.updateRole(role);
			return new ModelAndView("redirect:/admin/database/roleTable");
		} catch (FunctionalException funcEx) {
			modelAndView.addObject("errorform", funcEx.getMessage());
			return modelAndView;
		}
	
	}

	/**
	 * Delete role
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/delete/{id}")
	public ModelAndView deleteRole(@PathVariable("id") long id,final RedirectAttributes redirectAttributes) {
		String messageflash = "Delete role with id ( " + id + " ) successfully!";
		roleAdminService.deleteRoleById(id);
		redirectAttributes.addFlashAttribute("flashSuccess",messageflash);
		return new ModelAndView("redirect:/admin/database/roleTable");
	}

}