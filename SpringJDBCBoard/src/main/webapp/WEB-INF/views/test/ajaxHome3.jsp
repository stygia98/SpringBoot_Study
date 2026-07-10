<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {

			// 1. 일반 PUT 요청 버튼 이벤트
			$("#postBtn").on("click", function() {
				
				var boardDTOArray = [
					{boardNo:"01", title:"pw01"},
					{boardNo:"02", title:"pw02"}
				];

				$.ajax({
					type : "post",
					url : "/test/gohome2",
					data : JSON.stringify(boardDTOArray),
					contentType : "application/json; charset=utf-8",
					success : function(result) {
						console.log("result: " + result);
						if (result === "SUCCESS") {
							alert("SUCCESS");
						}
					} // <-- success 함수를 여기서 올바르게 닫아줍니다.
				}); // <-- $.ajax를 여기서 올바르게 닫아줍니다.
			
			}); // <-- #putBtn 클릭 이벤트를 여기서 올바르게 닫아줍니다.	

		}); // <-- $(document).ready를 여기서 최종적으로 닫아줍니다.
	</script>
</head>
<body>
<h1>Ajax Home</h1>
	<div>
		<button id="postBtn">객체배열전송 boardDTO</button>
	</div>
</body>
</html>