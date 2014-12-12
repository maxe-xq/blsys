package com.bl.controller;

import javax.annotation.Resource;

import com.bl.bean.BlUser;
 import com.bl.service.UserService;

public class UserAction extends BaseAction {

	/**
	 * 用户action
	 */
	private static final long serialVersionUID = 5800823690318213202L;
	@Resource(name="UserService")
    private UserService userService;
	private BlUser user;
	
	public String login(){
		if(userService.getUserByKey(user)!=null)
			return SUCCESS;
		else
			return NONE;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public BlUser getUser() {
		return user;
	}
	public void setUser(BlUser user) {
		this.user = user;
	}
}
