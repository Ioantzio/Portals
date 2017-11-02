package com.ian.portals.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.ian.portals.R;
import com.ian.portals.conntrollers.MainController;
import com.ian.portals.data.GlobalVariables;
import com.ian.portals.data.Tile;
import com.ian.portals.miscellaneous.RandomNumberGenerator;

public class Game extends AppCompatActivity
{
    //Controllers
    private MainController mainController;

    //Variables for activity views
    private ImageView mapView;
    private ImageView diceView;

    //Variables for method 'onBackPressed'
    private static final int waitTime = 2000;
    private long mBackPressed;
    private Toast mExitToast;

    //Variables for startActivityForResult
    private final static int REQUEST_CODE_OK = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        initializeVariables();

        mainController.getGameSession().setDiceRoll(1);

        drawMap();
        drawDice();
    }

    @Override
    public void onBackPressed()
    {
        if(mBackPressed + waitTime > System.currentTimeMillis())
        {
            mExitToast.cancel();
            finish();
            super.onBackPressed();
            return;
        }
        else
        {
            mExitToast = Toast.makeText(getBaseContext(), R.string.TEXT_exit, Toast.LENGTH_SHORT);
            mExitToast.show();
        }
        mBackPressed = System.currentTimeMillis();
    }

    private void initializeVariables()
    {
        mainController = new MainController(this);

        mapView = (ImageView) findViewById(R.id.game);
        diceView = (ImageView) findViewById(R.id.dice);
    }

    private void drawMap()
    {
        mapView.setImageBitmap(mainController.getGraphicsController().getMapToDraw());
    }

    private void drawDice()
    {
        diceView.setImageBitmap(mainController.getGraphicsController().getDiceToDraw());
    }

    private void showVictoryScreen()
    {
        startActivity(new Intent(Game.this, VictoryScreen.class));
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if(requestCode == REQUEST_CODE_OK && resultCode == RESULT_OK)
        {
            int result = mainController.getGameplayController().checkAnswer();
            mainController.getGameSession().increaseNumberOfQuestions();

            switch(result)
            {
                case -1:
                    Toast.makeText(this, R.string.TEXT_wrongAnswer, Toast.LENGTH_SHORT).show();
                    break;
                case 0:
                    mainController.getGameSession().increaseNumberOfCorrectAnswers();
                    mainController.getGameSession().getAvatar().setPosition(mainController.getDataController().getWidthTilesCount()*mainController.getDataController().getHeightTilesCount());
                    drawMap();
                    showVictoryScreen();
                    break;
                case 1:
                    mainController.getGameSession().increaseNumberOfCorrectAnswers();
                    Toast.makeText(this, R.string.TEXT_correctAnswer, Toast.LENGTH_SHORT).show();
                    if(mainController.getGameSession().isOnPortalTile())
                    {
                        mainController.getGameSession().increaseNumberOfPortalsUsed();
                        int portalTile;
                        do
                        {
                            portalTile = GlobalVariables.getPortalTilesList().get(new RandomNumberGenerator().generateNumber(0, GlobalVariables.getPortalTilesList().size(), true));
                        }
                        while(portalTile == mainController.getGameSession().getAvatar().getPosition() + mainController.getGameSession().getDiceRoll());

                        mainController.getGameSession().getAvatar().setPosition(portalTile);
                        mainController.getGameSession().setOnPortalTile(false);
                    }
                    drawMap();
                    break;
                default:
                    drawMap();
                    break;
            }
        }
    }

    public void playOnClickEvent(View view)
    {
        mainController.getGameplayController().play();
        drawDice();

        if(mainController.getGameSession().isOnFreeTile())
        {
            Toast.makeText(this, R.string.TEXT_freeTile, Toast.LENGTH_SHORT).show();

            mainController.getGameSession().increaseNumberOfFreeTilesStepped();
            mainController.getGameSession().setOnFreeTile(false);
            drawMap();
        }
        else
        {
            if(GlobalVariables.getTileTypes().get(mainController.getGameSession().getAvatar().getPosition() + mainController.getGameSession().getDiceRoll()) == Tile.portal)
            {
                Toast.makeText(this, R.string.TEXT_portal, Toast.LENGTH_LONG).show();
            }
            startActivityForResult(new Intent(Game.this, QuestionDialog.class), REQUEST_CODE_OK);
        }
    }
}