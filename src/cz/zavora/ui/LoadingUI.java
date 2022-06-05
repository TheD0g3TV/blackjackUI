package cz.zavora.ui;

import cz.zavora.managers.GameManager;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;


public class LoadingUI extends JFrame {
    private final GameManager manager;
    JLabel loadingLabel;
    Clip clip;
    AudioInputStream ais;
    Timer timer;

    public LoadingUI(GameManager manager) throws IOException {
        loadingLabel = new JLabel();
        loadingLabel.setText("Loading...");
        loadingLabel.setForeground(Color.WHITE);
        loadingLabel.setBackground(Color.BLACK);
        loadingLabel.setOpaque(true);
        loadingLabel.setVerticalAlignment(JLabel.CENTER);
        loadingLabel.setHorizontalAlignment(JLabel.CENTER);
        loadingLabel.setFont(new Font("Arial", Font.BOLD, 100));

        this.setIconImage(ImageIO.read(new File("pics/icon.png")));
        this.manager = manager;
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setTitle("BLACKJACK");
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
        this.add(loadingLabel);
        this.setVisible(true);
        start();


    }

    public void start() {
        playMusic();
        timer = new Timer(6000, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                clip.stop();
                dispose();
                manager.createGameUI();
                manager.getGameUI().setVisible(true);
            }
        });
        timer.setRepeats(false);
        timer.start();

    }

    public void playMusic() {
        try {
            ais = AudioSystem.getAudioInputStream(new File("music/game_start.wav"));
            clip = AudioSystem.getClip();
            clip.open(ais);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }

        clip.start();
    }
}
