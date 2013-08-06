<%@ page pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="description" content="ERMES" />
	<meta name="keywords" content="ERMES" />
	
	<title><tiles:insertAttribute name="pageTitle" /></title>
	<link rel="shortcut icon"
		href="<c:url value="${baseResourceUrl}/images/shared/favicon.ico"/>"
		type="image/x-icon" />
	<link href='http://fonts.googleapis.com/css?family=Roboto:400,700,400italic,700italic,500,500italic,300,300italic' rel='stylesheet' type='text/css'>
	<link type="text/css" rel="stylesheet"
		href="<c:url value="${baseResourceUrl}/css/styles.css"/>"
		media="screen" title="default" />
	<%-- <link type="text/css" rel="stylesheet"
		href="<c:url value="${baseResourceUrl}/css/typography.css"/>"
		media="screen" title="default" /> --%>
</head>

<body>
	<div id="header">
		<img id="logo" src="http://www.fabioformosa.it/sites/default/files/pictures/photo_profile2.png" class="inline"/>
		<div id="headerTitleContainer" class="inline">
			<h1 id="headerTitle">${title}</h1>
			<h2 id="headerSubTitle"><tiles:getAsString name="pageTitle"/></h2>
		</div>
		<div class="clearer"></div>
	</div>
	<hr>
	
	<tiles:insertAttribute name="innerContent"/>
</body>
</html>