<%@ include file="include.jsp"%>

<div class="modal fade" id="eventsCenturyModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">select century</h4>
            </div>
            <div class="modal-body">
                <table class="table table-striped table-bordered table-hover dataTable" id="eventsCenturyTable">
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
									<a href="javascript:loadCenturyEvents(<s:property value="id"/>)" title="Add Century">
	                <i class="fa fa-plus-circle fa-fw"></i>Zenturie auswählen
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