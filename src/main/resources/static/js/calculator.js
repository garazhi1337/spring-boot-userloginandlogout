/**
 * author Artur Krukov
   2022.06.25
 */
let num1;
let num2;
let myElement = document.forms['calcForm']['calcInput'];
let operator;

function onOneClick() {
	myElement.value+="1";
}

function onTwoClick() {
	myElement.value+="2";
}

function onThreeClick() {
	myElement.value+="3";
}

function onFourClick() {
	myElement.value+="4";
}

function onFiveClick() {
	myElement.value+="5";
}

function onSixClick() {
	myElement.value+="6";
}

function onSevenClick() {
	myElement.value+="7";
}

function onEightClick() {
	myElement.value+="8";
}

function onNineClick() {
	myElement.value+="9";
}

function onZeroClick() {
	myElement.value+="0";
}

function onClearClick() {
	myElement.value="";
}

function onPlusClick() {
	operator = "plus";
	num1 = myElement.value;
	myElement.value="";
}

function onMinusClick() {
	operator = "minus";
	num1 = myElement.value;
	myElement.value="";
}

function onDivClick() {
	operator = "div";
	num1 = myElement.value;
	myElement.value="";
}

function onMulClick() {
	operator = "mul";
	num1 = myElement.value;
	myElement.value="";
}

function onDotClick() {
	myElement.value+=".";
}

function onEqualsClick() {
	num2 = myElement.value;
	switch (operator) {
		case "plus":
			num1 = parseFloat(num1);
			num2 = parseFloat(num2);
			num1+=num2;
			break;
		
		case "minus":
			num1 = parseFloat(num1);
			num2 = parseFloat(num2);
			num1-=num2;
			break;
		
		case "div":
			num1 = parseFloat(num1);
			num2 = parseFloat(num2);
			num1/=num2
			break;
		
		case "mul":
			num1 = parseFloat(num1);
			num2 = parseFloat(num2);
			num1*=num2;
			break;
	}
	myElement.value = num1;
}

function onDelClick() {
	let x = myElement.value;
	x = x.toString();
	x = x.slice(0, -1);
	myElement.value = x;
}












