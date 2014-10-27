$(document).ready(function() {

	$.ajax({
	       url: "ShowLecturerList.action",
	       contentType: 'application/json',
	       type: 'POST',
	       datatype:'json', 
	       async: true,
	       success: function (res) {
	    	   alert(res.lecturerMap.name);
	    }  });
	
});

