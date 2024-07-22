package com.farmacy.administrationroute.infrastructure;

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

import com.farmacy.administrationroute.aplication.DeleteAdministrationRouteUC;
import com.farmacy.administrationroute.aplication.FindAdministrationRouteByIdUC;
import com.farmacy.administrationroute.aplication.FindAdministrationRouteByNameUc;
import com.farmacy.administrationroute.aplication.FindAdministrationRoutesUC;
import com.farmacy.administrationroute.aplication.CreateAdministrationRouteUC;
import com.farmacy.administrationroute.aplication.UpdateAdministrationRouteUC;
import com.farmacy.administrationroute.domain.entity.AdministrationRoute;

public class AdministrationRouteUI {
    private CreateAdministrationRouteUC createAdministrationRouteUC;
    private UpdateAdministrationRouteUC updateAdministrationRouteUC;
    private FindAdministrationRouteByIdUC findAdministrationRouteByIdUC;
    private FindAdministrationRoutesUC findAdministrationRoutesUC;
    private DeleteAdministrationRouteUC deleteAdministrationRouteUC;
    private FindAdministrationRouteByNameUc findAdministrationRouteByNameUc;
    private int idOfAdministrationRoute;
    private String nameAdministrationRoute;

    public AdministrationRouteUI(CreateAdministrationRouteUC createAdministrationRouteUC) {
        this.createAdministrationRouteUC = createAdministrationRouteUC;
    }

    public AdministrationRouteUI(FindAdministrationRouteByIdUC findAdministrationRouteByIdUC) {
        this.findAdministrationRouteByIdUC = findAdministrationRouteByIdUC;
    }

    public AdministrationRouteUI(FindAdministrationRoutesUC findAdministrationRoutesUC) {
        this.findAdministrationRoutesUC = findAdministrationRoutesUC;
    }  

    public AdministrationRouteUI(UpdateAdministrationRouteUC updateAdministrationRouteUC) {
        this.updateAdministrationRouteUC = updateAdministrationRouteUC;
    }

    public AdministrationRouteUI(UpdateAdministrationRouteUC ucuc, FindAdministrationRoutesUC fcsuc, FindAdministrationRouteByNameUc fciduc) {
        this.updateAdministrationRouteUC = ucuc;
        this.findAdministrationRoutesUC = fcsuc;
        this.findAdministrationRouteByNameUc = fciduc;
    }

    public AdministrationRouteUI(DeleteAdministrationRouteUC deleteAdministrationRouteUC) {
        this.deleteAdministrationRouteUC = deleteAdministrationRouteUC;
    }

    public AdministrationRouteUI(DeleteAdministrationRouteUC dcuc, FindAdministrationRoutesUC fcsuc, FindAdministrationRouteByNameUc fciduc) {
        this.deleteAdministrationRouteUC = dcuc;
        this.findAdministrationRoutesUC = fcsuc;
        this.findAdministrationRouteByNameUc = fciduc;
    }

    public AdministrationRouteUI(FindAdministrationRouteByNameUc findAdministrationRouteByNameUc) {
        this.findAdministrationRouteByNameUc = findAdministrationRouteByNameUc;
    }

