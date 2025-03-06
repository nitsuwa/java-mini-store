import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Module1CaseStudy2BSIT14AllNighters {

    // Instance variables
    private JFrame mainMenu;
    private JButton buyButton, paymentButton, inventoryButton, exitButton;
	private ArrayList<Product> items;

    public static void main(String[] args) {
        Module1CaseStudy2BSIT14AllNighters program = new Module1CaseStudy2BSIT14AllNighters();
        program.mainScreen();
    }

    public void mainScreen() {
        mainMenu = new JFrame("The Java Mini Store");
        mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainMenu.setSize(420, 420);
        mainMenu.setResizable(false);
		mainMenu.setLocationRelativeTo(null);
        mainMenu.setLayout(new BorderLayout());

        // To create buttons
        buyButton = new JButton("Buy");
        buyButton.setFocusable(false);
		buyButton.addActionListener(e -> buyMenu());
		
        paymentButton = new JButton("Payment");
        paymentButton.setFocusable(false);
		paymentButton.addActionListener(e -> paymentMenu());
		
        inventoryButton = new JButton("Inventory");
        inventoryButton.setFocusable(false);
		inventoryButton.addActionListener(e -> inventoryMenu());
		
        exitButton = new JButton("Exit");
        exitButton.setFocusable(false);
		exitButton.addActionListener(e -> exitProgram());
		

        // Panel to hold the buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(buyButton);
        buttonPanel.add(paymentButton);
        buttonPanel.add(inventoryButton);
        buttonPanel.add(exitButton);
        mainMenu.add(buttonPanel, BorderLayout.SOUTH);

        // Header for mainMenu
        JLabel headerLabel = new JLabel("Welcome to our Mini Store :) ", JLabel.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        headerLabel.setBorder(BorderFactory.createEmptyBorder(15, 10, 10, 10)); // border ng title
        mainMenu.add(headerLabel, BorderLayout.NORTH);
		
		// To display item list
        JEditorPane itemList = new JEditorPane();
        itemList.setContentType("text/html"); // Set content type to HTML
        itemList.setText(generateProductListHTML());
        itemList.setEditable(false);
        mainMenu.add(new JScrollPane(itemList), BorderLayout.CENTER);
		
		// Create a Box container for vertical centering (rsj)
		Box verticalBox = Box.createVerticalBox();
		verticalBox.add(Box.createVerticalGlue()); // Add vertical glue above the table
		verticalBox.add(new JScrollPane(itemList)); // Add the table to the vertical box
		verticalBox.add(Box.createVerticalGlue()); // Add vertical glue below the table

		// Add components to mainMenu (rsj)
		mainMenu.add(headerLabel, BorderLayout.NORTH);
		mainMenu.add(verticalBox, BorderLayout.CENTER); // Add the vertical box to the CENTER region
		mainMenu.add(buttonPanel, BorderLayout.SOUTH);
	
        mainMenu.setVisible(true);
    }
	
	// FORMAT OF ITEM LIST (rsj)
	private String generateProductListHTML() {
	String html = "<html><body><br><table border='1' align='center'>";
	html += "<tr><th align='center'>Product Code</th><th align='center'>Product Description</th><th align='center'>Price</th></tr>";
	for (Product product : items) {
		html += "<tr>";
		html += "<td align='center'>" + product.code + "</td>";
		html += "<td align='center'>" + product.description + "</td>";
		html += "<td align='center'>" + product.price + "</td>";
		html += "</tr>";
	}
	html += "</table></body></html>";
	return html;
	}
	
    public void buyMenu() {
		System.out.println();
    }

    public void paymentMenu() {
    }
	
	public void inventoryMenu() {
		
	}
	
	public void exitProgram() {
		JOptionPane.showMessageDialog(null, "Thank you for shopping!");
		System.exit(0);
	}
	
	// Initialize items in the item list (rsj)
	public Module1CaseStudy2BSIT14AllNighters() {
		items = new ArrayList<>();
        items.add(new Product("A", "3-in-1 coffee", 10.00, 100));
        items.add(new Product("B", "Cup noodles", 20.00, 36));
		items.add(new Product("C", "Laundry soap", 25.00, 15));
		items.add(new Product("D", "Bottled water - 1 liter", 20.00, 8)); 
		items.add(new Product("E", "Bottled water - 500 ml", 12.00, 24));
	}
	
	// Data format for items (rsj)
	public class Product {
		String code;
		String description;
		double price;
		int amount;
		
		public Product(String code, String description, double price, int amount) {
			this.code = code;
			this.description = description;
			this.price = price;
			this.amount = amount;
		}
	}
}
