import javax.swing.*;

public class InvoiceGUIRunner {
    public static void main(String[] args) {
        InvoiceDataCollector invoiceFrame = new InvoiceDataCollector();
        invoiceFrame.setTitle("Invoice Data Collector");
        invoiceFrame.setSize(600, 400);
        invoiceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        invoiceFrame.setVisible(true);
    }
}
