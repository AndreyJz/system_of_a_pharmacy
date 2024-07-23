package com.farmacy.unitofmeasure.infrastructure;

import java.awt.Image;
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

import com.farmacy.unitofmeasure.aplication.DeleteUnitOfMeasureUC;
import com.farmacy.unitofmeasure.aplication.FindUnitOfMeasureByIdUC;
import com.farmacy.unitofmeasure.aplication.FindUnitOfMeasureByNameUC;
import com.farmacy.unitofmeasure.aplication.FindUnitOfMeasuresUC;
import com.farmacy.unitofmeasure.aplication.CreateUnitOfMeasureUC;
import com.farmacy.unitofmeasure.aplication.UpdateUnitOfMeasureUC;
import com.farmacy.unitofmeasure.domain.entity.UnitOfMeasure;

public class UnitOfMeasureUI {
    private CreateUnitOfMeasureUC createUnitOfMeasureUC;
    private UpdateUnitOfMeasureUC updateUnitOfMeasureUC;
    private FindUnitOfMeasureByIdUC findUnitOfMeasureByIdUC;
    private FindUnitOfMeasuresUC findUnitOfMeasuresUC;
    private DeleteUnitOfMeasureUC deleteUnitOfMeasureUC;
    private FindUnitOfMeasureByNameUC findUnitOfMeasureByNameUc;
    private int idOfUnitOfMeasure;
    private String nameUnitOfMeasure;

    public UnitOfMeasureUI(CreateUnitOfMeasureUC createUnitOfMeasureUC) {
        this.createUnitOfMeasureUC = createUnitOfMeasureUC;
    }

    public UnitOfMeasureUI(FindUnitOfMeasureByIdUC findUnitOfMeasureByIdUC) {
        this.findUnitOfMeasureByIdUC = findUnitOfMeasureByIdUC;
    }

    public UnitOfMeasureUI(FindUnitOfMeasuresUC findUnitOfMeasuresUC) {
        this.findUnitOfMeasuresUC = findUnitOfMeasuresUC;
    }  

    public UnitOfMeasureUI(UpdateUnitOfMeasureUC updateUnitOfMeasureUC) {
        this.updateUnitOfMeasureUC = updateUnitOfMeasureUC;
    }

    public UnitOfMeasureUI(UpdateUnitOfMeasureUC ucuc, FindUnitOfMeasuresUC fcsuc, FindUnitOfMeasureByNameUC fciduc) {
        this.updateUnitOfMeasureUC = ucuc;
        this.findUnitOfMeasuresUC = fcsuc;
        this.findUnitOfMeasureByNameUc = fciduc;
    }

    public UnitOfMeasureUI(DeleteUnitOfMeasureUC deleteUnitOfMeasureUC) {
        this.deleteUnitOfMeasureUC = deleteUnitOfMeasureUC;
    }

    public UnitOfMeasureUI(DeleteUnitOfMeasureUC dcuc, FindUnitOfMeasuresUC fcsuc, FindUnitOfMeasureByNameUC fciduc) {
        this.deleteUnitOfMeasureUC = dcuc;
        this.findUnitOfMeasuresUC = fcsuc;
        this.findUnitOfMeasureByNameUc = fciduc;
    }

    public UnitOfMeasureUI(FindUnitOfMeasureByNameUC findUnitOfMeasureByNameUc) {
        this.findUnitOfMeasureByNameUc = findUnitOfMeasureByNameUc;
    }

