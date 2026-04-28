package ui;

import javax.swing.*;
import java.awt.*;
// IMPORTANTE: Estos imports conectan el menú con tus archivos en la carpeta ui/cesar
import ui.cesar.CesarNormalView;
import ui.cesar.CesarPosicionesView;
import ui.cesar.CesarClaveView;

public class MainMenu extends JFrame {

    public MainMenu() {
        setTitle("Proyecto Criptografía - Sarai Grimaldiz");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(20, 20));

        // --- TÍTULO (NORTE) ---
        JLabel lblTitulo = new JLabel("<html><div style='text-align: center;'>Segundo Parcial<br>Criptografía</div></html>", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        add(lblTitulo, BorderLayout.NORTH);

        // --- BOTONES (OESTE) ---
        JPanel pnlBotones = new JPanel(new GridLayout(5, 1, 10, 10));
        pnlBotones.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 0));
        
        JButton btnCesar = new JButton("Cesar");
        JButton btnPigPen = new JButton("Pig Pen");
        JButton btnRailFence = new JButton("Rail Fence");
        JButton btnVigenere = new JButton("Vigenere");
        JButton btnAes = new JButton("AES");

        pnlBotones.add(btnCesar);
        pnlBotones.add(btnPigPen);
        pnlBotones.add(btnRailFence);
        pnlBotones.add(btnVigenere);
        pnlBotones.add(btnAes);
        add(pnlBotones, BorderLayout.WEST);

        // --- INTEGRANTES (ESTE) ---
        JPanel pnlIntegrantes = new JPanel(new GridLayout(6, 1));
        pnlIntegrantes.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 40));
        pnlIntegrantes.add(new JLabel("Integrantes:"));
        pnlIntegrantes.add(new JLabel("• Sarai Grimaldiz"));
        pnlIntegrantes.add(new JLabel("• Jose Clemente"));
        pnlIntegrantes.add(new JLabel("• Luis Fernandez"));
        pnlIntegrantes.add(new JLabel("• Silverio Pacheco"));
        pnlIntegrantes.add(new JLabel("• Marcela Quinteros"));
        add(pnlIntegrantes, BorderLayout.EAST);

        // --- LÓGICA PARA CÉSAR ---
        btnCesar.addActionListener(e -> {
            abrirOpcionesCesar();
        });

        setVisible(true);
    }

    private void abrirOpcionesCesar() {
        String[] opciones = {"Normal", "Por Posiciones", "Con Clave"};
        int seleccion = JOptionPane.showOptionDialog(this, 
                "Seleccione el tipo de Cifrado César", 
                "Opciones César", 
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.QUESTION_MESSAGE, 
                null, opciones, opciones[0]);

        if (seleccion == 0) { 
            new CesarNormalView(); 
        }
        else if (seleccion == 1) { 
            new CesarPosicionesView(); 
        }
        else if (seleccion == 2) { 
            new CesarClaveView(); 
        }
    }
}