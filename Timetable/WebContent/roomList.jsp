<%@include file="includes/include.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header"><s:text name="h.room"/></h1>
	</div>
</div>

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				<s:text name="lbl.roomList"/>
			</div>
			<div class="panel-body">
				<table class="table table-striped table-bordered table-hover dataTable">
					<thead>
						<tr>
							<th><s:text name="lbl.room.name"/></th>
							<th><s:text name="lbl.room.type"/></th>
							<th><s:text name="lbl.room.capacity"/></th>
							<th><s:text name="lbl.changeoverTime"/></th>
							<th class="nosort"><s:text name="lbl.action"/></th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="roomList">
							<tr>
								<td><s:property value="building"/><s:property value="number"/></td>
								<td><s:text name="lbl.room.%{type}"></s:text></td>
								<td><s:property value="capacity"/></td>
								<td><s:property value="changeoverTime"/></td>
								<td class="text-center">
									<a href="
										<s:url action="EditRoom">
											<s:param name="roomId"><s:property value="id"/></s:param>
										</s:url>">
										<span class="fa fa-pencil fa-fw"></span>
									</a>
									<a href="
										<s:url action="DeleteRoom">
											<s:param name="roomId"><s:property value="id"/></s:param>
										</s:url>">
										<span class="fa fa-trash-o fa-fw"></span>
									</a>
								</td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
				<s:form>
					<s:submit cssClass="btn btn-primary" key="btn.add" action="AddRoom"/>
				</s:form>
			</div>
		</div>
	</div>
</div>

