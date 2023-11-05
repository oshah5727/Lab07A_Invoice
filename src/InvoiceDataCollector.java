import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class InvoiceDataCollector extends JFrame {
    private JLabel itemInputLbl;
    private JLabel priceInputLbl;
    private JLabel quantityInputLbl;
    private JLabel titleInputLbl;

    private JLabel streetInputLbl;

    private JLabel cityInputLbl;

    private JLabel stateInputLbl;

    private JLabel zipInputLbl;
    private JTextField itemInputFld;
    private JTextField priceInputFld;
    private JTextField quantityInputFld;

    private JTextField titleInputFld;

    private JTextField streetInputFld;

    private JTextField cityInputFld;

    private JTextField stateInputFld;

    private JTextField zipInputFld;

    private JTextArea invoiceDisplayTA;

    private Invoice invoice;

    private String custAddTitle;

    private String custAddStreet;

    private String custAddCity;

    private String custAddState;

    private int custAddZipCode;

    public InvoiceDataCollector() {

        setLayout(new GridLayout());

        JPanel inputPanel = createInputPanel();
        invoiceDisplayTA = new JTextArea(10, 20);
        invoiceDisplayTA.setEditable(false);


        add(new JScrollPane(invoiceDisplayTA), BorderLayout.NORTH);
        add(inputPanel, BorderLayout.SOUTH);

        invoice = new Invoice(new LineItem(0, new Product("", 0.0), 0.0),
               new CustomerAddress("", "", "", "", 0),
               0.0);
    }

    private JPanel createInputPanel() {
        JPanel inputPanel = new JPanel(new GridLayout(0,2));

        itemInputLbl = new JLabel("Item:");
        quantityInputLbl = new JLabel("Quantity:");
        priceInputLbl = new JLabel("Price:");
        titleInputLbl = new JLabel("Title:");
        streetInputLbl = new JLabel("Street:");
        cityInputLbl = new JLabel("City:");
        stateInputLbl = new JLabel("State:");
        zipInputLbl = new JLabel("Zip Code:");

        itemInputFld = new JTextField();
        quantityInputFld = new JTextField();
        priceInputFld = new JTextField();
        titleInputFld = new JTextField();
        streetInputFld = new JTextField();
        cityInputFld = new JTextField();
        stateInputFld = new JTextField();
        zipInputFld = new JTextField();

        JButton addToInvoiceBtn = new JButton("Add to Invoice");
        addToInvoiceBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addToInvoice();
            }
        });

        inputPanel.add(itemInputLbl);
        inputPanel.add(itemInputFld);
        inputPanel.add(quantityInputLbl);
        inputPanel.add(quantityInputFld);
        inputPanel.add(priceInputLbl);
        inputPanel.add(priceInputFld);
        inputPanel.add(titleInputLbl);
        inputPanel.add(titleInputFld);
        inputPanel.add(streetInputLbl);
        inputPanel.add(streetInputFld);
        inputPanel.add(cityInputLbl);
        inputPanel.add(cityInputFld);
        inputPanel.add(stateInputLbl);
        inputPanel.add(stateInputFld);
        inputPanel.add(zipInputLbl);
        inputPanel.add(zipInputFld);

        inputPanel.add(new JLabel());
        inputPanel.add(addToInvoiceBtn);

        return inputPanel;
    }

    private void addToInvoice() {

        String itemName = itemInputFld.getText();
        int quantity = Integer.parseInt(quantityInputFld.getText());
        double unitPrice = Double.parseDouble(priceInputFld.getText());
        custAddTitle = titleInputFld.getText();
        custAddStreet = streetInputFld.getText();
        custAddCity = cityInputFld.getText();
        custAddState = stateInputFld.getText();
        custAddZipCode = Integer.parseInt(zipInputFld.getText());

        invoice.setLineItem(new LineItem(quantity, new Product(itemName, unitPrice), unitPrice));
        invoice.setAmountDue(quantity * unitPrice);
        displayInvoice();
    }

        private void displayInvoice() {
            StringBuilder invoiceText = new StringBuilder();
            Font titleFont = new Font("Arial", Font.BOLD, 10);

            invoiceDisplayTA.setText("");
            invoiceDisplayTA.setFont(titleFont);

            invoiceText.append("INVOICE\n");

            CustomerAddress customerAddress = new CustomerAddress(custAddTitle, custAddStreet, custAddCity, custAddState, custAddZipCode);
            invoiceText.append(customerAddress.getTitle() + "\n");
            invoiceText.append(customerAddress.getStreet() + "\n");
            invoiceText.append(customerAddress.getCity() + ", ").append(customerAddress.getState() + " ").append(customerAddress.getZip() + "\n");

            invoiceText.append("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");


            LineItem lineItem = invoice.getLineItem();
            Product product = lineItem.getProduct();
            invoiceText.append("Item").append("\t\t\t\t").append(" Qty").append("\t\t").append("Price").append("\t\t").append("Total").append("\n");
            invoiceText.append(product.getName()).append("\t\t\t\t").append(lineItem.getQuantity()).append("\t\t").append(product.getUnitPrice()).append("\t\t").append(lineItem.calculateLineItemTotal()).append("\n");
            invoiceText.append("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
            invoiceText.append("AMOUNT DUE: $" + invoice.getAmountDue() + "\n");

            invoiceDisplayTA.setText(invoiceText.toString());

        }
    }
