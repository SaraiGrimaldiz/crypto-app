package ui.cesar;

import javax.swing.*;
import java.awt.*;
import logic.cesar.CesarCipher;

public class CesarPosicionesView extends JFrame {
    public CesarPosicionesView() {
        setTitle("Cifrado por Posiciones");
        setSize(400, 300);
        setLayout(new GridLayout(6, 1, 5, 5));
        setLocationRelativeTo(null);

        JTextField txtEntrada = new JTextField();
        JTextField txtN = new JTextField("3");
        JButton btnCifrar = new JButton("Cifrar");
        JTextField txtResultado = new JTextField();
        txtResultado.setEditable(false);

        btnCifrar.addActionListener(e -> {
            try {
                int n = Integer.parseInt(txtN.getText());
                txtResultado.setText(CesarCipher.cifrarPorPosicion(txtEntrada.getText(), n));
            } catch(Exception ex) {
                JOptionPane.showMessageDialog(this, "Pon un número válido");
            }
        });

        add(new JLabel(" Texto:")); add(txtEntrada);
        add(new JLabel(" Posición de inicio (n):")); add(txtN);
        add(btnCifrar); add(txtResultado);
        setVisible(true);
    }
}