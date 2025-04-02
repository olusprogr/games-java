import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main extends JPanel implements ActionListener {
    
    private final int WIN_WIDTH = 800;
    private final int WIN_HEIGHT = 600;
    private final int BOX_SIZE = 20;
    
    private List<Point> squares;
    private boolean gameOver;
    private boolean botEnabled;
    private int difficulty;

    private Timer timer;

    public Main(Map<String, Integer> settings) {
        this.squares = new LinkedList<>();
        this.gameOver = false;
        this.botEnabled = settings.get("Bot enabled") == 1;
        this.difficulty = settings.get("Difficulty");

        setPreferredSize(new Dimension(WIN_WIDTH, WIN_HEIGHT));
        timer = new Timer(100, this);
        timer.start();
    }

    public void actionPerformed(ActionEvent e) {
        if (!gameOver) {
            repaint();
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        
        for (int i = 0; i < 8*difficulty; i++) {
           g.fillRect(100*i, 50, BOX_SIZE*4, BOX_SIZE); 
        }
    }

    private void restartGame() {
        this.gameOver = false;
        this.squares.clear();
        repaint();
    }

    public static void main(Map<String, Integer> settings) {
        JFrame frame = new JFrame("Snake Game");
        Main game = new Main(settings);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(game);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        game.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_R && game.gameOver) {
                    game.restartGame();
                }
            }
        });
        game.setFocusable(true);
    }
}
