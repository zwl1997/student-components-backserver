$( document ).ready(function() {
	
	var url = window.location;
	
	// SUBMIT FORM
    $("#courseForm").submit(function(event) {
		// Prevent the form from submitting via the browser.
		event.preventDefault();
		ajaxPost();
		$("#postCourseDiv").text('');
	});
    
    
    function ajaxPost(){
    	
    	// PREPARE FORM DATA
    	var formData = {
    		name : $("#cname").val(),
    		time : $("#time").val(),
    		type : $("#type").val(),
    	}
    	
    	
    	
    	// DO POST
    	$.ajax({
			type : "POST",
			contentType : "application/json",
			url : url + "/courses",
			data : JSON.stringify(formData),
			//dataType : 'json',
			success : function(result) {

				console.log(result);
				$("#postCourseDiv").html("<strong>" + "Post Successfully!");
				
			},
			error : function(e) {
				alert("Error!")
				console.log("ERROR: ", e);
			}
		});
    	
    	// Reset FormData after Posting
    	resetData();

    }
    
    function resetData(){
    	$("#name").val("");
    	$("#time").val("");
    	$("#type").val("");
    }
})