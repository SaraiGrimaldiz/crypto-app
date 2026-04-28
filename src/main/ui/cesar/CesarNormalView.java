package ui.cesar;

import javax.swing.*;
import java.awt.*;
import logic.cesar.CesarCipher;

public class CesarNormalView extends JFrame {
    public CesarNormalView() {
        setTitle("Cifrado César Normal (n=3)");
        setSize(400, 250);
        setLayout(new GridLayout(4, 1, 10, 10));
        setLocationRelativeTo(null);

        JTextField txtEntrada = new JTextField();
        JButton btnCifrar = new JButton("Cifrar (Desplazamiento 3)");
        JTextField txtResultado = new JTextField();
        txtResultado.setEditable(false);

        btnCifrar.addActionListener(e -> {
            txtResultado.setText(CesarCipher.cifrarNormal(txtEntrada.getText()));
        });

        add(new JLabel(" Texto a cifrar:")); add(txtEntrada);
        add(btnCifrar); add(txtResultado);
        setVisible(true);
    }
}