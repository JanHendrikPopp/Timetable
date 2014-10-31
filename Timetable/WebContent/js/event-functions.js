var lecturerModal = $("#lecturerModal");
var lecturerTable = $("#lecturerTable");
var lecturerId = $("#lecturerId");
var lecturerNameEdit = $("#EditEvent_lecturerName");
var lecturerNameAdd = $("#AddEvent_lecturerName");

$(document).ready(function() {
	
    $('.addLecturer-dataTable').dataTable( {
        searching: true,
        paging: true,
        info: false,
        'aoColumnDefs': [{
            'bSortable': false,
            'aTargets': ['nosort']
        }],
        "aoColumns": [
            null, null, null, { "sClass": "text-center" }
        ],
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


function openLecturerModal() {
	lecturerModal.modal('show');
	initializeTable();
}


function initializeTable() {
	var table = lecturerTable.DataTable();
    table.clear();
    table.draw();
    
    $.getJSON('LoadLecturers', function (obj) {
        jQuery.each(obj, function (i,val) {
            jQuery.each(val, function (e,value) {
                addRow(value);
            });
        });
    });
}

function addRow(value) {
    var t = lecturerTable.DataTable();
    var gender = value.gender;
    var title = value.title;
    var name = value.name;
    var link = '<a href="javascript:setLecturer(';
    var link = link.concat(value.id);
    var link = link.concat(", '");
    var link = link.concat(value.name);
    var link = link.concat("'");
    var link = link.concat(')" title="Add lecturer">Teeest</a>');
    t.row.add( [
        gender,
        title,
        name,
        link
    ]).draw();
}

function setLecturer(id, name) {
	lecturerId.val(id);
	lecturerNameEdit.val(name);
	lecturerNameAdd.val(name);
	lecturerModal.modal('hide');
}
function clearLecturer() {
	lecturerId.val("");
	lecturerNameEdit.val("");
	lecturerNameAdd.val("");
}
