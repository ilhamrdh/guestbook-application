package com.view;
import com.templates.cDashboard;
import com.partials.*;
import com.program.Model;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.Date;

public class vDashboard extends cDashboard{
    //SideBar Menu
    private cSidebarMenu menuBeranda = new cSidebarMenu("Beranda", 90);
    private cSidebarMenu menuData = new cSidebarMenu("Data L1", 90 + 50);
    private cSidebarMenu menuTambah = new cSidebarMenu("Tambah", 90 + 50 + 50);
    private cSidebarMenu menuLogout = new cSidebarMenu("Logout", 90 + 50 + 50 + 50);

    // Isi Content Beranda
    private cInfo labelJmlData = new cInfo("Data Kunjungan Tamu",33,59);
    private cBigFont JlmData = new cBigFont("0",33,125);
    
    // Isi Content Data Lantai 1
    private cTable tableTamu;
    private cScrollPane spTable;
    private cFormLable cari = new cFormLable("Cari",55,22,50,false);
    private cTextField txtCari = new cTextField(127,22,300,false);
    private cRedButton Hapus = new cRedButton("Hapus", 55,419,130);
    private cGreenButton btnUbah = new cGreenButton("Ubah", 252,420,140);
    
    // Isi Content Data Tambah
    private cLableTambah namaPetugas = new cLableTambah("Nama Petugas", 102,55,340,false);
    private cTextField txtNamaPetugas = new cTextField(84,95,376,false);
    private cErrorLable errorNamaPetugas = new cErrorLable("*Nama Petugas Tidak Boleh Kosong", 84,130,340,false);
    private cLableTambah nama = new cLableTambah("Nama Tamu", 102,150,340,false);
    private cTextField txtNama = new cTextField(84,191,376,false); 
    private cErrorLable errorNama = new cErrorLable("*Nama Tamu Tidak Boleh Kosong", 84,225,340,false);
    private cLableTambah NoHp = new cLableTambah("No Hp", 102,255,340,false);
    private cTextField txtNoHp = new cTextField(84,295,376,false); 
    private cErrorLable errorNoHp = new cErrorLable("*Nomor HP Tidak Boleh Kosong", 84,330,340,false);
    private cLableTambah alamat = new cLableTambah("Alamat", 102,360,340,false);
    private cTextField txtAlamat = new cTextField(84,400,376,false);
    private cErrorLable errorAlamat = new cErrorLable("*Alamat Tidak Boleh Kosong", 84,435,340,false);
    private cLableTambah tujuan = new cLableTambah("Tujuan", 582,55,340,false);
    private cTextField txtTujuan = new cTextField(565,95,360,false);
    private cErrorLable errorTujuan = new cErrorLable("*Tujuan Tidak Boleh Kosong", 565,130,340,false);
    private cLableTambah ket = new cLableTambah("Keterangan", 582,150,340,false);
    private JTextArea txtKet = new JTextArea();
    private cScrollPane spKet;
    private cErrorLable note = new cErrorLable("*Boleh dikosongkan dengan “-”", 565,290,340,false);
    private cReport btnReport = new cReport("Report",440);
    private cGreenButton btnTambah = new cGreenButton("Tambah",595,350,140);
    private cRedButton btnBatal = new cRedButton("Batal",765,350,140);

    //Isi Content Ubah
    private cLableTambah namaUbah = new cLableTambah("Nama", 102,50,340,false);
    private cTextField txtNamaUbah = new cTextField(84,95,376,false);
    private cErrorLable errorNamaUbah = new cErrorLable("*Nama Tamu Tidak Boleh Kosong", 84,130,340,false);
    private cLableTambah NoHpUbah = new cLableTambah("No Hp", 102,145,340,false);
    private cTextField txtNoHpUbah = new cTextField(84,191,376,false); 
    private cErrorLable errorNoHpUbah = new cErrorLable("*Nomor HP Tidak Boleh Kosong", 84,225,340,false);
    private cLableTambah alamatUbah = new cLableTambah("Alamat", 102,250,340,false);
    private cTextField txtAlamatUbah = new cTextField(84,295,376,false);
    private cErrorLable errorAlamatUbah = new cErrorLable("*Alamat Tidak Boleh Kosong", 84,330,340,false);
    private cLableTambah tujuanUbah = new cLableTambah("Tujuan", 102,355,340,false);
    private cTextField txtTujuanUbah = new cTextField(84,400,376,false); 
    private cErrorLable errorTujuanUbah = new cErrorLable("*Tujuan Tidak Boleh Kosong", 84,435,340,false);
    private cLableTambah ketUbah = new cLableTambah("Keterangan",582,50,340,false);
    private JTextArea txtKetUbah = new JTextArea();
    private cScrollPane spKetUbah;
    private cLableTambah noteUbah = new cLableTambah("*Boleh dikosongkan dengan “-”", 580,252,340,false);
    private cGreenButton btnTambahUbah = new cGreenButton("Ubah",595,350,140);
    private cRedButton btnBatalUbah = new cRedButton("Batal",765,350,140);
    
