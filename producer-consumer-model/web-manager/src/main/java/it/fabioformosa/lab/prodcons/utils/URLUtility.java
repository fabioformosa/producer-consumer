package it.fabioformosa.lab.prodcons.utils;

import javax.servlet.http.HttpServletRequest;

public class URLUtility {

	//TODO: scrivere test!!!

	public static String extractOrchestratorPath(HttpServletRequest request) {
		String orchestratorPath = request.getContextPath();

		if (orchestratorPath.endsWith("/"))
			orchestratorPath = orchestratorPath.substring(0,
					orchestratorPath.length() - 1);

		return orchestratorPath; //es: /ines
	}

	private static String extractPluginName(HttpServletRequest request) {
		String completeURL = request.getRequestURI(); //es: /ines/plugins/dummy-plugin/link
		String[] splitURL = completeURL.split("/");
		String pluginName = splitURL[3];
		return pluginName;
	}

	public static String extractPluginResourceName(HttpServletRequest request) {
		String completeURL = request.getRequestURI(); //es: /ines/plugins/dummy-plugin/link
		String[] splitURL = completeURL.split("/");
		return splitURL[2];
	}

	public static String getGenericBaseURL(HttpServletRequest req) {
		String scheme = req.getScheme(); // http
		String serverName = req.getServerName(); // hostname.com
		int serverPort = req.getServerPort(); // 80

		//Reconstruct original requesting URL
		StringBuffer url = new StringBuffer();
		url.append(scheme).append("://").append(serverName);

		if (serverPort != 80 && serverPort != 443)
			url.append(":").append(serverPort);

		return url.toString();

	}

	public static String getPluginBaseURL(HttpServletRequest request) {
		String orchestratorContextPath = extractOrchestratorPath(request); //es: /ines/
		String pluginsResourceName = extractPluginResourceName(request);
		String pluginName = extractPluginName(request);

		return orchestratorContextPath + "/" + pluginsResourceName + "/"
				+ pluginName;
	}

	public static String getPluginBaseURLWithoutOrchestrator(
			HttpServletRequest request) {
		String pluginsResourceName = extractPluginResourceName(request);
		String pluginName = extractPluginName(request);

		return "/" + pluginsResourceName + "/" + pluginName;
	}

	public static String getURL(HttpServletRequest req) {

		String scheme = req.getScheme(); // http
		String serverName = req.getServerName(); // hostname.com
		int serverPort = req.getServerPort(); // 80
		String contextPath = req.getContextPath(); // /mywebapp
		String servletPath = req.getServletPath(); // /servlet/MyServlet
		String pathInfo = req.getPathInfo(); // /a/b;c=123
		String queryString = req.getQueryString(); // d=789

		// Reconstruct original requesting URL
		StringBuffer url = new StringBuffer();
		url.append(scheme).append("://").append(serverName);

		if (serverPort != 80 && serverPort != 443)
			url.append(":").append(serverPort);

		url.append(contextPath).append(servletPath);

		if (pathInfo != null)
			url.append(pathInfo);
		if (queryString != null)
			url.append("?").append(queryString);
		return url.toString();
	}

}
