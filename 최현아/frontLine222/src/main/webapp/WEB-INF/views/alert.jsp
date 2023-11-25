<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script>
	
	
	let msgSuccess = "<c:out value='${msg1}'/>";
	let urlSuccess = "<c:out value='${url1}'/>";
	let num = "<c:out value='${comparison}'/>";
	
	let msgFail= "<c:out value='${msg2}'/>";
	let urlFail = "<c:out value='${url2}'/>";
	let num2 = "<c:out value='${comparison2}'/>";

	let msg3= "<c:out value='${msg3}'/>";
	let url3 = "<c:out value='${url3}'/>";
	let num3 = "<c:out value='${comparison3}'/>";
	
	let msg4= "<c:out value='${msg4}'/>";
	let url4 = "<c:out value='${url4}'/>";
	let num4 = "<c:out value='${comparison4}'/>";
	
	if(num == 1){	
	alert(msgSuccess)
	location.href = urlSuccess;
	}else if(num2 == 2){
	alert(msgFail)
	location.href = urlFail;
	}else if(num3 == 3) {
	alert(msg3)	
	location.href = url3;
	}else if(num4 == 4) {
	alert(msg4)
	location.href = url4;
	}else{
		let msg = "<c:out value='${msg}'/>";
		let url = "<c:out value='${url}'/>";
		alert(msg);
		location.href = url;
	}
	
	
</script>
</head>
<body>
<!-- <form action="relayNum"> -->
<%-- <input type="hidden" name="num" value="${num}"> --%>
<!-- <input type="submit" id="clickNum"> -->
<!-- </form> -->

</body>
</html>