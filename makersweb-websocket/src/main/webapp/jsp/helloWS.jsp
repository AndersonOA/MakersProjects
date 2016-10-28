<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta charset="UTF-8" />
		<title>MakersWeb - Websockets</title>
		<script type="text/javascript" src="./_cdn/_js/hellows.js"></script>
	</head>
	<body>
		<h1 style="text-align: center;">Bem vindo, ao WebSockets</h1>
		
		<br />
		
		<div style="text-align: center;">
			<form action="">
				<input onclick="sendMessage();" value="Send" type="button" />
				<input id="textID" name="message" value="Hello Websocket!" type="text" /> 
			</form>
		</div>
		
		<br />
		
		<div id="output"></div>
	</body>
</html>