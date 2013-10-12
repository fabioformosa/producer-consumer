<%@ page pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" data-framework="angularjs">
<head>
	<!-- IE Compatibility: IE9+ -->

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="description" content="ERMES" />
	<meta name="keywords" content="ERMES" />
	
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<title><tiles:insertAttribute name="pageTitle" /></title>
	
	<link rel="shortcut icon"
		href="<c:url value="${baseResourceUrl}/images/shared/favicon.ico"/>"
		type="image/x-icon" />
		
	<link href='http://fonts.googleapis.com/css?family=Roboto:400,700,400italic,700italic,500,500italic,300,300italic' rel='stylesheet' type='text/css'>
	
		<%-- <link type="text/css" rel="stylesheet"
		href="<c:url value="${baseResourceUrl}/css/typography.css"/>"
		media="screen" title="default" /> --%>
		
	<!-- STYLESHEETS -->	
	<link type="text/css" rel="stylesheet"
		href="<c:url value="${baseResourceUrl}/css/styles.css"/>"
		media="screen" title="default" />
		
	 <!-- BOOTSTRAP -->
     <link rel="stylesheet" href="<c:url value="${baseResourceUrl}/css/bootstrap.min.css"/>">
     <link rel="stylesheet" href="<c:url value="${baseResourceUrl}/css/bootstrap-overrides.css"/>">

	 <!-- JQUERY UI BOOTSTRAP -->
     <link rel="stylesheet" href="<c:url value="${baseResourceUrl}/css/jquery.ui.1.10.0.ie.css"/>">
     <link rel="stylesheet" href="<c:url value="${baseResourceUrl}/css/jquery-ui-1.10.0.custom.css"/>">
	
</head>

<body>
	
	<header class="navbar navbar-inverse navbar-fixed-top">
	  <div class="container">
	    <div class="navbar-header">
	      <button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".navbar-ex1-collapse">
	        <span class="sr-only">Toggle navigation</span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	      </button>
	      <a id="fab_logo" href="http://www.fabioformosa.it" class="navbar-brand"><img id="fab_logo_img" src="http://www.fabioformosa.it/sites/default/files/pictures/photo_profile2.png"/></a>
	    </div>
	    <nav class="collapse navbar-collapse navbar-ex1-collapse">
	      <ul id="headerBar" class="nav navbar-nav">
	        <li>
	          <a id="appTitle" href="<c:url value="panel" />">${title}</a>
	        </li>
	        <li>
	          <a>By Fabio Formosa</a>
	        </li>
	      </ul>
	    </nav>
	  </div>
	</header>
	
	<div class="container">

		<h2 id="headerSubTitle">
			<tiles:getAsString name="pageTitle"/>
		</h2>
		
		<tiles:insertAttribute name="innerContent"/>
	</div>
	
	
	<script data-main="../static/js/main" src="<c:url value="${baseResourceUrl}/js/require.js"/>"></script>
</body>
</html>