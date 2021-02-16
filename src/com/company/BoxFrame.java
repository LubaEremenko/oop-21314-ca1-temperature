package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class BoxFrame extends JFrame {
    private final JComboBox<String> imagesJComboBox;
    private final JLabel label;

    private static final String[] names = {"celciud.jpg", "fahrenheit.jpg"};

    private final Icon[] icons = {
      new ImageIcon(getClass().getResource(names[0])),
      new ImageIcon(getClass().getResource(names[1]))
    };

    public BoxFrame () {
        super("Converter temperature");
        setLayout(new FlowLayout());
        imagesJComboBox = new JComboBox<String>(names);
        imagesJComboBox.setMaximumRowCount(2);

        add(imagesJComboBox);
        imagesJComboBox.addItemListener(
                new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        if (e.getStateChange() == ItemEvent.SELECTED ) {
                            label.setIcon(icons[imagesJComboBox.getSelectedIndex()]);
                        }
                    }
                }
        );

        label = new JLabel(icons[0]);
        add(label);

    }

}
