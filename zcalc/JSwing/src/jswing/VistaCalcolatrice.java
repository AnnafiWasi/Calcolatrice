/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jswing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author PC
 */

public class VistaCalcolatrice {
    private JFrame frame;
    private JTextField textField;
    private LogicaCalcolatrice logica;

    public VistaCalcolatrice() {
        logica = new LogicaCalcolatrice();
    }

    public void creaGUI() {
        frame = new JFrame("Calcolatrice");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 450);
        frame.setLayout(new BorderLayout());
        frame.setResizable(false);
        Image icon = new ImageIcon(this.getClass().getResource("/Wasi.jpg")).getImage();
        frame.setIconImage(icon);
        textField = new JTextField();
        textField.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 24));
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setBackground(Color.white);
        textField.setForeground(Color.red);
        textField.setEditable(false);
        frame.add(textField, BorderLayout.NORTH);
        JPanel pannelloBottoni = new JPanel();
        pannelloBottoni.setLayout(new GridLayout(5, 4, 7, 5));
        String[] bottoni = {
            "C","n^x", "x√n", "%",
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            ".", "0", "=", "+"
        };
        for (int i = 0; i < bottoni.length; i++) {
            JButton bottone = new JButton(bottoni[i]);
            bottone.setFont(new Font("Serif", Font.PLAIN, 20));
            bottone.setBackground(Color.black);
            bottone.setForeground(Color.white);
            bottone.setFocusable(false);
            pannelloBottoni.add(bottone);
            bottone.addActionListener(new BottoneListener());
        }
        frame.add(pannelloBottoni, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private class BottoneListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String input = ((JButton) e.getSource()).getText();
            String risultato = logica.gestisciInput(input, textField.getText());
            textField.setText(risultato);
        }
    }
}
