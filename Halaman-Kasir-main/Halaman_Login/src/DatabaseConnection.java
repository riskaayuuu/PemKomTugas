import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                String url = "jdbc:mysql://localhost:3306/db_kasir"; // Ganti sesuai detail MySQL Anda
                String username = "root"; // Ganti sesuai dengan username MySQL Anda
                String password = ""; // Ganti sesuai dengan password MySQL Anda

                // Mendapatkan koneksi ke database
                connection = DriverManager.getConnection(url, username, password);
                System.out.println("Koneksi Berhasil!");
            } catch (SQLException e) {
                System.out.println("Gagal Terhubung ke Database!");
            }
        }
        return connection;
    }
}
