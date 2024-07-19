package com.farmacy.country.infrastructure;

import java.awt.Image;
import java.awt.PopupMenu;
import java.util.Hashtable;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import com.farmacy.country.aplication.FindCountriesUC;
import com.farmacy.country.aplication.FindCountryByIdUC;
import com.farmacy.country.aplication.SaveCountryUC;
import com.farmacy.country.aplication.UpdateCountryUC;
import com.farmacy.country.domain.entity.Country;

public class CountryUI {
    private SaveCountryUC createCountryUC;
    private UpdateCountryUC updateCountryUC;
    private FindCountryByIdUC findCountryByIdUC;
    private FindCountriesUC findCountriesUC;
    private int idUser;

    public CountryUI(SaveCountryUC createCountryUC) {
        this.createCountryUC = createCountryUC;
    }

    public CountryUI(FindCountryByIdUC findCountryByIdUC) {
        this.findCountryByIdUC = findCountryByIdUC;
    }

    public CountryUI(FindCountriesUC findCountriesUC) {
        this.findCountriesUC = findCountriesUC;
    }  

    public CountryUI(UpdateCountryUC updateCountryUC) {
        this.updateCountryUC = updateCountryUC;
    }

    public CountryUI(UpdateCountryUC ucuc, FindCountriesUC fcsuc) {
        this.updateCountryUC = ucuc;
        this.findCountriesUC = fcsuc;
    }

    public void CreateCountry() {
        JFrame myFrame = new JFrame();

        // Configurar el JFrame
        myFrame.setTitle("Interfaz de Usuario");
        myFrame.setSize(400, 300);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLocationRelativeTo(null);

        // Crear componentes
        JLabel imageLabel = new JLabel();
        JTextField textField = new JTextField(20);
        JButton sendButton = new JButton("Enviar");

        // Configurar el JLabel para la imagen
        imageLabel.setIcon(resizeImage("/images/45069.png", 100, 100)); // Ajusta la URL y el tamaño de la imagen

        // Configurar el JButton
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Acción al hacer clic en el botón
                Country country = new Country();
                country.setName(textField.getText());
                createCountryUC.execute(country);
                myFrame.dispose();
                JOptionPane.showMessageDialog(null, "Country has been added!", null, JOptionPane.PLAIN_MESSAGE);
            }
        });

        // Crear un panel y añadir los componentes
        JPanel panel = new JPanel();
        panel.add(imageLabel);
        panel.add(textField);
        panel.add(sendButton);

        // Añadir el panel al JFrame
        myFrame.add(panel);

        // Hacer visible el JFrame
        myFrame.setVisible(true);
    }

    public void UpdateCountry() {
        JFrame myFrame = new JFrame();

        // Configurar el JFrame
        myFrame.setTitle("Interfaz de Usuario");
        myFrame.setSize(400, 300);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLocationRelativeTo(null);

        JPanel myPanel = new JPanel();

        List<Country> countries =  findCountriesUC.execute();

        JComboBox<String> myComboBox = new JComboBox<>();
        for (Country country : countries) {
            myComboBox.addItem(country.getName());
        }
        
        // countries.forEach(c -> myComboBox.add(c.getName(), myComboBox));

        myPanel.add(myComboBox);
        myFrame.add(myPanel);

        myFrame.setVisible(true);
    }

    public Optional<Country> FindCountryByID() {
        idUser = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el ID del Usuario: "));
        Optional<Country> country = findCountryByIdUC.execute(idUser);
        if (country.isPresent()) {
            JOptionPane.showMessageDialog(null, "País encontrado:\nID: " + country.get().getId() + "\nNombre: " + country.get().getName(),
                    "Información del País", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "País no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return country;
    }

    public List<Country> ListCountries() {
        List<Country> countries =  findCountriesUC.execute();
        showCountriesTable(countries);
        return countries;
    }

    public static void showCountriesTable(List<Country> countries) {
        String[] columns = {"ID", "Name"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        countries.forEach(country -> {
            Object[] row = {country.getId(), country.getName()};
            model.addRow(row);
        });

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);

        JOptionPane.showMessageDialog(null, panel, "Teams List", JOptionPane.PLAIN_MESSAGE);
    }

    private ImageIcon resizeImage(String imagePath, int width, int height) {
        // Leer la imagen desde la URL
        // URL url = new URL(imagePath);
        // Image img = ImageIO.read(url);
        java.net.URL imgURL = getClass().getResource(imagePath);
        ImageIcon icon = new ImageIcon(imgURL);
        Image img = icon.getImage();
        // Redimensionar la imagen
        Image imgScaled = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        // Crear y devolver el ImageIcon redimensionado
        return new ImageIcon(imgScaled);
    }
}
