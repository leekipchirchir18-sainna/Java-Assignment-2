import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RadioButtonDemo extends JFrame implements ActionListener {
    private JRadioButton birdButton, catButton, dogButton, rabbitButton, pigButton;
    private ButtonGroup buttonGroup;
    private JLabel petImageLabel;

    public RadioButtonDemo() {
        // Set up the JFrame
        setTitle("RadioButtonDemo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(750, 350);
        setLocationRelativeTo(null);
        setResizable(false);

        // Create main panel with BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Create left panel for radio buttons
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBorder(BorderFactory.createTitledBorder("Select a Pet"));

        // Initialize radio buttons
        birdButton = new JRadioButton("Bird");
        catButton = new JRadioButton("Cat");
        dogButton = new JRadioButton("Dog");
        rabbitButton = new JRadioButton("Rabbit");
        pigButton = new JRadioButton("Pig");

        // Set Pig as default selected
        pigButton.setSelected(true);

        // Add action listeners to radio buttons
        birdButton.addActionListener(this);
        catButton.addActionListener(this);
        dogButton.addActionListener(this);
        rabbitButton.addActionListener(this);
        pigButton.addActionListener(this);

        // Create button group and add radio buttons
        buttonGroup = new ButtonGroup();
        buttonGroup.add(birdButton);
        buttonGroup.add(catButton);
        buttonGroup.add(dogButton);
        buttonGroup.add(rabbitButton);
        buttonGroup.add(pigButton);

        // Add radio buttons to left panel
        leftPanel.add(Box.createVerticalStrut(10));
        leftPanel.add(birdButton);
        leftPanel.add(Box.createVerticalStrut(10));
        leftPanel.add(catButton);
        leftPanel.add(Box.createVerticalStrut(10));
        leftPanel.add(dogButton);
        leftPanel.add(Box.createVerticalStrut(10));
        leftPanel.add(rabbitButton);
        leftPanel.add(Box.createVerticalStrut(10));
        leftPanel.add(pigButton);
        leftPanel.add(Box.createVerticalGlue());

        // Create right panel for image display
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BorderLayout());
        rightPanel.setBorder(BorderFactory.createTitledBorder("Pet Display"));

        // Create image label
        petImageLabel = new JLabel();
        petImageLabel.setHorizontalAlignment(JLabel.CENTER);
        petImageLabel.setVerticalAlignment(JLabel.CENTER);
        petImageLabel.setFont(new Font("Arial", Font.BOLD, 14));

        rightPanel.add(petImageLabel, BorderLayout.CENTER);

        // Add panels to main panel
        mainPanel.add(leftPanel, BorderLayout.WEST);
        mainPanel.add(rightPanel, BorderLayout.CENTER);

        // Add main panel to frame
        add(mainPanel);

        // Display initial pet (Pig)
        displayPet("Pig");

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (birdButton.isSelected()) {
            displayPet("Bird");
        } else if (catButton.isSelected()) {
            displayPet("Cat");
        } else if (dogButton.isSelected()) {
            displayPet("Dog");
        } else if (rabbitButton.isSelected()) {
            displayPet("Rabbit");
        } else if (pigButton.isSelected()) {
            displayPet("Pig");
        }
    }

    private void displayPet(String petName) {
        // Display a message box with the selected pet
        JOptionPane.showMessageDialog(this, 
            "You selected: " + petName, 
            "Pet Selection", 
            JOptionPane.INFORMATION_MESSAGE);

        // Update the image label
        petImageLabel.setText("🐾 " + petName + " 🐾");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RadioButtonDemo());
    }
}
