/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pertemuan5;

/**
 *
 * @author Daffa
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Latihan3 extends JFrame{
   
    private boolean checkBoxSelected;
    
    public Latihan3(){
        this.checkBoxSelected = false;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel headerLabel = new JLabel("Form Biodata", JLabel.CENTER);
        
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        
        JPanel panel = new JPanel();
        panel.setSize(800,800);
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();
        
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

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(labelInputNama, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(textFieldNama, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(labelInputNotelp, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(textFieldNotelp, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(labelJenisKelamin, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(radioButtonL, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(radioButtonP, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(checkBox, gbc);

        gbc.fill = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        panel.add(button, gbc);

        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButtonL);
        bg.add(radioButtonP);

        checkBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                checkBoxSelected = e.getStateChange() == 1;
            }
        });

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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
                        "WNA    :" + WNA + "\n" + "Daffa Gimnastiar Kurnia Irawan 213040135");

                textFieldNama.setText("");
                textFieldNotelp.setText("");
            }
        });

        controlPanel.add(panel);
        this.setSize(800, 800);
        this.setLayout(new GridLayout(6, 2));
        this.add(headerLabel);
        this.add(controlPanel);
        this.add(txtOutput);
    }
    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                Latihan3 b = new Latihan3();
                b.setVisible(true);
            }
        
        });
    
    
    
    
    }
}
