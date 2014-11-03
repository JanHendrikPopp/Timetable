<%@ include file="include.jsp"%>

<div class="modal fade" id="lecturerModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">Add Lecturer</h4>
            </div>
            <div class="modal-body">
                <table class="table table-striped table-bordered table-hover addLecturer-dataTable" id="lecturerTable">
					<thead>
						<tr>
							<th><s:text name="lbl.gender"/></th>
							<th><s:text name="lbl.title"/></th>
							<th><s:text name="lbl.name"/></th>
							<th class="nosort"><s:text name="lbl.action"/></th>
						</tr>
					</thead>
					<tbody></tbody>
				</table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
            </div>
        </div>
    </div>
</div>