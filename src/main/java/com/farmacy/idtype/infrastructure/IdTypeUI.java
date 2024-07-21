package com.farmacy.idtype.infrastructure;

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

import com.farmacy.idtype.aplication.DeleteIdTypeUC;
import com.farmacy.idtype.aplication.FindIdTypeByIdUC;
import com.farmacy.idtype.aplication.FindIdTypeByNameUc;
import com.farmacy.idtype.aplication.FindIdTypesUC;
import com.farmacy.idtype.aplication.SaveIdTypeUC;
import com.farmacy.idtype.aplication.UpdateIdTypeUC;
import com.farmacy.idtype.domain.entity.IdType;

public class IdTypeUI {
    private SaveIdTypeUC createIdTypeUC;
    private UpdateIdTypeUC updateIdTypeUC;
    private FindIdTypeByIdUC findIdTypeByIdUC;
    private FindIdTypesUC findIdTypesUC;
    private DeleteIdTypeUC deleteIdTypeUC;
    private FindIdTypeByNameUc findIdTypeByNameUc;
    private int idOfIdType;
    private String nameIdType;

    public IdTypeUI(SaveIdTypeUC createIdTypeUC) {
        this.createIdTypeUC = createIdTypeUC;
    }

    public IdTypeUI(FindIdTypeByIdUC findIdTypeByIdUC) {
        this.findIdTypeByIdUC = findIdTypeByIdUC;
    }

    public IdTypeUI(FindIdTypesUC findIdTypesUC) {
        this.findIdTypesUC = findIdTypesUC;
    }  

    public IdTypeUI(UpdateIdTypeUC updateIdTypeUC) {
        this.updateIdTypeUC = updateIdTypeUC;
    }

    public IdTypeUI(UpdateIdTypeUC ucuc, FindIdTypesUC fcsuc, FindIdTypeByNameUc fciduc) {
        this.updateIdTypeUC = ucuc;
        this.findIdTypesUC = fcsuc;
        this.findIdTypeByNameUc = fciduc;
    }

    public IdTypeUI(DeleteIdTypeUC deleteIdTypeUC) {
        this.deleteIdTypeUC = deleteIdTypeUC;
    }

    public IdTypeUI(DeleteIdTypeUC dcuc, FindIdTypesUC fcsuc, FindIdTypeByNameUc fciduc) {
        this.deleteIdTypeUC = dcuc;
        this.findIdTypesUC = fcsuc;
        this.findIdTypeByNameUc = fciduc;
    }

    public IdTypeUI(FindIdTypeByNameUc findIdTypeByNameUc) {
        this.findIdTypeByNameUc = findIdTypeByNameUc;
    }

    public void CreateIdType() {
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
                IdType idType = new IdType();
                idType.setName(textField.getText());
                createIdTypeUC.execute(idType);
                myFrame.dispose();
                JOptionPane.showMessageDialog(null, "IdType has been added!", null, JOptionPane.PLAIN_MESSAGE);
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

    public void UpdateIdType() {
        JFrame myFrame = new JFrame();

        // Configurar el JFrame
        myFrame.setTitle("Interfaz de Usuario");
        myFrame.setSize(400, 300);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLocationRelativeTo(null);

        JPanel myPanel = new JPanel();
        JButton sendButton = new JButton("Next ->");

        List<IdType> IdTypes =  findIdTypesUC.execute();

        JComboBox<String> myComboBox = new JComboBox<>();
        for (IdType IdType : IdTypes) {
            myComboBox.addItem(IdType.getName());
        }
        
        // IdTypes.forEach(c -> myComboBox.addItem(c.getName()));

        myPanel.add(myComboBox);
        myPanel.add(sendButton);
        myFrame.add(myPanel);

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameIdType = (String) myComboBox.getSelectedItem();
                Optional<IdType> IdType = findIdTypeByNameUc.execute(nameIdType);
                String newName = JOptionPane.showInputDialog(null, "Insert the new name for the IdType");
                IdType.get().setName(newName);
                updateIdTypeUC.execute(IdType.get());
                myFrame.dispose();
                JOptionPane.showMessageDialog(null, "IdType has been updated!", null, JOptionPane.PLAIN_MESSAGE);
            }
        });

        myFrame.setVisible(true);
    }

    public void DeleteIdType(){
        JFrame myFrame = new JFrame();

        // Configurar el JFrame
        myFrame.setTitle("Interfaz de Usuario");
        myFrame.setSize(400, 300);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLocationRelativeTo(null);

        JPanel myPanel = new JPanel();
        JButton sendButton = new JButton("Next ->");

        List<IdType> idTypes =  findIdTypesUC.execute();

        JComboBox<String> myComboBox = new JComboBox<>();
        for (IdType IdType : idTypes) {
            myComboBox.addItem(IdType.getName());
        }
        
        // IdTypes.forEach(c -> myComboBox.add(c.getName(), myComboBox));

        myPanel.add(myComboBox);
        myPanel.add(sendButton);
        myFrame.add(myPanel);

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameIdType = (String) myComboBox.getSelectedItem();
                Optional<IdType> idType = findIdTypeByNameUc.execute(nameIdType);
                deleteIdTypeUC.execute(idType.get().getId());
                myFrame.dispose();
                JOptionPane.showMessageDialog(null, "IdType has been deleted...", null, JOptionPane.PLAIN_MESSAGE);
            }
        });

        myFrame.setVisible(true);
    }

    public Optional<IdType> FindIdTypeByID() {
        idOfIdType = Integer.parseInt(JOptionPane.showInputDialog(null, "Insert the id of the type of id: "));
        Optional<IdType> idType = findIdTypeByIdUC.execute(idOfIdType);
        if (idType.isPresent()) {
            JOptionPane.showMessageDialog(null, "Type of Id founded:\nID: " + idType.get().getId() + "\nNombre: " + idType.get().getName(),
                    "Información del País", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Type of Id not funded", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return idType;
    }

    public List<IdType> ListIdTypes() {
        List<IdType> idTypes =  findIdTypesUC.execute();
        showIdTypesTable(idTypes);
        return idTypes;
    }

    public static void showIdTypesTable(List<IdType> idTypes) {
        String[] columns = {"ID", "Type"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        idTypes.forEach(idType -> {
            Object[] row = {idType.getId(), idType.getName()};
            model.addRow(row);
        });

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);

        JOptionPane.showMessageDialog(null, panel, "Type of ids List", JOptionPane.PLAIN_MESSAGE);
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
