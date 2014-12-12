package com.bl.service;

import java.util.List;
import java.util.Map;

import com.bl.bean.BlCompany;
import com.bl.bean.BlInfo;
import com.bl.bean.BlOrder;
import com.bl.bean.BlOrderItem;
import com.bl.bean.BlStore;
import com.bl.bean.PageList;

public interface BlService {
	public boolean addOrder(BlOrder blOrder);
	public boolean updateOrder(BlOrder blOrder);
	public boolean deleteOrder(String bl_order_id);
	public boolean addOrderItem(BlOrderItem blOrderItem);
	public boolean updateOrderItem(BlOrderItem blOrderItem);
	public boolean deleteOrderItem(String bl_item_id);
	public boolean batchAddOrderItem(List<BlOrderItem> items);
	public boolean batchUpdateOrderItem(List<BlOrderItem> items);
	public boolean batchDeleteOrderItem(String[] bl_item_ids);
	public boolean batchUpdateStore(List<BlStore> stores);
	public boolean updateStore(BlStore store);
	public boolean addStore(BlStore store);
	public boolean batchAddStore(List<BlStore> stores);
	public PageList<BlStore> queryStoreByConditions(long page,long pagesize,Map<String,String> conditions);
	public List<BlStore> queryStoreByConditions(Map<String,String> conditions);
	public List<BlInfo> queryBlByConditions(Map<String,String> conditions);
	public PageList<BlInfo> queryBlByConditions(long page,long pagesize,Map<String,String> conditions);
	public boolean optStore(BlOrder blOrder);
	public List<BlCompany> getCompanyList(Map<String,String> conditions);
	public PageList<BlCompany> getCompanyPageList(long page,long pagesize,Map<String,String> conditions);
}
