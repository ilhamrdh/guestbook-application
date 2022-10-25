package com.program;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

public class Model {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/db_resepsionis";
    private static final String USER = "root";
    private static final String PASS = "";

    private static Connection conn;
    private static Statement statement;

    private static void connection() {
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ! Dashboard
    public static DefaultTableModel getData() {
        connection();
        String[] dataHeader = { "ID", "Tanggal", "Petugas", "Nama", "No Hp", "Alamat", "Tujuan", "Keterangan" };
        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);
        try {
            statement = conn.createStatement();
            String query = "SELECT * FROM vwtamu";
            ResultSet resulData = statement.executeQuery(query);
            while (resulData.next()) {
                Object[] rowData = { resulData.getInt("id"), resulData.getString("tglWaktu"),
                        resulData.getString("namaPetugas"), resulData.getString("namaTamu"),
                        resulData.getString("noHp"), resulData.getString("alamatTamu"), resulData.getString("tujuan"),
                        resulData.getString("ket") };
                tm.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tm;
    }

    public static int getCount() {
        connection();
        int count = 0;
        try {
            statement = conn.createStatement();
            String query = "SELECT COUNT(*) FROM vwtamu";
            ResultSet resulData = statement.executeQuery(query);
            resulData.next();
            count = resulData.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public static boolean tambahData(Date sqldate, String petugas, String nama, String noHp, String alamat,
            String tujuan, String ket) {
        connection();
        boolean data = false;
        try {
            statement = conn.createStatement();
            String query = "INSERT INTO tbltamu VALUES (" + null + ", '" + sqldate + "', '" + petugas + "', '" + nama
                    + "', '" + noHp + "', '" + alamat + "', '" + tujuan + "', '" + ket + "')";
            if (statement.executeUpdate(query) > 0) {
                data = true;
            }
            statement.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public static Object[] getDetail(int id) {
        connection();
        Object[] rowData = new Object[8];
        try {
            statement = conn.createStatement();
            String query = "SELECT * FROM vwtamu WHERE id = " + id;
            ResultSet resultData = statement.executeQuery(query);

            resultData.next();
            rowData[0] = resultData.getInt("id");
            rowData[1] = resultData.getString("tglWaktu");
            rowData[2] = resultData.getString("namaPetugas");
            rowData[3] = resultData.getString("namaTamu");
            rowData[4] = resultData.getString("noHp");
            rowData[5] = resultData.getString("alamatTamu");
            rowData[6] = resultData.getString("tujuan");
            rowData[7] = resultData.getString("ket");

            statement.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowData;
    }

    public static boolean ubahData(int id, String namaTamu, String noHp, String alamatTamu, String tujuanTamu,
            String ketTamu) {
        connection();
        boolean data = false;

        try {
            statement = conn.createStatement();
            String query = "UPDATE tbltamu SET namaTamu = '" + namaTamu + "', noHp = '" + noHp + "', alamatTamu = '"
                    + alamatTamu + "', tujuan = '" + tujuanTamu + "', ket = '" + ketTamu + "' WHERE id = " + id;
            if (statement.executeUpdate(query) > 0) {
                data = true;
            }
            statement.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public static DefaultTableModel getSearch(String keyword) {
        connection();
        String[] dataHeader = { "ID", "Tanggal", "Petugas", "Nama", "No Hp", "Alamat", "Tujuan", "Keterangan" };
        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);
        try {
            statement = conn.createStatement();
            String query = "SELECT * FROM vwtamu WHERE tglWaktu LIKE '%" + keyword + "%' OR namaPetugas LIKE '%"
                    + keyword + "%' OR namaTamu LIKE '%" + keyword + "%' OR noHp LIKE '%" + keyword
                    + "%' OR alamatTamu LIKE '%" + keyword + "%' OR tujuan LIKE '%" + keyword + "%' OR ket LIKE '%"
                    + keyword + "%'";
            ResultSet resulData = statement.executeQuery(query);
            while (resulData.next()) {
                Object[] rowData = { resulData.getInt("idLantai1"), resulData.getString("tglWaktu"),
                        resulData.getString("namaPetugas"), resulData.getString("namaTamu"),
                        resulData.getString("noHp"), resulData.getString("alamatTamu"), resulData.getString("tujuan"),
                        resulData.getString("ket") };
                tm.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tm;
    }
}
