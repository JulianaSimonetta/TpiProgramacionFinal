package BD;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class Inicializador {

    public static void inicializar() throws SQLException {

        // Consulta adaptada a MySQL para verificar si la tabla 'tipoDocumento' ya existe en la BD actual.
        String consulta =
                "SELECT 1 FROM information_schema.tables " + "WHERE table_schema = DATABASE() " + "AND table_name = 'tipoDocumento'";

        // Sentencia SQL para crear la tabla usando AUTO_INCREMENT para IDs autoincrementales.
        String crearTabla =
                "CREATE TABLE tipoDocumento (" + "codigo INT AUTO_INCREMENT PRIMARY KEY, " + "descripcion VARCHAR(50) NOT NULL" + ")";
        // Try-with-resources para asegurar el cierre automático de recursos
        try (Connection conexion = Conexion.conectar();
             Statement sentencia = conexion.createStatement()) {

            boolean existe;

            try (ResultSet resultado = sentencia.executeQuery(consulta)) {
                existe = resultado.next();
            }

            if (!existe) {
                sentencia.executeUpdate(crearTabla);
                System.out.println("Tabla 'tipoDocumento' creada correctamente en MySQL.");
            } else {
                System.out.println("La tabla 'tipoDocumento' ya existe.");
            }
        }
    }
}