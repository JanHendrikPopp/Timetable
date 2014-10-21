$(document).ready(function() {

    /* Standard DataTable */
    $('.dataTable').dataTable( {
        searching: true,
        'aoColumnDefs': [{
            'bSortable': false,
            'aTargets': ['nosort']
        }],
        "language": {
            "emptyTable": timetable.localization.datatable_messages.emptyTable,
            "info": timetable.localization.datatable_messages.info,
            "infoEmpty": timetable.localization.datatable_messages.infoEmpty,
            "infoFiltered": timetable.localization.datatable_messages.infoFiltered,
            "infoPostFix": "",
            "thousands": ",",
            "lengthMenu": timetable.localization.datatable_messages.lengthMenu,
            "loadingRecords": timetable.localization.datatable_messages.loadingRecords,
            "processing": timetable.localization.datatable_messages.processing,
            "search": timetable.localization.datatable_messages.search + ' ',
            "zeroRecords": timetable.localization.datatable_messages.zeroRecords,
            "paginate": {
                "first": timetable.localization.datatable_messages.first,
                "last": timetable.localization.datatable_messages.last,
                "next": timetable.localization.datatable_messages.next,
                "previous": timetable.localization.datatable_messages.previous
            },
            "aria": {
                "sortAscending": timetable.localization.datatable_messages.sortAscending,
                "sortDescending": timetable.localization.datatable_messages.sortDescending
            }
        }
    } );
});
