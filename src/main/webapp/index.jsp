<!DOCTYPE html>
<html>
<head>
<title>Flight Status System</title>
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

body {
	
	font-family: 'Arial', sans-serif;
	background-image: url('backimage.jpg');
	background-repeat: no-repeat;
	background-size: 110% 110%;
	color: #333;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
}

.container {
	text-align: center;
	background-color: white;
	border-radius: 8px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
	padding: 60px;
	max-width: 700px;
	width: 100%;
}

h1 {
	font-size: 2.5em;
	color: #4a90e2;
	margin-bottom: 20px;
}

form {
	margin-top: 20px;
}

button {
	background-color: #4a90e2;
	color: white;
	border: none;
	padding: 15px 30px;
	font-size: 1em;
	cursor: pointer;
	border-radius: 5px;
	transition: background-color 0.3s ease, transform 0.2s ease;
}

button:hover {
	background-color: #357abd;
	transform: scale(1.05);
}

button:active {
	background-color: #2a5d9d;
}
</style>
</head>
<body>

	<div class="container">
		<h1>Welcome to the Flight Status Notification System</h1>
		<form action="flightStatus" method="get">
			<button type="submit">Check Flight Status</button>
		</form>
	</div>
</body>
</html>
