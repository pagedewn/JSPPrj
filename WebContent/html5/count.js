var count = 60;
var timer = null;

function countDown() {

	var lblCount = document.getElementById("lbl-count");
	lblCount.innerText = --count;
	if(count > 0)
		timer = setTimeout(countDown, 1000);
	

}

function btnCountDownClick(){
	if(timer == null)
	timer = setTimeout(countDown, 1000);
}

function init() {
	var btnCnt = document.getElementById("btn-countdown");
	btnCnt.onclick = btnCountDownClick;

}

window.onload = init;