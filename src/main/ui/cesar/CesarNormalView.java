package ui.cesar;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import logic.cesar.CesarCipher;

public class CesarNormalView extends JFrame {
    private final Color azulBoton = new Color(52, 152, 219);
    private final Color azulOscuro = new Color(44, 62, 80);

    public CesarNormalView() {
        setTitle("Cifrado César Estándar (n=3)");
        setSize(400, 380);
        setLocationRelativeTo(null);
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(new Color(245, 247, 250));
        mainPanel.setBorder(new EmptyBorder(30, 40, 30, 40));
        setContentPane(mainPanel);

        JLabel lblTitulo = new JLabel("Cifrado Normal");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblTitulo.setForeground(azulOscuro);
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(lblTitulo);
        mainPanel.add(Box.createVerticalStrut(20));

        // Entrada
        JLabel lblIn = new JLabel("Texto a cifrar:");
        lblIn.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(lblIn);
        
        JTextField txtEntrada = new JTextField();
        txtEntrada.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));
        mainPanel.add(txtEntrada);
        mainPanel.add(Box.createVerticalStrut(20));

        // Botón
        JButton btnCifrar = new JButton("Cifrar (Desplazamiento 3)");
        btnCifrar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnCifrar.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnCifrar.setForeground(Color.WHITE);
        btnCifrar.setBackground(azulBoton);
        btnCifrar.setFocusPainted(false);
        btnCifrar.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        mainPanel.add(btnCifrar);
        mainPanel.add(Box.createVerticalStrut(25));

        // Resultado
        JTextField txtResultado = new JTextField();
        txtResultado.setEditable(false);
        txtResultado.setHorizontalAlignment(JTextField.CENTER);
        txtResultado.setFont(new Font("Monospaced", Font.BOLD, 16));
        mainPanel.add(txtResultado);

        btnCifrar.addActionListener(e -> {
            txtResultado.setText(CesarCipher.cifrarNormal(txtEntrada.getText()));
        });

        setVisible(true);
    }
}