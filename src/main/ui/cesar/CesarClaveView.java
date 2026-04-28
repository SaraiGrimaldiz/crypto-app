package ui.cesar;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import logic.cesar.CesarCipher;

public class CesarClaveView extends JFrame {
    // Paleta de colores que combina con tu MainMenu
    private final Color azulBoton = new Color(52, 152, 219);
    private final Color azulOscuro = new Color(44, 62, 80);
    private final Color fondoGris = new Color(245, 247, 250);

    public CesarClaveView() {
        setTitle("Cifrado César con Clave");
        setSize(450, 450);
        setLocationRelativeTo(null);
        
        // Panel Principal con "aire" (padding)
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(fondoGris);
        mainPanel.setBorder(new EmptyBorder(30, 40, 30, 40));
        setContentPane(mainPanel);

        // --- TÍTULO DE VENTANA ---
        JLabel lblTitulo = new JLabel("Configuración de Cifrado");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblTitulo.setForeground(azulOscuro);
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(lblTitulo);
        mainPanel.add(Box.createVerticalStrut(25));

        // --- CAMPOS DE ENTRADA ---
        JTextField txtEntrada = crearCampoEstilizado("Texto a cifrar:");
        mainPanel.add(txtEntrada);
        mainPanel.add(Box.createVerticalStrut(15));

        JTextField txtClave = crearCampoEstilizado("Clave (Palabra Secreta):");
        mainPanel.add(txtClave);
        mainPanel.add(Box.createVerticalStrut(25));

        // --- BOTÓN CENTRADO Y BONITO ---
        JButton btnCifrar = new JButton("Ejecutar Cifrado");
        btnCifrar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnCifrar.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnCifrar.setForeground(Color.WHITE);
        btnCifrar.setBackground(azulBoton);
        btnCifrar.setFocusPainted(false);
        btnCifrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnCifrar.setBorder(BorderFactory.createEmptyBorder(12, 30, 12, 30));
        
        mainPanel.add(btnCifrar);
        mainPanel.add(Box.createVerticalStrut(25));

        // --- RESULTADO ---
        JLabel lblRes = new JLabel("Resultado:");
        lblRes.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lblRes.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(lblRes);
        
        JTextField txtResultado = new JTextField();
        txtResultado.setEditable(false);
        txtResultado.setHorizontalAlignment(JTextField.CENTER);
        txtResultado.setFont(new Font("Monospaced", Font.BOLD, 16));
        txtResultado.setBackground(Color.WHITE);
        txtResultado.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        mainPanel.add(txtResultado);

        // Lógica del botón
        btnCifrar.addActionListener(e -> {
            String res = CesarCipher.cifrarConClave(txtEntrada.getText(), txtClave.getText());
            txtResultado.setText(res);
        });

        setVisible(true);
    }

    // Método auxiliar para crear etiquetas y campos ordenados
    private JTextField crearCampoEstilizado(String etiqueta) {
        JLabel label = new JLabel(etiqueta);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        getContentPane().add(label);
        getContentPane().add(Box.createVerticalStrut(5));
        
        JTextField field = new JTextField();
        field.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));
        field.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(210, 210, 210)),
            BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        return field;
    }
}