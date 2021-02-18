package com.asf.bricotuto.webapp.failurehandler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.asf.bricotuto.business.contract.ManagerFactory;
import com.asf.bricotuto.model.bean.User.AppUser;

@Component
public class UserDetailFailureHandler extends SimpleUrlAuthenticationFailureHandler {
	
	@Autowired
	private ManagerFactory mFactory;

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		String errorMessage;
		String email = request.getParameter("email");
		AppUser user=mFactory.getAuthManager().getUserToSignIn(email);		
		
		 if (user!=null && !user.isEnabled()){
			 errorMessage="User is disable";
		 }else if(user!=null && user.isEnabled()) {
			 errorMessage="Invalid Password ";
		 }else {
			 errorMessage="Email is not found";
		 }
		 String redirectURL = "/signin?error="+errorMessage;
		super.setDefaultFailureUrl(redirectURL);
        super.onAuthenticationFailure(request, response, exception);
        
	}

}