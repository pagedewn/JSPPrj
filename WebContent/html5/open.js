var win = null;

function btnNewTabClick() {

	win = open("http://www.naver.com", "_blank");
}

function btnNewWinClick() {
	win = open("notice.html", "_blank", "width=500px, height=400px");
}

function btnCloseWinClick() {
	win.close();
}

function init(){
	var newTab = document.getElementById("btn-new-tab");
	var newWin = document.getElementById("btn-new-win");
	var closeWin = document.getElementById("btn-close-win");
	
	
	newTab.onclick = btnNewTabClick;
	newWin.onclick = btnNewWinClick;
	closeWin.onclick = btnCloseWinClick;
}

window.onload = init;