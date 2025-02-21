import javax.swing.*;
import java.awt.*;

public class MainScreen {

    public static void start() {
        SwingUtilities.invokeLater(() -> {
            // Create the main window (frame)
            JFrame frame = new JFrame("Elf Village Creator");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 200);

            // Use a vertical layout for convenience
            frame.setLayout(new BorderLayout());

            // Center panel to hold our components
            JPanel centerPanel = new JPanel();
            centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
            
            // The prompt label
            JLabel promptLabel = new JLabel("How much elves will live in your city?");
            promptLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            // Add some vertical spacing
            centerPanel.add(Box.createVerticalGlue());
            centerPanel.add(promptLabel);
            centerPanel.add(Box.createVerticalStrut(20));

            // Panel for the text field and button
            JPanel inputPanel = new JPanel();
            inputPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

            JTextField elfCountField = new JTextField(10);
            JButton generateButton = new JButton("Generate a village");

            // Add listener to the button
            generateButton.addActionListener(e -> {
                String elfCountText = elfCountField.getText();
                try {
                    int elfCount = Integer.parseInt(elfCountText); // Parse the number of elves
                    System.out.println("Starting village with " + elfCount + " elves.");
                    Village.start(elfCount); // Pass elf count to Village.start()
                    frame.dispose(); // Close the MainScreen
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, 
                        "Please enter a valid number!", 
                        "Invalid Input", 
                        JOptionPane.ERROR_MESSAGE);
                }
            });

            inputPanel.add(elfCountField);
            inputPanel.add(generateButton);

            centerPanel.add(inputPanel);
            centerPanel.add(Box.createVerticalGlue());

            frame.add(centerPanel, BorderLayout.CENTER);

            // Center the frame on the screen
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}