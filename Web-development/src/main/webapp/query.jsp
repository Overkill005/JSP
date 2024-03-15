<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Welcome ${param.name} 1st time    <!--  pass ?name=..... in url -->
<br>
<script type="text/javascript">
  var url=new URL(window.location);
  var name=url.searchParams.get("name");
  document.write("Welcome "+name+" 2nd time<br>");
  
  
  
  var name1 = new URLSearchParams(document.location.search).get("name");
  document.write("Welcome "+name1+" 3rd time");
</script>

</body>
</html>