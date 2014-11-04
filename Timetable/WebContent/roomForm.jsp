<%@include file="includes/include.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header"><s:text name="h.room"/></h1>
	</div>
<!-- /.col-lg-12 -->
</div>

<div class="row">
	<div class="col-lg-6">
		<div class="panel panel-default">
			<div class="panel-heading">
				<s:text name="lbl.editRoom"/>
			</div>
			<div class="panel-body">
				<s:form>
					<%-- Form fields for the room's attributes --%>
					<s:hidden name="room.id"/>
					<s:select key="lbl.room.building" headerKey="-1" list="#{'A':'A', 'B':'B', 'C':'C', 'D':'D', 'H':'H'}" name="room.building" />
					<s:textfield name="room.number" key="lbl.room.number" size="10" maxlength="50" requiredLabel="true"/>
					<s:select key="lbl.room.type" headerKey="-1" list="#{'PC':'Computerraum', 'LAB':'Labor', 'LECT':'Studienraum'}" name="room.type" />
					<s:textfield name="room.capacity" key="lbl.room.capacity" size="10" maxlength="20" requiredLabel="true"/>
					<s:textfield name="room.changeoverTime" key="lbl.changeoverTime" size="10" maxlength="20" requiredLabel="true"/>
					<%-- The buttons --%>
					<s:submit key="btn.save" cssClass="btn btn-primary" action="SaveRoom"/>
					<s:submit key="btn.cancel" cssClass="btn btn-primary" action="CancelRoom"/>
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