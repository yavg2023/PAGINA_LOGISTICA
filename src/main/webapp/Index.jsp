<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Iniciar Sesión</title>
</head>
<body>
<h1>INICIO DE SESIÓN</h1>
<form action= "LoginServlet" method="post">
    <table>
        <tr>
            <td> USUARIO:</td>
            <td> <input type="text" name="txtusuario"></td>
        </tr>
        <tr>
            <td> CONTRASEÑA:</td>
            <td> <input type="password" name="txtclave"></td>
        </tr>
        <tr>
            <td colspan="2"> <input type="submit" value="ENVIAR"></td>
        </tr>
    </table>
</form>
</body>
</html>
