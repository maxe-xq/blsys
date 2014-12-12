package com.bl.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import com.bl.bean.BlCompany;
import com.bl.bean.BlInfo;
import com.bl.bean.BlStore;
import com.bl.bean.PageList;
import com.bl.service.BlService;

public class BlAction extends BaseAction {

	/**
	 * 业务
	 */
	private static final long serialVersionUID = 154440865126027710L;
	
	@Resource(name="BlService")
    private BlService blService;
	
	public String nav;
	public PageList<BlStore> storeList;
	public PageList<BlInfo> blList;
	public PageList<BlCompany> companyList;
	
	/**
	 * 界面
	 * @return
	 */
	public String index(){
		if("store".equalsIgnoreCase(nav)){
			queryStoreList();
		}else if("inStore".equalsIgnoreCase(nav)){
			queryBlList();
			queryCompanyList();
		}else if("outStore".equalsIgnoreCase(nav)){
			queryStoreList();
			queryCompanyList();
		}
		return nav;
	}
	
	/**
	 * 获取库存列表
	 * @return
	 */
	public void queryStoreList(){
		Map<String,String> conditions = new HashMap<String,String>();
		storeList = blService.queryStoreByConditions(page, pagesize, conditions);
		//outputResult(storeList);
	}
	
	/**
	 * 获取玻璃列表
	 * @return
	 */
	public void queryBlList(){
		Map<String,String> conditions = new HashMap<String,String>();
		blList = blService.queryBlByConditions(page, pagesize, conditions);
		//outputResult(blList);
	}
	
	public void queryCompanyList(){
		Map<String,String> conditions = new HashMap<String,String>();
		companyList = blService.getCompanyPageList(page, pagesize, conditions);
		//outputResult(blList);
	}

	public BlService getBlService() {
		return blService;
	}

	public void setBlService(BlService blService) {
		this.blService = blService;
	}
}
