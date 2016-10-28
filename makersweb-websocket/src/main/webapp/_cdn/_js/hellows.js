var wsURI = "ws://" + document.location.host + "/makersweb-websocket/ws/hello";
var websocket = new WebSocket(wsURI);
var output;

function init() {
	output = document.getElementById("output");
	
	websocket.onopen = function(evt) {
		onOpen(evt);
	};
	
	websocket.onclose = function(evt) {
		onClose(evt);
	};
	
	websocket.onerror = function(evt) {
		onError(evt);
	};
	
	websocket.onmessage = function(evt) {
		onMessage(evt);
	};
}

function sendMessage() {
	websocket.send(document.getElementById("textID").value);
}

function onOpen(evt) {
	writeToScreen("Conectado ao EndPoint!");
}

function onClose(evt) {
	writeToScreen("Desconectado ao EndPoint :(");
}

function onError(evt) {
	writeToScreen('<b style="color: red;">ERROR: </b>' + evt.data);
}

function onMessage(evt) {
	writeToScreen("Message: " + evt.data);
}

function writeToScreen(message) {
	var pre = document.createElement("p");
	pre.style.wordWrap = "break-word";
	pre.innerHTML = message;
	
	output.appendChild(pre);
}

window.addEventListener("load", init, false);