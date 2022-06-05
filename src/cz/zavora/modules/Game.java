package cz.zavora.modules;

import cz.zavora.managers.GameManager;

public class Game {

    private GameManager manager;

    public Game(GameManager manager) {
        this.manager = manager;
    }
    public void start(){
        while (true) {
            try {
                Blackjack b = new Blackjack();
                break;
            } catch(Exception e) {
                System.out.println("Bohužel se někde stala chyba (unlucky). Hra začne znovu");
                System.exit(0);
            }
        }

    }
}