    public void CreateAdministrationRoute() {
        JFrame myFrame = new JFrame();

        myFrame.setTitle("User Interface");
        myFrame.setSize(400, 300);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLocationRelativeTo(null);

        JLabel imageLabel = new JLabel();
        JTextField textField = new JTextField(20);
        JButton sendButton = new JButton("Enviar");

        imageLabel.setIcon(resizeImage("/images/45069.png", 100, 100));

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdministrationRoute administrationRoute = new AdministrationRoute();
                administrationRoute.setName(textField.getText());
                createAdministrationRouteUC.execute(administrationRoute);
                myFrame.dispose();
                JOptionPane.showMessageDialog(null, "Administration Route has been added!", null, JOptionPane.PLAIN_MESSAGE);
            }
        });

        JPanel panel = new JPanel();
        panel.add(imageLabel);
        panel.add(textField);
        panel.add(sendButton);

        myFrame.add(panel);

        myFrame.setVisible(true);
    }

    public void UpdateAdministrationRoute() {
        JFrame myFrame = new JFrame();

        myFrame.setTitle("User Interface");
        myFrame.setSize(400, 300);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLocationRelativeTo(null);

        JPanel myPanel = new JPanel();
        JButton sendButton = new JButton("Next ->");

        List<AdministrationRoute> administrationRoutes =  findAdministrationRoutesUC.execute();

        JComboBox<String> myComboBox = new JComboBox<>();
        for (AdministrationRoute administrationRoute : administrationRoutes) {
            myComboBox.addItem(administrationRoute.getName());
        }
        
        // AdministrationRoutes.forEach(c -> myComboBox.addItem(c.getName()));

        myPanel.add(myComboBox);
        myPanel.add(sendButton);
        myFrame.add(myPanel);

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameAdministrationRoute = (String) myComboBox.getSelectedItem();
                Optional<AdministrationRoute> administrationRoute = findAdministrationRouteByNameUc.execute(nameAdministrationRoute);
                String newName = JOptionPane.showInputDialog(null, "Insert the new name for the Administration Route");
                administrationRoute.get().setName(newName);
                updateAdministrationRouteUC.execute(administrationRoute.get());
                myFrame.dispose();
                JOptionPane.showMessageDialog(null, "Administration Route has been updated!", null, JOptionPane.PLAIN_MESSAGE);
            }
        });

        myFrame.setVisible(true);
    }

    public void DeleteAdministrationRoute(){
        JFrame myFrame = new JFrame();

        myFrame.setTitle("User Interface");
        myFrame.setSize(400, 300);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLocationRelativeTo(null);

        JPanel myPanel = new JPanel();
        JButton sendButton = new JButton("Next ->");

        List<AdministrationRoute> administrationRoutes =  findAdministrationRoutesUC.execute();

        JComboBox<String> myComboBox = new JComboBox<>();
        for (AdministrationRoute administrationRoute : administrationRoutes) {
            myComboBox.addItem(administrationRoute.getName());
        }
        
        // AdministrationRoutes.forEach(c -> myComboBox.add(c.getName(), myComboBox));

        myPanel.add(myComboBox);
        myPanel.add(sendButton);
        myFrame.add(myPanel);

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameAdministrationRoute = (String) myComboBox.getSelectedItem();
                Optional<AdministrationRoute> administrationRoute = findAdministrationRouteByNameUc.execute(nameAdministrationRoute);
                deleteAdministrationRouteUC.execute(administrationRoute.get().getId());
                myFrame.dispose();
                JOptionPane.showMessageDialog(null, "Administration Route has been deleted...", null, JOptionPane.PLAIN_MESSAGE);
            }
        });

        myFrame.setVisible(true);
    }

    public Optional<AdministrationRoute> FindAdministrationRouteByID() {
        idOfAdministrationRoute = Integer.parseInt(JOptionPane.showInputDialog(null, "Insert the id of the Administration Route: "));
        Optional<AdministrationRoute> administrationRoute = findAdministrationRouteByIdUC.execute(idOfAdministrationRoute);
        if (administrationRoute.isPresent()) {
            JOptionPane.showMessageDialog(null, "Administration Route founded:\nID: " + administrationRoute.get().getId() + "\nNombre: " + administrationRoute.get().getName(),
                    "Administration Route's Info", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Administration Route not funded", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return administrationRoute;
    }

    public List<AdministrationRoute> ListAdministrationRoutes() {
        List<AdministrationRoute> administrationRoutes =  findAdministrationRoutesUC.execute();
        showAdministrationRoutesTable(administrationRoutes);
        return administrationRoutes;
    }

    public static void showAdministrationRoutesTable(List<AdministrationRoute> administrationRoutes) {
        String[] columns = {"ID", "Administration Route"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        administrationRoutes.forEach(administrationRoute -> {
            Object[] row = {administrationRoute.getId(), administrationRoute.getName()};
            model.addRow(row);
        });

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);

        JOptionPane.showMessageDialog(null, panel, "Administration Routes List", JOptionPane.PLAIN_MESSAGE);
    }

    private ImageIcon resizeImage(String imagePath, int width, int height) {
        // Leer la imagen desde la URL
        // URL url = new URL(imagePath);
        // Image img = ImageIO.read(url);
        java.net.URL imgURL = getClass().getResource(imagePath);
        ImageIcon icon = new ImageIcon(imgURL);
        Image img = icon.getImage();
        Image imgScaled = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(imgScaled);
    }
}
