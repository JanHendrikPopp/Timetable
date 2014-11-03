<%@ include file="include.jsp"%>

<div class="modal fade" id="eventsLecturerModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">select lecturer</h4>
            </div>
            <div class="modal-body">
                <table class="table table-striped table-bordered table-hover dataTable" id="eventsLecturerTable">
					<thead>
						<tr>
							<th><s:text name="lbl.gender"/></th>
							<th><s:text name="lbl.title"/></th>
							<th><s:text name="lbl.name"/></th>
							<th class="nosort"><s:text name="lbl.action"/></th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="lecturerList">
							<tr>
								<td><s:text name="lbl.%{gender}"></s:text></td>
								<td><s:property value="title"/></td>
								<td><s:property value="name"/></td>
								<td class="text-center">
									<a href="javascript:loadEvents(<s:property value="id"/>)" title="Add lecturer">
	                <i class="fa fa-plus-circle fa-fw"></i>Dozent auswählen
	                	</a>
								</td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
            </div>
        </div>
    </div>
</div>