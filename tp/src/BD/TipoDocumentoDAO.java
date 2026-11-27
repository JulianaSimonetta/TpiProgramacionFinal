package BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TipoDocumentoDAO {

    /**
     * Registra una nueva persona en la base de datos de manera segura usando PreparedStatement.
     */
    public void registrarTipoDocumento(String descripcion) throws SQLException {

        String sql = """
            INSERT INTO tipoDocumento (descripcion)
            VALUES (?)
            """;

        try (Connection conexion = Conexion.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setString(1, descripcion);

            sentencia.executeUpdate();
        }
    }

    /**
     * Lista todas las personas registradas en la base de datos.
     */
    public void listarTiposDocumento() throws SQLException {

        String sql = "SELECT codigo, descripcion FROM tipoDocumento ORDER BY codigo";

        try (Connection conexion = Conexion.conectar();
             Statement sentencia = conexion.createStatement();
             ResultSet resultado = sentencia.executeQuery(sql)) {

            System.out.println("\n--- LISTADO DE TIPOS DE DOCUMENTOS (MYSQL) ---");

            while (resultado.next()) {
                int id = resultado.getInt("codigo");
                String nombre = resultado.getString("descripcion");

                System.out.println(
                        id + " - " + nombre + " "
                );
            }
        }
    }
}
