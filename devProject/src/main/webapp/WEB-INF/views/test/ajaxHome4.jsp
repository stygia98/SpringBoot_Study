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
			$("#sendFile").on("change", function(event) {
				console.log("change");
				
				var files = event.target.files;
				var file = files[0]; 
				console.log(file);
				
				var formData = new FormData(); 
				formData.append("file", file);

				$.ajax({
					type : "post",
					url : "/test/gohome4", 
					data: formData, 
					dataType:'text', 
					processData: false, 
					contentType: false, 
					success: function(data){
						alert(data);
					} // <-- success 함수를 여기서 올바르게 닫아줍니다.
				}); // <-- $.ajax를 여기서 올바르게 닫아줍니다.
			
			}); // <-- #putBtn 클릭 이벤트를 여기서 올바르게 닫아줍니다.	

		}); // <-- $(document).ready를 여기서 최종적으로 닫아줍니다.
	</script>
</head>
<body>
<h1>Ajax 파일업로드</h1>
	<div>
		<input type="file" id="sendFile">
	</div>
</body>
</html>