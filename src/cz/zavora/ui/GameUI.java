package cz.zavora.ui;

import cz.zavora.managers.GameManager;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class GameUI extends JFrame implements ActionListener {

    JLabel mainPanel;
    JButton buttonExit;
    JButton buttonHit;
    JButton buttonStand;
    Clip win;
    Clip lost;
    Clip gameMusic;
    AudioInputStream ais;
    JLabel handPlayer;
    JLabel handOpponent;

    public GameUI(GameManager manager) throws IOException {

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.getContentPane().setBackground(Color.black);
        this.setUndecorated(true);
        this.setTitle("BLACKJACK");
        this.setLocationRelativeTo(null);
        this.setIconImage(ImageIO.read(new File("pics/icon.png")));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        visuals();
    }

    public void visuals() {

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
            gameMusic.stop();
            win.stop();
            lost.stop();
            dispose();
            System.exit(0);
        }

    }

    public Clip getWin() {
        return win;
    }

    public void setWin(Clip win) {
        this.win = win;
    }

    public Clip getLost() {
        return lost;
    }

    public void setLost(Clip lost) {
        this.lost = lost;
    }

    public Clip getGameMusic() {
        return gameMusic;
    }

    public void setGameMusic(Clip gameMusic) {
        this.gameMusic = gameMusic;
    }
}
