var eventsLecturerModal = $("#eventsLecturerModal");

$(document).ready(function() {
	updateCalendar();
});


function openEventsLecturerModal() {
	eventsLecturerModal.modal('show');
}


function loadEvents(lecturerId) {
	
	$.getJSON('LoadLecturerEvents?lecturerId=' + lecturerId, function (obj) {
	       jQuery.each(obj, function (i,val) {
	           jQuery.each(val, function (e,value) {
	              addEvent(value);
	           });
	       });
	   });
}

function addEvent(event) {
	var events = [];
	events.push({
		title: event.name,
		start: event.eventStart,
		end: addMinutes(event.eventStart, event.duration)});
	
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