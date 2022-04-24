import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;


public class ControlPanel extends JPanel {

    private static final Color TITLE_COLOR = new Color(199, 40, 40);
    private static JLabel scoreLabel;
    private static JLabel bestScoreLabel;

    public ControlPanel(GameBoard board) {
        setBackground(Game.BG_COLOR);
        setPreferredSize(new Dimension(600, 150));
        setLayout(null);

        final JPanel sidePanel = new JPanel(new GridLayout(2, 0, 0, 0));
        Font font = new Font("Arial", Font.BOLD, 16);

        // Display score
        scoreLabel = new JLabel("Score: 0");
        scoreLabel.setForeground(TITLE_COLOR);
        scoreLabel.setFont(font);
		sidePanel.add(scoreLabel);

        
		// Display best score
        bestScoreLabel = new JLabel("Best: 0");
        bestScoreLabel.setForeground(TITLE_COLOR);
        bestScoreLabel.setFont(font);
        sidePanel.add(bestScoreLabel);
		
        // New game button
        final JButton reset = new JButton("New Game");
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                board.newGame();
            }
        });
		reset.setBounds(270, 90, 130, 30);
        add(reset);
        
		Font font1 = new Font("Arial", Font.BOLD, 11);
		
		JLabel logoLabel = new JLabel("Join the tiles bet the 2048!");
        logoLabel.setFont(font1);
		logoLabel.setBounds(55, 80, 150, 30);
        add(logoLabel);
		
		
		//instructions window
		final JButton howtoPlay = new JButton("How to Play ->");
        howtoPlay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"HOW TO PLAY: Use your arrow keys to move the tiles."
					+"\nEverytime you move one, another tile pops up in a random manner anywhere in the box."
					+"\nWhen two of the same tiles collide, they combine and give you one greater tile that displays the sum");  
					 board.newGame();
            }
        });
		howtoPlay.setBounds(50, 110, 130, 30);
        add(howtoPlay);
		
		
		
        // Undo move button
        final JButton undo = new JButton("Undo Move");
        undo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                board.undo();
            }
        });
		
		undo.setBounds(430, 90, 130, 30);
        add(undo);
		
		sidePanel.setBackground(Game.BG_COLOR);
        sidePanel.setBounds(430, 20, 130, 60);
        add(sidePanel);
    }

    @Override
    public void paintComponent(Graphics g) {
        Font font = new Font("Arial", Font.BOLD, 80);

        // Draw title text
        g.setColor(TITLE_COLOR);
        g.setFont(font);
        g.drawString("2048", 50, 80);
    }
	
	
    public static void setScore(int score) {
        scoreLabel.setText("Score: " + String.valueOf(score));
    }

    public static void setBestScore(int bestScore) {
        bestScoreLabel.setText("Best: " + String.valueOf(bestScore));
    }

}
