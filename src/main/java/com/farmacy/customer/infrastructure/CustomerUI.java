package com.farmacy.customer.infrastructure;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JDateChooser;

import com.farmacy.customer.aplication.CreateCustomerUC;
import com.farmacy.customer.aplication.DeleteCustomerUC;
import com.farmacy.customer.aplication.FindCustomerByIdUC;
import com.farmacy.customer.aplication.FindCustomerByNameUC;
import com.farmacy.customer.aplication.FindCustomersUC;
import com.farmacy.customer.aplication.UpdateCustomerUC;
import com.farmacy.customer.domain.entity.Customer;
import com.farmacy.customer.domain.service.CustomerService;
import com.farmacy.idtype.aplication.FindIdTypeByIdUC;
import com.farmacy.idtype.aplication.FindIdTypeByNameUc;
import com.farmacy.idtype.aplication.FindIdTypesUC;
import com.farmacy.idtype.domain.entity.IdType;
import com.farmacy.neighborhood.aplication.FindNeighborhoodByIdUC;
import com.farmacy.neighborhood.aplication.FindNeighborhoodByNameUC;
import com.farmacy.neighborhood.aplication.FindNeighborhoodsUC;
import com.farmacy.neighborhood.domain.entity.Neighborhood;

public class CustomerUI {
    private CreateCustomerUC createCustomerUC;
    private UpdateCustomerUC updateCustomerUC;
    private DeleteCustomerUC deleteCustomerUC;
    private FindCustomerByNameUC findCustomerByNameUC;
    private FindNeighborhoodByNameUC findNeighborhoodByNameUC;
    private FindIdTypeByNameUc findIdTypeByNameUc;
    private FindCustomerByIdUC findCustomerByIdUC;
    private FindIdTypeByIdUC findIdTypeByIdUC;
    private FindNeighborhoodByIdUC findNeighborhoodByIdUC;
    private FindCustomersUC findCustomersUC;
    private FindNeighborhoodsUC findNeighborhoodsUC;
    private FindIdTypesUC findIdTypesUC;
    private String nameIdType;
    private String nameNeighborhood;
    private String nameCustomer;
    private String idCustomer;
    
    
    
    public CustomerUI(CreateCustomerUC createCustomerUC, FindNeighborhoodsUC findNeighborhoodsUC, FindNeighborhoodByNameUC findNeighborhoodByNameUC, FindIdTypesUC findIdTypesUC, FindIdTypeByNameUc findIdTypeByNameUc) {
        this.createCustomerUC = createCustomerUC;
        this.findNeighborhoodsUC = findNeighborhoodsUC;
        this.findNeighborhoodByNameUC = findNeighborhoodByNameUC;
        this.findIdTypesUC = findIdTypesUC;
        this.findIdTypeByNameUc = findIdTypeByNameUc;
    }

    public CustomerUI(UpdateCustomerUC updateCustomerUC, FindCustomersUC findCustomersUC, FindCustomerByNameUC findCustomerByNameUC, FindNeighborhoodsUC findNeighborhoodsUC, FindNeighborhoodByNameUC findNeighborhoodByNameUC, FindIdTypesUC findIdTypesUC, FindIdTypeByNameUc findIdTypeByNameUC, FindIdTypeByIdUC findIdTypeByIdUC, FindNeighborhoodByIdUC findNeighborhoodByIdUC) {
        this.updateCustomerUC = updateCustomerUC;
        this.findCustomersUC = findCustomersUC;
        this.findCustomerByNameUC = findCustomerByNameUC;
        this.findNeighborhoodByIdUC = findNeighborhoodByIdUC;
        this.findNeighborhoodsUC = findNeighborhoodsUC;
        this.findNeighborhoodByNameUC = findNeighborhoodByNameUC;
        this.findIdTypeByIdUC = findIdTypeByIdUC;
        this.findIdTypesUC = findIdTypesUC;
        this.findIdTypeByNameUc = findIdTypeByNameUC;
    }

    public CustomerUI(DeleteCustomerUC deleteCustomerUC, FindCustomersUC fcsuc, FindCustomerByNameUC fciduc) {
        this.deleteCustomerUC = deleteCustomerUC;
        this.findCustomersUC = fcsuc;
        this.findCustomerByNameUC = fciduc;
    }

    public CustomerUI(FindCustomerByIdUC findCustomerById) {
        this.findCustomerByIdUC = findCustomerById;
    }

    public CustomerUI(FindCustomerByNameUC findCustomerByNameUC) {
        this.findCustomerByNameUC = findCustomerByNameUC;
    }

    public CustomerUI(FindCustomersUC findCustomersUC) {
        this.findCustomersUC = findCustomersUC;
    }

