package com.farmacy.city.infrastructure;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.List;
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

import com.farmacy.city.aplication.CreateCityUC;
import com.farmacy.city.aplication.DeleteCityUC;
import com.farmacy.city.aplication.FindCitiesUC;
import com.farmacy.city.aplication.FindCityByIdUC;
import com.farmacy.city.aplication.FindCityByNameUC;
import com.farmacy.city.aplication.UpdateCityUC;
import com.farmacy.city.domain.entity.City;
import com.farmacy.country.aplication.FindCountriesUC;
import com.farmacy.country.aplication.FindCountryByNameUc;
import com.farmacy.country.domain.entity.Country;

public class CityUI {
    private CreateCityUC createCityUC;
    private FindCountriesUC findCountriesUC;
    private FindCountryByNameUc findCountryByNameUc;
    private FindCitiesUC findCitiesUC;
    private FindCityByIdUC findCityByIdUC;
    private FindCityByNameUC findCityByNameUC;
    private UpdateCityUC updateCityUC;
    private DeleteCityUC deleteCityUC;
    private String nameCity;
    private int idCity;

    public CityUI(CreateCityUC createCityUC) {
        this.createCityUC = createCityUC;
    }

    public CityUI(CreateCityUC ccuc, FindCountriesUC fcsuc, FindCountryByNameUc fciduc) {
        this.createCityUC = ccuc;
        this.findCountriesUC = fcsuc;
        this.findCountryByNameUc = fciduc;
    }

    public CityUI(FindCityByIdUC findCityByIdUC) {
        this.findCityByIdUC = findCityByIdUC;
    }

    public CityUI(FindCitiesUC findCitiesUC) {
        this.findCitiesUC = findCitiesUC;
    }

    public CityUI(UpdateCityUC ucuc, FindCitiesUC fcsuc, FindCityByNameUC fcnuc) {
        this.updateCityUC = ucuc;
        this.findCitiesUC = fcsuc;
        this.findCityByNameUC = fcnuc;
    }

    public CityUI(DeleteCityUC dcuc, FindCitiesUC fcsuc, FindCityByNameUC fcnuc) {
        this.deleteCityUC = dcuc;
        this.findCitiesUC = fcsuc;
        this.findCityByNameUC = fcnuc;
    }

    public void createCity() {
        JFrame myFrame = new JFrame();

        // Configurar el JFrame
        myFrame.setTitle("Interfaz de Usuario");
        myFrame.setSize(400, 300);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLocationRelativeTo(null);

        List<Country> countries =  findCountriesUC.execute();

        JComboBox<String> countryField = new JComboBox<>();
        for (Country country : countries) {
            countryField.addItem(country.getName());
        }

        // Crear componentes
        JLabel imageLabel = new JLabel();
        JTextField nameField = new JTextField(20);
        JButton sendButton = new JButton("Enviar");

        // Configurar el JLabel para la imagen
        imageLabel.setIcon(resizeImage("/images/45069.png", 100, 100)); // Ajusta la URL y el tamaño de la imagen

        // Configurar el JButton
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                City city = new City();
                nameCity = (String) countryField.getSelectedItem();
                Optional<Country> country = findCountryByNameUc.execute(nameCity);
                city.setName(nameField.getText());
                city.setIdCountry(country.get().getId());
                createCityUC.execute(city);
                myFrame.dispose();
                JOptionPane.showMessageDialog(null, "City has been added!", null, JOptionPane.PLAIN_MESSAGE);
            }
        });

        // Crear un panel y añadir los componentes
        JPanel panel = new JPanel();
        panel.add(imageLabel);
        panel.add(nameField);
        panel.add(countryField);
        panel.add(sendButton);

        // Añadir el panel al JFrame
        myFrame.add(panel);

        // Hacer visible el JFrame
        myFrame.setVisible(true);
    }

    public void updateCity() {
        JFrame myFrame = new JFrame();

        // Configurar el JFrame
        myFrame.setTitle("Interfaz de Usuario");
        myFrame.setSize(400, 300);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLocationRelativeTo(null);

        JPanel myPanel = new JPanel();
        JButton sendButton = new JButton("Siguiente ->");

        List<City> cities =  findCitiesUC.execute();

        JComboBox<String> myComboBox = new JComboBox<>();
        for (City city : cities) {
            myComboBox.addItem(city.getName());
        }
        
        // countries.forEach(c -> myComboBox.addItem(c.getName()));

        myPanel.add(myComboBox);
        myPanel.add(sendButton);
        myFrame.add(myPanel);

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameCity = (String) myComboBox.getSelectedItem();
                Optional<City> city = findCityByNameUC.execute(nameCity);
                String newName = JOptionPane.showInputDialog(null, "Insert the new name for the city");
                city.get().setName(newName);
                updateCityUC.execute(city.get());
                myFrame.dispose();
                JOptionPane.showMessageDialog(null, "City has been updated!", null, JOptionPane.PLAIN_MESSAGE);
            }
        });

        myFrame.setVisible(true);
    }

    public void deleteCity(){
        JFrame myFrame = new JFrame();

        // Configurar el JFrame
        myFrame.setTitle("Interfaz de Usuario");
        myFrame.setSize(400, 300);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLocationRelativeTo(null);

        JPanel myPanel = new JPanel();
        JButton sendButton = new JButton("Siguiente ->");

        List<City> countries =  findCitiesUC.execute();

        JComboBox<String> myComboBox = new JComboBox<>();
        for (City city : countries) {
            myComboBox.addItem(city.getName());
        }
        
        // countries.forEach(c -> myComboBox.add(c.getName(), myComboBox));

        myPanel.add(myComboBox);
        myPanel.add(sendButton);
        myFrame.add(myPanel);

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameCity = (String) myComboBox.getSelectedItem();
                Optional<City> city = findCityByNameUC.execute(nameCity);
                deleteCityUC.execute(city.get().getId());
                myFrame.dispose();
                JOptionPane.showMessageDialog(null, "City has been deleted...", null, JOptionPane.PLAIN_MESSAGE);
            }
        });

        myFrame.setVisible(true);
    }

    public Optional<City> FindCityByID() {
        idCity = Integer.parseInt(JOptionPane.showInputDialog(null, "Insert the ID of the City: "));
        Optional<City> city = findCityByIdUC.execute(idCity);
        if (city.isPresent()) {
            JOptionPane.showMessageDialog(null, "City Founded:\nID: " + city.get().getId() + "\nName: " + city.get().getName() + "\nIdCountry: " + city.get().getIdCountry(),
                    "City's Info", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "City Not Funded", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return city;
    }
    
    public List<City> listCities(){
        List<City> cities =  findCitiesUC.execute();
        showCitiesTable(cities);
        return cities;
    }

    public static void showCitiesTable(List<City> cities) {
        String[] columns = {"ID", "Name", "IdCountry"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        cities.forEach(country -> {
            Object[] row = {country.getId(), country.getName(), country.getIdCountry()};
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
