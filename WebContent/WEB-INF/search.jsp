<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索結果</title>
</head>
<body>
	<h1>検索結果</h1>


	<div>
		<h2>${errorMessage}</h2>
	</div>
	<div>${errorDetail}</div>


	<div>
		<table border="1">
			<thead>
				<tr>
					<td>フライト日付</td>
					<td>フライト番号</td>
					<td>出発地コード</td>
					<td>出発時間</td>
					<td>目的地コード</td>
					<td>到着時間</td>
					<td>機体コード</td>
					<td>予約</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${flights}" var="item">
					<tr>
						<td>${item.flightDate}</td>
						<td>${item.flightNo}</td>
						<td>${item.originCode}</td>
						<td>${item.departureTime}</td>
						<td>${item.destinationCode}</td>
						<td>${item.arrivalTime}</td>
						<td>${item.bodyCode}</td>
						<td><a href="ReservationServlet?date=${item.flightDate}&amp;no=${item.flightNo}">予約</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>