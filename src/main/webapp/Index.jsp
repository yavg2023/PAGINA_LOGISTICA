<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Iniciar Sesi�n</title>
</head>
<body>
<h1>INICIO DE SESI�N</h1>
<form action= "LoginServlet" method="post">
    <table>
        <tr>
            <td> USUARIO:</td>
            <td> <input type="text" name="txtusuario"></td>
        </tr>
        <tr>
            <td> CONTRASE�A:</td>
            <td> <input type="password" name="txtclave"></td>
        </tr>
        <tr>
            <td colspan="2"> <input type="submit" value="ENVIAR"></td>
        </tr>
    </table>
</form>
</body>
</html>
