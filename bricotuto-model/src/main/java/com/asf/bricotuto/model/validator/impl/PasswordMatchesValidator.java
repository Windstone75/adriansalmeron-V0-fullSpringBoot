package com.asf.bricotuto.model.validator.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.asf.bricotuto.model.bean.User.AppUser;
import com.asf.bricotuto.model.validator.PasswordMatches;

public class PasswordMatchesValidator 
implements ConstraintValidator<PasswordMatches, Object> { 
  
  @Override
  public void initialize(PasswordMatches constraintAnnotation) {       
  }
  @Override
  public boolean isValid(Object obj, ConstraintValidatorContext context){   
      AppUser user = (AppUser) obj;
      return user.getPassword().equals(user.getMatchingPassword());    
  }     
}