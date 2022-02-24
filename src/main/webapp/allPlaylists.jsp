<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Your Playlists</title>
</head>
<body>
	<h1> Your Playlists </h1>
	<form method = "post" action = "managerNavServlet">
		<table>
		<c:forEach items = "${requestScope.playListsToDisplay}" var = "p">
		<tr>
			<td><input type = "radio"  name = "id" value = "${p.id}"></td>
			
				<td><h2> Playlist Name: ${p.playlistName} </h2> <h4>Created by: ${p.creator}</h4></td>
				
			<c:forEach items = "${p.playlist}" var = "currSong" >
				<tr><td colspan = "4"> Song Name: ${currSong.song} - Artist: ${currSong.artist} - Genre: ${currSong.genre}</td></tr>
			</c:forEach>
		
		</c:forEach>
		</table>
		<br />
	<input type = "submit" value = "New Playlist" name="selection">
	<input type = "submit" value = "Delete Playlist" name="selection">
	</form>
	<br />
	<a href = "index.html">Add New Songs</a>

</body>
</html>