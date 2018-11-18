$( document ).ready(function() {
	
	var url = window.location;
	var courselist=new Array();
	
	// SUBMIT FORM
    $("#sForm").submit(function(event) {
		// Prevent the form from submitting via the browser.
		event.preventDefault();
		
		ajaxGetCourse();
		ajaxGetStudent();
		$("#searchStudentDiv").text('');
		 $("#searchForm").show();
		
	});
    
    $("#searchForm").submit(function(event) {
		// Prevent the form from submitting via the browser.
		event.preventDefault();
		
		ajaxpostSubject();
		 $("#searchForm").hide();
		
	});
    
    function ajaxpostSubject(){
    	
    	var formData= {
    			"studentid" : $("#searchID").text(),
    			"coursename" : $("#searchCourse").find("option:selected").text(),
    			"subjectfinal" : $("#searchFinal").val(),
    	}
    	
    	$.ajax({
			type : "POST",
			contentType : "application/json",
			url : url + "/subjects",
			data : JSON.stringify(formData),
			//dataType : 'json',
			success : function(result) {
		
				console.log(result);
				$("#searchStudentDiv").html("<strong>" + "Post Successfully!");
				
			},
			error : function(e) {
				alert("Error!")
				console.log("ERROR: ", e);
			}
		});
    }
    
    
    function ajaxGetCourse(){
    	$.ajax({
			type : "GET",
			url : url + "/courses",
			success: function(result){
				$("#searchCourse").text('');
				for (var i=0;i<result.length;i++){
					//courselist.push(result.name);
					$("#searchCourse").append('<option value="' + (i+1) +'">' + result[i].name + "</option>")
					//<option value="1">One</option>
					
				};
				console.log(result);
			},
			error : function(e) {
				alert("Error!")
				console.log("ERROR: ", e);
			}
    });
    	
    }
    
    function ajaxGetStudent(){
    	
    	// PREPARE FORM DATA
    	var formData = $("#student_s").val()
    	
    	
    	// DO POST
    	$.ajax({
			type : "GET",
			url : url + "/students/" + formData,
			success: function(result){
			
				console.log(result);
			
			$("#searchName").text('');
			$("#searchID").text('');	
/*				
			$("#searchStudentDiv").html('<form id="subjectForm">' +  "<label>姓名</label>" + 
						"<label>"+result.name+"</label>" + "<label>ID</label>" + "<label>"+result.id + "</label>" + 
						"<label>课程</label>" 
						); 
*/			
			$("#searchName").append(result.name);
			
			$("#searchID").append(result.id);
				
						               			 
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