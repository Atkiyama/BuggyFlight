<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>予約画面</title>
</head>
<body>

	<h1>予約</h1>

		<div>
			<table border="1">
			<form action="CompleteServlet">
				<thead>
					<tr>
						<td>フライト日付</td>
						<td>フライト番号</td>
						<td>出発地コード</td>
						<td>出発時間</td>
						<td>目的地コード</td>
						<td>到着時間</td>
						<td>機体コード</td>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${flights}" var="item">
					<tr>
						<td>${item.flightDate}</td>
						<td>${item.flightNo}</td>
						<td>${item.originCode}</td>
						<td>${itemdepartureTime}</td>
						<td>${item.destinationCode}</td>
						<td>${item.arrivalTime}</td>
						<td>${item.bodyCode}</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>


		予約者の氏名を入力してください :<input type="text" name="name"	value="${name}" />
		予約人数を入力してください :<input type="text"name="number_of_people" value="${number_of_people}" />
		クレジットカード番号を入力してください :<input type="text"	name="card_number" value="${card_number}" />
		<input type="submit"value="予約">
	</form>




</body>
</html>