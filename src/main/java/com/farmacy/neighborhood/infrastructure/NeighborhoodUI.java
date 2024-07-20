package com.farmacy.neighborhood.infrastructure;

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

import com.farmacy.neighborhood.aplication.CreateNeighborhoodUC;
import com.farmacy.neighborhood.aplication.DeleteNeighborhoodUC;
import com.farmacy.neighborhood.aplication.FindNeighborhoodsUC;
import com.farmacy.neighborhood.aplication.FindNeighborhoodByIdUC;
import com.farmacy.neighborhood.aplication.FindNeighborhoodByNameUC;
import com.farmacy.city.aplication.FindCitiesUC;
import com.farmacy.city.aplication.FindCityByNameUC;
import com.farmacy.neighborhood.aplication.UpdateNeighborhoodUC;
import com.farmacy.city.domain.entity.City;
import com.farmacy.neighborhood.domain.entity.Neighborhood;

public class NeighborhoodUI {
    private CreateNeighborhoodUC createNeighborhoodUC;
    private FindNeighborhoodsUC findNeighborhoodsUC;
    private FindCitiesUC findCitiesUC;
    private FindCityByNameUC findCityByNameUC;
    private FindNeighborhoodByIdUC findNeighborhoodByIdUC;
    private FindNeighborhoodByNameUC findNeighborhoodByNameUC;
    private UpdateNeighborhoodUC updateNeighborhoodUC;
    private DeleteNeighborhoodUC deleteNeighborhoodUC;
    private String nameCity;
    private int idNeighborhood;

    public NeighborhoodUI(CreateNeighborhoodUC createNeighborhoodUC) {
        this.createNeighborhoodUC = createNeighborhoodUC;
    }

    public NeighborhoodUI(CreateNeighborhoodUC cnuc, FindCitiesUC fcsuc, FindCityByNameUC fcnuc) {
        this.createNeighborhoodUC = cnuc;
        this.findCitiesUC = fcsuc;
        this.findCityByNameUC = fcnuc;
    }

    public NeighborhoodUI(FindNeighborhoodByIdUC findNeighborhoodByIdUC) {
        this.findNeighborhoodByIdUC = findNeighborhoodByIdUC;
    }

    public NeighborhoodUI(FindNeighborhoodsUC findNeighborhoodsUC) {
        this.findNeighborhoodsUC = findNeighborhoodsUC;
    }

    public NeighborhoodUI(UpdateNeighborhoodUC ucuc, FindNeighborhoodsUC fcsuc, FindNeighborhoodByNameUC fcnuc) {
        this.updateNeighborhoodUC = ucuc;
        this.findNeighborhoodsUC = fcsuc;
        this.findNeighborhoodByNameUC = fcnuc;
    }

    public NeighborhoodUI(DeleteNeighborhoodUC dcuc, FindNeighborhoodsUC fcsuc, FindNeighborhoodByNameUC fcnuc) {
        this.deleteNeighborhoodUC = dcuc;
        this.findNeighborhoodsUC = fcsuc;
        this.findNeighborhoodByNameUC = fcnuc;
    }

