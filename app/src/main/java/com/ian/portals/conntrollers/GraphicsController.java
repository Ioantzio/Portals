package com.ian.portals.conntrollers;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build;

import com.ian.portals.R;
import com.ian.portals.data.GameSession;
import com.ian.portals.miscellaneous.DisplayMetrics;
import com.ian.portals.miscellaneous.ImageSelector;
import com.ian.portals.models.Avatar;
import com.ian.portals.models.Point;

/**
 * Created by Ian.
 */

public class GraphicsController
{
    //Variables: Controllers
    private DataController dataController;
    private GameSession gameSession;

    private Avatar avatar;
    private Context context;

    //Variables for map creation
    private DisplayMetrics displayMetrics;
    private Point[][] tileMap;

    //Variables for component's images
    private ImageSelector imageSelector;


    public GraphicsController(MainController mainController)
    {
        dataController = mainController.getDataController();
        gameSession = mainController.getGameSession();
        context = mainController.getContext();

        initializeVariables();
    }

    private void initializeVariables()
    {
        avatar = gameSession.getAvatar();

        displayMetrics = new DisplayMetrics(dataController.getWidthTilesCount(), dataController.getHeightTilesCount());
        tileMap = displayMetrics.getTileCoordinates();

        imageSelector = new ImageSelector();
    }

    @SuppressWarnings("deprecation")
    public Bitmap getMapToDraw()
    {
        Paint paint;
        Bitmap bitmap;
        Canvas canvas;
        Drawable player;
        Drawable tileBlue, tileGreen, tileBlueFree, tileGreenFree;

        bitmap = Bitmap.createBitmap(displayMetrics.getDisplayWidth(), displayMetrics.getDisplayHeight(), Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
        paint = new Paint();

        paint.setColor(Color.rgb(240, 140, 0));
        paint.setTextSize(20);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            tileBlue = context.getResources().getDrawable(R.drawable.tile_blue, null);
            tileGreen = context.getResources().getDrawable(R.drawable.tile_green, null);
            tileBlueFree = context.getResources().getDrawable(R.drawable.tile_blue_free, null);
            tileGreenFree = context.getResources().getDrawable(R.drawable.tile_green_free, null);
            player = context.getResources().getDrawable(R.drawable.player_cyan, null);
        }
        else
        {
            tileBlue = context.getResources().getDrawable(R.drawable.tile_blue);
            tileGreen = context.getResources().getDrawable(R.drawable.tile_green);
            tileBlueFree = context.getResources().getDrawable(R.drawable.tile_blue_free);
            tileGreenFree = context.getResources().getDrawable(R.drawable.tile_green_free);
            player = context.getResources().getDrawable(R.drawable.player_cyan);
        }

        //noinspection ForLoopReplaceableByForEach
        for(int i = 0; i < tileMap.length; i++)
        {
            for(int j = 0; j < tileMap[i].length; j++)
            {
                if(tileMap[i][j].getIndex()%2 == 0)
                {
                    if(gameSession.getFreeTiles().contains(tileMap[i][j].getIndex()))
                    {
                        tileGreenFree.setBounds(
                                tileMap[i][j].getWidth(),
                                tileMap[i][j].getHeight(),
                                tileMap[i][j].getWidth() + displayMetrics.getTileWidth(),
                                tileMap[i][j].getHeight() + displayMetrics.getTileHeight());
                        tileGreenFree.draw(canvas);
                    }
                    else
                    {
                        tileGreen.setBounds(
                                tileMap[i][j].getWidth(),
                                tileMap[i][j].getHeight(),
                                tileMap[i][j].getWidth() + displayMetrics.getTileWidth(),
                                tileMap[i][j].getHeight() + displayMetrics.getTileHeight());
                        tileGreen.draw(canvas);
                    }
                }
                else
                {
                    if(gameSession.getFreeTiles().contains(tileMap[i][j].getIndex()))
                    {
                        tileBlueFree.setBounds(
                                tileMap[i][j].getWidth(),
                                tileMap[i][j].getHeight(),
                                tileMap[i][j].getWidth() + displayMetrics.getTileWidth(),
                                tileMap[i][j].getHeight() + displayMetrics.getTileHeight());
                        tileBlueFree.draw(canvas);
                    }
                    else
                    {
                        tileBlue.setBounds(
                                tileMap[i][j].getWidth(),
                                tileMap[i][j].getHeight(),
                                tileMap[i][j].getWidth() + displayMetrics.getTileWidth(),
                                tileMap[i][j].getHeight() + displayMetrics.getTileHeight());
                        tileBlue.draw(canvas);
                    }
                }

                canvas.drawText(String.valueOf(
                        tileMap[i][j].getIndex()),
                        tileMap[i][j].getWidth() + (displayMetrics.getTileWidth() / 7),
                        tileMap[i][j].getHeight() + (displayMetrics.getTileHeight() / 4),
                        paint);

                if(tileMap[i][j].getIndex() == avatar.getPosition())
                {
                    avatar.setLastLocation(avatar.getLocation());
                    avatar.setLocation(new Point(tileMap[i][j].getWidth(), tileMap[i][j].getHeight()));
                }

                if(gameSession.getFreeTiles().contains(tileMap[i][j].getIndex()))
                {
                    canvas.drawText("*",
                            tileMap[i][j].getWidth() + ((displayMetrics.getTileWidth() * 3) / 4),
                            tileMap[i][j].getHeight() + (displayMetrics.getTileHeight() / 4),
                            paint);
                }
            }
        }

        player.setBounds(
                avatar.getLocation().getWidth() + (displayMetrics.getTileWidth() * 4/ 15),
                avatar.getLocation().getHeight() + (displayMetrics.getTileHeight() / 3),
                avatar.getLocation().getWidth() + ((displayMetrics.getTileWidth() * 11) / 15),
                avatar.getLocation().getHeight() + ((displayMetrics.getTileHeight() * 3) / 4));

        player.draw(canvas);

        return bitmap;
    }

    @SuppressWarnings("deprecation")
    public Bitmap getDiceToDraw()
    {
        Drawable drawable;
        Canvas canvas;
        Bitmap bitmap;

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            drawable = context.getResources().getDrawable(imageSelector.getDiceImage(gameSession.getDiceRoll()), null);
        }
        else
        {
            drawable = context.getResources().getDrawable(imageSelector.getDiceImage(gameSession.getDiceRoll()));
        }

        bitmap = Bitmap.createBitmap(dataController.getDiceImageWidth(), dataController.getDiceImageHeight(), Bitmap.Config.ARGB_8888);

        canvas = new Canvas(bitmap);

        drawable.setBounds(
                0,
                0,
                dataController.getDiceImageWidth(),
                dataController.getDiceImageHeight());
        drawable.draw(canvas);

        return bitmap;
    }
}