    public void CreateUnitOfMeasure() {
        JFrame myFrame = new JFrame();

        myFrame.setTitle("User Interface");
        myFrame.setSize(400, 300);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLocationRelativeTo(null);

        JLabel imageLabel = new JLabel();
        JTextField textField = new JTextField(20);
        JButton sendButton = new JButton("Sent");

        imageLabel.setIcon(resizeImage("/images/45069.png", 100, 100));

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
                unitOfMeasure.setName(textField.getText());
                createUnitOfMeasureUC.execute(unitOfMeasure);
                myFrame.dispose();
                JOptionPane.showMessageDialog(null, "Unit Of Measure has been added!", null, JOptionPane.PLAIN_MESSAGE);
            }
        });

        JPanel panel = new JPanel();
        panel.add(imageLabel);
        panel.add(textField);
        panel.add(sendButton);

        myFrame.add(panel);

        myFrame.setVisible(true);
    }

    public void UpdateUnitOfMeasure() {
        JFrame myFrame = new JFrame();

        myFrame.setTitle("User Interface");
        myFrame.setSize(400, 300);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLocationRelativeTo(null);

        JPanel myPanel = new JPanel();
        JButton sendButton = new JButton("Next ->");

        List<UnitOfMeasure> unitsOfMeasure =  findUnitOfMeasuresUC.execute();

        JComboBox<String> myComboBox = new JComboBox<>();
        for (UnitOfMeasure unitOfMeasure : unitsOfMeasure) {
            myComboBox.addItem(unitOfMeasure.getName());
        }
        
        // UnitOfMeasures.forEach(c -> myComboBox.addItem(c.getName()));

        myPanel.add(myComboBox);
        myPanel.add(sendButton);
        myFrame.add(myPanel);

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameUnitOfMeasure = (String) myComboBox.getSelectedItem();
                Optional<UnitOfMeasure> unitOfMeasure = findUnitOfMeasureByNameUc.execute(nameUnitOfMeasure);
                String newName = JOptionPane.showInputDialog(null, "Insert the new name for the Unit Of Measure");
                unitOfMeasure.get().setName(newName);
                updateUnitOfMeasureUC.execute(unitOfMeasure.get());
                myFrame.dispose();
                JOptionPane.showMessageDialog(null, "Unit Of Measure has been updated!", null, JOptionPane.PLAIN_MESSAGE);
            }
        });

        myFrame.setVisible(true);
    }

    public void DeleteUnitOfMeasure(){
        JFrame myFrame = new JFrame();

        myFrame.setTitle("User Interface");
        myFrame.setSize(400, 300);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLocationRelativeTo(null);

        JPanel myPanel = new JPanel();
        JButton sendButton = new JButton("Next ->");

        List<UnitOfMeasure> unitsOfMeasure =  findUnitOfMeasuresUC.execute();

        JComboBox<String> myComboBox = new JComboBox<>();
        for (UnitOfMeasure unitOfMeasure : unitsOfMeasure) {
            myComboBox.addItem(unitOfMeasure.getName());
        }
        
        // UnitOfMeasures.forEach(c -> myComboBox.add(c.getName(), myComboBox));

        myPanel.add(myComboBox);
        myPanel.add(sendButton);
        myFrame.add(myPanel);

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameUnitOfMeasure = (String) myComboBox.getSelectedItem();
                Optional<UnitOfMeasure> unitOfMeasure = findUnitOfMeasureByNameUc.execute(nameUnitOfMeasure);
                deleteUnitOfMeasureUC.execute(unitOfMeasure.get().getId());
                myFrame.dispose();
                JOptionPane.showMessageDialog(null, "Unit Of Measure has been deleted...", null, JOptionPane.PLAIN_MESSAGE);
            }
        });

        myFrame.setVisible(true);
    }

    public Optional<UnitOfMeasure> FindUnitOfMeasureByID() {
        idOfUnitOfMeasure = Integer.parseInt(JOptionPane.showInputDialog(null, "Insert the id of the Unit Of Measure: "));
        Optional<UnitOfMeasure> unitOfMeasure = findUnitOfMeasureByIdUC.execute(idOfUnitOfMeasure);
        if (unitOfMeasure.isPresent()) {
            JOptionPane.showMessageDialog(null, "Unit Of Measure founded:\nID: " + unitOfMeasure.get().getId() + "\nName: " + unitOfMeasure.get().getName(),
                    "Administration Route's Info", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Unit Of Measure not funded", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return unitOfMeasure;
    }

    public List<UnitOfMeasure> ListUnitOfMeasures() {
        List<UnitOfMeasure> unitsOfMeasure =  findUnitOfMeasuresUC.execute();
        showUnitOfMeasuresTable(unitsOfMeasure);
        return unitsOfMeasure;
    }

    public static void showUnitOfMeasuresTable(List<UnitOfMeasure> unitsOfMeasure) {
        String[] columns = {"ID", "Unit Of Measure"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        unitsOfMeasure.forEach(unitOfMeasure -> {
            Object[] row = {unitOfMeasure.getId(), unitOfMeasure.getName()};
            model.addRow(row);
        });

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);

        JOptionPane.showMessageDialog(null, panel, "Units Of Measure List", JOptionPane.PLAIN_MESSAGE);
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
