function deleteSubjectRow(t){
	 
	   var id2del;
	   console.log($(t).parent().parent());
	  
	   //console.log($(t).parent().parent().children("th:first").text())
	   id2del=$(t).parent().parent().children("th:first").text();
	   var res = confirm("确认是否删除");
	   if (res){
		   ajaxDeleteSubject(t,id2del);
	   }   
   };
   
   
   function ajaxDeleteSubject(t,d){
	   var url = window.location;
	   
		$.ajax({
			type:"DELETE",
			url:url + "/subjects/" + d,
			statusCode : {
				204:function(){
					alert("不能删除！")
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
	$("#query-tab").click(function(event){
		
		event.preventDefault();
		$('#getSubjectDiv tr').remove();

		ajaxQueryGet();
	});
	
	// DO GET
	function ajaxQueryGet(){
		$.ajax({
			type : "GET",
			url : url + "/subjects",
			success: function(result){
					//$('#getSubjectDiv tr').remove();
					
				$.each(result, function(i, result){
				
						$('#getSubjectDiv').append('<tr><th scope="row">'  + result.subjectid + '</th><td>' + result.classname + '</td><td>'+ result.studentname + 
								'</td><td>'+result.coursename +'</td><td>' + result.subjectfinal+'</td><td>' + 
								'<button class="btn btn-primary" onclick="deleteSubjectRow(this)">删除</button></td></tr>');
						
					console.log("Success: ", result);

				});
			},
			error : function(e) {
				$("#getResultDiv").html("<strong>Error</strong>");
				console.log("ERROR: ", e);
			}
		});	
	}
})