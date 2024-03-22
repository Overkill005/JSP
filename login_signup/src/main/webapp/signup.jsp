<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Signup</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>

<script type="text/javascript">
$(document).ready(function(){
    $("input[type='button']").click(function(){
        var username = $("#username").val();
        var password = $("#password").val();
        var role = $("input[name='role']:checked").val();
        
        $.ajax({
            url: "signupServlet",
            type: "POST",
            dataType: "json",
            data: { username: username, password: password, role: role },
            success: function(res){
                if(res.sms === "success"){
                    // Redirect to login page
                    window.location.href = "login.jsp";
                }
            }
        });
    });
});
</script>

User Details<br>
<label for="username">User Name</label><input name="username" id="username"><br>
<label for="password">Password</label><input name="password" id="password"><br>
Role Name
<input type="radio" name="role" value="user" id="user"><label for="user" >User</label>
<input type="radio" name="role" value="admin" id="admin"><label for="admin">Admin</label><br>
<input type="button" value="Create User">
</body>
</html>
