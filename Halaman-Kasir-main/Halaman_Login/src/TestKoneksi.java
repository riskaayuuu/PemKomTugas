import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestKoneksi {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/db_kasir"; // Ganti dengan nama database Anda
        String username = "root"; // Ganti dengan username Anda
        String password = ""; // Ganti dengan password Anda
        
        try {
            Connection connection;
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Koneksi Berhasil!");
            connection.close();
        } catch (SQLException e) {
            System.out.println("Gagal Terhubung ke Database!");
            // Tampilkan detail error
        }
    }
}
