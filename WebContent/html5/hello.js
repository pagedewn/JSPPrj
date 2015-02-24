/*
	function printResult() {
		var x, y;
		x = parseInt(prompt("x값을 입력하세요", 0));
		y = parseInt(prompt("y값을 입력하세요", 0));

		var btnPrint = document.getElementById("btn-print");
		btnPrint.value = x + y;
	}
	function init() {
		var btnPrint = document.getElementById("btn-print");
		btnPrint.onclick = printResult;
	}

	window.onload = init;*/

function add() {
	   
	var x = document.getElementById("txt-x");
	var y = document.getElementById("txt-y");
	var sum = document.getElementById("txt-sum");

	sum.value=parseInt(x.value)+parseInt(y.value);
	
}

function init() {
	var btnSum = document.getElementById("btn-sum");
	btnSum.onclick = add;
}


window.onload=init;