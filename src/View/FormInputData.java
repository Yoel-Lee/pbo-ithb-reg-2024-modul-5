package View;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import Controller.DBController;
import Controller.Controller;
import Model.Class.KTP;
import Model.Enum.JenisAgama;
import Model.Enum.JenisKelamin;
import Model.Enum.StatusPerkawinan;

public class FormInputData {

    private File photoFile;
    private File signatureFile;

    public FormInputData(String action, KTP myKtp) {

        showForm(action, myKtp);

    }

    public void showForm(String action, KTP myKtp) {
        Toolkit toolkit = Toolkit.getDefaultToolkit(); // INIT TOOLKIT
        Dimension screenSize = toolkit.getScreenSize(); // GET MY SCREEN SIZE

        int screenWidth = screenSize.width; // GET PIXELS FOR WIDTH
        int screenHeight = screenSize.height; // GET PIXELS FOR HEIGHT

        final int FRAME_WIDTH = 1200; // SET WIDTH
        final int FRAME_HEIGHT = 800; // SET WEIGHT

        int start_x = screenWidth / 2 - (FRAME_WIDTH / 2); // SET START LOCATION FOR X
        int start_y = screenHeight / 2 - (FRAME_HEIGHT / 2); // SET START LOCATION FOR Y

        JFrame form = new JFrame("Form Input Data Penduduk"); // CREATE FRAME AND SET TITLE

        form.setBounds(start_x, start_y, FRAME_WIDTH, FRAME_HEIGHT); // SET FRAME BOUND

        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        form.setLayout(null);

        JPanel formPanel = new JPanel(); // MAKE PANEL
        formPanel.setLayout(null);
        formPanel.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);

        JLabel nik = new JLabel("NIK");
        nik.setBounds(20, 30, 100, 20);
        formPanel.add(nik);

        JTextField nikField = new JTextField();
        nikField.setBounds(120, 30, 100, 20);
        formPanel.add(nikField);

        JLabel nama = new JLabel("Nama");
        nama.setBounds(20, 60, 100, 20);
        formPanel.add(nama);

        JTextField namaField = new JTextField();
        namaField.setBounds(120, 60, 100, 20);
        formPanel.add(namaField);

        JLabel tempatLahir = new JLabel("Tempat Lahir");
        tempatLahir.setBounds(20, 90, 100, 20);
        formPanel.add(tempatLahir);

        JTextField tempatLahirField = new JTextField();
        tempatLahirField.setBounds(120, 90, 100, 20);
        formPanel.add(tempatLahirField);

