package com.bl.service.imp;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bl.bean.BlCompany;
import com.bl.bean.BlInfo;
import com.bl.bean.BlOrder;
import com.bl.bean.BlOrderItem;
import com.bl.bean.BlStore;
import com.bl.bean.PageList;
import com.bl.common.BlException;
import com.bl.common.EnumHelper;
import com.bl.common.FormatUtil;
import com.bl.dao.BlDao;
import com.bl.service.BlService;

@Service("BlService")
@Transactional 
public class BlServiceImp implements BlService {

	@Autowired
	@Qualifier("BlDao")
	private BlDao blDao;
	
	@Override
	public boolean addOrder(BlOrder blOrder) {
		return blDao.addOrder(blOrder);
	}

	@Override
	public boolean updateOrder(BlOrder blOrder) {
		return blDao.updateOrder(blOrder);
	}

	@Override
	public boolean deleteOrder(String bl_order_id) {
		return blDao.deleteOrder(bl_order_id);
	}

	@Override
	public boolean addOrderItem(BlOrderItem blOrderItem) {
		return blDao.addOrderItem(blOrderItem);
	}

	@Override
	public boolean updateOrderItem(BlOrderItem blOrderItem) {
		return blDao.updateOrderItem(blOrderItem);
	}

	@Override
	public boolean deleteOrderItem(String bl_item_id) {
		return blDao.deleteOrderItem(bl_item_id);
	}

	@Override
	public boolean batchAddOrderItem(List<BlOrderItem> items) {
		return blDao.batchAddOrderItem(items);
	}

	@Override
	public boolean batchUpdateOrderItem(List<BlOrderItem> items) {
		return blDao.batchAddOrderItem(items);
	}

	@Override
	public boolean batchDeleteOrderItem(String[] bl_item_ids) {
		return blDao.batchDeleteOrderItem(bl_item_ids);
	}

	@Override
	public boolean batchUpdateStore(List<BlStore> stores) {
		return blDao.batchUpdateStore(stores);
	}

	@Override
	public boolean updateStore(BlStore store) {
		return blDao.updateStore(store);
	}

	@Override
	public boolean addStore(BlStore store) {
		return blDao.addStore(store);
	}

	@Override
	public boolean batchAddStore(List<BlStore> stores) {
		return blDao.batchAddStore(stores);
	}
	
	@Override
	public List<BlStore> queryStoreByConditions(Map<String,String> conditions) {
		return blDao.queryStoreByConditions(conditions);
	}
	
	@Override
	public PageList<BlStore> queryStoreByConditions(long page,long pagesize,Map<String,String> conditions) {
		return blDao.queryStoreByConditions(page,pagesize,conditions);
	}
	
	@Override
	public List<BlInfo> queryBlByConditions(Map<String,String> conditions) {
		return blDao.queryBlByConditions(conditions);
	}
	
	@Override
	public PageList<BlInfo> queryBlByConditions(long page,long pagesize,Map<String,String> conditions) {
		return blDao.queryBlByConditions(page,pagesize,conditions);
	}
	
	@Override
	public boolean optStore(BlOrder blOrder) throws DataAccessException{
		 List<BlOrderItem> items = blOrder.getItems();
		 if(items==null||items.size()==0){
			 throw new BlException("订单必须有明细项！");
		 }
		 for(BlOrderItem blOrderItem : items){
			 if(blDao.addOrderItem(blOrderItem)){
				 BlStore store = new BlStore();
				 store.setBl_id(blOrderItem.getBl_id());
				 store.setBl_name(blOrderItem.getBl_name());
				 store.setBl_store_date(FormatUtil.DateToStr(new Date(), 
						 "yyyy-MM-dd HH:mm:ss"));
				 store.setSh_id(blOrderItem.getSh_id());
				 store.setSs_id(blOrderItem.getSs_id());
				 store.setSh_name(blOrderItem.getSh_name());
				 store.setSs_name(blOrderItem.getSs_name());
				 
				 
				 //查询库存，关联所有仓库。
				 Map<String,String> conditions = new HashMap<String,String>();
				 conditions.put("bl_id", blOrderItem.getBl_id());
				 conditions.put("sh_id", blOrderItem.getSh_id());
				 conditions.put("ss_id", blOrderItem.getSs_id());
				 List<BlStore> storeList = blDao.queryStoreByConditions(conditions);
				 
				 
				 if(storeList!=null&&storeList.size()>0){
					 BlStore b = storeList.get(0);
					 if(blOrder.getBl_order_opt().equalsIgnoreCase(EnumHelper.getEnumKeyValue("BL_ORDER.BL_ORDER_OPT", "入库"))){
						 store.setBl_store_num(b.getBl_store_num()+blOrderItem.getBl_num());
					 }else if(blOrder.getBl_order_opt().equalsIgnoreCase(
							 EnumHelper.getEnumKeyValue("BL_ORDER.BL_ORDER_OPT", "出库"))){
						 if(b.getBl_store_num()>=blOrderItem.getBl_num()){
							 store.setBl_store_num(b.getBl_store_num()-blOrderItem.getBl_num());
						 }else{
							 throw new BlException("当前库存不够！");
						 }
					 }
					if(!blDao.updateStore(store)){
						 throw new BlException("更新库存失败:"+store.getBl_name()+"-"+store.getSh_id()+"-"+store.getSs_id());
					}
				 }else{
					 store.setBl_store_num(blOrderItem.getBl_num());
					 if(!blDao.addStore(store)){
						 throw new BlException("新增库存失败:"+store.getBl_name()+"-"+store.getSh_id()+"-"+store.getSs_id());
					 }
				 }
			 }else{
				 throw new BlException("保存订单明细失败:"+blOrderItem.getBl_name()+"-"+blOrderItem.getSh_id()+"-"+blOrderItem.getSs_id());
			 }
		 }
		 if(!blDao.addOrder(blOrder)){
			 throw new BlException("保存订单失败");
		 }
		return true;
	}
	@Override
	public List<BlCompany> getCompanyList(Map<String,String> conditions){
		return blDao.getCompanyList(conditions);
	}
	@Override
	public PageList<BlCompany> getCompanyPageList(long page,long pagesize,Map<String,String> conditions){
		return blDao.getCompanyPageList(page, pagesize, conditions);
	}

}
