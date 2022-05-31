package cz.zavora.managers;

import cz.zavora.modules.Game;
import cz.zavora.ui.GameUI;
import cz.zavora.ui.LoadingUI;
import cz.zavora.ui.TitleUI;

import java.io.IOException;

public class GameManager {
    private Game game;
    private TitleUI titleUI;
    private GameUI gameUI;
    private LoadingUI loadingUI;

    public GameManager() throws IOException {
        this.titleUI = new TitleUI(this);
    }

    public LoadingUI getLoadingUI() {
        return loadingUI;
    }

    public void createLoadingUI() {
        this.loadingUI = new LoadingUI(this);
        this.loadingUI.start();
    }

    public void createGameUI() {
        this.gameUI = new GameUI(this);
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public TitleUI getTitle() {
        return titleUI;
    }

    public void setTitle(TitleUI titleUI) {
        this.titleUI = titleUI;
    }

    public GameUI getGameUI() {
        return gameUI;
    }

    public void setGameUI(GameUI gameUI) {
        this.gameUI = gameUI;
    }
}
