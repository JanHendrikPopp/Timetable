<%@ include file="include.jsp"%>

<script type="text/javascript">
    window.timetable = {
        locale: '<c:out value="${pageContext.response.locale}" />',
        localization: {
            error_messages: {
            },
            datatable_messages: {
                emptyTable: '<s:text name="datatable.emptyTable"/>',
                info: '<s:text name="datatable.info"/>',
                infoEmpty: '<s:text name="datatable.infoEmpty"/>',
                infoFiltered: '<s:text name="datatable.infoFiltered"/>',
                lengthMenu: '<s:text name="datatable.lengthMenu"/>',
                loadingRecords: '<s:text name="datatable.loadingRecords"/>',
                processing: '<s:text name="datatable.processing"/>',
                search: '<s:text name="datatable.search"/>',
                zeroRecords: '<s:text name="datatable.zeroRecords"/>',
                first: '<s:text name="datatable.first"/>',
                last: '<s:text name="datatable.last"/>',
                next: '<s:text name="datatable.next"/>',
                previous: '<s:text name="datatable.previous"/>',
                sortAscending: '<s:text name="datatable.sortAscending"/>',
                sortDescending: '<s:text name="datatable.sortDescending"/>'
            },
            gender: {
            	MALE: '<s:text name="lbl.MALE"/>',
            	FEMALE: '<s:text name="lbl.FEMALE"/>'
            },
            roomType: {
            	LECT: '<s:text name="lbl.room.LECT"/>',
            	LAB: '<s:text name="lbl.room.LAB"/>',
            	PC: '<s:text name="lbl.room.PC"/>'
            }
        }
    };
</script>