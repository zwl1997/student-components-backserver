$( document ).ready(function() {
	
	var url = window.location;
	
	// SUBMIT FORM
    $("#studentForm").submit(function(event) {
		// Prevent the form from submitting via the browser.
		event.preventDefault();
		ajaxPost();
		$("#postStudentDiv").text('');
	});
    
    
    function ajaxPost(){
    	
    	// PREPARE FORM DATA
    	var formData = {
    		name : $("#sname").val(),
    		classname : $("#classname").val(),
    		studentno : $("#studentno").val(),
    	}
    	
    	
    	
    	// DO POST
    	$.ajax({
			type : "POST",
			contentType : "application/json",
			url : url + "/students",
			data : JSON.stringify(formData),
			//dataType : 'json',
			success : function(result) {
				console.log(result);
				$("#postStudentDiv").html("<strong>" + "Post Successfully!");
				
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
    	$("#classname").val("");
    	$("#studentno").val("");
    }
})