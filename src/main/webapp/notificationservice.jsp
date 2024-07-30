<!DOCTYPE html>
<html>
<head>
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

body {
	font-family: 'Arial', sans-serif;
	background-image: url('third.jpg');
	background-repeat: no-repeat;
	
	background-size: 140% 140%;
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
	padding: 20px;
	max-width: 600px;
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

.input-group {
	margin-bottom: 15px;
}

input[type="email"] {
	padding: 10px;
	border: 1px solid #ddd;
	border-radius: 4px;
	font-size: 1em;
	width: 80%; /* Adjust width as needed */
	max-width: 400px; /* Optional: Set a maximum width */
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
<title>Flight Status System</title>
</head>
<body>
	<div class="container">
		<h1>Flight Status Notification System</h1>
		<form action="sendFlightStatus" method="post">
			<div class="input-group">
				<input type="email" name="email" placeholder="Enter recipient email"
					required>
			</div>
			<button type="submit">Send Flight Status to Email</button>
		</form>
	</div>
</body>
</html>
