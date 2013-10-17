<%@ page pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="frm" uri="http://www.springframework.org/tags/form"%>

<%@ page import="it.fabioformosa.lab.prodcons.views.LoggingViewHelper" %>
<%@ page import="it.fabioformosa.lab.prodcons.model.LoggingEvent" %>

<div class="row">

	<!--  LEFT PANEL -->
	<div class="col-md-3">

		<!-- SETUP PANEL -->
		<div class="panel">
		  <div class="panel-heading panel-cyan">Setup</div>
		  <div class="panel-body">
		  
		  		<c:url value="/manager/panel" var="startAction"/>
		  
		    	<frm:form name="settingForm" 
		    				commandName="settings" method="POST"
		    				action="${startAction}"
		    				class="validated-form css-form" role="form">
				  <fieldset>
					    <legend>Settings</legend>
					    
					    <div class="form-group">
					      <label for="producerNumber">Producer Number</label><br/>
					      <frm:input path="producerNumber" type="text" required="true" size="3" />
					      <frm:errors path="producerNumber" class="alert alert-danger" />
					    </div>
					    
					    <div class="form-group">
					      <label for="consumerNumber">Consumer Number</label><br/>
					      <frm:input path="consumerNumber" type="text" required="true" size="3"/>
					      <frm:errors path="consumerNumber" class="alert alert-danger"/>
					    </div>
					    
					    <div class="form-group">
					      <label for="prodCycleNumber">Producer Cycle Number</label><br/>
					      <frm:input path="prodCycleNumber" type="text" required="true" size="3" />
					      <frm:errors path="prodCycleNumber" class="alert alert-danger" />
					    </div>
					    
					    <button type="submit" class="btn btn-default" data-ng-disabled="settingForm.$invalid">Submit</button>
				    
				  </fieldset>
				</frm:form>
		  </div>
	  	</div> <!-- /Setup panel -->
	</div> <!-- left panel -->
	
	<!-- RIGHT PANEL -->
	<div class="col-md-9">
		<div id="logControllerDiv" class="panel"  data-ng-controller="LogController">
		  <div class="panel-heading panel-lime">Statistics <img id="logLoading" src="<c:url value="${imageBaseUrl}/loading.gif"/>" width="25"/> </div>
		  <div class="panel-body" data-ng-init="loadLogs(${taskId})">

		  		<table id="logTable" class="table table-striped">
		    			<tr data-ng-repeat="log in logs">
		    				<td>{{log.timestmp | date:'yyyy-MM-dd HH:mm:ss Z'}}</td>
		    				<td>{{log.callerMethod}}</td>
		    				<td>{{log.formattedMessage}}</td>
		    			</tr>
		    	</table>
		  		
		  </div>
	  	</div>
	</div> <!-- right panel -->
	
</div>