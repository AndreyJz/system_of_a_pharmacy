package com.farmacy;

import com.farmacy.country.aplication.FindCountriesUC;
import com.farmacy.country.aplication.FindCountryByIdUC;
import com.farmacy.country.aplication.SaveCountryUC;
import com.farmacy.country.aplication.UpdateCountryUC;
import com.farmacy.country.domain.service.CountryService;
import com.farmacy.country.infrastructure.CountryRepository;
import com.farmacy.country.infrastructure.CountryUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {
    private JButton opcion1Button, opcion2Button, opcion3Button,opcion4Button,opcion5Button, salirButton;

    public Main() {
        // Configuración del JFrame principal
        setTitle("Menú Personalizado");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana en la pantalla

        // Crear panel principal y establecer layout
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 10, 10)); // 4 filas, 1 columna

        // Crear botones para las opciones del menú
        opcion1Button = new JButton("Opción 1");
        opcion1Button.addActionListener(this);
        panel.add(opcion1Button);

        opcion2Button = new JButton("Opción 2");
        opcion2Button.addActionListener(this);
        panel.add(opcion2Button);

        opcion3Button = new JButton("Opción 3");
        opcion3Button.addActionListener(this);
        panel.add(opcion3Button);

        opcion4Button = new JButton("Opción 4");
        opcion4Button.addActionListener(this);
        panel.add(opcion4Button);

        opcion5Button = new JButton("Opción 5");
        opcion5Button.addActionListener(this);
        panel.add(opcion5Button);

        salirButton = new JButton("Salir");
        salirButton.addActionListener(this);
        panel.add(salirButton);

        // Agregar el panel al JFrame
        add(panel);

        // Mostrar el JFrame
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == opcion1Button) {
            CountryService cs = new CountryRepository();
            SaveCountryUC scuc = new SaveCountryUC(cs);
            CountryUI uiCountry = new CountryUI(scuc);
            uiCountry.CreateCountry();
        } else if (e.getSource() == opcion2Button) {
            CountryService cs = new CountryRepository();
            FindCountriesUC fcsuc = new FindCountriesUC(cs);
            CountryUI uiCountry = new CountryUI(fcsuc);
            uiCountry.ListCountries();
        } else if (e.getSource() == opcion3Button) {
            CountryService cs = new CountryRepository();
            FindCountryByIdUC fcuc = new FindCountryByIdUC(cs);
            CountryUI uiCountry = new CountryUI(fcuc);
            uiCountry.FindCountryByID();
        } else if (e.getSource() == opcion4Button) {
            CountryService cs = new CountryRepository();
            FindCountriesUC fcsuc = new FindCountriesUC(cs);
            UpdateCountryUC ucuc = new UpdateCountryUC(cs);
            CountryUI uiCountry = new CountryUI(ucuc,fcsuc);
            uiCountry.UpdateCountry();

        } else if (e.getSource() == opcion5Button) {
            CountryService cs = new CountryRepository();
            FindCountryByIdUC fcuc = new FindCountryByIdUC(cs);
            CountryUI uiCountry = new CountryUI(fcuc);
            uiCountry.FindCountryByID();
        } else if (e.getSource() == salirButton) {
            JOptionPane.showMessageDialog(this, "Saliendo del programa...");
            System.exit(0); // Salir del programa al presionar Salir
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Main();
            }
        });
    }
}

