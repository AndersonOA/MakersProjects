var wsURI = "ws://" + document.location.host + "/makersweb-websocket/ws/contact";
var websocket = new WebSocket(wsURI);

websocket.onmessage = function(evt) {
	onMessage(evt);
};

function onMessage(evt) {
	var jsonObj = JSON.parse(evt.data);
	var id = jsonObj.contact.id;
	var firstName = jsonObj.contact.firstName;
	var lastName = jsonObj.contact.lastName;
	var email = jsonObj.contact.email;
	var phone = jsonObj.contact.phone;
	
	if (jsonObj.action === "ADICIONADO") {
		addContact(id, firstName, lastName, email, phone);
	}
}

function addContact(id, firstName, lastName, email, phone) {
	var contactTable = document.getElementById("contactTable");
	var rowCount = contactTable.rows.length;
	var row = contactTable.insertRow(rowCount);
	
	var cellId = row.insertCell(0);
	cellId.innerHTML = id;
	
	var cellFirstName = row.insertCell(1);
	cellFirstName.innerHTML = firstName;
	
	var cellLastName = row.insertCell(2);
	cellLastName.innerHTML = lastName;
	
	var cellEmail = row.insertCell(3);
	cellEmail.innerHTML = email;
	
	var cellPhone = row.insertCell(4);
	cellPhone.innerHTML = phone;
}