<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Playlist Editor</title>
</head>
<body>
	<h1>Edit Song Details Below: </h1>
	<form action ="playlistEditorServlet" method = "post">
		Song Name:<input type = "text" name = "song" value = "${editSong.song}">
		Artist: <input type = "text" name = "artist" value = "${editSong.artist}">
		Genre: <input type = "text" name = "genre" value = "${editSong.genre}">
		<input type = "hidden" name = "id" value = "${editSong.id}">
		<input type = "submit" value ="finished">
	</form>
	
</body>
</html>