var xhttp = new XMLHttpRequest();
function addCart(arg1, arg2) {
	console.log("name is " + arg1);
	console.log("sal is " + arg2);
	xhttp.open("GET", "addcart?name=arg1&sal=arg2", true);
	xhttp.send();
	console.log(xhttp.statusText);

	var tdd = document.getElementById(arg1);
	var texttd = "Item " + arg1 + " added to cart ";
	var text = document.createTextNode(texttd);
	tdd.appendChild(text);

}


$(document).ready(function(){
	  $("button").click(function(){
	    $("p").hide();
	  });
});