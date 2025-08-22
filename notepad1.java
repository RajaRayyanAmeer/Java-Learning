import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class notepad1 extends JFrame {
    public static void main(String[] args) {
        // frame
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setTitle("Notepad App in Java");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextArea textArea = new JTextArea();// add text area
        JScrollPane scrollPane = new JScrollPane(textArea); // Add scroll pane
        frame.add(scrollPane, BorderLayout.CENTER);
        // file menu
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);
        frame.setVisible(true);
        // sub-items for the "File" menu
        JMenuItem newItem = new JMenuItem("New");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem exitItem = new JMenuItem("Exit");
        // Adding sub-items to the "File" menu
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.addSeparator(); // Adds a separator line
        fileMenu.add(exitItem);
        // Action listeners for file menu
        newItem.addActionListener(new ActionListener() {// new menuitem
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(""); // Clear the text area for a new file
                JOptionPane.showMessageDialog(null, "New file created.");
            }
        });
        openItem.addActionListener(new ActionListener() {// openmenuitem
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                        textArea.setText(""); // Clear existing text
                        String line;
                        while ((line = reader.readLine()) != null) {
                            textArea.append(line + "\n");
                        }
                        JOptionPane.showMessageDialog(null, "File opened successfully.");
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Error opening file: " + ex.getMessage());
                    }
                }
            }
        });
        saveItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showSaveDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                        writer.write(textArea.getText());
                        JOptionPane.showMessageDialog(null, "File saved successfully.");
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Error saving file: " + ex.getMessage());
                    }
                }
            }
        });
        exitItem.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "EXit ");
            }
        }));
        // edit menu
        JMenu editMenu = new JMenu("Edit");
        menuBar.add(editMenu);
        frame.setJMenuBar(menuBar);
        frame.setVisible(true);
        // sub-items for the "Edit" menu
        JMenuItem cutItem = new JMenuItem("Cut");
        JMenuItem copyItem = new JMenuItem("Copy");
        JMenuItem pasteItem = new JMenuItem("Paste");
        // Adding sub-items to the "Edit" menu
        editMenu.add(cutItem);
        editMenu.add(copyItem);
        editMenu.add(pasteItem);
        // Action listener
        cutItem.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.cut();
                JOptionPane.showMessageDialog(null, "Text has been cut ");
            }
        }));
        copyItem.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.copy();
                JOptionPane.showMessageDialog(null, "Text has been copy ");
            }
        }));
        pasteItem.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.paste();
                JOptionPane.showMessageDialog(null, "Text has been paste ");
            }
        }));
        // help menu
        JMenu helpMenu = new JMenu("Help");
        menuBar.add(helpMenu);
        frame.setJMenuBar(menuBar);
        frame.setVisible(true);
        // sub-items for the "Edit" menu
        JMenuItem aboutItem = new JMenuItem("about");
        // Adding sub-items to the "Edit" menu
        helpMenu.add(aboutItem);
        // action listener
        aboutItem.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "This is the notepad application using java."
                        + " you can write your data in space given and perform different functions on it!!");
            }
        }));
    }
}