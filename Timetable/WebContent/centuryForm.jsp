<%@include file="includes/include.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header"><s:text name="h.century"/></h1>
	</div>
</div>

<div class="row">
	<div class="col-lg-6">
		<div class="panel panel-default">
			<div class="panel-heading">
				<s:text name="lbl.editCentury"/>
			</div>
			<div class="panel-body">
				<s:form>
					<s:hidden name="century.id"/>
					<s:select key="lbl.century.major" headerKey="-1" list="#{'A':'Ainf', 'I':'Winf', 'B':'Bwl', 'W':'Wing'}" name="century.major" />
					<s:textfield name="century.year" key="lbl.century.year" size="10" maxlength="20" requiredLabel="true"/>
					<s:select key="lbl.century.centuryChar" headerKey="-1" list="#{'A':'a', 'B':'b', 'C':'c', 'D':'d', 'E':'e', 'F':'f'}" name="century.centuryChar" />
					<s:textfield name="century.size" key="lbl.century.capacity" size="10" maxlength="20" requiredLabel="true"/>
					<s:textfield name="century.changeoverTime" key="lbl.changeoverTime" size="10" maxlength="20" requiredLabel="true"/>
					<s:submit key="btn.save" cssClass="btn btn-primary" action="SaveCentury"/>
					<s:submit key="btn.cancel" cssClass="btn btn-primary" action="CancelCentury"/>
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