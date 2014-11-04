<%@include file="includes/include.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header"><s:text name="h.century"/></h1>
	</div>
</div>

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				<s:text name="lbl.centuryList"/>
			</div>
			<div class="panel-body">
				<table class="table table-striped table-bordered table-hover dataTable">
					<thead>
						<tr>
							<th><s:text name="lbl.name"/></th>
							<th><s:text name="lbl.century.major"/></th>
							<th><s:text name="lbl.century.capacity"/></th>
							<th><s:text name="lbl.changeoverTime"/></th>
							<th class="nosort"><s:text name="lbl.action"/></th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="centuryList">
							<tr>
								<td><s:property value="major"/><s:property value="year"/><s:text name="lbl.century.char.%{centuryChar}"></s:text></td>
								<td><s:text name="lbl.century.major.%{major}"></s:text></td>
								<td><s:property value="size"/></td>
								<td><s:property value="changeoverTime"/></td>
								<td class="text-center">
									<a href="
										<s:url action="EditCentury">
											<s:param name="centuryId"><s:property value="id"/></s:param>
										</s:url>">
										<span class="fa fa-pencil fa-fw"></span>
									</a>
									<a href="
										<s:url action="DeleteCentury">
											<s:param name="centuryId"><s:property value="id"/></s:param>
										</s:url>">
										<span class="fa fa-trash-o fa-fw"></span>
									</a>
								</td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
				<s:form>
					<s:submit cssClass="btn btn-primary" key="btn.add" action="AddCentury"/>
				</s:form>
			</div>
		</div>
	</div>
</div>

