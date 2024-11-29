// package View;

// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import java.util.Properties;
// import javax.swing.JButton;
// import javax.swing.JFrame;
// import javax.swing.JLabel;
// import javax.swing.JTextField;
// import org.jdatepicker.impl.JDatePanelImpl;
// import org.jdatepicker.impl.JDatePickerImpl;
// import org.jdatepicker.impl.UtilDateModel;
// import org.jdatepicker.impl.DateComponentFormatter;

// public class Lat {
//     public static void main(String[] args) {
//         // ===== CONTAINER 
//         JFrame form = new JFrame("Latihan");
//         form.setSize(400, 600);
//         form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         form.setLocationRelativeTo(null);
//         form.setLayout(null);

//         // ===== COMPONENT
//         JLabel labelJudul = new JLabel("Latihan Komponen");
//         labelJudul.setBounds(140, 30, 150, 30);
//         form.add(labelJudul);

//         JLabel namaBuku = new JLabel("Nama Buku");
//         namaBuku.setBounds(20, 80, 150, 30);
//         form.add(namaBuku);

//         JTextField textFieldkodeBuku = new JTextField();
//         textFieldkodeBuku.setBounds(120, 80, 150, 30); // Perbaikan posisi
//         form.add(textFieldkodeBuku);

//         JLabel tanggalLahir = new JLabel("Tanggal Lahir");
//         tanggalLahir.setBounds(20, 140, 100, 20);
//         form.add(tanggalLahir);

//         // Konfigurasi JDatePicker
//         UtilDateModel model = new UtilDateModel();
//         Properties p = new Properties();
//         p.put("text.today", "Today");
//         p.put("text.month", "Month");
//         p.put("text.year", "Year");
//         JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
//         JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateComponentFormatter());

//         datePicker.setBounds(120, 140, 150, 30);
//         form.add(datePicker);

//         JButton submitButton = new JButton("SUBMIT");
//         submitButton.setBounds(20, 200, 200, 30);
//         form.add(submitButton);

//         // ActionListener untuk tombol SUBMIT
//         submitButton.addActionListener(new ActionListener() {
//             public void actionPerformed(ActionEvent e) {
//                 String nama = textFieldkodeBuku.getText();
//                 java.util.Date tanggal = (java.util.Date) datePicker.getModel().getValue();

//                 if (tanggal != null) {
//                     System.out.println("Nama Buku: " + nama);
//                     System.out.println("Tanggal Lahir: " + tanggal.toString());
//                 } else {
//                     System.out.println("Harap pilih tanggal lahir!");
//                 }
//             }
//         });

//         form.setVisible(true); // Menampilkan form
//     }
// }
