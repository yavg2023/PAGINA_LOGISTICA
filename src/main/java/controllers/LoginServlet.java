package controllers;

import utilidades.ClassConex;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usuario = request.getParameter("txtusuario");
        String clave = request.getParameter("txtclave");

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ClassConex.getConnection();
            if (conn != null) {
                String sql = "SELECT COUNT(*) FROM usuarios WHERE usuario = ? AND password = ?";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, usuario);
                stmt.setString(2, clave);
                rs = stmt.executeQuery();

                if (rs.next() && rs.getInt(1) > 0) {
                    // Autenticación exitosa, redirigir a página de éxito
                    response.sendRedirect("login_success.jsp");
                } else {
                    // Autenticación fallida, redirigir de vuelta al formulario de inicio de sesión
                    response.sendRedirect("login.jsp");
                }
            } else {
                // Error de conexión a la base de datos
                throw new SQLException("No se pudo establecer la conexión a la base de datos.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            // Manejo de errores
            e.printStackTrace(); // Para propósitos de depuración

            // Mensaje de error para el usuario o log
            String errorMessage = "Error al procesar la solicitud: " + e.getMessage();
            request.setAttribute("error_message", errorMessage);
            request.getRequestDispatcher("error.jsp").forward(request, response); // Redirige a una página de error más informativa
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace(); // Puedes manejar esto de manera similar si es necesario
            }
        }
    }
}

