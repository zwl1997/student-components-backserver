


function deleteCourseRow(t){
	
	   var id2del;
	 
	   console.log($(t).parent().parent());
	  
	   //console.log($(t).parent().parent().children("th:first").text())
	   id2del=$(t).parent().parent().children("th:first").text();
	   var res = confirm("确认是否删除");
	   if (res){
		   ajaxDeleteCourse(t,id2del);
	   }
	   
   };
   
 
   function ajaxDeleteCourse(t,d){
	   var url = window.location;
	   
		$.ajax({
			type:"DELETE",
			url:url + "/courses/" + d,
			statusCode : {
				204:function(){
					alert("Cannot delete!")
				},
				200:function(){
					$(t).parent().parent().remove();
				}
			
			},
			error : function(e) {
				
				console.log("ERROR: ", e);
			}
		});
	}


$( document ).ready(function() {
	
	var url = window.location;
	
	
	// GET REQUEST
	$("#coursegetBtn").click(function(event){
		event.preventDefault();
		ajaxGet();
	});
	
	
	
	// DO GET
	function ajaxGet(){
		$.ajax({
			type : "GET",
			url : url + "/courses",
			success: function(result){
					$('#getCourseDiv tr').remove();
					
					$.each(result, function(i, result){
					
						$('#getCourseDiv').append('<tr><th scope="row">' + result.id + '</th><td>'+result.name +
						'</td><td>' + result.time+'</td><td>' + result.type+'</td><td>' + 
						'<button  class="btn btn-primary" onclick="deleteCourseRow(this)">删除</button></td></tr>');
			        });
					console.log("Success: ", result);		
			},
			error : function(e) {
				$("#getResultDiv").html("<strong>Error</strong>");
				console.log("ERROR: ", e);
			}
		});	
	}
})