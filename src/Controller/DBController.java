package Controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import Model.Class.KTP;

public class DBController {
    static DataBaseHandler conn = new DataBaseHandler();

    
    // INSERT
    public static boolean insertNewUser(KTP ktp) {

        String query = "INSERT INTO ktp (nik, nama, tempat_lahir, tanggal_lahir, jenis_kelamin, gol_darah, alamat, rt, rw, keldesa, kecamatan, agama, status_perkawinan, pekerjaan, kewarganegaraan, negara_asal, photo_path, signature_path, berlaku_hingga, kota_pembuatan, tanggal_pembuatan) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {

            conn.connect();
            PreparedStatement stmt = conn.con.prepareStatement(query);
            
            stmt.setString(1, ktp.getNik());
            stmt.setString(2, ktp.getNama());
            stmt.setString(3, ktp.getTempatLahir());
            stmt.setString(4, ktp.getTanggalLahir());
            stmt.setString(5, ktp.getJenisKelamin().name());
            stmt.setString(6, ktp.getGolDarah());
            stmt.setString(7, ktp.getAlamat());
            stmt.setString(8, ktp.getRt());
            stmt.setString(9, ktp.getRw());
            stmt.setString(10, ktp.getKelDesa());
            stmt.setString(11, ktp.getKecamatan());
            stmt.setString(12, ktp.getAgama().name());
            stmt.setString(13, ktp.getStatusPerkawinan().name());
            stmt.setString(14, ktp.getPekerjaan());
            stmt.setString(15, ktp.getKewarganegaraan());
            stmt.setString(16, ktp.getWargaNegaraAsal());
            stmt.setString(17, ktp.getFotoFilePath().getPath());
            stmt.setString(18, ktp.getTandaTanganFilePath().getPath());
            stmt.setString(19, ktp.getBerlakuHingga());
            stmt.setString(20, ktp.getKotaPembuatan());
            stmt.setString(21, ktp.getTanggalPembuatan());

            stmt.executeUpdate();
            return true;

        } 
        catch (SQLException e) {
            
            e.printStackTrace();
            return false;

        } 
        finally {

            conn.disconnect();

        }

    }
}
