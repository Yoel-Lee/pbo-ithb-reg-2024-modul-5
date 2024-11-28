package Controller;

import java.io.File;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePickerImpl;

import Model.Class.KTP;
import Model.Enum.JenisAgama;
import Model.Enum.JenisKelamin;
import Model.Enum.StatusPerkawinan;

public class Controller {

    public static boolean checkInput(
            JTextField nikField,
            JTextField namaField,
            JTextField tempatLahirField,
            JDatePickerImpl datePicker,
            ButtonGroup genderGroup,
            ButtonGroup bloodGroup,
            JTextField alamatField,
            JTextField RTRWField,
            JTextField kelDesaField,
            JTextField kecamatanField,
            JTextField kecamatanField2, JComboBox<String> agamaCB,
            JComboBox<String> statusNikahCB,
            JCheckBox karyawanSwastaCheck,
            JCheckBox pnsCheck,
            JCheckBox wiraswastaCheck,
            JCheckBox akademisiCheck,
            JCheckBox pengangguranCheck,
            ButtonGroup groupKewarganegaraan,
            JTextField countryLabelField,
            File photoFile,
            File signatureFile,
            JTextField berlakuField,
            JTextField kotaPembuatanKTPField,
            JDatePickerImpl tanggalPembuatanKTP) {

        if (nikField.getText().trim().isEmpty()
                || namaField.getText().trim().isEmpty()
                || tempatLahirField.getText().trim().isEmpty()
                || datePicker.getModel().getValue() == null
                || genderGroup.getSelection() == null
                || bloodGroup.getSelection() == null
                || alamatField.getText().trim().isEmpty()
                || RTRWField.getText().trim().isEmpty()

                || kelDesaField.getText().trim().isEmpty()
                || kecamatanField.getText().trim().isEmpty()
                || agamaCB.getSelectedIndex() == -1
                || statusNikahCB.getSelectedIndex() == -1
                || (!karyawanSwastaCheck.isSelected()
                        && !pnsCheck.isSelected()
                        && !wiraswastaCheck.isSelected()
                        && !akademisiCheck.isSelected()
                        && !pengangguranCheck.isSelected())
                || groupKewarganegaraan.getSelection() == null
                || (groupKewarganegaraan.getSelection().getActionCommand().equals("WNA")
                        && countryLabelField.getText().trim().isEmpty())
                || photoFile == null
                || signatureFile == null
                || berlakuField.getText().trim().isEmpty()
                || kotaPembuatanKTPField.getText().trim().isEmpty()
                || tanggalPembuatanKTP.getModel().getValue() == null) {

            return false;

        } else {

            return true;

        }
    }




    public static String getSelectedJobs(JCheckBox karyawanSwastaCheck, JCheckBox pnsCheck,
            JCheckBox wiraswastaCheck, JCheckBox akademisiCheck,
            JCheckBox pengangguranCheck) {
        if (karyawanSwastaCheck.isSelected()) {
            return "Karyawan Swasta";
        } else if (pnsCheck.isSelected()) {
            return "PNS";
        } else if (wiraswastaCheck.isSelected()) {
            return "Wiraswasta";
        } else if (akademisiCheck.isSelected()) {
            return "Akademisi";
        } else if (pengangguranCheck.isSelected()) {
            return "Pengangguran";
        }
        return "Tidak ada pekerjaan";
    }



    public static JenisAgama getJenisAgama(String agama) {

        if (agama.equalsIgnoreCase("KRISTEN")) {
            
            return JenisAgama.KRISTEN;

        }
        else if (agama.equalsIgnoreCase("KATHOLIK")) {
            
            return JenisAgama.KATHOLIK;

        } 
        else if (agama.equalsIgnoreCase("ISLAM")) {
            
            return JenisAgama.ISLAM;

        } 
        else if (agama.equalsIgnoreCase("HINDU")) {
            
            return JenisAgama.HINDU;

        } 
        else if (agama.equalsIgnoreCase("BUDDHA")) {
            
            return JenisAgama.BUDDHA;

        } 
        else if (agama.equalsIgnoreCase("KONGHUCU")) {
            
            return JenisAgama.KONGHUCU;

        }else{
            return JenisAgama.ATEIS;
        }

}



    public static StatusPerkawinan getStatusPerkawinan(String status) {

        if (status.equalsIgnoreCase("BELUM MENIKAH")) {
            
            return StatusPerkawinan.BELUM_MENIKAH;

        }
        else if (status.equalsIgnoreCase("MENIKAH")) {
            
            return StatusPerkawinan.MENIKAH;

        } 
        else {
            return StatusPerkawinan.UNKNOWN;
        }
    }


    
    public static String getCitizenship(String citizen, String country) {

        String citizenship = "";

        if (citizen.equalsIgnoreCase("WNI")) {
            
            citizenship = "WNI";

        }
        else {

            citizenship = "WNA(" + country + ")";

        }

        return citizenship;

    }




    
    public static KTP createKTP(
        String nik, 
        String nama, 
        String tempatLahir, 
        String tanggalLahir, 
        JenisKelamin jenisKelamin, 
        String golDarah, 
        String alamat, 
        String rt, 
        String rw, 
        String kelDesa, 
        String kecamatan,
        JenisAgama agama, 
        StatusPerkawinan statusPerkawinan, 
        String pekerjaan, 
        String kewarganegaraan, 
        String wargaNegaraAsal, 
        File photoFile, 
        File signatureFile, 
        String berlakuHingga, 
        String kotaPembuatan, 
        String tanggalPembuatan, 
        int actionValue) {
        


        KTP ktp = new KTP(nik, nama, tempatLahir, tanggalLahir, jenisKelamin, golDarah, alamat, rt, rw, kelDesa, kecamatan,
                                agama, statusPerkawinan, pekerjaan, kewarganegaraan, wargaNegaraAsal, photoFile,
                                signatureFile, berlakuHingga, kotaPembuatan, tanggalPembuatan);
        
        if (actionValue == 1) {
            
        Toolkit toolkit = Toolkit.getDefaultToolkit(); // INIT TOOLKIT
        Dimension screenSize = toolkit.getScreenSize(); // GET MY SCREEN SIZE

        int screenWidth = screenSize.width; // GET PIXELS FOR WIDTH
        int screenHeight = screenSize.height; // GET PIXELS FOR HEIGHT

        final int FRAME_WIDTH = 1200; // SET WIDTH
        final int FRAME_HEIGHT = 800; // SET WEIGHT

        int start_x = screenWidth / 2 - (FRAME_WIDTH / 2); // SET START LOCATION FOR X
        int start_y = screenHeight / 2 - (FRAME_HEIGHT / 2); // SET START LOCATION FOR Y

        JFrame displayKTP = new JFrame("Form Input Data Penduduk"); // CREATE FRAME AND SET TITLE

        displayKTP.setBounds(start_x, start_y, FRAME_WIDTH, FRAME_HEIGHT); // SET FRAME BOUND

        displayKTP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        displayKTP.setLayout(null);

        

        displayKTP.setVisible(true);






        

        }
        else {

          System.out.println("Update");

        }

        return ktp;

    }

}


