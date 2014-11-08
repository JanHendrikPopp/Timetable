<%@ include file="include.jsp"%>

<div class="modal fade" id="eventsRoomModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">select room</h4>
            </div>
            <div class="modal-body">
                <table class="table table-striped table-bordered table-hover dataTable" id="eventsRoomTable">
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
									<a href="javascript:loadRoomEvents(<s:property value="id"/>)" title="Add Room">
	                <i class="fa fa-plus-circle fa-fw"></i>Raum auswählen
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