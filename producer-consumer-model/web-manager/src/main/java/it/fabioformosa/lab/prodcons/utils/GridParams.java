package it.fabioformosa.lab.prodcons.utils;

import java.util.Map;

public class GridParams {

	public class OrderByParam {
		private String label;
		private String map;
		private String filterPredicate;
		private String sortPredicate;
		private String headerTemplateUrl;
		private boolean isInFilterForm = false;

		private boolean reverse;

		public String getFilterPredicate() {
			return filterPredicate;
		}

		public String getHeaderTemplateUrl() {
			return headerTemplateUrl;
		}

		public String getLabel() {
			return label;
		}

		public String getMap() {
			return map;
		}

		public String getSortPredicate() {
			return sortPredicate;
		}

		public boolean isInFilterForm() {
			return isInFilterForm;
		}

		public boolean isReverse() {
			return reverse;
		}

		public void setFilterPredicate(String filterPredicate) {
			this.filterPredicate = filterPredicate;
		}

		public void setHeaderTemplateUrl(String headerTemplateUrl) {
			this.headerTemplateUrl = headerTemplateUrl;
		}

		public void setIsInFilterForm(boolean isInFilterForm) {
			this.isInFilterForm = isInFilterForm;
		}

		public void setLabel(String label) {
			this.label = label;
		}

		public void setMap(String map) {
			this.map = map;
		}

		public void setReverse(boolean reverse) {
			this.reverse = reverse;
		}

		public void setSortPredicate(String sortPredicate) {
			this.sortPredicate = sortPredicate;
		}
	}

	private int itemsByPage;
	private int page;

	private OrderByParam orderBy;

	private Map<String, String> filter;

	public Map<String, String> getFilter() {
		return filter;
	}

	public int getItemsByPage() {
		return itemsByPage;
	}

	public OrderByParam getOrderBy() {
		return orderBy;
	}

	public int getPage() {
		return page;
	}

	public void setFilter(Map<String, String> filter) {
		this.filter = filter;
	}

	public void setItemsByPage(int itemsByPage) {
		this.itemsByPage = itemsByPage;
	}

	public void setOrderBy(OrderByParam orderBy) {
		this.orderBy = orderBy;
	}

	public void setPage(int page) {
		this.page = page;
	}

}
