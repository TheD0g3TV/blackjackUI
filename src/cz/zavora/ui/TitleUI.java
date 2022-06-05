package cz.zavora.ui;

import cz.zavora.managers.GameManager;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class TitleUI extends JFrame implements ActionListener {
    private final GameManager manager;
    JLabel mainPanel;
    JButton buttonStart;
    JButton buttonExit;
    Clip clip;
    AudioInputStream ais;
    JLabel TitleText;

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
        playMusic();

        this.setVisible(true);
        this.validate();
        this.pack();
    }

    public void title() throws IOException {
        mainPanel = new JLabel();
        buttonStart = new JButton();
        buttonExit = new JButton();

        mainPanel.add(buttonSetup(buttonStart, "Start", "pics/start.png", 750, 900, 180, 50));
        mainPanel.add(buttonSetup(buttonExit, "Exit", "pics/exit.png", 990, 900, 180, 50));
        mainPanel.setOpaque(true);
        mainPanel.setVisible(true);
        mainPanel.setIcon(new ImageIcon(ImageIO.read(new File("pics/bg.jpg"))));
        mainPanel.setBounds(0, 0, 1920, 1080);

        TitleText = new JLabel();
        TitleText.setText("Welcome to BLACKJACK");
        TitleText.setFont(new Font("Arial", Font.BOLD, 80));
        TitleText.setBounds(460,440,1000,100);
        mainPanel.add(TitleText);

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
            clip.stop();
            dispose();
            System.exit(0);
        }
        if (e.getSource() == buttonStart) {
            dispose();
            clip.stop();
            manager.createLoadingUI();
            manager.getLoadingUI().setVisible(true);
        }
    }

    public void playMusic() {
        try {
            ais = AudioSystem.getAudioInputStream(new File("music/main_theme.wav"));
            clip = AudioSystem.getClip();
            clip.open(ais);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }

        clip.start();
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
}
