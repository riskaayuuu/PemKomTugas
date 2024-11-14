package OPP;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Koneksi {

    public static Connection Go() {
        try {
            MysqlDataSource m = new MysqlDataSource();
            m.setServerName("localhost"); // Ganti dengan nama server MySQL kamu
            m.setDatabaseName("kasirsembako"); // Ganti dengan nama database kamu
            m.setUser("root"); // Ganti dengan username MySQL kamu
            m.setPassword(""); // Ganti dengan password MySQL kamu
            m.setPortNumber(3306); // Ganti dengan port MySQL kamu jika berbeda
            m.setServerTimezone("Asia/Jakarta"); // Ganti dengan zona waktu kamu

            Connection C = m.getConnection();
            System.out.println("Koneksi sukses");
            return C;
        } catch (SQLException e) {
            System.err.println("Koneksi Gagal!\n" + e.getMessage());
        }
        return null;
    }
}

