<!DOCTYPE html>
<html>
<head>
<title>Email Notification Response</title>
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

body {
	font-family: 'Arial', sans-serif;
	background-image: url('second.jpg');
	background-repeat: no-repeat;
	background-size: cover;
	color: #333;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	margin: 0;
}

.message-container {
	padding: 30px;
	border-radius: 15px;
	text-align: center;
	box-shadow: 0 8px 16px rgba(0, 0, 0, 0.3);
	max-width: 600px;
	width: 90%;
	margin: 20px auto;
}

h1 {
	color: #333;
	margin-top: 20px;
	font-size: 1.5em;
}
</style>
</head>
<body>
	<div class="message-container">
		<%
		boolean emailSent = (boolean) request.getAttribute("emailSent");
		if (emailSent) {
		%>
		<h1 style="color: green;"><%=request.getAttribute("emailSentMessage")%></h1>
		<%
		} else {
		%>
		<h1 style="color: red;"><%=request.getAttribute("emailSentMessage")%></h1>
		<%
		}
		%>
	</div>
</body>
</html>
