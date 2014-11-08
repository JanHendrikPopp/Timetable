var eventsLecturerModal = $("#eventsLecturerModal");
var eventsRoomModal = $("#eventsRoomModal");
var eventsCenturyModal = $("#eventsCenturyModal");

$(document).ready(function() {
	updateCalendar();
});


function openEventsLecturerModal() {
	eventsLecturerModal.modal('show');
}

function openEventsRoomModal() {
	eventsRoomModal.modal('show');
}

function openEventsCenturyModal() {
	eventsCenturyModal.modal('show');
}


function loadEvents(lecturerId) {
	$('#calendar').fullCalendar( 'removeEvents' );
	$.getJSON('LoadLecturerEvents?lecturerId=' + lecturerId, function (obj) {
	       jQuery.each(obj, function (i,val) {
	           jQuery.each(val, function (e,value) {
	              addEvent(value);
	           });
	       });
	   });
	eventsLecturerModal.modal('hide');
}
function loadRoomEvents(roomId) {
	$('#calendar').fullCalendar( 'removeEvents' );
	$.getJSON('LoadRoomEvents?roomId=' + roomId, function (obj) {
	       jQuery.each(obj, function (i,val) {
	           jQuery.each(val, function (e,value) {
	              addEvent(value);
	           });
	       });
	   });
	eventsRoomModal.modal('hide');
}
function loadCenturyEvents(centuryId) {
	$('#calendar').fullCalendar( 'removeEvents' );
	$.getJSON('LoadCenturyEvents?centuryId=' + centuryId, function (obj) {
	       jQuery.each(obj, function (i,val) {
	           jQuery.each(val, function (e,value) {
	              addEvent(value);
	           });
	       });
	   });
	eventsCenturyModal.modal('hide');
}

function addEvent(event) {
	var events = [];
	
	var rec = event.weeklyRecurrence;
	var start = event.eventStart;
	while (rec >= 0) {
		events.push({
			title: event.name,
			start: start,
			end: addMinutes(start, event.duration)});
	start = addMinutes(start, 10080);
	rec--;
	}
	
	$('#calendar').fullCalendar( 'addEventSource', events );
}

function addMinutes(date, minutes) {
    return new Date(Date.parse(date) + minutes*60000);
}

function updateCalendar() {
	$('#calendar').fullCalendar({
		header: {
			left: 'prev,next today',
			center: 'title',
			right: 'month,basicWeek,basicDay'
		},
		editable: true,
		eventLimit: true,
		defaultView: 'agendaWeek',
		allDaySlot: false,
		scrollTime: '08:45:00',
		height: 650,
		editable: false,
		day: false
		
	});
}