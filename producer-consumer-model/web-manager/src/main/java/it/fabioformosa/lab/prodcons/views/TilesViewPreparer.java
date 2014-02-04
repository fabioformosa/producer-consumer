package it.fabioformosa.lab.prodcons.views;

import it.fabioformosa.lab.prodcons.utils.URLUtility;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.tiles.AttributeContext;
import org.apache.tiles.context.TilesRequestContext;
import org.apache.tiles.preparer.PreparerException;
import org.apache.tiles.preparer.ViewPreparer;
import org.apache.tiles.servlet.context.ServletTilesRequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TilesViewPreparer implements ViewPreparer {

	private String title;
	private String titleVersioned;
	private String baseResourceUrl, backendUrl;

	private String imageBaseUrl;

	private static Logger logger = LoggerFactory
			.getLogger(TilesViewPreparer.class);

	@Override
	public void execute(TilesRequestContext requestContext,
			AttributeContext attributeContext) throws PreparerException {

		if (!checkContext(requestContext))
			return;

		ServletTilesRequestContext context = (ServletTilesRequestContext) requestContext;
		HttpServletRequest request = context.getRequest();

		backendUrl = URLUtility.extractOrchestratorPath(request);
		request.setAttribute("backendUrl", backendUrl);
		
		request.setAttribute("title", title);
		request.setAttribute("titleVersioned", titleVersioned);
		request.setAttribute("baseResourceUrl", baseResourceUrl);
		request.setAttribute("imageBaseUrl", getImageBaseUrl());
		request.setAttribute("backendUrl", backendUrl);

	}

	public String getImageBaseUrl() {
		return baseResourceUrl + "/images";
	}

	public String getTitleVersioned() {
		return titleVersioned;
	}

	public void setBackendUrl(String backendUrl) {
		this.backendUrl = StringUtils.trimToEmpty(backendUrl);
	}

	public void setBaseResourceUrl(String baseResourceUrl) {
		this.baseResourceUrl = StringUtils.trimToEmpty(baseResourceUrl);
	}

	public void setImageBaseUrl(String imageBaseUrl) {
		if (StringUtils.isBlank(imageBaseUrl))
			throw new IllegalArgumentException("imagesBaseUrl cannot be blank!");

		if (!imageBaseUrl.endsWith("/"))
			imageBaseUrl += "/";

		this.imageBaseUrl = imageBaseUrl;
	}

	public void setSiteProperties(Properties siteProperties) {
		//		this.siteProperties = siteProperties;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setTitleVersioned(String titleVersioned) {
		this.titleVersioned = titleVersioned;
	}

	private boolean checkContext(TilesRequestContext requestContext) {
		boolean validContext = requestContext instanceof ServletTilesRequestContext;
		if (!validContext)
			logger.warn("RequestContext is not a "
					+ ServletTilesRequestContext.class.getSimpleName()
					+ "; it is a " + requestContext.getClass().getSimpleName()
					+ " instead.");
		return validContext;
	}

}