        JLabel tanggalLahir = new JLabel("Tanggal Lahir");
        tanggalLahir.setBounds(20, 120, 100, 20);
        formPanel.add(tanggalLahir);

        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());

        datePicker.setBounds(120, 120, 150, 20);
        formPanel.add(datePicker);

        JLabel jenisKelamin = new JLabel("Jenis Kelamin");
        jenisKelamin.setBounds(20, 150, 100, 20);
        formPanel.add(jenisKelamin);

        JRadioButton priaButton = new JRadioButton("Pria");
        priaButton.setBounds(120, 150, 50, 20);

        JRadioButton wanitaButton = new JRadioButton("Wanita");
        wanitaButton.setBounds(200, 150, 100, 20);

        // di group agar hanya 1 doang yg bs di check
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(priaButton);
        genderGroup.add(wanitaButton);

        formPanel.add(priaButton);
        formPanel.add(wanitaButton);

        JLabel golDarahLabel = new JLabel("GOLONGAN DARAH");
        golDarahLabel.setBounds(20, 180, 200, 50);
        formPanel.add(golDarahLabel);

        JRadioButton aRadio = new JRadioButton("A");
        JRadioButton bRadio = new JRadioButton("B");
        JRadioButton oRadio = new JRadioButton("O");
        JRadioButton abRadio = new JRadioButton("AB");

        aRadio.setBounds(20, 210, 35, 35);
        bRadio.setBounds(80, 210, 35, 35);
        oRadio.setBounds(140, 210, 35, 35);
        abRadio.setBounds(200, 210, 55, 35);

        ButtonGroup bloodGroup = new ButtonGroup();
        bloodGroup.add(aRadio);
        bloodGroup.add(bRadio);
        bloodGroup.add(oRadio);
        bloodGroup.add(abRadio);

        aRadio.setActionCommand("A");
        bRadio.setActionCommand("B");
        oRadio.setActionCommand("O");
        abRadio.setActionCommand("AB");

        formPanel.add(aRadio);
        formPanel.add(bRadio);
        formPanel.add(oRadio);
        formPanel.add(abRadio);

        JLabel alamat = new JLabel("Alamat");
        alamat.setBounds(20, 240, 80, 20);
        formPanel.add(alamat);

        JTextField alamatField = new JTextField();
        alamatField.setBounds(120, 240, 100, 20);
        formPanel.add(alamatField);

        JLabel RT = new JLabel("RT");
        RT.setBounds(20, 270, 100, 20);
        formPanel.add(RT);

        JTextField RTField = new JTextField();
        RTField.setBounds(120, 270, 100, 20);
        formPanel.add(RTField);

        JLabel RW = new JLabel("RW");
        RW.setBounds(250, 270, 100, 20);
        formPanel.add(RW);

        JTextField RWField = new JTextField();
        RWField.setBounds(290, 270, 100, 20);
        formPanel.add(RWField);

        JLabel kelDesa = new JLabel("Kel / Desa");
        kelDesa.setBounds(20, 300, 100, 20);
        formPanel.add(kelDesa);

        JTextField kelDesaField = new JTextField();
        kelDesaField.setBounds(120, 300, 100, 20);
        formPanel.add(kelDesaField);

        JLabel kecamatan = new JLabel("Kecamatan");
        kecamatan.setBounds(20, 330, 100, 20);
        formPanel.add(kecamatan);

        JTextField kecamatanField = new JTextField();
        kecamatanField.setBounds(120, 330, 100, 20);
        formPanel.add(kecamatanField);

        JLabel Agama = new JLabel("Agama");
        Agama.setBounds(20, 360, 100, 20);
        formPanel.add(Agama);

        JComboBox<String> agamaCB = new JComboBox<>();
        agamaCB.addItem("Kristen");
        agamaCB.addItem("Katolik");
        agamaCB.addItem("Islam");
        agamaCB.addItem("Hindu");
        agamaCB.addItem("Buddha");
        agamaCB.addItem("Konghucu");

        agamaCB.setBounds(120, 360, 100, 20);
        formPanel.add(agamaCB);

        JLabel statusNikah = new JLabel("Status Nikah");
        statusNikah.setBounds(20, 390, 100, 20);
        formPanel.add(statusNikah);

        JComboBox<String> statusNikahCB = new JComboBox<>();
        statusNikahCB.addItem("Belum Menikah");
        statusNikahCB.addItem("Menikah");

        statusNikahCB.setBounds(120, 390, 100, 20);
        formPanel.add(statusNikahCB);

        JLabel pekerjaan = new JLabel("Pekerjaan ");
        pekerjaan.setBounds(20, 420, 100, 20);
        formPanel.add(pekerjaan);

        JCheckBox karyawanSwastaCheck = new JCheckBox("Karyawan Swasta");
        karyawanSwastaCheck.setBounds(20, 450, 150, 20);

        JCheckBox pnsCheck = new JCheckBox("PNS");
        pnsCheck.setBounds(170, 450, 90, 20);

        JCheckBox wiraswastaCheck = new JCheckBox("Wiraswasta");
        wiraswastaCheck.setBounds(270, 450, 100, 20);

        JCheckBox akademisiCheck = new JCheckBox("Akademisi");
        akademisiCheck.setBounds(400, 450, 100, 20);

        JCheckBox pengangguranCheck = new JCheckBox("Pengangguran");
        pengangguranCheck.setBounds(500, 450, 180, 20);

        formPanel.add(karyawanSwastaCheck);
        formPanel.add(pnsCheck);
        formPanel.add(wiraswastaCheck);
        formPanel.add(akademisiCheck);
        formPanel.add(pengangguranCheck);

        pengangguranCheck.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (pengangguranCheck.isSelected()) {
                    karyawanSwastaCheck.setEnabled(false);
                    pnsCheck.setEnabled(false);
                    wiraswastaCheck.setEnabled(false);
                    akademisiCheck.setEnabled(false);

                    karyawanSwastaCheck.setSelected(false);
                    pnsCheck.setSelected(false);
                    wiraswastaCheck.setSelected(false);
                    akademisiCheck.setSelected(false);
                } else {
                    karyawanSwastaCheck.setEnabled(true);
                    pnsCheck.setEnabled(true);
                    wiraswastaCheck.setEnabled(true);
                    akademisiCheck.setEnabled(true);
                }
            }
        });

        JLabel kewarganegaraan = new JLabel("KEWARGANEGARAAN");
        kewarganegaraan.setBounds(20, 480, 140, 20);
        formPanel.add(kewarganegaraan);

        JRadioButton wniRadio = new JRadioButton("WNI");
        JRadioButton wnaRadio = new JRadioButton("WNA");
        wniRadio.setBounds(20, 510, 50, 20);
        wnaRadio.setBounds(90, 510, 70, 20);

        ButtonGroup groupKewarganegaraan = new ButtonGroup();
        groupKewarganegaraan.add(wniRadio);
        groupKewarganegaraan.add(wnaRadio);

        wniRadio.setActionCommand("WNI");
        wnaRadio.setActionCommand("WNA");

        formPanel.add(wniRadio);
        formPanel.add(wnaRadio);

        JLabel countryLabel = new JLabel("ASAL NEGARA");
        countryLabel.setBounds(20, 540, 150, 20);
        countryLabel.setVisible(false);
        formPanel.add(countryLabel);

        JTextField countryLabelField = new JTextField();
        countryLabelField.setBounds(200, 540, 100, 20);
        countryLabelField.setVisible(false);
        formPanel.add(countryLabelField);

        wnaRadio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                countryLabel.setVisible(true);
                countryLabelField.setVisible(true);
            }
        });

        wniRadio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                countryLabel.setVisible(true);
                countryLabelField.setVisible(true);
            }
        });

        JLabel photoLabel = new JLabel("FOTO");
        photoLabel.setBounds(20, 570, 100, 20);
        formPanel.add(photoLabel);

        JButton photoButton = new JButton("Upload");
        photoButton.setBounds(120, 570, 100, 20);
        formPanel.add(photoButton);

        photoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);

                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    photoFile = fileChooser.getSelectedFile();
                }
            }
        });

        JLabel ttdLabel = new JLabel("Tanda Tangan");
        ttdLabel.setBounds(20, 600, 100, 20);
        formPanel.add(ttdLabel);

        JButton ttdButton = new JButton("Upload");
        ttdButton.setBounds(120, 600, 100, 20);
        formPanel.add(ttdButton);

        ttdButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);

                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    signatureFile = fileChooser.getSelectedFile();
                }
            }
        });

        JLabel berlaku = new JLabel("Berlaku");
        berlaku.setBounds(20, 630, 80, 20);
        formPanel.add(berlaku);

        JTextField berlakuField = new JTextField();
        berlakuField.setBounds(120, 630, 100, 20);
        formPanel.add(berlakuField);

        JLabel kotaPembuatanKTP = new JLabel("Kota pembuatan KTP");
        kotaPembuatanKTP.setBounds(20, 660, 200, 20);
        formPanel.add(kotaPembuatanKTP);

        JTextField kotaPembuatanKTPField = new JTextField();
        kotaPembuatanKTPField.setBounds(120, 660, 100, 20);
        formPanel.add(kotaPembuatanKTPField);

        JLabel tanggalPembuatanKTP = new JLabel("Tanggal pembuatan KTP");
        tanggalPembuatanKTP.setBounds(20, 690, 100, 20);
        formPanel.add(tanggalPembuatanKTP);

        UtilDateModel modelKTP = new UtilDateModel();
        Properties pKTP = new Properties();
        pKTP.put("text.today", "Today");
        pKTP.put("text.month", "Month");
        pKTP.put("text.year", "Year");
        JDatePanelImpl datePanelKTP = new JDatePanelImpl(modelKTP, pKTP);
        JDatePickerImpl datePickerKTP = new JDatePickerImpl(datePanelKTP, new DateLabelFormatter());

        datePickerKTP.setBounds(120, 690, 120, 20);
        formPanel.add(datePickerKTP);

        JButton submitButton = new JButton("SUBMIT");
        submitButton.setBounds(20, 720, 200, 30);
        formPanel.add(submitButton);



        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (Controller.checkInput(nikField, namaField, tempatLahirField, datePicker, genderGroup, bloodGroup,
                        alamatField, RTField, RWField, kelDesaField, kecamatanField, agamaCB, statusNikahCB,
                        karyawanSwastaCheck, pnsCheck, wiraswastaCheck, akademisiCheck, pengangguranCheck,
                        groupKewarganegaraan, countryLabelField, photoFile, signatureFile, berlakuField,
                        kotaPembuatanKTPField, datePickerKTP))
                {



                    String nik = nikField.getText();
                    String nama = namaField.getText();
                    String tempatLahir = tempatLahirField.getText();
                  java.util.Date tanggal1 = (java.util.Date) datePicker.getModel().getValue();
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
String tanggal1Str = sdf.format(tanggal1);
                    JenisKelamin jenisKelamin = priaButton.isSelected() ? JenisKelamin.PRIA : JenisKelamin.WANITA;
                    String golDarah = bloodGroup.getSelection().getActionCommand();
                    String alamat = alamatField.getText();
                    String rt = RTField.getText();
                    String rw = RWField.getText();
                    String kelDesa = kelDesaField.getText();
                    String kecamatan = kecamatanField.getText();
                    JenisAgama agama = Controller.getJenisAgama(String.valueOf(agamaCB.getSelectedItem()));
                    StatusPerkawinan statusPerkawinan = Controller
                            .getStatusPerkawinan(String.valueOf(statusNikahCB.getSelectedItem()));
                    String pekerjaan = Controller.getSelectedJobs(karyawanSwastaCheck, pnsCheck, wiraswastaCheck,
                            akademisiCheck, pengangguranCheck);
                    String wargaNegaraAsal = wnaRadio.isSelected() ? countryLabelField.getText() : null;
                    String kewarganegaraan = Controller
                            .getCitizenship(groupKewarganegaraan.getSelection().getActionCommand(), wargaNegaraAsal);
                    String berlakuHingga = berlakuField.getText();
                    String kotaPembuatan = kotaPembuatanKTPField.getText();
                    java.util.Date tanggal2 = (java.util.Date) datePicker.getModel().getValue();
SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
String tanggal2Str = sdf.format(tanggal2);












                    // M A S U K I N    K E     D A T A B A S E


                    
                    Controller.createKTP(nik, nama, tempatLahir, tanggal1Str, jenisKelamin, golDarah, alamat, rt, rw, kelDesa, kecamatan, agama, statusPerkawinan, 
                    pekerjaan, kewarganegaraan, wargaNegaraAsal, photoFile, signatureFile, berlakuHingga, kotaPembuatan, tanggal2Str, action);
                    




                    







                    
                    // System.out.println("NIK: " + nik);
                    // System.out.println("Nama: " + nama);
                    // System.out.println("Tempat Lahir: " + tempatLahir);
                    // System.out.println("Tanggal Lahir: " + tanggal1);
                    // System.out.println("Jenis Kelamin: " + jenisKelamin);
                    // System.out.println("Golongan Darah: " + golDarah);
                    // System.out.println("Alamat: " + alamat);
                    // System.out.println("RT: " + rt);
                    // System.out.println("RW: " + rw);
                    // System.out.println("Kelurahan/Desa: " + kelDesa);
                    // System.out.println("Kecamatan: " + kecamatan);
                    // System.out.println("Agama: " + agama);
                    // System.out.println("Status Perkawinan: " + statusPerkawinan);
                    // System.out.println("Pekerjaan: " + pekerjaan);
                    // System.out.println("Warga Negara Asal: " + wargaNegaraAsal);
                    // System.out.println("Kewarganegaraan: " + kewarganegaraan);
                    // System.out.println("Berlaku Hingga: " + berlakuHingga);
                    // System.out.println("Kota Pembuatan: " + kotaPembuatan);
                    // System.out.println("Tanggal Pembuatan KTP: " + tanggal2);

                    Toolkit toolkit = Toolkit.getDefaultToolkit(); // INIT TOOLKIT
                    Dimension screenSize = toolkit.getScreenSize(); // GET MY SCREEN SIZE

                    int screenWidth = screenSize.width; // GET PIXELS FOR WIDTH
                    int screenHeight = screenSize.height; // GET PIXELS FOR HEIGHT

                    final int FRAME_WIDTH = 800; // SET WIDTH
                    final int FRAME_HEIGHT = 500; // SET WEIGHT

                    int start_x = screenWidth / 2 - (FRAME_WIDTH / 2); // SET START LOCATION FOR X
                    int start_y = screenHeight / 2 - (FRAME_HEIGHT / 2); // SET START LOCATION FOR Y

                    JFrame displayKTP = new JFrame("KTP"); // CREATE FRAME AND SET TITLE

                    displayKTP.setBounds(start_x, start_y, FRAME_WIDTH, FRAME_HEIGHT); // SET FRAME BOUND

                    displayKTP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    displayKTP.setLayout(null);

                    JLabel labelNIK = new JLabel("NIK : " + nik);
                    labelNIK.setBounds(200, 20, 150, 20);
                    displayKTP.add(labelNIK);

                    JLabel labelTempatLahir = new JLabel("Tempat Lahir : " + tempatLahir);
                    labelTempatLahir.setBounds(200, 40, 150, 20);
                    displayKTP.add(labelTempatLahir);

                    JLabel labelTanggal1 = new JLabel("Tanggal : " + tanggal1);
                    labelTanggal1.setBounds(200, 60, 200, 20);
                    displayKTP.add(labelTanggal1);

                    JLabel labelJenisKelamin = new JLabel("Jenis Kelamin : " + jenisKelamin);
                    labelJenisKelamin.setBounds(200, 80, 150, 20);
                    displayKTP.add(labelJenisKelamin);

                    JLabel labelGoldat = new JLabel("Goldar : " + golDarah);
                    labelGoldat.setBounds(200, 100, 150, 20);
                    displayKTP.add(labelGoldat);

                    JLabel labelAlamat = new JLabel("Alamat : " + alamat);
                    labelAlamat.setBounds(200, 120, 150, 20);
                    displayKTP.add(labelAlamat);

                    JLabel labelRTRW = new JLabel("RT / RW: " + rt + " " + rw);
                    labelRTRW.setBounds(200, 140, 150, 20);
                    displayKTP.add(labelRTRW);

                    JLabel labelKelDesa = new JLabel("Kel / Desa : " + kelDesa);
                    labelKelDesa.setBounds(200, 160, 150, 20);
                    displayKTP.add(labelKelDesa);

                    JLabel labelKecamatan = new JLabel("Kecamatan : " + kecamatan);
                    labelKecamatan.setBounds(200, 180, 150, 20);
                    displayKTP.add(labelKecamatan);

                    JLabel labelAgama = new JLabel("Agama : " + agama);
                    labelAgama.setBounds(200, 200, 150, 20);
                    displayKTP.add(labelAgama);

                    JLabel labelStatusKawin = new JLabel("Status Kawin : " + statusPerkawinan);
                    labelStatusKawin.setBounds(200, 220, 150, 20);
                    displayKTP.add(labelStatusKawin);

                    JLabel labelPekerjaan = new JLabel("Pekerjaan : " + pekerjaan);
                    labelPekerjaan.setBounds(200, 240, 250, 20);
                    displayKTP.add(labelPekerjaan);

                    JLabel labelWargaNegaraAsal = new JLabel("Asal Negara : " + wargaNegaraAsal);
                    labelWargaNegaraAsal.setBounds(200, 260, 150, 20);
                    displayKTP.add(labelWargaNegaraAsal);

                    JLabel labelKewarganegaraan = new JLabel("Kewarganegaraan : " + kewarganegaraan);
                    labelKewarganegaraan.setBounds(200, 280, 150, 20);
                    displayKTP.add(labelKewarganegaraan);

                    JLabel labelBerlakuHingga = new JLabel("Berlaku Hingga : " + berlakuHingga);
                    labelBerlakuHingga.setBounds(200, 300, 150, 20);
                    displayKTP.add(labelBerlakuHingga);

                    JLabel labelKotaPembuatan = new JLabel("Kota Pembuatan : " + kotaPembuatan);
                    labelKotaPembuatan.setBounds(200, 320, 150, 20);
                    displayKTP.add(labelKotaPembuatan);

                    JLabel labelTanggalPembuatan = new JLabel("Tanggal Pembuatan : " + tanggal2);
                    labelTanggalPembuatan.setBounds(200, 340, 350, 20);
                    displayKTP.add(labelTanggalPembuatan);


                        //foto muka
                    JLabel labelPhoto = new JLabel();
                    labelPhoto.setBounds(500, 100, 200, 200);
                    displayKTP.add(labelPhoto);

                    ImageIcon imageIcon = new ImageIcon(photoFile.getAbsolutePath());

                    Image image = imageIcon.getImage().getScaledInstance(
                            labelPhoto.getWidth(),
                            labelPhoto.getHeight(),
                            Image.SCALE_SMOOTH);
                    labelPhoto.setIcon(new ImageIcon(image));





                        //foto signature

                    JLabel labelSignPhoto = new JLabel();
                    labelSignPhoto.setBounds(570, 300, 50, 50);
                    displayKTP.add(labelSignPhoto);

                    ImageIcon imageIconSign = new ImageIcon(signatureFile.getAbsolutePath());

                    Image imageSign = imageIconSign.getImage().getScaledInstance(
                            labelSignPhoto.getWidth(),
                            labelSignPhoto.getHeight(),
                            Image.SCALE_SMOOTH);
                    labelSignPhoto.setIcon(new ImageIcon(imageSign));



                    //BACK TO MAIN MENU

                    JButton backtoMainMenuButton = new JButton("Back To Main Menu");
                    backtoMainMenuButton.setBounds(570, 400, 100, 30);
                    displayKTP.add(backtoMainMenuButton);

                    backtoMainMenuButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e){
                            new MainMenu();
                        }
                    });






                    displayKTP.setVisible(true);

                } else {

                    JOptionPane.showMessageDialog(form, "input ga lengkap", "Error",
                            JOptionPane.ERROR_MESSAGE);

                }
            }

        });


        
        form.add(formPanel);
        form.setVisible(true);

    }
    
}
