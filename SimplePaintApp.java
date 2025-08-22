import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class SimplePaintApp extends JFrame {
    private Color currentColor = Color.BLACK; // Default color is black
    private final ArrayList<Point> points = new ArrayList<>(); // Store points
    private final ArrayList<Color> colors = new ArrayList<>(); // Store color for each point
    private final JLabel colorLabel = new JLabel("Current Color: ");
    private final JTextField colorTextField = new JTextField("#000000", 8);

    public SimplePaintApp() {
        setTitle("Simple Paint Application");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        // Create and add the control panel
        JPanel controlPanel = createControlPanel();
        add(controlPanel, BorderLayout.NORTH);
        // Create and add the drawing panel
        PaintPanel paintPanel = new PaintPanel();
        add(paintPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    // Method to create the control panel
    private JPanel createControlPanel() {
        JPanel controlPanel = new JPanel();
        JButton clearButton = new JButton("Clear Canvas");
        JButton colorButton = new JButton("Pick Color");
        JButton eraseButton = new JButton("Eraser");
        // Action Listener for "Clear Canvas"
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                points.clear();
                colors.clear();
                repaint();
            }
        });
        // Action Listener for "Pick Color"
        colorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color newColor = JColorChooser.showDialog(null, "Pick a Color", currentColor);
                if (newColor != null) {
                    currentColor = newColor;
                    updateColorDisplay();
                }
            }
        });
        // Action Listener for "Eraser"
        eraseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentColor = Color.WHITE; // Set current color to the background color
                updateColorDisplay();
            }
        });
        // Action Listener for "Hex Code Input"
        colorTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    currentColor = Color.decode(colorTextField.getText());
                    updateColorDisplay();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid color code. Use a hex code, e.g., #FF5733.");
                }
            }
        });
        // Add components to the control panel
        controlPanel.add(clearButton);
        controlPanel.add(colorButton);
        controlPanel.add(eraseButton);
        controlPanel.add(colorLabel);
        controlPanel.add(colorTextField);
        return controlPanel;
    }

    // Method to update the color label to reflect the current color
    private void updateColorDisplay() {
        colorLabel.setText("Current Color: ");
        colorLabel.setForeground(currentColor);
    }

    // Inner class for the drawing panel
    private class PaintPanel extends JPanel {
        public PaintPanel() {
            setBackground(Color.WHITE);
            // Add mouse listeners for drawing
            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    points.add(e.getPoint());
                    colors.add(currentColor);
                    repaint();
                }
            });
            addMouseMotionListener(new MouseMotionAdapter() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    points.add(e.getPoint());
                    colors.add(currentColor);
                    repaint();
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (int i = 0; i < points.size(); i++) {
                g.setColor(colors.get(i));
                g.fillOval(points.get(i).x, points.get(i).y, 8, 8); // Slightly larger dots for better visibility
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SimplePaintApp::new);
    }
}