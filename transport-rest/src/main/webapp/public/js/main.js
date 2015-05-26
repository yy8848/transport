function greet(name){

	$.get("/rest/greeting?name="+name, function(data, status){
		alert(JSON.stringify(data) + "\nstatus " + JSON.stringify(status));
		$("#greeting").html(data.count);
	});					
}

function login(userName, password, successFunction, errorFunction){
	$.post(
		"/service/login?userName=" + userName + "&password=" + password, 
		function(){		
			successFunction();
		}
    ).fail(data){
		errorFunction(data);
	};	
}

function logout(){
	$.post(
		"/service/logout"
	).fail(data){
		
	};
}