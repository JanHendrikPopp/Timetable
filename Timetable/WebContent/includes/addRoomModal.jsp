<%@ include file="include.jsp"%>

<div class="modal fade" id="roomModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel"><s:text name="modal.addRoom"/></h4>
            </div>
            <div class="modal-body">
                <table class="table table-striped table-bordered table-hover addRoom-dataTable" id="roomTable">
					<thead>
						<tr>
							<th><s:text name="lbl.room.name"/></th>
							<th><s:text name="lbl.room.type"/></th>
							<th><s:text name="lbl.room.capacity"/></th>
							<th class="nosort"><s:text name="lbl.action"/></th>
						</tr>
					</thead>
					<tbody></tbody>
				</table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal"><s:text name="modal.ok"/></button>
            </div>
        </div>
    </div>
</div>