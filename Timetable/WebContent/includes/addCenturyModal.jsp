<%@ include file="include.jsp"%>

<div class="modal fade" id="centuryModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">Add Century</h4>
            </div>
            <div class="modal-body">
                <table class="table table-striped table-bordered table-hover addCentury-dataTable" id="centuryTable">
					<thead>
						<tr>
							<th><s:text name="lbl.name"/></th>
							<th><s:text name="lbl.major"/></th>
							<th><s:text name="lbl.size"/></th>
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