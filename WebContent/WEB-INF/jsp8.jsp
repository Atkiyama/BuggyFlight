<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${title}</title>
</head>
<body>
	<h1>${title}</h1>

	<form>
		<table>
			<tr>
				<th>出発日付</th>
				<td>
					<input type="text" name="flight_date" value="${flight_date}"/>
				</td>
			</tr>
			<tr>
				<th>出発地コード</th>
				<td>
					<input type="text" name="origin_code" value="${origin_code}"/>
				</td>
			</tr>
			<tr>
				<td>
					<button type="submit">検索する</button>
				</td>
			</tr>
		</table>
	</form>

	<div><h2>${errorMessage}</h2></div>
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
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${flights}" var="item">
					<tr>
					<td>${item.flightDate}</td>
					<td>${item.flightNo}</td>
					<td>${item.originCode}</td>
					<td>${itemdepartureTime}</td>
					<td>${item.destinationCode}/td>
					<td>${item.arrivalTime}</td>
						<td>${item.bodyCode}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>