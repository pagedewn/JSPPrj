function openDoc(){
	window.frames[0].location.href="http://www.daum.net";
}


function init(){
	var openBtn = document.getElementById("btn-open");

	
	
	openBtn.onclick = openDoc;
	
}

window.onload = init;