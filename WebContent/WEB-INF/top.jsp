<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>航空機予約システム</title>
</head>
<body>
	<h1>航空機予約システム</h1>

	<form action="SearchServlet">
		<table>
			<tr>
				<th>出発地</th>
				<td>
				<select name="origin_code" size="7">
					<option value="CTS">札幌・新千歳</option>
					<option value="FUK">福岡</option>
					<option value="HND">東京・羽田</option>
					<option value="ITM">大阪・伊丹</option>
					<option value="KIX">大阪・関西</option>
					<option value="NGO">名古屋・中部</option>
					<option value="NRT">成田</option>
				</select>
				</td>
			</tr>


			<tr>
				<th>目的地</th>
				<td>
				<select name="destination_code" size="7">
				<option value="CTS">札幌・新千歳</option>
					<option value="FUK">福岡</option>
					<option value="HND">東京・羽田</option>
					<option value="ITM">大阪・伊丹</option>
					<option value="KIX">大阪・関西</option>
					<option value="NGO">名古屋・中部</option>
					<option value="NRT">成田</option>
				</select>
				</td>
			</tr>



			<tr>
				<th>日時</th>
				<td>
					<input type="date" min="2020-05-15" max="2020-06-30" name="flight_date" value="${flight_date}">
				</td>
			</tr>

			<tr>
				<td>
					<button type="submit" name="action" value="search.jspに遷移">検索</button>
				</td>
			</tr>
		</table>
	</form>


</body>
</html>