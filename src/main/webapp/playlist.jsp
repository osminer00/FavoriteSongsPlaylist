<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Playlist</title>
</head>
<body>

	<h1>Your Playlist: </h1>
	<form method = "post" action = "navigationServlet">
		<table>
			<c:forEach items = "${requestScope.allSongs}" var="currentSong">
			<tr>
				<td><input type = "radio" name = "id" value = "${currentSong.id}"></td>
				<td>${currentSong.song} - </td>
				<td>${currentSong.artist} - </td>
				<td>${currentSong.genre}</td>
			</tr>
			</c:forEach>
		</table>
		
		
		<input type = "submit" value = "edit song" name = "selection">
		<input type = "submit" value = "delete song" name = "selection">
		<input type = "submit" value = "add song" name = "selection">
	</form>

</body>
</html>