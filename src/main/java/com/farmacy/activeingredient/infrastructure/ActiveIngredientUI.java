package com.farmacy.activeingredient.infrastructure;

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

import com.farmacy.activeingredient.aplication.DeleteActiveIngredientUC;
import com.farmacy.activeingredient.aplication.FindActiveIngredientByIdUC;
import com.farmacy.activeingredient.aplication.FindActiveIngredientByNameUc;
import com.farmacy.activeingredient.aplication.FindActiveIngredientsUC;
import com.farmacy.activeingredient.aplication.CreateActiveIngredientUC;
import com.farmacy.activeingredient.aplication.UpdateActiveIngredientUC;
import com.farmacy.activeingredient.domain.entity.ActiveIngredient;

public class ActiveIngredientUI {
    private CreateActiveIngredientUC createActiveIngredientUC;
    private UpdateActiveIngredientUC updateActiveIngredientUC;
    private FindActiveIngredientByIdUC findActiveIngredientByIdUC;
    private FindActiveIngredientsUC findActiveIngredientsUC;
    private DeleteActiveIngredientUC deleteActiveIngredientUC;
    private FindActiveIngredientByNameUc findActiveIngredientByNameUc;
    private int idOfActiveIngredient;
    private String nameActiveIngredient;

    public ActiveIngredientUI(CreateActiveIngredientUC createActiveIngredientUC) {
        this.createActiveIngredientUC = createActiveIngredientUC;
    }

    public ActiveIngredientUI(FindActiveIngredientByIdUC findActiveIngredientByIdUC) {
        this.findActiveIngredientByIdUC = findActiveIngredientByIdUC;
    }

    public ActiveIngredientUI(FindActiveIngredientsUC findActiveIngredientsUC) {
        this.findActiveIngredientsUC = findActiveIngredientsUC;
    }  

    public ActiveIngredientUI(UpdateActiveIngredientUC updateActiveIngredientUC) {
        this.updateActiveIngredientUC = updateActiveIngredientUC;
    }

    public ActiveIngredientUI(UpdateActiveIngredientUC ucuc, FindActiveIngredientsUC fcsuc, FindActiveIngredientByNameUc fciduc) {
        this.updateActiveIngredientUC = ucuc;
        this.findActiveIngredientsUC = fcsuc;
        this.findActiveIngredientByNameUc = fciduc;
    }

    public ActiveIngredientUI(DeleteActiveIngredientUC deleteActiveIngredientUC) {
        this.deleteActiveIngredientUC = deleteActiveIngredientUC;
    }

    public ActiveIngredientUI(DeleteActiveIngredientUC dcuc, FindActiveIngredientsUC fcsuc, FindActiveIngredientByNameUc fciduc) {
        this.deleteActiveIngredientUC = dcuc;
        this.findActiveIngredientsUC = fcsuc;
        this.findActiveIngredientByNameUc = fciduc;
    }

    public ActiveIngredientUI(FindActiveIngredientByNameUc findActiveIngredientByNameUc) {
        this.findActiveIngredientByNameUc = findActiveIngredientByNameUc;
    }

    public void CreateActiveIngredient() {
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
                ActiveIngredient ActiveIngredient = new ActiveIngredient();
                ActiveIngredient.setName(textField.getText());
                createActiveIngredientUC.execute(ActiveIngredient);
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

    public void UpdateActiveIngredient() {
        JFrame myFrame = new JFrame();

        myFrame.setTitle("User Interface");
        myFrame.setSize(400, 300);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLocationRelativeTo(null);

        JPanel myPanel = new JPanel();
        JButton sendButton = new JButton("Next ->");

        List<ActiveIngredient> ActiveIngredients =  findActiveIngredientsUC.execute();

        JComboBox<String> myComboBox = new JComboBox<>();
        for (ActiveIngredient ActiveIngredient : ActiveIngredients) {
            myComboBox.addItem(ActiveIngredient.getName());
        }
        
        // ActiveIngredients.forEach(c -> myComboBox.addItem(c.getName()));

        myPanel.add(myComboBox);
        myPanel.add(sendButton);
        myFrame.add(myPanel);

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameActiveIngredient = (String) myComboBox.getSelectedItem();
                Optional<ActiveIngredient> ActiveIngredient = findActiveIngredientByNameUc.execute(nameActiveIngredient);
                String newName = JOptionPane.showInputDialog(null, "Insert the new name for the Administration Route");
                ActiveIngredient.get().setName(newName);
                updateActiveIngredientUC.execute(ActiveIngredient.get());
                myFrame.dispose();
                JOptionPane.showMessageDialog(null, "Administration Route has been updated!", null, JOptionPane.PLAIN_MESSAGE);
            }
        });

        myFrame.setVisible(true);
    }

    public void DeleteActiveIngredient(){
        JFrame myFrame = new JFrame();

        myFrame.setTitle("User Interface");
        myFrame.setSize(400, 300);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLocationRelativeTo(null);

        JPanel myPanel = new JPanel();
        JButton sendButton = new JButton("Next ->");

        List<ActiveIngredient> ActiveIngredients =  findActiveIngredientsUC.execute();

        JComboBox<String> myComboBox = new JComboBox<>();
        for (ActiveIngredient ActiveIngredient : ActiveIngredients) {
            myComboBox.addItem(ActiveIngredient.getName());
        }
        
        // ActiveIngredients.forEach(c -> myComboBox.add(c.getName(), myComboBox));

        myPanel.add(myComboBox);
        myPanel.add(sendButton);
        myFrame.add(myPanel);

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameActiveIngredient = (String) myComboBox.getSelectedItem();
                Optional<ActiveIngredient> ActiveIngredient = findActiveIngredientByNameUc.execute(nameActiveIngredient);
                deleteActiveIngredientUC.execute(ActiveIngredient.get().getId());
                myFrame.dispose();
                JOptionPane.showMessageDialog(null, "Administration Route has been deleted...", null, JOptionPane.PLAIN_MESSAGE);
            }
        });

        myFrame.setVisible(true);
    }

    public Optional<ActiveIngredient> FindActiveIngredientByID() {
        idOfActiveIngredient = Integer.parseInt(JOptionPane.showInputDialog(null, "Insert the id of the Administration Route: "));
        Optional<ActiveIngredient> ActiveIngredient = findActiveIngredientByIdUC.execute(idOfActiveIngredient);
        if (ActiveIngredient.isPresent()) {
            JOptionPane.showMessageDialog(null, "Administration Route founded:\nID: " + ActiveIngredient.get().getId() + "\nNombre: " + ActiveIngredient.get().getName(),
                    "Administration Route's Info", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Administration Route not funded", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return ActiveIngredient;
    }

    public List<ActiveIngredient> ListActiveIngredients() {
        List<ActiveIngredient> ActiveIngredients =  findActiveIngredientsUC.execute();
        showActiveIngredientsTable(ActiveIngredients);
        return ActiveIngredients;
    }

    public static void showActiveIngredientsTable(List<ActiveIngredient> ActiveIngredients) {
        String[] columns = {"ID", "Administration Route"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        ActiveIngredients.forEach(ActiveIngredient -> {
            Object[] row = {ActiveIngredient.getId(), ActiveIngredient.getName()};
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
