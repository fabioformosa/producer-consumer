package it.fabioformosa.lab.prodcons.utils;

public class GridParamsConverter {

	public static PaginatedListRequest createAndInflatePaginatedRequest(
			GridParams gridParams) {

		PaginatedListRequest paginatedReq = new PaginatedListRequest(
				gridParams.getPage(), gridParams.getItemsByPage());

		if (gridParams.getOrderBy() != null) {
			String orderField = gridParams.getOrderBy().getMap();
			boolean ascOrder = gridParams.getOrderBy().isReverse();
			paginatedReq.setOrdering(paginatedReq.new OrderCriterion(
					orderField, ascOrder));
		}

		if (gridParams.getFilter() != null)
			paginatedReq.setFilters(gridParams.getFilter());

		return paginatedReq;
	}

}
