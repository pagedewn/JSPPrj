
function btnOpenerClose() {
	opener.close();
	}

function init(){

	var openerClose = document.getElementById("btn-parent-close");
	
	openerClose.onclick = btnOpenerClose;
}

window.onload = init;
