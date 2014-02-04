package it.fabioformosa.lab.prodcons.utils;

import java.util.HashMap;
import java.util.Map;

public class PaginatedListRequest {

	public class OrderCriterion {

		private String fieldname;
		private boolean asc;
		private String direction = "ASC";

		public OrderCriterion(String orderFieldname, boolean ascendenting) {
			fieldname = orderFieldname;
			asc = ascendenting;
			direction = asc ? "ASC" : "DESC";
		}

		public String getDirection() {
			return direction;
		}

		public String getFieldname() {
			return fieldname;
		}

		public boolean isAsc() {
			return asc;
		}

	}

	private static final int DEFAULT_PAGE_SIZE = 20;

	private int firstItem = 0;
	private int pageSize = DEFAULT_PAGE_SIZE;

	private int currPage = 1;

	private OrderCriterion orderCriterion;

	private Map<String, String> filters = new HashMap<String, String>();

	public PaginatedListRequest(int currPage, int pageSize) {
		this.currPage = currPage;
		this.pageSize = pageSize;
		firstItem = (currPage - 1) * pageSize;
	}

	public int getCurrPage() {
		return currPage;
	}

	public Map<String, String> getFilters() {
		return filters;
	}

	public int getFirstItem() {
		return firstItem;
	}

	public int getLastItem() {
		return getFirstItem() + getPageSize() - 1;
	}

	public OrderCriterion getOrderCriterion() {
		return orderCriterion;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public void setFilters(Map<String, String> filters) {
		this.filters = filters;
	}

	public void setFirstItem(int firstItem) {
		this.firstItem = firstItem;
	}

	public void setOrdering(OrderCriterion orderField) {
		orderCriterion = orderField;

	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
