<%@include file="includes/include.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header"><s:text name="h.event"/></h1>
	</div>
<!-- /.col-lg-12 -->
</div>

<div class="row">
	<div class="col-lg-6">
		<div class="panel panel-default">
			<div class="panel-heading">
				<s:text name="lbl.editEvent"/>
			</div>
			<div class="panel-body">
				<s:form>
					<%-- Form fields for the event's attributes --%>
					<s:hidden name="event.id"/>
					<s:hidden name="event.lecturer.id" value="1"/>
					<s:textfield name="event.name" key="lbl.eventTitle" size="40" maxlength="100" requiredLabel="true"/>
					<s:textfield cssClass="form_datetime" name="event.eventStart" key="lbl.eventStart" size="10" maxlength="50" requiredLabel="true" value='%{getText("{0,date,dd.MM.yyyy HH:mm}",{event.eventStart})}'/>
					<s:textfield name="event.duration" key="lbl.eventDuaration" size="10" maxlength="50" requiredLabel="true"/>
					<s:textfield name="event.changeoverTime" key="lbl.changeoverTime" size="10" maxlength="20" requiredLabel="true"/>
					<%-- The buttons --%>
					<s:submit key="btn.save" cssClass="btn btn-primary" action="SaveEvent"/>
					<s:submit key="btn.cancel" cssClass="btn btn-primary" action="CancelEvent"/>
					<s:checkbox name="proceed" fieldValue="true" value="false" label="Check Me for testing"/>
					<s:if test="hasActionErrors()">
						
					</s:if>
				</s:form>		
			</div>
		</div>
	</div>
	
	<s:if test="hasActionErrors()">
   		<div class="col-lg-6">
			<div class="panel panel-default">
				<div class="panel-heading">
					<s:text name="lbl.editEvent"/>
				</div>
				<div class="panel-body">
					<div class="errors">
    					<s:actionerror/>
   					</div>	
				</div>
			</div>
		</div>
	</s:if>
</div>

<script src="js/event-functions.js"></script>	