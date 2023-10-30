/*
 * Ini adalah kelas Java untuk membuat formulir Biodata diri dengan GUI Swing.
 * Kode ini digunakan untuk membuat tampilan form dan mengumpulkan informasi biodata dari pengguna.
 * Pengguna dapat memasukkan nama, nomor HP, memilih jenis kelamin, dan mengindikasikan apakah mereka adalah Warga Negara Asing.
 * Hasil input akan ditampilkan di JTextArea.
 * Kode ini adalah bagian dari pertemuan 5.
 */

package pertemuan5;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BiodataDiri extends JFrame {
   
    private boolean checkBoxSelected;
    
    public BiodataDiri() {
        // Inisialisasi variabel checkBoxSelected
        this.checkBoxSelected = false;
        
        // Pengaturan jendela
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Label judul formulir
        JLabel headerLabel = new JLabel("Form Biodata", JLabel.CENTER);
        
        // Panel kontrol
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        
        // Panel utama
        JPanel panel = new JPanel();
        panel.setSize(800, 800);
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();
        
        // Komponen-komponen formulir: Nama, Nomor HP, Jenis Kelamin, WNA, Tombol Simpan
        JLabel labelInputNama = new JLabel("Nama:");
        JTextField textFieldNama = new JTextField();
        JLabel labelInputNotelp = new JLabel("Nomor HP:");
        JTextField textFieldNotelp = new JTextField();
        JLabel labelJenisKelamin = new JLabel("Jenis Kelamin:");
        JRadioButton radioButtonL = new JRadioButton("Laki-Laki", true);
        JRadioButton radioButtonP = new JRadioButton("Perempuan");
        JCheckBox checkBox = new JCheckBox("Warga Negara Asing");
        JButton button = new JButton("Simpan");
        JTextArea txtOutput = new JTextArea("");

        // Konfigurasi GridBagLayout untuk meletakkan komponen-komponen
        // ...

        // Grupkan RadioButton agar hanya bisa memilih satu
        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButtonL);
        bg.add(radioButtonP);

        // Menambahkan listener ke CheckBox untuk mengatur variabel checkBoxSelected
        checkBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                checkBoxSelected = e.getStateChange() == 1;
            }
        });

        // Menambahkan aksi ke Tombol Simpan
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Mengambil input pengguna dan menampilkan hasil di JTextArea
                String nama = textFieldNama.getText();
                String noTelp = textFieldNotelp.getText();
                String jenisKelamin = "";
                String WNA = "";

                if (radioButtonL.isSelected()) {
                    jenisKelamin = radioButtonL.getText();
                }
                if (radioButtonP.isSelected()) {
                    jenisKelamin = radioButtonP.getText();
                }

                if (checkBoxSelected) {
                    WNA = "Ya";
                } else {
                    WNA = "Tidak";
                }

                txtOutput.append("Nama  :" + nama + "\n" +
                        "Nomor HP   :" + noTelp + "\n" +
                        "Jenis Kelamin  :" + jenisKelamin + "\n" +
                        "WNA    :" + WNA + "\n" + "Wildan Nasrulloh Reliyanto - 213040140");

                textFieldNama.setText("");
                textFieldNotelp.setText("");
            }
        });

        // Mengatur tata letak komponen di jendela
        controlPanel.add(panel);
        this.setSize(800, 800);
        this.setLayout(new GridLayout(6, 2));
        this.add(headerLabel);
        this.add(controlPanel);
        this.add(txtOutput);
    }
    
    public static void main(String[] args) {
        // Memulai aplikasi Swing
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Membuat objek BiodataDiri dan menampilkannya
                BiodataDiri b = new BiodataDiri();
                b.setVisible(true);
            }
        });
    }
}
