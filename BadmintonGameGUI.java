package ass;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BadmintonGameGUI extends JFrame {
    private JPanel courtPanel;
    private JButton player1Button;
    private JButton player2Button;
    private int player1Score = 0;
    private int player2Score = 0;
    private int shuttlecockX = 400;  // Initial shuttlecock position
    private int shuttlecockY = 200;  // Initial shuttlecock position
    private int shuttlecockSpeedX = 2;
    private int shuttlecockSpeedY = 2;

    public BadmintonGameGUI() {
        setTitle("Badminton Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);

        // Initialize the court panel
        courtPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Draw the badminton court, players, and shuttlecock
                g.setColor(Color.GREEN);
                g.fillRect(0, 0, getWidth(), getHeight());

                g.setColor(Color.BLACK);
                g.fillRect(10, getHeight() / 2 - 20, 20, 80); // Player 1
                g.fillRect(getWidth() - 30, getHeight() / 2 - 20, 20, 80); // Player 2

                g.setColor(Color.RED);
                g.fillOval(shuttlecockX, shuttlecockY, 20, 20); // Shuttlecock

                // Display scores
                g.setFont(new Font("Arial", Font.BOLD, 24));
                g.drawString("Player 1: " + player1Score, 50, 50);
                g.drawString("Player 2: " + player2Score, getWidth() - 200, 50);
            }
        };

        // Create player buttons
        player1Button = new JButton("Player 1 Hit");
        player2Button = new JButton("Player 2 Hit");

        // Add action listeners to player buttons
        player1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Simulate player 1 hitting the shuttlecock
                if (shuttlecockX < 30 && shuttlecockY >= getHeight() / 2 - 20 && shuttlecockY <= getHeight() / 2 + 60) {
                    player1Score++;
                }
                courtPanel.repaint();
            }
        });

        player2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Simulate player 2 hitting the shuttlecock
                if (shuttlecockX > getWidth() - 40 && shuttlecockY >= getHeight() / 2 - 20 && shuttlecockY <= getHeight() / 2 + 60) {
                    player2Score++;
                }
                courtPanel.repaint();
            }
        });

        // Set layout manager
        setLayout(new BorderLayout());

        // Add components to the frame
        add(courtPanel, BorderLayout.CENTER);
        add(player1Button, BorderLayout.WEST);
        add(player2Button, BorderLayout.EAST);

        // Create a game loop to move the shuttlecock
        Timer timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shuttlecockX += shuttlecockSpeedX;
                shuttlecockY += shuttlecockSpeedY;

                if (shuttlecockX <= 0 || shuttlecockX >= getWidth() - 20) {
                    shuttlecockSpeedX = -shuttlecockSpeedX;
                }

                if (shuttlecockY <= 0 || shuttlecockY >= getHeight() - 20) {
                    shuttlecockSpeedY = -shuttlecockSpeedY;
                }

                courtPanel.repaint();
            }
        });
        timer.start();

        // Display the frame
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new BadmintonGameGUI();
        });
    }
}
