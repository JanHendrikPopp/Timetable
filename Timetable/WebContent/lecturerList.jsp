<%@include file="includes/include.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header"><s:text name="h.lecturer"/></h1>
	</div>
<!-- /.col-lg-12 -->
</div>

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				<s:text name="lbl.lecturerList"/>
			</div>
			<div class="panel-body">
				<table class="table table-striped table-bordered table-hover dataTable">
					<thead>
						<tr>
							<th><s:text name="lbl.gender"/></th>
							<th><s:text name="lbl.title"/></th>
							<th><s:text name="lbl.name"/></th>
							<th><s:text name="lbl.changeoverTime"/></th>
							<th class="nosort"><s:text name="lbl.action"/></th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="lecturerList">
							<tr>
								<td><s:property value="gender"/></td>
								<td><s:property value="title"/></td>
								<td><s:property value="name"/></td>
								<td><s:property value="changeoverTime"/></td>
								<td class="text-center">
									<a href="
										<s:url action="EditLecturer">
											<s:param name="lecturerId"><s:property value="id"/></s:param>
										</s:url>">
										<span class="fa fa-pencil fa-fw"></span>
									</a>
									<a href="
										<s:url action="DeleteLecturer">
											<s:param name="lecturerId"><s:property value="id"/></s:param>
										</s:url>">
										<span class="fa fa-trash-o fa-fw"></span>
									</a>
								</td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
				<s:form>
					<s:submit cssClass="btn btn-primary" key="btn.add" action="AddLecturer"/>
				</s:form>
			</div>
		</div>
	</div>
</div>

