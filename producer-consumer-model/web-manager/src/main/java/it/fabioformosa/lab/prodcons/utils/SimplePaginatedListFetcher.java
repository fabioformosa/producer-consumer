package it.fabioformosa.lab.prodcons.utils;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ReflectionUtils;

/**
 * Simple Fetcher gets fieldname from filter paramater in request and checks if
 * they exists as field in model class by reflection
 * 
 * @author fabio
 * 
 * @param <Model>
 * @param <Request>
 */
public class SimplePaginatedListFetcher<Model, Request extends PaginatedListRequest>
		extends PaginatedListFetcher<Model, PaginatedListRequest> {

	private static Logger log = LoggerFactory
			.getLogger(SimplePaginatedListFetcher.class);

	private Class<Model> modelClass;

	public SimplePaginatedListFetcher(Class<Model> clazz) {
		super(clazz);
		this.modelClass = clazz;
	}

	public SimplePaginatedListFetcher(Class<Model> clazz, String fromClauseClass) {
		super(clazz, fromClauseClass);
	}

	@Override
	protected String generateWhereClause(PaginatedListRequest request) {
		StringBuilder sb = new StringBuilder();

		String superWhereClause = super.generateWhereClause(request);
		if (StringUtils.isNotBlank(superWhereClause))
			sb.append(superWhereClause);

		Map<String, String> filters = request.getFilters();
		if (filters != null)
			for (Entry<String, String> filterEntry : filters.entrySet()) {
				String filteringFieldname = filterEntry.getKey();
				try {
					Field declaredField = ReflectionUtils.findField(modelClass,
							filteringFieldname);
					if (declaredField != null
							&& StringUtils.isNotBlank(filterEntry.getValue())) {
						if (sb.length() == 0)
							sb.append(" 1=1");
						sb.append(" and " + filteringFieldname + " like " + ":"
								+ filteringFieldname);
					}
				} catch (Exception e) {
					log.debug("Exception in generating whereClause: "
							+ e.getMessage());
				}
			}

		return sb.toString();
	}

	@Override
	protected void prepareQuery(javax.persistence.Query query, PaginatedListRequest request) {
		super.prepareQuery(query, request);

		Map<String, String> filters = request.getFilters();
		Set<Entry<String, String>> entrySet = filters.entrySet();
		for (Entry<String, String> filteringEntry : entrySet) {
			String filteringFieldname = filteringEntry.getKey();
			try {
				Field declaredField = ReflectionUtils.findField(modelClass,
						filteringFieldname);
				if (declaredField != null
						&& StringUtils.isNotBlank(filteringEntry.getValue()))
					query.setParameter(filteringEntry.getKey(),
							filteringEntry.getValue() + "%");

			} catch (Exception e) {
			}
		}

	}
}
