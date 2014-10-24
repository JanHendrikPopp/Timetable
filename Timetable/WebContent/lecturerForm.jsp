<%@include file="includes/include.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header"><s:text name="h.lecturer"/></h1>
	</div>
<!-- /.col-lg-12 -->
</div>

<div class="row">
	<div class="col-lg-6">
		<div class="panel panel-default">
			<div class="panel-heading">
				<s:text name="lbl.editLecturer"/>
			</div>
			<div class="panel-body">
				<s:form>
					<%-- Form fields for the lecturer's attributes --%>
					<s:hidden name="lecturer.id"/>
					<s:select key="lbl.gender" headerKey="-1" list="#{'MALE':'Herr', 'FEMALE':'Frau'}" name="lecturer.gender" />					
					<s:textfield name="lecturer.title" key="lbl.title" size="10" maxlength="50" requiredLabel="true"/>
					<s:textfield name="lecturer.name" key="lbl.name" size="10" maxlength="50" requiredLabel="true"/>
					<s:textfield name="lecturer.changeoverTime" key="lbl.changeoverTime" size="10" maxlength="20" requiredLabel="true"/>
					<%-- The buttons --%>
					<s:submit key="btn.save" cssClass="btn btn-primary" action="SaveLecturer"/>
					<s:submit key="btn.cancel" cssClass="btn btn-primary" action="CancelLecturer"/>
				</s:form>		
			</div>
		</div>
	</div>
	<s:if test="hasActionErrors()">
   		<div class="col-lg-6">
			<div class="panel panel-default">
				<div class="panel-heading">
					<s:text name="lbl.warning"/>
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