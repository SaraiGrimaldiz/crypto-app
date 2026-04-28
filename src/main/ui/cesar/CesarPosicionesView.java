package ui.cesar;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import logic.cesar.CesarCipher;

public class CesarPosicionesView extends JFrame {
    private final Color azulBoton = new Color(52, 152, 219);
    private final Color azulOscuro = new Color(44, 62, 80);

    public CesarPosicionesView() {
        setTitle("Cifrado por Posiciones Personalizadas");
        setSize(400, 420);
        setLocationRelativeTo(null);
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(new Color(245, 247, 250));
        mainPanel.setBorder(new EmptyBorder(30, 40, 30, 40));
        setContentPane(mainPanel);

        JLabel lblTitulo = new JLabel("Cifrado Variable");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblTitulo.setForeground(azulOscuro);
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(lblTitulo);
        mainPanel.add(Box.createVerticalStrut(20));

        // Texto
        mainPanel.add(new JLabel("Texto:") {{ setAlignmentX(CENTER_ALIGNMENT); }});
        JTextField txtEntrada = new JTextField();
        txtEntrada.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));
        mainPanel.add(txtEntrada);
        mainPanel.add(Box.createVerticalStrut(15));

        // Posición n
        mainPanel.add(new JLabel("Posición de inicio (n):") {{ setAlignmentX(CENTER_ALIGNMENT); }});
        JTextField txtN = new JTextField();
        txtN.setMaximumSize(new Dimension(80, 35)); // Campo más pequeño para el número
        txtN.setHorizontalAlignment(JTextField.CENTER);
        mainPanel.add(txtN);
        mainPanel.add(Box.createVerticalStrut(20));

        // Botón
        JButton btnCifrar = new JButton("Ejecutar Cifrado");
        btnCifrar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnCifrar.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnCifrar.setForeground(Color.WHITE);
        btnCifrar.setBackground(azulBoton);
        btnCifrar.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));
        mainPanel.add(btnCifrar);
        mainPanel.add(Box.createVerticalStrut(25));

        // Resultado
        JTextField txtResultado = new JTextField();
        txtResultado.setEditable(false);
        txtResultado.setHorizontalAlignment(JTextField.CENTER);
        txtResultado.setFont(new Font("Monospaced", Font.BOLD, 16));
        mainPanel.add(txtResultado);

        btnCifrar.addActionListener(e -> {
            try {
                int n = Integer.parseInt(txtN.getText());
                txtResultado.setText(CesarCipher.cifrarPorPosicion(txtEntrada.getText(), n));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor ingrese un número válido.");
            }
        });

        setVisible(true);
    }
}