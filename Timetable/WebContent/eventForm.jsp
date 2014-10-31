<%@include file="includes/include.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header"><s:text name="h.event"/></h1>
	</div>
<!-- /.col-lg-12 -->
</div>
<s:form>

	<div class="row">
		<div class="col-lg-6">
			<div class="panel panel-default">
				<div class="panel-heading">
					<s:text name="lbl.event.basicData"/>
				</div>
				<div class="panel-body">
						<s:hidden name="event.id"/>
						<s:textfield name="event.name" key="lbl.eventTitle" size="40" maxlength="100" requiredLabel="true"/>
						<s:textfield cssClass="form_datetime" name="event.eventStart" key="lbl.eventStart" size="10" maxlength="50" requiredLabel="true" value='%{getText("{0,date,dd.MM.yyyy HH:mm}",{event.eventStart})}'/>
						<s:textfield name="event.duration" key="lbl.eventDuaration" size="10" maxlength="50" requiredLabel="true"/>
						<s:textfield name="event.changeoverTime" key="lbl.changeoverTime" size="10" maxlength="20" requiredLabel="true"/>
						<s:textfield name="event.weeklyRecurrence" key="lbl.weeklyRecurrence" size="10" maxlength="20" requiredLabel="true"/>		
				</div>
			</div>
		</div>
		<s:if test="hasActionErrors()">
	   		<c:import url="../includes/actionErrors.jsp"/>
		</s:if>
	</div>
	
	<div class="row">
		<div class="col-lg-6">
			<div class="panel panel-default">
				<div class="panel-heading">
					<s:text name="lbl.event.connection"/>
				</div>
				<div class="panel-body">
					<s:hidden name="lecturerId" id="lecturerId"/>
					<s:textfield name="lecturerName" key="lbl.event.lecturer" disabled="true"/>
					<a href="javascript:openLecturerModal()" title="Add lecturer">
	                	<i class="fa fa-plus-circle fa-fw"></i>Dozent auswählen
	                </a>
	                <a href="javascript:clearLecturer()" title="Add lecturer">
	                	<i class="fa fa-trash-o fa-fw"></i>Dozenten löschen
	                </a>	
				</div>
			</div>
		</div>
	</div>
	
	<div class="row">
		<div class="form-group ">
			<s:submit key="btn.save" cssClass="btn btn-primary" action="SaveEvent"/>
			<s:submit key="btn.cancel" cssClass="btn btn-primary" action="CancelEvent"/>
			<s:checkbox name="proceed" fieldValue="true" value="false" label="Check Me for testing"/>
		</div>
	</div>
</s:form>

<c:import url="../includes/addLecturerModal.jsp"/>