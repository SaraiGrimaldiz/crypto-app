package ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import ui.cesar.CesarNormalView;
import ui.cesar.CesarPosicionesView;
import ui.cesar.CesarClaveView;

public class MainMenu extends JFrame {

    // Definimos una paleta de colores moderna
    private final Color colorFondo = new Color(240, 244, 248);
    private final Color azulOscuro = new Color(44, 62, 80);
    private final Color azulBoton = new Color(52, 152, 219);

    public MainMenu() {
        setTitle("Sistema de Criptografía - Sarai Grimaldiz");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Panel Principal con margen
        JPanel panelPrincipal = new JPanel(new BorderLayout(30, 30));
        panelPrincipal.setBackground(colorFondo);
        panelPrincipal.setBorder(new EmptyBorder(25, 25, 25, 25));
        setContentPane(panelPrincipal);

        // --- TÍTULO ---
        JLabel lblTitulo = new JLabel("<html><div style='text-align: center;'>SEGUNDO PARCIAL<br><span style='font-size:14pt; color:#34495e;'>Laboratorio de Criptografía</span></div></html>", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 28));
        lblTitulo.setForeground(azulOscuro);
        panelPrincipal.add(lblTitulo, BorderLayout.NORTH);

        // --- PANEL CENTRAL (BOTONES) ---
        JPanel pnlBotones = new JPanel(new GridLayout(5, 1, 15, 15));
        pnlBotones.setOpaque(false);
        
        JButton btnCesar = crearBotonEstilizado("Algoritmo César");
        JButton btnPigPen = crearBotonEstilizado("Cifrado Pig Pen");
        JButton btnRailFence = crearBotonEstilizado("Cifrado Rail Fence");
        JButton btnVigenere = crearBotonEstilizado("Algoritmo Vigenere");
        JButton btnAes = crearBotonEstilizado("Estándar AES");

        pnlBotones.add(btnCesar);
        pnlBotones.add(btnPigPen);
        pnlBotones.add(btnRailFence);
        pnlBotones.add(btnVigenere);
        pnlBotones.add(btnAes);
        panelPrincipal.add(pnlBotones, BorderLayout.CENTER);

        // --- PANEL LATERAL (INTEGRANTES) ---
        JPanel pnlIntegrantes = new JPanel();
        pnlIntegrantes.setLayout(new BoxLayout(pnlIntegrantes, BoxLayout.Y_AXIS));
        pnlIntegrantes.setBackground(Color.WHITE);
        pnlIntegrantes.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
            new EmptyBorder(20, 20, 20, 20)
        ));

        pnlIntegrantes.add(crearLabelIntegrante("INTEGRANTES", true));
        pnlIntegrantes.add(Box.createVerticalStrut(10));
        pnlIntegrantes.add(crearLabelIntegrante("• Sarai Grimaldiz", false));
        pnlIntegrantes.add(crearLabelIntegrante("• Jose Clemente", false));
        pnlIntegrantes.add(crearLabelIntegrante("• Luis Fernandez", false));
        pnlIntegrantes.add(crearLabelIntegrante("• Silverio Pacheco", false));
        pnlIntegrantes.add(crearLabelIntegrante("• Marcela Quinteros", false));
        
        panelPrincipal.add(pnlIntegrantes, BorderLayout.EAST);

        // --- LÓGICA ---
        btnCesar.addActionListener(e -> abrirOpcionesCesar());

        setVisible(true);
    }

    private JButton crearBotonEstilizado(String texto) {
        JButton btn = new JButton(texto);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btn.setForeground(Color.WHITE);
        btn.setBackground(azulBoton);
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        // Efecto Hover simple
        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn.setBackground(azulOscuro);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn.setBackground(azulBoton);
            }
        });
        return btn;
    }

    private JLabel crearLabelIntegrante(String texto, boolean esTitulo) {
        JLabel label = new JLabel(texto);
        if (esTitulo) {
            label.setFont(new Font("Segoe UI", Font.BOLD, 14));
            label.setForeground(azulOscuro);
        } else {
            label.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            label.setForeground(new Color(100, 100, 100));
        }
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        return label;
    }

    private void abrirOpcionesCesar() {
        UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.PLAIN, 14));
        UIManager.put("OptionPane.buttonFont", new Font("Segoe UI", Font.BOLD, 12));
        
        String[] opciones = {"Normal", "Por Posiciones", "Con Clave"};
        int seleccion = JOptionPane.showOptionDialog(this, 
                "Seleccione la modalidad del cifrado César", 
                "Configuración César", 
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.INFORMATION_MESSAGE, 
                null, opciones, opciones[0]);

        if (seleccion == 0) new CesarNormalView();
        else if (seleccion == 1) new CesarPosicionesView();
        else if (seleccion == 2) new CesarClaveView();
    }
}