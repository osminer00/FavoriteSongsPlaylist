<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Playlist</title>
</head>
<body>
	<h1> Create A New Playlist</h1>
	<form action = "addPlaylistServlet" method = "post">
	Playlist Name: <input type = "text" name = "playlistName">
	Creator Name: <input type = "text" name = "creator">
	<br />
	Songs:<br />
	<select name = "addSongs" multiple size = "10">
		<c:forEach items = "${requestScope.songs}" var= "s">
			<option value = "${s.id}"> - Song Name: ${s.song} - Genre: ${s.genre} - Artist: ${s.artist}
		
		</c:forEach>
	</select>
	<br />
	<input type = "submit" value ="Make Playlist">
	</form>
	<a href= "index.html"> Add New Songs</a>
	
</body>
</html>