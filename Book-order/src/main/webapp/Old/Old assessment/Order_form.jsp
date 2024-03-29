<!DOCTYPE html>
<html>
<head>
<title>Order Form</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style>
body {
	font-family: Arial, sans-serif;
/* 	background-color: lightgray; */
	/* 	display: flex; */
	text-align: center;
	width: 50%;
	margin-top: 10%; margin-left : 25%;
	margin-left: 25%;
	padding: 2rem;
	margin-left: 25%;
}

.container {
	max-width: 600px;
	margin: 50px auto;
	padding: 20px;
	background-color: #fff; border-radius : 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	border-radius: 8px;
}
.cont{
background-color:lightgray;
padding:1rem;
border-radius:2rem;
}

h2 {
	text-align: center;
	color: #333;
}

form {
	margin-top: 20px;
}

label {
	display: block;
	margin-bottom: 10px;
	color: #555;
}

input[type="text"], input[type="number"], input[type="submit"] {
	width: 100%;
	padding: 10px;
	margin-bottom: 20px;
	border: 1px solid #ccc;
	border-radius: 5px;
	box-sizing: border-box;
}

button {
	background-color: #007bff;
	color: #fff;
	cursor: pointer;
	padding: 10px; margin-bottom : 20px; border : 1px solid #ccc;
	border-radius : 5px;
	transition: background-color 0.3s ease;
	margin-bottom: 20px;
	border: 1px solid #ccc;
	border-radius: 5px;
}

button:hover {
	background-color: #0056b3;
}
</style>
</head>
<body>
	<div class="cont">
		<h2>Order Books</h2>
		<label for="productName">Product Name:</label> <input type="text"
			id="productName" name="productName">
		<button id="checkProduct">Check Product</button>
		<div id="productInfo"></div>
		<div id="invalidp"></div>
	</div>
	<script>
		$(document).ready(function() {
			$('#checkProduct').click(function() {
				$.ajax({
					url : "../OrderServlet",
					type : "GET",
					data : {
						productName : $("#productName").val()
					},
					success : function(response) {
						$("#productInfo").html(response);
					}
				});
			});
		});
	</script>
</body>
</html>
