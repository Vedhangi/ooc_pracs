package ass;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SimpleHouseDesign extends JPanel implements ActionListener {
    private Timer timer;

    // Enum to represent the different rooms
    private enum Room {
        LIVING_ROOM, KITCHEN, BEDROOM, OUTSIDE , BATHROOM
    }

    // Current room
    private Room currentRoom = Room.OUTSIDE;

    public SimpleHouseDesign() {
        timer = new Timer(100, this);
        timer.start();
        setFocusable(true);
        addKeyListener(new CustomKeyListener());
    }

    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

         // Display the house exterior
         //ooutside 
    if (currentRoom == Room.OUTSIDE) {
        // Fill color for the outside of the house
        g.setColor(new Color(173, 216, 230)); // Pastel Blue
        g.fillRect(20, 20, 200, 200);
        // Draw the roof
        int[] xPoints = { 20, 120, 220 };
        int[] yPoints = { 20, 5, 20 };
        g.setColor(new Color(139, 69, 19)); // Brown
        g.fillPolygon(xPoints, yPoints, 3);
        // Draw the front door
        g.setColor(new Color(139, 69, 19)); // Brown
        g.fillRect(100, 100, 40, 120);
        // Label the front door
        g.setColor(Color.BLACK);
        g.drawString("Front Door", 105, 230);
        // Add the house name above the front door
        g.setFont(new Font("Arial", Font.BOLD, 10));
        g.setColor(Color.BLACK);
        g.drawString("home sweet home", 70, 60);
        // Initial instruction to enter the house
        g.drawString("Press 'I' to enter the house.", 10, 260);
    }

        // Display inside the house (living room)
        else if (currentRoom == Room.LIVING_ROOM) {
            // Fill color for the living room
            g.setColor(new Color(255, 215, 0)); // Gold (changed color to gold)
            g.fillRect(20, 20, 200, 200);

            g.setColor(new Color(135, 206, 235)); // Sky blue
            g.fillRect(50, 50, 60, 60);
            // Label the window
            g.setColor(Color.BLACK);
            g.drawString("Window", 75, 130);
            // Draw a sofa
            g.setColor(new Color(255, 165, 0)); // Orange
            g.fillRect(140, 140, 60, 40);
            // Label the sofa
            g.setColor(Color.BLACK);
            g.drawString("Sofa", 145, 185);
            // Draw a coffee table
            g.setColor(new Color(139, 69, 19)); // Brown
            g.fillRect(70, 170, 40, 20);
            // Label the coffee table
            g.setColor(Color.BLACK);
            g.drawString("Coffee Table", 70, 195);
            // Draw a TV
            g.setColor(Color.BLACK);
            g.fillRect(160, 50, 20, 20);
            // Label the TV
            g.setColor(Color.WHITE);
            g.drawString("TV", 160, 75);
            // Label for navigation
            g.setColor(Color.BLACK);
            g.drawString("Press 'K' to go to the kitchen.", 10, 260);
            g.drawString("Press 'B' to go to the bedroom.", 10, 280);
            g.drawString("Press 'O' to go outside.", 10, 300);
            // Labels for bedroom and kitchen in the living room
            g.setColor(Color.BLACK);
            g.drawString("Bedroom", 20, 100);
            g.drawString("Kitchen", 160, 100);
            // Border area rectangle for living room
            g.setColor(new Color(0, 128, 0)); // Green
            g.drawRect(20, 20, 200, 200);
        }
        // Display the kitchen
        else if (currentRoom == Room.KITCHEN) {
            // Fill color for the kitchen
            g.setColor(new Color(244, 164, 96)); // Sandy brown (changed color to sandy brown)
            g.fillRect(20, 20, 200, 200);
            // Draw a refrigerator
            g.setColor(Color.WHITE);
            g.fillRect(50, 100, 40, 80);
            // Label the refrigerator
            g.setColor(Color.BLACK);
            g.drawString("Refrigerator", 50, 190);
            // Draw a table
            g.setColor(new Color(139, 69, 19)); // Brown
            g.fillRect(130, 150, 60, 30);
            // Label the table
            g.setColor(Color.WHITE);
            g.drawString("Table", 150, 175);
            // Draw a chair
            g.setColor(new Color(255, 165, 0)); // Orange
            g.fillRect(140, 130, 40, 20);
            // Label the chair
            g.setColor(Color.BLACK);
            g.drawString("Chair", 145, 155);
            // Border area rectangle for the kitchen
            g.setColor(new Color(0, 128, 0)); // Green
            g.drawRect(20, 20, 200, 200);
            // Cupboard shape in the kitchen
            g.setColor(new Color(139, 69, 19)); // Brown
            g.fillRect(120, 20, 100, 80);
            // Label for the cooking area above the refrigerator
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.BOLD, 12));
            g.drawString("Cooking Area", 120, 40);
            // Comment indicating you can switch to the living room
            g.setColor(Color.BLACK);
            g.drawString("Press 'K' to go to the living room.", 10, 260);
        }
        // Display the bedroom
        else if (currentRoom == Room.BEDROOM) {
            // Fill color for the bedroom
            g.setColor(new Color(255, 192, 203)); // Pink (changed color to pink)
            g.fillRect(20, 20, 200, 200);

            g.setColor(new Color(176, 48, 96)); // Dark pink (changed color to dark pink)
            g.fillRect(50, 120, 120, 60);

            g.setColor(new Color(139, 69, 19)); // Brown
            g.fillRect(70, 40, 60, 80);
            // Label for bed
            g.setColor(Color.BLACK);
            g.drawString("Bed", 110, 185);
            // Label for cupboard
            g.drawString("Cupboard", 75, 25);
            // Add a window to the bedroom
            g.setColor(new Color(135, 206, 235)); // Sky blue
            g.fillRect(20, 50, 60, 60);
            // Label for window
            g.setColor(Color.BLACK);
            g.drawString("Window", 45, 80);
            // Label for bathroom
            g.setColor(Color.BLACK);
            g.drawString("Bathroom", 160, 120);
            // Label for navigation
            g.setColor(Color.BLACK);
            g.drawString("Press 'B' to go to the living room.", 10, 260);
            g.drawString("Press 'A' to go to the bathroom", 10, 280);
            // Border area rectangle for the bedroom
            g.setColor(new Color(0, 128, 0)); // Green
            g.drawRect(20, 20, 200, 200);
        }
        else if (currentRoom == Room.BATHROOM)    {
            // Display the bathroom

    // Fill color for the bathroom
    g.setColor(new Color(192, 192, 192)); // Light Gray
    g.fillRect(20, 20, 200, 200);

    // Bathtub
    g.setColor(new Color(255, 105, 180)); // Pink (you can change this to another color)
    g.fillRect(50, 120, 120, 60);
    g.setColor(Color.BLACK);
    g.drawString("Bathtub", 80, 180);

    // Sink
    g.setColor(new Color(0, 128, 128)); // Teal (you can change this to another color)
    g.fillRect(60, 40, 40, 20);
    g.setColor(Color.BLACK);
    g.drawString("Sink", 70, 60);

    // Mirror
    g.setColor(new Color(192, 192, 192)); // Light Gray (you can change this to another color)
    g.fillRect(130, 40, 40, 40);
    g.setColor(Color.BLACK);
    g.drawString("Mirror", 140, 60);

    // Toilet
    g.setColor(new Color(255, 255, 255)); // White (you can change this to another color)
    g.fillRect(160, 120, 20, 40);
    g.setColor(Color.BLACK);
    g.drawString("Toilet", 165, 140);

    // Label for navigation
    g.setColor(Color.BLACK);
    g.drawString("Press 'A' to go back to the bedroom.", 10, 260);

    // Border area rectangle for the bathroom
    g.setColor(new Color(0, 128, 0)); // Green
    g.drawRect(20, 20, 200, 200);


        }
    }

    private class CustomKeyListener extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();

            // Switch between rooms based on user input
            switch (currentRoom) {
                case OUTSIDE:
                    if (keyCode == KeyEvent.VK_I) {
                        currentRoom = Room.LIVING_ROOM;
                    }
                    break;
                case LIVING_ROOM:
                    if (keyCode == KeyEvent.VK_K) {
                        currentRoom = Room.KITCHEN;
                    } else if (keyCode == KeyEvent.VK_B) {
                        currentRoom = Room.BEDROOM;
                    } else if (keyCode == KeyEvent.VK_O) {
                        currentRoom = Room.OUTSIDE;
                    }
                    // else if (keyCode == KeyEvent.VK_A) {
                    //     currentRoom = Room.BATHROOM;
                    // }
                    break;
                case KITCHEN:
                    if (keyCode == KeyEvent.VK_K) {
                        currentRoom = Room.LIVING_ROOM;
                    }
                    break;
                case BEDROOM:
                    if (keyCode == KeyEvent.VK_B) {
                        currentRoom = Room.LIVING_ROOM;
                    }
                    else if( keyCode == KeyEvent.VK_A) {
                        currentRoom = Room.BATHROOM;
                    }
                    
                    break;
                case BATHROOM:
                if(keyCode == KeyEvent.VK_A)
                {
                    currentRoom = Room.BEDROOM;
                }
                break;
            }
            repaint();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("My House");
            SimpleHouseDesign demo = new SimpleHouseDesign();
            frame.add(demo);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 360);
            frame.setVisible(true);
        });
    }
}