<%@include file="includes/include.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header"><s:text name="h.event"/></h1>
	</div>
<!-- /.col-lg-12 -->
</div>

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				<s:text name="lbl.eventList"/>
			</div>
			<div class="panel-body">
				<table class="table table-striped table-bordered table-hover dataTable">
					<thead>
						<tr>
							<th><s:text name="lbl.eventTitle"/></th>
							<th><s:text name="lbl.eventStart"/></th>
							<th><s:text name="lbl.eventDuaration"/></th>
							<th><s:text name="lbl.changeoverTime"/></th>
							<th><s:text name="lbl.eventRoom"/></th>
							<th><s:text name="lbl.eventLecturer"/></th>
							<th><s:text name="lbl.eventClass"/></th>
							<th class="nosort"><s:text name="lbl.action"/></th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="eventList">
							<tr>
								<td><s:property value="name"/></td>
								<td><s:property value="eventStart"/></td>
								<td><s:property value="duration"/></td>
								<td><s:property value="changeoverTime"/></td>
								<td>Raum</td>
								<td>Dozent</td>
								<td>Zenturie</td>
								<td class="text-center">
									<a href="
										<s:url action="EditEvent">
											<s:param name="eventId"><s:property value="id"/></s:param>
										</s:url>">
										<span class="fa fa-pencil fa-fw"></span>
									</a>
									<a href="
										<s:url action="DeleteEvent">
											<s:param name="eventId"><s:property value="id"/></s:param>
										</s:url>">
										<span class="fa fa-trash-o fa-fw"></span>
									</a>
								</td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
				<s:form>
					<s:submit cssClass="btn btn-primary" key="btn.add" action="AddEvent"/>
				</s:form>
			</div>
		</div>
	</div>
</div>