    //Reset Side Bar
    private void resetSidebar(){
        try {
            setVisible(false);
            menuBeranda.setBackground(cColor.WHITE);
            menuBeranda.setForeground(cColor.GRAY);
            menuBeranda.setSidebarnonAktif();

            menuData.setBackground(cColor.WHITE);
            menuData.setForeground(cColor.GRAY);
            menuData.setSidebarnonAktif();
            
            menuTambah.setBackground(cColor.WHITE);
            menuTambah.setForeground(cColor.GRAY);
            menuTambah.setSidebarnonAktif();

            menuLogout.setSidebarnonAktif();
        } catch (Exception e) {

        }
    }
    //Refres
    private void refreshConten(){
        try {
            content.removeAll();
        } catch (Exception e) {

        }
    }

    public vDashboard(){
        super("Dashboard");
        roleText.setText("DATA TAMU");
        menuBeranda.addMouseListener(new java.awt.event.MouseAdapter(){
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me){
                initsBeranda();
            }
        });
        menuData.addMouseListener(new java.awt.event.MouseAdapter(){
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me){
                initsData();
            }
        });
        menuTambah.addMouseListener(new java.awt.event.MouseAdapter(){
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me){
                initsAdd();
            }
        });
        menuLogout.addMouseListener(new java.awt.event.MouseAdapter(){
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me){
                Object[] options = {"YA","BATAL"}; 
                int confrim = JOptionPane.showOptionDialog(null, "Yakin ingin logout?", "Logout", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                if (confrim == 0) {
                    com.program.Controller.showMainLogin();
                    vDashboard.this.dispose();
                }
            }
        });
        sidebar.add(menuBeranda);
        sidebar.add(menuData);
        sidebar.add(menuTambah);
        sidebar.add(menuLogout);
        initsBeranda();
    }

    private void initsBeranda(){
        resetSidebar();
        menuBeranda.setBackground(cColor.BLUE);
        menuBeranda.setForeground(cColor.WHITE);
        refreshConten();
        roleText.setText("Data Tamu");
        menuTitle.setText("Beranda");
        menuBeranda.setSidebarAktif();
        JlmData.setText(String.valueOf(Model.getCount()));
        content.add(JlmData);
        content.add(labelJmlData);
        setVisible(true);
    }

    private void initsData(){
        resetSidebar();
        menuData.setBackground(cColor.BLUE);
        menuData.setForeground(cColor.WHITE);
        refreshConten();
        roleText.setText("Data Tamu");
        menuTitle.setText("Data");
        menuData.setSidebarAktif();
        Hapus.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae){
                
            }
        });
        btnUbah.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae){
                int selectedIndex = tableTamu.getSelectedRow();
                if (selectedIndex == -1) {
                    JOptionPane.showMessageDialog(vDashboard.this, "Pilih terlebih dahulu", "Peringatan", JOptionPane.WARNING_MESSAGE);
                }else{
                    int id = Integer.valueOf(tableTamu.getValueAt(selectedIndex, 0).toString());
                    initsUbah(id);
                }
            }
        });
        tableTamu = new cTable(Model.getData());
        tableTamu.getColumnModel().getColumn(0).setMinWidth(0);
        tableTamu.getColumnModel().getColumn(0).setMaxWidth(0);
        tableTamu.getColumnModel().getColumn(0).setWidth(0);
        tableTamu.getColumnModel().getColumn(1).setWidth(120);
        tableTamu.getColumnModel().getColumn(1).setMinWidth(100);
        tableTamu.getColumnModel().getColumn(2).setWidth(100);
        tableTamu.getColumnModel().getColumn(2).setMinWidth(90);
        tableTamu.getColumnModel().getColumn(3).setWidth(150);
        tableTamu.getColumnModel().getColumn(3).setMinWidth(140);
        tableTamu.getColumnModel().getColumn(4).setWidth(120);
        tableTamu.getColumnModel().getColumn(4).setMinWidth(110);
        tableTamu.getColumnModel().getColumn(5).setWidth(160);
        tableTamu.getColumnModel().getColumn(5).setMinWidth(150);
        tableTamu.getColumnModel().getColumn(6).setWidth(150);
        tableTamu.getColumnModel().getColumn(6).setMinWidth(140);
        spTable = new cScrollPane(tableTamu,30,74,950,315);

        txtCari.addActionListener( new java.awt.event.ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae){
                String keyword = txtCari.getText();
                tableTamu.setModel(Model.getSearch(keyword));
                tableTamu.getColumnModel().getColumn(0).setMinWidth(0);
                tableTamu.getColumnModel().getColumn(0).setMaxWidth(0);
                tableTamu.getColumnModel().getColumn(0).setWidth(0);
                tableTamu.getColumnModel().getColumn(1).setWidth(120);
                tableTamu.getColumnModel().getColumn(1).setMinWidth(100);
                tableTamu.getColumnModel().getColumn(2).setWidth(100);
                tableTamu.getColumnModel().getColumn(2).setMinWidth(90);
                tableTamu.getColumnModel().getColumn(3).setWidth(150);
                tableTamu.getColumnModel().getColumn(3).setMinWidth(140);
                tableTamu.getColumnModel().getColumn(4).setWidth(120);
                tableTamu.getColumnModel().getColumn(4).setMinWidth(110);
                tableTamu.getColumnModel().getColumn(5).setWidth(160);
                tableTamu.getColumnModel().getColumn(5).setMinWidth(150);
                tableTamu.getColumnModel().getColumn(6).setWidth(150);
                tableTamu.getColumnModel().getColumn(6).setMinWidth(140);
            }
        });

        content.add(cari);
        content.add(txtCari);
        content.add(spTable);
        content.add(btnReport);
        content.add(Hapus);
        content.add(btnUbah);
        setVisible(true);
    }

    private void initsAdd(){
        resetSidebar();
        menuTambah.setBackground(cColor.BLUE);
        menuTambah.setForeground(cColor.WHITE);
        refreshConten();
        menuTambah.setSidebarAktif();
        roleText.setText("Data Tamu");
        menuTitle.setText("Tambah Data");
        menuData.setSidebarAktif();
        note.setFont(cFonts.FONT_REGULAR_ERROR);
        note.setForeground(cColor.RED);
        txtKet.setFont(cFonts.FONT_REGULAR);
        txtKet.setWrapStyleWord(true);
        txtKet.setLineWrap(true);
        spKet = new cScrollPane(txtKet,565,191,360,100);

        txtNamaPetugas.setText(null);
        txtNama.setText(null);
        txtNoHp.setText(null);
        txtAlamat.setText(null);
        txtTujuan.setText(null);
        txtKet.setText(null);
        
        btnBatal.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae){
                initsAdd();
            }
        });
        btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae){
                if (txtNamaPetugas.getText().trim().isEmpty() || txtNama.getText().trim().isEmpty() || txtNoHp.getText().trim().isEmpty() || 
                    txtAlamat.getText().trim().isEmpty() || txtTujuan.getText().trim().isEmpty() || txtKet.getText().trim().isEmpty()){
                        vDashboard.this.setVisible(false);

                    if(txtNamaPetugas.getText().trim().isEmpty()) content.add(errorNamaPetugas);
                    else content.remove(errorNamaPetugas);
                    
                    if(txtNama.getText().trim().isEmpty()) content.add(errorNama);
                    else content.remove(errorNama);
                    
                    if(txtNoHp.getText().trim().isEmpty()) content.add(errorNoHp);
                    else content.remove(errorNoHp);
                    
                    if(txtAlamat.getText().trim().isEmpty()) content.add(errorAlamat);
                    else content.remove(errorAlamat);
                    
                    if(txtTujuan.getText().trim().isEmpty()) content.add(errorTujuan);
                    else content.remove(errorTujuan);
                    
                    vDashboard.this.setVisible(true);
                } else {
                    String petugas = txtNamaPetugas.getText();
                    String nama = txtNama.getText();
                    String noHp = txtNoHp.getText();
                    String alamat = txtAlamat.getText();
                    String tujuan = txtTujuan.getText();
                    String ket = txtKet.getText();
                    Date date = new Date();
                    java.sql.Date sqldate = new java.sql.Date(date.getTime());
                    if (Model.tambahData(sqldate,petugas, nama, noHp, alamat, tujuan, ket)) {
                        JOptionPane.showMessageDialog(vDashboard.this, "Berhasil ditambahkan", "Berhasil", JOptionPane.INFORMATION_MESSAGE);
                        initsData();
                    } else {
                        JOptionPane.showMessageDialog(vDashboard.this, "Gagal ditambahkan", "Gagal", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        content.add(namaPetugas);
        content.add(nama);
        content.add(NoHp);
        content.add(alamat);
        content.add(tujuan);
        content.add(ket);
        content.add(txtNamaPetugas);
        content.add(txtNama);
        content.add(txtNoHp);
        content.add(txtAlamat);
        content.add(txtTujuan);
        content.add(btnTambah);
        content.add(btnBatal);
        content.add(spKet);
        setVisible(true);
    }

    private void initsUbah(int id){
        resetSidebar();
        menuData.setBackground(cColor.BLUE);
        menuData.setForeground(cColor.WHITE);
        refreshConten();
        menuData.setSidebarAktif();
        roleText.setText("Data Tamu");
        menuTitle.setText("Ubah Data");
        menuData.setSidebarAktif();
        noteUbah.setFont(cFonts.FONT_REGULAR_ERROR);
        noteUbah.setForeground(cColor.RED);
        txtKetUbah.setFont(cFonts.FONT_REGULAR);
        txtKetUbah.setWrapStyleWord(true);
        txtKetUbah.setLineWrap(true);
        spKetUbah = new cScrollPane(txtKetUbah,565,95,360,100);
        

        Object[] detailData = Model.getDetail(id);

        txtNamaUbah.setText(detailData[3].toString());
        txtNoHpUbah.setText(detailData[4].toString());
        txtAlamatUbah.setText(detailData[5].toString());
        txtTujuanUbah.setText(detailData[6].toString());
        txtKetUbah.setText(detailData[7].toString());

        btnTambahUbah.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                if (txtNamaUbah.getText().trim().isEmpty() || txtNoHpUbah.getText().trim().isEmpty() || txtAlamatUbah.getText().trim().isEmpty() || 
                        txtTujuanUbah.getText().trim().isEmpty() || txtKetUbah.getText().trim().isEmpty()){
                        vDashboard.this.setVisible(false);

                    if(txtNamaUbah.getText().trim().isEmpty()) content.add(errorNamaUbah);
                    else content.remove(errorNamaUbah);
                    
                    if(txtNoHpUbah.getText().trim().isEmpty()) content.add(errorNoHpUbah);
                    else content.remove(errorNoHpUbah);
                    
                    if(txtAlamatUbah.getText().trim().isEmpty()) content.add(errorAlamatUbah);
                    else content.remove(errorAlamatUbah);
                    
                    if(txtTujuanUbah.getText().trim().isEmpty()) content.add(errorTujuanUbah);
                    else content.remove(errorTujuanUbah);
                    
                    vDashboard.this.setVisible(true);
                } else {
                    String nama = txtNamaUbah.getText();
                    String noHp = txtNoHpUbah.getText();
                    String alamat = txtAlamatUbah.getText();
                    String tujuan = txtTujuanUbah.getText();
                    String ket = txtKetUbah.getText();
                    if (Model.ubahData(id, nama, noHp, alamat, tujuan, ket)) {
                        JOptionPane.showMessageDialog(vDashboard.this, "Berhasil diubah", "Berhasil", JOptionPane.INFORMATION_MESSAGE);
                        initsData();
                    } else {
                        JOptionPane.showMessageDialog(vDashboard.this, "Gagal diubah", "Gagal", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        btnBatalUbah.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae){
                initsData();
            }
        });
        content.add(namaUbah);
        content.add(txtNamaUbah);
        content.add(NoHpUbah);
        content.add(txtNoHpUbah);
        content.add(alamatUbah);
        content.add(txtAlamatUbah);
        content.add(tujuanUbah);
        content.add(txtTujuanUbah);
        content.add(ketUbah);
        content.add(txtKetUbah);
        content.add(spKetUbah);
        content.add(btnTambahUbah);
        content.add(btnBatalUbah);
        setVisible(true);
    }
}
