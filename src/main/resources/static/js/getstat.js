
$( document ).ready(function() {
	
	var url = window.location;
	
	$("#stat-tab").click(function(event){
		event.preventDefault();
		$('#getStatDiv tr').remove();
		ajaxHighGet();
		ajaxLowGet();
		ajaxAvgGet();
		ajaxLevelGet();
	});
   
   
   
	// DO GET
	function ajaxHighGet(){
		$.ajax({
			type : "GET",
			url : url + "/stats/high",
			success: function(result){
				
						$('#getStatDiv').append('<tr><th scope="row">' + "最高分" + '</th><td>'+result +
						'</td></tr>');
						
					console.log("Success: ", result);
			},
			error : function(e) {
				$("#getResultDiv").html("<strong>Error</strong>");
				console.log("ERROR: ", e);
			}
		});	
	}
	
	function ajaxLowGet(){
		$.ajax({
			type : "GET",
			url : url + "/stats/low",
			success: function(result){
				
						$('#getStatDiv').append('<tr><th scope="row">' + "最低分" + '</th><td>'+result +
						'</td></tr>');
						
					console.log("Success: ", result);
			},
			error : function(e) {
				$("#getResultDiv").html("<strong>Error</strong>");
				console.log("ERROR: ", e);
			}
		});	
	}
	
	function ajaxAvgGet(){
		$.ajax({
			type : "GET",
			url : url + "/stats/avg",
			success: function(result){
				
						$('#getStatDiv').append('<tr><th scope="row">' + "平均分" + '</th><td>'+result +
						'</td></tr>');
						
					console.log("Success: ", result);
			},
			error : function(e) {
				$("#getResultDiv").html("<strong>Error</strong>");
				console.log("ERROR: ", e);
			}
		});	
	}
	
	function ajaxLevelGet(){
		$.ajax({
			type : "GET",
			url : url + "/stats/levels",
			success: function(result){

				　$.each(result, function(key, val) {      
					$('#getStatDiv').append('<tr><th scope="row">' + key + '</th><td>'+ val + " (人数X课程)" +
					'</td></tr>');
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