

function deleteStudentRow(t){
	 
	   var id2del;
	   console.log($(t).parent().parent());
	  
	   //console.log($(t).parent().parent().children("th:first").text())
	   id2del=$(t).parent().parent().children("th:first").text();
	   var res = confirm("确认是否删除");
	   if (res){
		   ajaxDeleteStudent(t,id2del);
	   }   
   };
   
   
   function ajaxDeleteStudent(t,d){
	   var url = window.location;
	   
		$.ajax({
			type:"DELETE",
			url:url + "/students/" + d,
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
	$("#studentgetBtn").click(function(event){
		event.preventDefault();
		ajaxGet();
	});
	
	
	
	// DO GET
	function ajaxGet(){
		$.ajax({
			type : "GET",
			url : url + "/students",
			success: function(result){
					$('#getStudentDiv tr').remove();
					
					$.each(result, function(i, result){
					
						$('#getStudentDiv').append('<tr><th scope="row">' + result.id + '</th><td>'+result.name +
						'</td><td>' + result.classname+'</td><td>' + result.studentno+'</td><td>' + 
						'<button class="btn btn-primary" onclick="deleteStudentRow(this)">删除</button></td></tr>');
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