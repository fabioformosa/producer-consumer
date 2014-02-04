package it.fabioformosa.lab.prodcons.utils;

import static org.apache.commons.lang.StringUtils.isBlank;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;

public class PaginatedListFetcher<Model, Request extends PaginatedListRequest> {

	protected static void limitQuery(javax.persistence.Query query, PaginatedListRequest request) {
		query.setFirstResult(request.getFirstItem());
		query.setMaxResults(request.getPageSize());
	}

	private String fromClauseClass;
	protected boolean distinctSelection = false;

	private static final Pattern SORT_PATTERN = Pattern.compile("([a-z_0-9]*)",
			Pattern.CASE_INSENSITIVE);

	public PaginatedListFetcher(Class<Model> clazz) {
		super();
		fromClauseClass = clazz.getSimpleName();
	}

	public PaginatedListFetcher(Class<Model> clazz, String fromClauseClass) {
		super();
		this.fromClauseClass = fromClauseClass;
	}
	
	

	public PaginatedList<Model> fetch(EntityManager entityManager, Request request) {

		String whereClause = generateWhereClause(request);
		if (!isBlank(whereClause))
			whereClause = " where " + whereClause;
		else
			whereClause = " ";

		String[] selections = getSelectionClause();

		String hql = buildCountQuery(selections, whereClause);
		javax.persistence.Query query = entityManager.createQuery(hql);
		prepareQuery(query, request);

		int total = ((Long) query.getSingleResult()).intValue();

		PaginatedList<Model> result = new PaginatedList<Model>(request);
		result.setTotal(total);

		if (total > 0) {
			List<Model> items = fetchItems(entityManager, request, selections,
					whereClause);
			result.setItems(items);

		} else
			result.setItems(new ArrayList<Model>());

		return result;
	}

	public void setDistinctSelection(boolean distinctSelection) {
		this.distinctSelection = distinctSelection;
	}

	public void setFromClauseClass(String fromClauseClass) {
		this.fromClauseClass = fromClauseClass;
	}

	private String buildCountQuery(String[] selections, String whereClause) {
		String selection = "*";
		if (selections != null && selections.length == 1 && distinctSelection)
			selection = generateSelection(selections);

		String hql = "select count(" + selection + " ) from " + fromClauseClass
				+ " main " + whereClause;
		return hql;
	}

	private String buildFetchQuery(Request request, String[] selections,
			String whereClause) {

		String selection = generateSelection(selections);

		String queryString = "select " + selection + " from " + fromClauseClass
				+ " main ";
		queryString += whereClause;

		if (request.getOrderCriterion() != null
				&& StringUtils.isNotBlank(request.getOrderCriterion()
						.getFieldname())) {

			Matcher sortMatcher = SORT_PATTERN.matcher(request
					.getOrderCriterion().getFieldname());
			if (sortMatcher.matches())
				queryString += " order by "
						+ request.getOrderCriterion().getFieldname() + " "
						+ request.getOrderCriterion().getDirection();
		}

		return queryString;

	}

	private List<Model> fetchItems(EntityManager entityManager, Request request,
			String[] selections, String whereClause) {
		javax.persistence.Query query;
		String queryString = buildFetchQuery(request, selections, whereClause);
		query = entityManager.createQuery(queryString);
		limitQuery(query, request);
		prepareQuery(query, request);

		@SuppressWarnings("unchecked")
		List<Model> items = query.getResultList();
		if (resolvesItems())
			for (Model item : items)
				resolve(item);
		return items;
	}

	private String generateSelection(String[] selections) {
		if (selections == null)
			return "main";

		StringBuffer selection = null;
		if (selections.length == 1) {
			selection = new StringBuffer();
			if (distinctSelection)
				selection.append("distinct ");
			selection.append("main." + selections[0]);
			return selection.toString();
		}

		if (selections.length > 0) {
			for (String selectionItem : selections) {
				if (selection == null)
					selection = new StringBuffer();
				else
					selection.append(", ");

				selection.append("main." + selectionItem);
			}
			return selection.toString();
		}
		return "main";
	}

	protected String generateWhereClause(Request request) {
		return null;
	}

	protected String[] getSelectionClause() {
		return null;
	}

	protected void prepareQuery(javax.persistence.Query query, Request request) {
	}

	protected void resolve(Model item) {
	}

	protected boolean resolvesItems() {
		return false;
	}

}
