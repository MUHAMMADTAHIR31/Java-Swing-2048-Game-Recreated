
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Game implements Runnable {

    static final Color BG_COLOR = new Color(250, 248, 239);

    public void run() {
		
		JFrame frame = new JFrame();
        frame.setTitle("2048");
		
		frame.setSize(600, 750);
		frame.setResizable(false);
		
		GameBoard board = new GameBoard();
        frame.add(board, BorderLayout.CENTER);

		final ControlPanel control_panel = new ControlPanel(board);
        frame.add(control_panel, BorderLayout.NORTH);

        frame.getContentPane().setBackground(BG_COLOR);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
		board.newGame(); 
    }
	
    /**
     * Main method run to start and run the game. Initializes the GUI elements
     * specified in Game and runs it. IMPORTANT: Do NOT delete! You MUST include
     * this in your final submission.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Game());
    }
}