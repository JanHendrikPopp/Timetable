var lecturerModal = $("#lecturerModal");
var roomModal = $("#roomModal");
var centuryModal = $("#centuryModal");
var lecturerTable = $("#lecturerTable");
var roomTable = $("#roomTable");
var centuryTable = $("#centuryTable");
var lecturerId = $("#lecturerId");

var lecturerName = $("#EditEvent_lecturerName, #AddEvent_lecturerName, #SaveEvent_lecturerName");
var roomNames = $("#EditEvent_roomNames, #AddEvent_roomNames, #SaveEvent_roomNames");
var centuryNames= $("#EditEvent_centuryNames, #AddEvent_centuryNames, #SaveEvent_centuryNames");

var eventStart = $("#EditEvent_event_eventStart, #AddEvent_event_eventStart, #SaveEvent_event_eventStart");
var eventDuration = $("#EditEvent_event_duration, #AddEvent_event_duration, #SaveEvent_event_duration");
var eventChangeOverTime = $("#EditEvent_event_changeoverTime, #AddEvent_event_changeoverTime, #SaveEvent_event_changeoverTime");
var eventWeeklyRecurrence = $("#EditEvent_event_weeklyRecurrence, #AddEvent_event_weeklyRecurrence, #SaveEvent_event_weeklyRecurrence");

var roomsDiv = $("#rooms");
var centuriesDiv = $("#centuries");


$(document).ready(function() {
	
    $('.addLecturer-dataTable, .addRoom-dataTable, .addCentury-dataTable').dataTable( {
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

function openAllRoomsModal() {
	roomModal.modal('show');
	initializeRoomTable();
}

function openFreeRoomsModal() {
	roomModal.modal('show');
	initializeFreeRoomTable();
}

function openCenturyModal() {
	centuryModal.modal('show');
	initializeCenturyTable();
}

function initializeRoomTable() {
	var table = roomTable.DataTable();
    table.clear();
    table.draw();
    
    $.getJSON('LoadRooms', function (obj) {
        jQuery.each(obj, function (i,val) {
            jQuery.each(val, function (e,value) {
                addRoomRow(value);
            });
        });
    });
}

function initializeFreeRoomTable() {
	var table = roomTable.DataTable();
    table.clear();
    table.draw();
    var duration = '&eventDuration=' + eventDuration.val();
    var changeOver = '&eventChangeOverTime=' + eventChangeOverTime.val();
    var rec = '&eventWeeklyRecurrence=' + eventWeeklyRecurrence.val();
    var start = '&eventStart=' + eventStart.val();
    $.getJSON('LoadFreeRooms', duration + changeOver + rec + start, function (obj) {
        jQuery.each(obj, function (i,val) {
            jQuery.each(val, function (e,value) {
                addRoomRow(value);
            });
        });
    });
}

function initializeCenturyTable() {
	var table = centuryTable.DataTable();
    table.clear();
    table.draw();
    
    $.getJSON('LoadCenturies', function (obj) {
        jQuery.each(obj, function (i,val) {
            jQuery.each(val, function (e,value) {
                addCenturyRow(value);
            });
        });
    });
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
    var gender = timetable.localization.gender[value.gender];
    var title = value.title;
    var name = value.name;
    var link = '<a href="javascript:setLecturer(';
    var link = link.concat(value.id);
    var link = link.concat(", '");
    var link = link.concat(title + ' ' + value.name);
    var link = link.concat("'");
    var link = link.concat(')" title="Add lecturer"><i class="fa fa-plus"></i></a>');
    t.row.add( [
        gender,
        title,
        name,
        link
    ]).draw();
}

function addRoomRow(value) {
    var t = roomTable.DataTable();
    var number = value.building + value.number;
    var type = timetable.localization.roomType[value.type];;
    var capacity = value.capacity;
    var link = '<a href="javascript:addRoom(';
    var link = link.concat(value.id);
    var link = link.concat(", '");
    var link = link.concat(number);
    var link = link.concat("'");
    var link = link.concat(')" title="Add lecturer"><i class="fa fa-plus"></i></a>');
    t.row.add( [
        number,
        type,
        capacity,
        link
    ]).draw();
}

function addCenturyRow(value) {
    var t = centuryTable.DataTable();
    var name = value.major + value.year + value.centuryChar;
    var major = value.major;
    var size = value.size;
    var link = '<a href="javascript:addCentury(';
    var link = link.concat(value.id);
    var link = link.concat(", '");
    var link = link.concat(name);
    var link = link.concat("'");
    var link = link.concat(')" title="Add Century"><i class="fa fa-plus"></i></a>');
    t.row.add( [
        name,
        major,
        size,
        link
    ]).draw();
}

function setLecturer(id, name) {
	lecturerId.val(id);
	lecturerName.val(name);
	lecturerModal.modal('hide');
}

function addRoom(id, name) {
	var input = '<input type="hidden" name="roomIds" value="' + id + '"/> ';
	var names = roomNames.val() + ' ' + name;
	$( "#rooms" ).append(input);
	roomNames.val(names);
}

function addCentury(id, name) {
	var input = '<input type="hidden" name="centuryIds" value="' + id + '"/> ';
	var names = centuryNames.val() + ' ' + name;
	$( "#centuries" ).append(input);
	centuryNames.val(names);
}


function clearRooms() {
	roomsDiv.empty();
	roomNames.val("");
}
function clearCenturies() {
	centuriesDiv.empty();
	centuryNames.val("");
}
function clearLecturer() {
	lecturerId.val("");
	lecturerName.val("");
}
