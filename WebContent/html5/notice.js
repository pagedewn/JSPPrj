function btnResizeClick() {

	opener.resizeTo(100, 100);
}

function btnMoveClick() {
	opener.moveTo(200, 300);
}

function btnOpenerClose() {
	opener.close();
}

function init(){
	var btnResize = document.getElementById("btn-resize");
	var btnMove = document.getElementById("btn-move");
	var openerClose = document.getElementById("btn-opener-close");
	
	
	btnResize.onclick = btnResizeClick;
	btnMove.onclick = btnMoveClick;
	openerClose.onclick = btnOpenerClose;
}

window.onload = init;