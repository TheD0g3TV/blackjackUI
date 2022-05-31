package cz.zavora.ui;

import cz.zavora.managers.GameManager;
import cz.zavora.modules.Game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class TitleUI extends JFrame implements ActionListener {
    private GameManager manager;
    JPanel mainPanel;
    JButton buttonStart;
    JButton buttonExit;
    JLabel bg;
    boolean close = false;
    boolean exit = false;

    public TitleUI(GameManager manager) throws HeadlessException, IOException {
        this.manager = manager;
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);
        this.setTitle("BLACKJACK");
        this.setLocationRelativeTo(null);
        this.setIconImage(ImageIO.read(new File("pics/icon.png")));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        title();

        // action listener
        manager.setGameUI(new GameUI(manager));
        manager.setGame(new Game(manager));
        this.dispose();
        //


        this.setVisible(true);
        this.validate();
        this.pack();
    }

    public void title() throws IOException {
        mainPanel = new JPanel();
        buttonStart = new JButton();
        buttonExit = new JButton();
        bg = new JLabel();
        mainPanel.add(buttonSetup(buttonStart, "Start", "pics/start.png", 500, 300, 180, 50));
        mainPanel.add(buttonSetup(buttonExit, "Exit", "pics/exit.png", 500, 300, 180, 50));
        bg.setIcon(new ImageIcon(ImageIO.read(new File("pics/bg.jpg"))));
        mainPanel.add(bg);
        bg.setBounds(0, 0, 1920, 1080);
        mainPanel.setOpaque(true);
        mainPanel.setVisible(true);
        this.setContentPane(mainPanel);
    }

    public JButton buttonSetup(JButton but, String name, String filename, int x, int y, int width, int height) {
        but.setText(name);
        but.setFocusable(false);
        but.setIcon(new ImageIcon(filename));
        but.setBounds(x, y, width, height);
        but.setBackground(Color.white);
        but.setForeground(Color.black);
        but.setFont(new Font("Arial", Font.BOLD, 30));
        but.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        but.addActionListener(this);
        but.setVisible(true);
        return but;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonExit) {
            dispose();
            System.exit(0);
        }
        if (e.getSource() == buttonStart) {
            dispose();
                manager.createLoadingUI();
                manager.getLoadingUI().setVisible(true);
        }
    }

    public boolean isClose() {
        return close;
    }

    public boolean isExit() {
        return exit;
    }
}
