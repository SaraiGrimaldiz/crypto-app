package ui.cesar;

import javax.swing.*;
import java.awt.*;

public class CesarView extends JFrame {

    public CesarView() {
        setTitle("Cifrado César");
        setSize(300, 300);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 1));

        JButton normal = new JButton("Cifrado Normal");
        JButton posiciones = new JButton("Por Posiciones");
        JButton clave = new JButton("Por Clave");

        add(normal);
        add(posiciones);
        add(clave);

        normal.addActionListener(e -> new CesarNormalView());
        posiciones.addActionListener(e -> new CesarPosicionesView());
        clave.addActionListener(e -> new CesarClaveView());

        setVisible(true);
    }
}