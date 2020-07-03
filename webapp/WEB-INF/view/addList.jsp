<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="/gb03/guest/add?" method="get">
		<table border='1'>
			<tbody>
				<tr>
					<td>이름</td>
					<td><input type='text' name='name'></td>
					<td>비밀번호</td>
					<td><input type='password' name='pw'></td>
				</tr>

				<tr>
					<td colspan='4'><textarea cols='65' rows='5' name='content'></textarea>
					</td>
				</tr>

				<tr>
					<td colspan='4'>
						<button type='submit'>확인</button>
					</td>
				</tr>
			</tbody>
		</table>
	</form>

	<br>

	<form action="" method="post">

	<c:forEach items="${vo}" var="vo">
		<table border='1'>
			<colgroup>
				<col style="width: 50px;">
				<col style="width: 100px;">
				<col style="width: 230px;">
				<col style="width: 100px;">
			</colgroup>

			<tbody>
				<tr>
					<td>${vo.no}</td>
					<td>${vo.name}</td>
					<td>${vo.date}</td>
					<td><a href='/gb03/guest/deleteForm?no=${vo.no}'> 삭제 </a></td>
				</tr>

				<tr>
					<td colspan='4'>${vo.content}</td>
				</tr>
			</tbody>
		</table>
	</form>
	<br>
	</c:forEach>
</body>
</html>