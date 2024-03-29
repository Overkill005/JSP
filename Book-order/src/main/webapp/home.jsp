<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order books</title>
<script type="text/javascript" src="js/jQuery.js"></script>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="bg-cont">
<video id="bg" src="./media/bgvideo.mp4" autoplay loop muted></video></div>
<div class="form-container"> <!-- Add a container for the form -->
    <form method="post" action="createorder" onsubmit="return chk()">
        <label for="prodname">Product Name: </label>
        <input type="text" id="prodname" name="prodname">
        <span id="nsms"></span>
        <button type="button" id="check">Check</button>
        <div id="checked" style="display: none;">
            <label for="prodrate">Product Rate: </label>
            <input type="text" readonly id="prodrate" name="prodrate">
            <label for="prodqty">Product Quantity: </label>
            <input type="number" id="prodqty" name="prodqty">
            <span id="qsms"></span>
            <input type="hidden" readonly id="oprodqty" name="oprodqty">
            <input type="hidden" readonly id="prodid" name="prodid">
            <input type="submit" value="Order">
        </div>
    </form>
</div>

	<script type="text/javascript">
		$(document).ready(function() {
			$("#check").click(function() {
				
				let prodname1 = $("#prodname").val();
				if (prodname1 === "") {
					 $("#nsms").html("Name cannot be null");
				} else {
					$.ajax({
						url : "getproduct",
						type : "POST",
						dataType : "JSON",
						data : {
							prodname : prodname1
						},
						success : function(res) {
							
							if (res.length > 0) {
								$("#prodrate").val(res[0].prodrate);
								$("#oprodqty").val(res[0].prodqty);
								$("#prodid").val(res[0].prodid);
								$("#checked").show(); // Show the hidden fields
								$("#nsms").html("");
								console.log(res);
							} else {
								$("#nsms").html("Product not found in database");
							}
						}
					});
				}
			});

		
		});
		function chk() {
			let errorQty = validQty();
			if (errorQty) {
				return true;
			} else {
				return false;
			}
		}

		function validQty() {
		    let prodqty = parseInt($("#prodqty").val());
		    let oprodqty = parseInt($("#oprodqty").val());
		    if (prodqty > 0) {
		        if (oprodqty >= prodqty) {
		            $("#qsms").html("");
		            return true;
		        } else {
		            $("#qsms").html("Not available");
		            return false;
		        }
		    } else {
		        $("#qsms").html("Quantity cannot be less than 1");
		        return false;
		    }
		}
	</script>
</body>
</html>
