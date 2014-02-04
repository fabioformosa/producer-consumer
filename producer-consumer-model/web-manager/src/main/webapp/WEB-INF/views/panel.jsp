<%@ page pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="frm" uri="http://www.springframework.org/tags/form"%>

<%@ page import="it.fabioformosa.lab.prodcons.views.LoggingViewHelper" %>
<%@ page import="it.fabioformosa.lab.prodcons.model.LoggingEvent" %>


<script type="text/javascript">

	function LogGridCtr($scope){
		$scope.columnCollection = [
	                            {label: 'Timestamp', map: 'timestmp', isInFilterForm: false},
	                            {label: 'Caller', map: 'callerMethod', isInFilterForm: true},
	                            {label: 'Log', map: 'formattedMessage', isInFilterForm: true},
	                        ];
		$scope.globalConfig = {
		        isPaginationEnabled: true,
		        itemsByPage: 10,
		        isFilterFormActivated : true,
		        resourceBaseURL : "${backendUrl}/logs/${taskId}" //TODO costruire a modo questa URL
		    };
	}

</script>

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
		    				action="${startAction}" novalidate="true"
		    				class="validated-form css-form" role="form">
				  <fieldset>
					    <legend>Settings</legend>
					    
					    <div class="form-group">
					      <label for="producerNumber">Producer Number</label><br/>
					      <frm:input 
					      			path="producerNumber" 
					      			ng-model="prodNumSettings" ng-spinner-custom="true"
					      			required="true" min="1" 
					      			type="text" size="3" />
					      <frm:errors path="producerNumber" class="alert-danger" />
					    </div>
					    
					    <div class="form-group">
					      <label for="consumerNumber">Consumer Number</label><br/>
					      <frm:input 
					      			path="consumerNumber" 
					      			ng-model="consNumSettings" ng-spinner-custom="true"
					      			required="true" min="1"  
					      			type="text" size="3"/>
					      <frm:errors path="consumerNumber" class="alert-danger"/>
					    </div>
					    
					    <div class="form-group">
					      <label for="prodCycleNumber">Producer Cycle Number</label><br/>
					      <frm:input 
					      			path="prodCycleNumber" 
					      			ng-model="prodCycleNum" ng-spinner-custom="true"
					      			required="true" min="1" 
					      			type="text" size="3" />
					      <frm:errors path="prodCycleNumber" class="alert-danger" />
					    </div>
					    
					    <button type="submit" 
					    		data-ng-disabled="settingForm.$invalid"
					    		class="btn btn-default" >Submit</button>
				    
				  </fieldset>
				</frm:form>
		  </div>
	  	</div> <!-- /Setup panel -->
	</div> <!-- left panel -->
	
	<!-- RIGHT PANEL -->
	<div class="col-md-9">
		<div id="logControllerDiv" class="panel"  data-ng-controller="LogController">
		
		  <div class="panel-heading panel-lime">
		  		Statistics <img id="logLoading" src="<c:url value="${imageBaseUrl}/loading.gif"/>" width="25"/>
		  </div>
		
<%-- 		  <div class="panel-body" data-ng-init="loadLogs(${taskId})"> --%>
<!-- 		  		<table id="logTable" class="table table-striped"> -->
<!-- 		    			<tr data-ng-repeat="log in logs"> -->
<!-- 		    				<td>{{log.timestmp | date:'yyyy-MM-dd HH:mm:ss Z'}}</td> -->
<!-- 		    				<td>{{log.callerMethod}}</td> -->
<!-- 		    				<td>{{log.formattedMessage}}</td> -->
<!-- 		    			</tr> -->
<!-- 		    	</table> -->
<!-- 		  </div> -->
	
			<c:if test="${taskId > 0}">
			    <div class="table-header">
					Logs
				</div>
				<div ng-controller="LogGridCtr" class="table-responsive smartTable dataTables_wrapper">
			    	<div class="table table-striped" smart-table columns="columnCollection" config="globalConfig"></div>
				</div>
			</c:if>

	  	</div>
	</div> <!-- right panel -->
	
</div>