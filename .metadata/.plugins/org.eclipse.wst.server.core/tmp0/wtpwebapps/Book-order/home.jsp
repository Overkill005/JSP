<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order books</title>
<script type="text/javascript" src="js/jQuery.js"></script>
</head>
<body>
	<label for="prodname">Product Name: </label>
	<input type="text" id="prodname" name="prodname">
	<br>
	<label for="prodrate">Product Rate: </label>
	<input type="number" readonly id="prodrate" name="prodrate">
	<script type="text/javascript">
		$(document).ready(function() {
			// 	alert();
			$("#prodname").blur(function() {
				// 								alert();
				$.ajax({
					url : "getproduct",
					type : "POST",
					data : {
						ProdName : $("#prodname").val()
					},
					success : function(res) {
												console.log(res);
						$("#prodrate").val(res[0].ProdRate);

					}
				})
			})

		})
	</script>
</body>
</html>