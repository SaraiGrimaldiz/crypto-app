package ui.cesar;

import javax.swing.*;
import java.awt.*;
import logic.cesar.CesarCipher;

public class CesarClaveView extends JFrame {
    public CesarClaveView() {
        setTitle("Cifrado con Clave");
        setSize(400, 300);
        setLayout(new GridLayout(6, 1, 5, 5));
        setLocationRelativeTo(null);

        JTextField txtEntrada = new JTextField();
        JTextField txtClave = new JTextField();
        JButton btnCifrar = new JButton("Cifrar con Clave");
        JTextField txtResultado = new JTextField();
        txtResultado.setEditable(false);

        btnCifrar.addActionListener(e -> {
            txtResultado.setText(CesarCipher.cifrarConClave(txtEntrada.getText(), txtClave.getText()));
        });

        add(new JLabel(" Texto a cifrar:")); add(txtEntrada);
        add(new JLabel(" Clave (ej: HOLA):")); add(txtClave);
        add(btnCifrar); add(txtResultado);
        setVisible(true);
    }
}