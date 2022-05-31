package cz.zavora.ui;

import cz.zavora.managers.GameManager;
import cz.zavora.modules.Game;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


public class LoadingUI extends JFrame {
    private GameManager manager;
    JLabel loadingLabel;
    Clip clip;
    AudioInputStream ais;

    public LoadingUI(GameManager manager) {
        loadingLabel = new JLabel();
        loadingLabel.setText("Loading...");
        loadingLabel.setForeground(Color.WHITE);
        loadingLabel.setBackground(Color.BLACK);
        loadingLabel.setOpaque(true);
        loadingLabel.setVerticalAlignment(JLabel.CENTER);
        loadingLabel.setHorizontalAlignment(JLabel.CENTER);
        loadingLabel.setFont(new Font("Arial", Font.BOLD, 100));

        this.manager = manager;
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setTitle("BLACKJACK");
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
        this.add(loadingLabel);

        this.setVisible(true);
    }

    public void start() {

        playMusic();

        long currentTime = System.currentTimeMillis();

        while (true) {
            if (System.currentTimeMillis() > clip.getMicrosecondLength() / 1000 + currentTime) {
                dispose();
                manager.createGameUI();
                manager.getGameUI().setVisible(true);
                return;
            }
        }
    }

    public void playMusic() {
        try {
            ais = AudioSystem.getAudioInputStream(new File("music/game_start.wav"));
            clip = AudioSystem.getClip();
            clip.open(ais);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }

        clip.start();

    }
}
