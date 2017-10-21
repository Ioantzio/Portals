package com.ian.portals.conntrollers;

import android.content.Context;

import com.ian.portals.data.GameSession;

/**
 * Created by Ian.
 */

public class MainController
{
    private DataController dataController;
    private GameplayController gameplayController;
    private GraphicsController graphicsController;
    private GameSession gameSession;
    private Context context;

    public MainController(Context cont)
    {
        setContext(cont);
        gameSession = new GameSession();

        dataController = new DataController();
        gameplayController = new GameplayController(this);
        graphicsController = new GraphicsController(this);
    }

    public DataController getDataController()
    {
        return dataController;
    }
    public GameplayController getGameplayController()
    {
        return gameplayController;
    }
    public GraphicsController getGraphicsController()
    {
        return graphicsController;
    }

    public GameSession getGameSession()
    {
        return gameSession;
    }
    public Context getContext()
    {
        return context;
    }
    private void setContext(Context context)
    {
        this.context = context;
    }
}
