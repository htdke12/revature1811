/**
 * 
 */
function createNewUser(){
	let user = {};
	
	
	
	
	
	user.eid=3;
	user.fname="mel0";
	user.lname="jelo";
	user.positionType=2;
	
	
	
	
	return user;
}



function SendNewUser(){
document.write(99999);
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function(){
		
		if(xhr.readyState === 4 && xhr.status === 201){
			document.write("New user validate");
		}
		
	}
	
	xhr.open("POST","api/UserServlet",true);
	
	let user = createNewUser();
	
	xhr.send(JSON.stringify(user));
	
}








function createNewForm(){
	let user = {};
	
	/*user.username = document.getElementById("newUsername").value;
	user.fname = document.getElementById("firstname").value;
	user.lname = document.getElementById("lastname").value;*/
	
	user.eid=1;
	user.workRelate="aa";
	user.courseType="bb";
	user.date="cc";
	user.time="dd";
	user.location="ee";
	user.description="ff";
	user.cost=200;
	
	
	
	return user;
}
function makeNewForm(){

	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function(){
		
		if(xhr.readyState === 4 && xhr.status === 201){
			document.write("New user created successfully");
		}
		
	}
	
	xhr.open("POST","api/FormServlet",true);
	
	let form = createNewForm();
	
	xhr.send(JSON.stringify(form));
	
	
}







window.onload = function(){
	
	SendNewUser();
	
}