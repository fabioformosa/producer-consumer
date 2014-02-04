package it.fabioformosa.lab.prodcons.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

public class PaginatedList<T> extends PaginatedListRequest {

	private List<T> items;
	private int total = -1;

	public PaginatedList(int currPage, int pageSize) {
		super(currPage, pageSize);
	}

	public PaginatedList(PaginatedListRequest request) {
		super(request.getCurrPage(), request.getPageSize());

		try {
			BeanUtils.copyProperties(this, request);
		} catch (IllegalAccessException e) {
		} catch (InvocationTargetException e) {
		}
	}

	public String getContentRangeHeader() {
		return "items " + getFirstItem() + "-" + getLastItem() + "/"
				+ getTotal();
	}

	public List<T> getItems() {
		return items;
	}

	@Override
	public int getLastItem() {
		return Math.min(super.getLastItem(), total);
	}

	public int getTotal() {
		return total;
	}

	public void setItems(List<T> items) {
		this.items = items;
	}

	public void setTotal(int total) {
		this.total = total;
	}

}