    public void CreateCustomer() {
        JFrame myFrame = new JFrame();

        // Configurar el JFrame
        myFrame.setTitle("Interfaz de Usuario");
        myFrame.setSize(400, 300);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 2, 10, 10));
        panel.setPreferredSize(new Dimension(320, 250));

        JLabel labelID = new JLabel("ID : ");
        JTextField txtID = new JTextField();
        labelID.setFont(new Font("Calibri", Font.PLAIN, 15));
        labelID.setHorizontalAlignment(SwingConstants.CENTER);
        txtID.setFont(new Font("Calibri", Font.PLAIN, 15));

        JLabel labelDocType = new JLabel("DocType : ");

        List<IdType> idTypes =  findIdTypesUC.execute();

        JComboBox<String> docTypeBox = new JComboBox<>();
        for (IdType IdType : idTypes) {
            docTypeBox.addItem(IdType.getName());
        }

        labelDocType.setFont(new Font("Calibri", Font.PLAIN, 15));
        labelDocType.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel labelName = new JLabel("Name : ");
        JTextField txtName = new JTextField();  
        labelName.setFont(new Font("Calibri", Font.PLAIN, 15));
        labelName.setHorizontalAlignment(SwingConstants.CENTER);
        txtName.setFont(new Font("Calibri", Font.PLAIN, 15));

        JLabel labelLastName = new JLabel("Last Name : ");
        JTextField txtLastName = new JTextField();
        labelLastName.setFont(new Font("Calibri", Font.PLAIN, 15));
        labelLastName.setHorizontalAlignment(SwingConstants.CENTER);
        txtLastName.setFont(new Font("Calibri", Font.PLAIN, 15));

        JLabel labelBirthdate = new JLabel("Birthdate : ");
        JDateChooser dateBirthDate = new JDateChooser ();
        labelBirthdate.setFont(new Font("Calibri", Font.PLAIN, 15));
        labelBirthdate.setHorizontalAlignment(SwingConstants.CENTER);
        dateBirthDate.setFont(new Font("Calibri", Font.PLAIN, 15));

        JLabel labelNeighborhood = new JLabel("Neigborhood : ");
        
        List<Neighborhood> neighborhoods =  findNeighborhoodsUC.execute();

        JComboBox<String> neighborhoodBox = new JComboBox<>();
        for (Neighborhood neighborhood : neighborhoods  ) {
            neighborhoodBox.addItem(neighborhood.getName());
        }
        
        labelNeighborhood.setFont(new Font("Calibri", Font.PLAIN, 15));
        labelNeighborhood.setHorizontalAlignment(SwingConstants.CENTER);

        JButton sendButton = new JButton("Enviar");

        // Añadir componentes al panel
        panel.add(labelID);
        panel.add(txtID);
        panel.add(labelDocType);
        panel.add(docTypeBox);
        panel.add(labelName);
        panel.add(txtName);
        panel.add(labelLastName);
        panel.add(txtLastName);
        panel.add(labelBirthdate);
        panel.add(dateBirthDate);
        panel.add(labelNeighborhood);
        panel.add(neighborhoodBox);
        panel.add(new JLabel());  // Placeholder for alignment
        panel.add(sendButton);

        JPanel containerPanel = new JPanel();
        containerPanel.add(panel);

        // Añadir el panel al JFrame
        myFrame.add(containerPanel);

        // Hacer visible el JFrame
        myFrame.setVisible(true);

        // imageLabel.setIcon(resizeImage("/images/45069.png", 100, 100)); // Ajusta la URL y el tamaño de la imagen

        // Configurar el JButton
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameIdType = (String) docTypeBox.getSelectedItem();
                nameNeighborhood = (String) neighborhoodBox.getSelectedItem();
                Optional<IdType> idType = findIdTypeByNameUc.execute(nameIdType);
                Optional<Neighborhood> neighborhood = findNeighborhoodByNameUC.execute(nameNeighborhood);
                Customer customer = new Customer();
                customer.setId(txtID.getText());
                customer.setDocType(idType.get().getId());
                customer.setName(txtName.getText());
                customer.setName(txtName.getText());
                customer.setLastName(txtLastName.getText());
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                customer.setBirthdate(dateFormat.format(dateBirthDate.getDate()));
                customer.setIdNeighborhood(neighborhood.get().getId());
                createCustomerUC.execute(customer);
                myFrame.dispose();
                JOptionPane.showMessageDialog(null, "Customer has been added!", null, JOptionPane.PLAIN_MESSAGE);
            }
        });
    }

    public void UpdateCustomer() {
        JFrame myFrame = new JFrame();

        // Configurar el JFrame
        myFrame.setTitle("Interfaz de Usuario");
        myFrame.setSize(400, 300);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLocationRelativeTo(null);

        JPanel myPanel = new JPanel();
        JButton nextButton = new JButton("Next ->");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 2, 10, 10));
        panel.setPreferredSize(new Dimension(320, 250));

        List<Customer> customers =  findCustomersUC.execute();

        JComboBox<String> customersBox = new JComboBox<>();
        for (Customer customer : customers) {
            customersBox.addItem(customer.getName());
        }
        
        // customers.forEach(c -> customersBox.addItem(c.getName()));

        myPanel.add(customersBox);
        myPanel.add(nextButton);
        myFrame.add(myPanel);

        myPanel.setVisible(true);

        myFrame.setVisible(true);

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameCustomer = (String) customersBox.getSelectedItem();
                Optional<Customer> customer = findCustomerByNameUC.execute(nameCustomer);
                myPanel.setVisible(false);


                JLabel labelID = new JLabel("ID : ");
                JTextField txtID = new JTextField();
                labelID.setFont(new Font("Calibri", Font.PLAIN, 15));
                labelID.setHorizontalAlignment(SwingConstants.CENTER);
                txtID.setFont(new Font("Calibri", Font.PLAIN, 15));
                System.out.println(customer.get().getId());
                txtID.setText(customer.get().getId());

                JLabel labelDocType = new JLabel("DocType : ");

                List<IdType> idTypes =  findIdTypesUC.execute();

                JComboBox<String> docTypeBox = new JComboBox<>();
                for (IdType IdType : idTypes) {
                    docTypeBox.addItem(IdType.getName());
                }

                Optional<IdType> idType = findIdTypeByIdUC.execute(customer.get().getDocType());
                docTypeBox.setSelectedItem(idType.get().getName());

                labelDocType.setFont(new Font("Calibri", Font.PLAIN, 15));
                labelDocType.setHorizontalAlignment(SwingConstants.CENTER);

                JLabel labelName = new JLabel("Name : ");
                JTextField txtName = new JTextField();  
                labelName.setFont(new Font("Calibri", Font.PLAIN, 15));
                labelName.setHorizontalAlignment(SwingConstants.CENTER);
                txtName.setFont(new Font("Calibri", Font.PLAIN, 15));
                txtName.setText(customer.get().getName());

                JLabel labelLastName = new JLabel("Last Name : ");
                JTextField txtLastName = new JTextField();
                labelLastName.setFont(new Font("Calibri", Font.PLAIN, 15));
                labelLastName.setHorizontalAlignment(SwingConstants.CENTER);
                txtLastName.setFont(new Font("Calibri", Font.PLAIN, 15));
                txtLastName.setText(customer.get().getLastName());

                JLabel labelBirthdate = new JLabel("Birthdate : ");
                JDateChooser dateBirthDate = new JDateChooser();
                labelBirthdate.setFont(new Font("Calibri", Font.PLAIN, 15));
                labelBirthdate.setHorizontalAlignment(SwingConstants.CENTER);
                dateBirthDate.setFont(new Font("Calibri", Font.PLAIN, 15));

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    Date birthDate = simpleDateFormat.parse(customer.get().getBirthdate());
                    dateBirthDate.setDate(birthDate);
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }

                JLabel labelNeighborhood = new JLabel("Neigborhood : ");
                
                List<Neighborhood> neighborhoods =  findNeighborhoodsUC.execute();

                JComboBox<String> neighborhoodBox = new JComboBox<>();
                for (Neighborhood neighborhood : neighborhoods  ) {
                    neighborhoodBox.addItem(neighborhood.getName());
                }

                Optional<Neighborhood> neighborhood = findNeighborhoodByIdUC.execute(customer.get().getIdNeighborhood());
                neighborhoodBox.setSelectedItem(neighborhood.get().getName());
                
                labelNeighborhood.setFont(new Font("Calibri", Font.PLAIN, 15));
                labelNeighborhood.setHorizontalAlignment(SwingConstants.CENTER);

                JButton sendButton = new JButton("Save");

                // Añadir componentes al panel
                panel.add(labelID);
                panel.add(txtID);
                panel.add(labelDocType);
                panel.add(docTypeBox);
                panel.add(labelName);
                panel.add(txtName);
                panel.add(labelLastName);
                panel.add(txtLastName);
                panel.add(labelBirthdate);
                panel.add(dateBirthDate);
                panel.add(labelNeighborhood);
                panel.add(neighborhoodBox);
                panel.add(new JLabel());  // Placeholder for alignment
                panel.add(sendButton);

                JPanel containerPanel = new JPanel();
                containerPanel.add(panel);
                containerPanel.setVisible(true);

                // Añadir el panel al JFrame
                myFrame.add(containerPanel);

                // imageLabel.setIcon(resizeImage("/images/45069.png", 100, 100)); // Ajusta la URL y el tamaño de la imagen

                // Configurar el JButton
                sendButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        nameIdType = (String) docTypeBox.getSelectedItem();
                        nameNeighborhood = (String) neighborhoodBox.getSelectedItem();
                        Optional<IdType> idType = findIdTypeByNameUc.execute(nameIdType);
                        Optional<Neighborhood> neighborhood = findNeighborhoodByNameUC.execute(nameNeighborhood);
                        Customer customer = new Customer();
                        customer.setId(txtID.getText());
                        customer.setDocType(idType.get().getId());
                        customer.setName(txtName.getText());
                        customer.setName(txtName.getText());
                        customer.setLastName(txtLastName.getText());
                        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        customer.setBirthdate(dateFormat.format(dateBirthDate.getDate()));
                        customer.setIdNeighborhood(neighborhood.get().getId());
                        updateCustomerUC.execute(customer);
                        myFrame.dispose();
                        JOptionPane.showMessageDialog(null, "Customer has been added!", null, JOptionPane.PLAIN_MESSAGE);
                    }
                });
            }
        });
    }

    public void DeleteCustomer(){
        JFrame myFrame = new JFrame();

        // Configurar el JFrame
        myFrame.setTitle("Interfaz de Usuario");
        myFrame.setSize(400, 300);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLocationRelativeTo(null);

        JPanel myPanel = new JPanel();
        JButton sendButton = new JButton("Next ->");

        List<Customer> customers =  findCustomersUC.execute();

        JComboBox<String> myComboBox = new JComboBox<>();
        for (Customer customer : customers) {
            myComboBox.addItem(customer.getName());
        }
        
        // IdTypes.forEach(c -> myComboBox.add(c.getName(), myComboBox));

        myPanel.add(myComboBox);
        myPanel.add(sendButton);
        myFrame.add(myPanel);

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameCustomer = (String) myComboBox.getSelectedItem();
                Optional<Customer> customer = findCustomerByNameUC.execute(nameCustomer);
                deleteCustomerUC.execute(customer.get().getId());
                myFrame.dispose();
                JOptionPane.showMessageDialog(null, "Customer has been deleted...", null, JOptionPane.PLAIN_MESSAGE);
            }
        });

        myFrame.setVisible(true);
    }

    public Optional<Customer> FindCustomerById() {
        idCustomer = JOptionPane.showInputDialog(null, "Insert the id of the customer of id: ");
        Optional<Customer> customer = findCustomerByIdUC.execute(idCustomer);
        if (customer.isPresent()) {
            JOptionPane.showMessageDialog(null, "Customer founded:\nID: " + customer.get().getId() + "\nIDType: " + customer.get().getDocType() + "\nNombre: " + customer.get().getName() + "\nLastName: " + customer.get().getLastName() + "\nAge: " + customer.get().getAge() + "\nBirthDate: " + customer.get().getBirthdate() + "\nRegistration Date: " + customer.get().getRegdate() + "\nNeighborhood ID: " + customer.get().getIdNeighborhood(),
                    "Customer Info", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Customer not funded", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return customer;
    }

    public List<Customer> ListCustomers() {
        List<Customer> customers =  findCustomersUC.execute();
        showCustomersTable(customers);
        return customers;
    }

    public static void showCustomersTable(List<Customer> customers) {
        String[] columns = {"ID", "IDType", "Name", "LastName", "Age", "BirthDate", "RestrationDate", "NeighborhoodID"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        customers.forEach(customer -> {
            Object[] row = {customer.getId(), customer.getDocType(), customer.getName(), customer.getLastName(), customer.getAge(), customer.getBirthdate(), customer.getRegdate(), customer.getIdNeighborhood()};
            model.addRow(row);
        });

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);

        JOptionPane.showMessageDialog(null, panel, "Customers List", JOptionPane.PLAIN_MESSAGE);
    }

    // private ImageIcon resizeImage(String imagePath, int width, int height) {
    //     // Leer la imagen desde la URL
    //     // URL url = new URL(imagePath);
    //     // Image img = ImageIO.read(url);
    //     java.net.URL imgURL = getClass().getResource(imagePath);
    //     ImageIcon icon = new ImageIcon(imgURL);
    //     Image img = icon.getImage();
    //     // Redimensionar la imagen
    //     Image imgScaled = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    //     // Crear y devolver el ImageIcon redimensionado
    //     return new ImageIcon(imgScaled);
    // }
}
