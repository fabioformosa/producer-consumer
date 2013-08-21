<%@ page pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="frm" uri="http://www.springframework.org/tags/form"%>

<%@ page import="it.fabioformosa.lab.prodcons.views.LoggingViewHelper" %>
<%@ page import="it.fabioformosa.lab.prodcons.model.LoggingEvent" %>

<script type="text/javascript">
	$(document).ready(function() {
		var prodNumspinner = $( "#producerNumber" ).spinner();
		var consNumspinner = $( "#consumerNumber" ).spinner();
		var prodCycleNumSpinner = $( "#prodCycleNumber" ).spinner();
	});
</script>

<div class="row">

	<!--  LEFT PANEL -->
	<div class="col-md-3">

		<!-- SETUP PANEL -->
		<div class="panel">
		  <div class="panel-heading">Setup</div>
		  <div class="panel-body">
		  		<c:url value="/manager/panel" var="startAction"/>
		    	<frm:form commandName="settings" method="POST"  action="${startAction}" role="form">
				  <fieldset>
				    <legend>Settings</legend>
				    <div class="form-group">
				      <label for="producerNumber">Producer Number</label><br/>
				      <frm:input type="text" class="form-control" path="producerNumber" placeholder="Enter number of producers"/>
				      <frm:errors path="producerNumber" class="formError" />
				    </div>
				    <div class="form-group">
				      <label for="consumerNumber">Consumer Number</label><br/>
				      <frm:input type="text" class="form-control" path="consumerNumber" placeholder="Enter number of consumers"/>
				      <frm:errors path="consumerNumber" class="formError"/>
				    </div>
				    <div class="form-group">
				      <label for="prodCycleNumber">Producer Cycle Number</label><br/>
				      <frm:input type="text" class="form-control" path="prodCycleNumber" placeholder="Enter producer cycles"/>
				      <frm:errors path="prodCycleNumber" class="formError" />
				    </div>
				    <button type="submit" class="btn btn-default">Submit</button>
				  </fieldset>
				</frm:form>
		  </div>
	  	</div> <!-- /Setup panel -->
	</div> <!-- left panel -->
	
	<!-- RIGHT PANEL -->
	<div class="col-md-9">
		<div class="panel">
		  <div class="panel-heading">Statistics</div>
		  <div class="panel-body">
		  		<table>
		    		<c:forEach items="${loggingEvents}" var="loggingEvent">
		    			<tr>
		    				<td>
		    					<%	LoggingEvent loggingEvent = (LoggingEvent) pageContext.getAttribute("loggingEvent");
	    							String filteredClassName = LoggingViewHelper.filterClassName(loggingEvent.getCallerClass());
		    						out.print(filteredClassName);
		    					%>
		    				</td>
		    				<td>${loggingEvent.callerMethod}</td>
		    				<td>${loggingEvent.formattedMessage}</td>
		    			</tr>
		    		</c:forEach>
		    	</table>
		  </div>
	  	</div>
	</div> <!-- right panel -->
	
</div>