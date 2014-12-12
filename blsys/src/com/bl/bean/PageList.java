package com.bl.bean;

import java.util.Collection;

public class PageList<T> {
	private boolean hasPre;
	private boolean hasNext;
	private long currs;
	// total rows
	public long total = 0;
	public long pageSize = 10;
	public long pageTotal = 0;
	public Collection<T> list = null;
	public long getPageTotal() {
		if(total%pageSize==0){
			pageTotal = total/pageSize;
		}else{
			pageTotal = total/pageSize+1;
		}
		return pageTotal;
	}

	public void setPageTotal(long pageTotal) {
		this.pageTotal = pageTotal;
	}

	public long getPageSize() {
		if (pageSize == 0 || pageSize < 1)
			pageSize =  10;
		return pageSize;
	}

	public void setPageSize(long pageSize) {
		this.pageSize = pageSize;
	}

	

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public Collection<T> getList() {
		return list;
	}

	public void setList(Collection<T> list) {
		this.list = list;
	}

	public boolean isHasPre() {
		return hasPre;
	}

	public void setHasPre(boolean hasPre) {
		this.hasPre = hasPre;
	}

	public boolean isHasNext() {
		return hasNext;
	}

	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}

	public long getCurrs() {
		return currs;
	}

	public void setCurrs(long currs) {
		this.currs = currs;
	}
 

}
