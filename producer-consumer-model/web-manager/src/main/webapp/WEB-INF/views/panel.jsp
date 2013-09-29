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
		  <div class="panel-heading">Setup</div>
		  <div class="panel-body">
		  
		  		<c:url value="/manager/panel" var="startAction"/>
		  
		    	<frm:form name="settingForm" 
		    				commandName="settings" method="POST"
		    				action="${startAction}"
		    				class="validated-form" role="form">
				  <fieldset>
					    <legend>Settings</legend>
					    
					    <div class="form-group">
					      <label for="producerNumber">Producer Number</label><br/>
					      <frm:input type="text" class="form-control" path="producerNumber" ng-model="settings.producerNumber" required="true" size="3"/>
					      <frm:errors path="producerNumber" class="alert alert-danger" />
	<!-- 				      <span data-ng-show="settingForm.producerNumber.$error.required">Valore obbligatorio!</span> -->
					    </div>
					    
					    <div class="form-group">
					      <label for="consumerNumber">Consumer Number</label><br/>
					      <frm:input type="text" class="form-control" path="consumerNumber" required="true" size="3"/>
					      <frm:errors path="consumerNumber" class="alert alert-danger"/>
					    </div>
					    
					    <div class="form-group">
					      <label for="prodCycleNumber">Producer Cycle Number</label><br/>
					      <frm:input type="text" class="form-control" path="prodCycleNumber" required="true" size="3"/>
					      <frm:errors path="prodCycleNumber" class="alert alert-danger" />
					    </div>
					    
	<!-- 				    <button type="submit" class="btn btn-default" data-ng-disabled="settingForm.$invalid">Submit</button> -->
					    <button type="submit" class="btn btn-default">Submit</button>
				    
				  </fieldset>
				</frm:form>
		  </div>
	  	</div> <!-- /Setup panel -->
	</div> <!-- left panel -->
	
	<!-- RIGHT PANEL -->
	<div class="col-md-9">
		<div id="logControllerDiv" class="panel"  data-ng-controller="LogController">
		  <div class="panel-heading">Statistics</div>
		  <div class="panel-body" data-ng-init="loadLogs()">

		  		<table>
		    			<tr data-ng-repeat="log in logs">
<!-- 		    				<td> -->
<%-- 		    					<%	LoggingEvent loggingEvent = (LoggingEvent) pageContext.getAttribute("loggingEvent"); 
 	    							String filteredClassName = LoggingViewHelper.filterClassName(loggingEvent.getCallerClass());
 		    						out.print(filteredClassName);
 		    					%> --%>
<!-- 		    				</td> -->
		    				<td>{{log.callerMethod}}</td>
		    				<td>{{log.formattedMessage}}</td>
		    			</tr>
		    	</table>
		  
		  </div>
	  	</div>
	</div> <!-- right panel -->
	
</div>