    public void createNeighborhood() {
        JFrame myFrame = new JFrame();

        // Configurar el JFrame
        myFrame.setTitle("Interfaz de Usuario");
        myFrame.setSize(400, 300);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLocationRelativeTo(null);

        List<City> cities =  findCitiesUC.execute();

        JComboBox<String> cityField = new JComboBox<>();
        for (City city : cities) {
            cityField.addItem(city.getName());
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
                Neighborhood neighborhood = new Neighborhood();
                nameCity = (String) cityField.getSelectedItem();
                Optional<City> cities = findCityByNameUC.execute(nameCity);
                neighborhood.setName(nameField.getText());
                neighborhood.setIdCity(cities.get().getId());
                createNeighborhoodUC.execute(neighborhood);
                myFrame.dispose();
                JOptionPane.showMessageDialog(null, "Neighborhood has been added!", null, JOptionPane.PLAIN_MESSAGE);
            }
        });

        // Crear un panel y añadir los componentes
        JPanel panel = new JPanel();
        panel.add(imageLabel);
        panel.add(nameField);
        panel.add(cityField);
        panel.add(sendButton);

        // Añadir el panel al JFrame
        myFrame.add(panel);

        // Hacer visible el JFrame
        myFrame.setVisible(true);
    }

    public void updateNeighborhood() {
        JFrame myFrame = new JFrame();

        // Configurar el JFrame
        myFrame.setTitle("Interfaz de Usuario");
        myFrame.setSize(400, 300);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLocationRelativeTo(null);

        JPanel myPanel = new JPanel();
        JButton sendButton = new JButton("Siguiente ->");

        List<Neighborhood> neighborhoods =  findNeighborhoodsUC.execute();

        JComboBox<String> myComboBox = new JComboBox<>();
        for (Neighborhood neighborhood : neighborhoods) {
            myComboBox.addItem(neighborhood.getName());
        }
        
        // countries.forEach(c -> myComboBox.addItem(c.getName()));

        myPanel.add(myComboBox);
        myPanel.add(sendButton);
        myFrame.add(myPanel);

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameCity = (String) myComboBox.getSelectedItem();
                Optional<Neighborhood> neighborhood = findNeighborhoodByNameUC.execute(nameCity);
                String newName = JOptionPane.showInputDialog(null, "Insert the new name for the neighborhood");
                neighborhood.get().setName(newName);
                updateNeighborhoodUC.execute(neighborhood.get());
                myFrame.dispose();
                JOptionPane.showMessageDialog(null, "Neighborhood has been updated!", null, JOptionPane.PLAIN_MESSAGE);
            }
        });

        myFrame.setVisible(true);
    }

    public void deleteNeighborhood(){
        JFrame myFrame = new JFrame();

        // Configurar el JFrame
        myFrame.setTitle("Interfaz de Usuario");
        myFrame.setSize(400, 300);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLocationRelativeTo(null);

        JPanel myPanel = new JPanel();
        JButton sendButton = new JButton("Siguiente ->");

        List<Neighborhood> neighborhoods =  findNeighborhoodsUC.execute();

        JComboBox<String> myComboBox = new JComboBox<>();
        for (Neighborhood neighborhood : neighborhoods) {
            myComboBox.addItem(neighborhood.getName());
        }
        
        // countries.forEach(c -> myComboBox.add(c.getName(), myComboBox));

        myPanel.add(myComboBox);
        myPanel.add(sendButton);
        myFrame.add(myPanel);

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameCity = (String) myComboBox.getSelectedItem();
                Optional<Neighborhood> neighborhood = findNeighborhoodByNameUC.execute(nameCity);
                deleteNeighborhoodUC.execute(neighborhood.get().getId());
                myFrame.dispose();
                JOptionPane.showMessageDialog(null, "Neighborhood has been deleted...", null, JOptionPane.PLAIN_MESSAGE);
            }
        });

        myFrame.setVisible(true);
    }

    public Optional<Neighborhood> FindNeighborhoodByID() {
        idNeighborhood = Integer.parseInt(JOptionPane.showInputDialog(null, "Insert the ID of the Neighborhood: "));
        Optional<Neighborhood> neighborhood = findNeighborhoodByIdUC.execute(idNeighborhood);
        if (neighborhood.isPresent()) {
            JOptionPane.showMessageDialog(null, "Neighborhood funded:\nID: " + neighborhood.get().getId() + "\nName: " + neighborhood.get().getName() + "\nIdCity: " + neighborhood.get().getIdCity(),
                    "Info of the Neighborhood", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Neighborhood not funded", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return neighborhood;
    }
    
    public List<Neighborhood> listNeighborhoods(){
        List<Neighborhood> neighborhoods =  findNeighborhoodsUC.execute();
        showNeighborhoodsTable(neighborhoods);
        return neighborhoods;
    }

    public static void showNeighborhoodsTable(List<Neighborhood> neighborhoods) {
        String[] columns = {"ID", "Name", "IdCountry"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        neighborhoods.forEach(neighborhood -> {
            Object[] row = {neighborhood.getId(), neighborhood.getName(), neighborhood.getIdCity()};
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
