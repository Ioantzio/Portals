package com.ian.portals.activities;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.ian.portals.R;
import com.ian.portals.miscellaneous.DisplayMetrics;
import com.ian.portals.miscellaneous.ImageSizeCalculator;
import com.ian.portals.miscellaneous.RandomNumberGenerator;
import com.ian.portals.models.Avatar;
import com.ian.portals.models.Point;

public class Game extends AppCompatActivity
{
    private Avatar avatar;

    //Variables for dice roll
    private RandomNumberGenerator randomNumberGenerator;
    private static final int diceLowLimit = 1;
    private static final int diceHighLimit = 6;
    private static final int diceImageWidth = 72;
    private static final int diceImageHeight = 72;

    //Variables for map creation
    private DisplayMetrics displayMetrics;
    private Point[][] tileMap;
    private static final int widthTilesCount = 6;
    private static final int heightTilesCount = 8;

    //Variables for method 'onBackPressed'
    private static final int waitTime = 2000;
    private long mBackPressed;
    private Toast mExitToast;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        avatar = new Avatar();
        randomNumberGenerator = new RandomNumberGenerator();
        displayMetrics = new DisplayMetrics(widthTilesCount, heightTilesCount);
        tileMap = displayMetrics.getTileCoordinates();

        drawMap();
    }

    @Override
    public void onBackPressed()
    {
        if (mBackPressed + waitTime > System.currentTimeMillis())
        {
            mExitToast.cancel();
            finish();
            super.onBackPressed();
            return;
        }
        else
        {
            mExitToast = Toast.makeText(getBaseContext(), "Tap again to exit", Toast.LENGTH_SHORT);
            mExitToast.show();
        }
        mBackPressed = System.currentTimeMillis();
    }

    private void drawMap()
    {
        Paint paint;
        Bitmap bitmap;
        Canvas canvas;
        Drawable tile;
        Drawable player;
        int tileImage;
        int playerImage;
        ImageSizeCalculator imageSizeCalculator;

        imageSizeCalculator = new ImageSizeCalculator(widthTilesCount, heightTilesCount, displayMetrics.getDisplayWidth(), displayMetrics.getDisplayHeight());
        tileImage = imageSizeCalculator.getTileImage();
        playerImage = imageSizeCalculator.getPlayerImage();

        bitmap = Bitmap.createBitmap(displayMetrics.getDisplayWidth(), displayMetrics.getDisplayHeight(), Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
        paint = new Paint();

        canvas.drawColor(Color.WHITE);
        paint.setColor(Color.RED);
        paint.setTextSize(20);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            tile = getResources().getDrawable(tileImage, null);
            player = getResources().getDrawable(playerImage, null);
        }
        else
        {
            //noinspection deprecation
            tile = getResources().getDrawable(tileImage);
            //noinspection deprecation
            player = getResources().getDrawable(playerImage);
        }

        //noinspection ForLoopReplaceableByForEach
        for(int i=0; i<tileMap.length; i++)
        {
            for(int j=0; j<tileMap[i].length; j++)
            {
                tile.setBounds(
                        tileMap[i][j].getWidth(),
                        tileMap[i][j].getHeight(),
                        tileMap[i][j].getWidth() + displayMetrics.getTileWidth(),
                        tileMap[i][j].getHeight() + displayMetrics.getTileHeight());
                tile.draw(canvas);

                canvas.drawText(String.valueOf(
                        tileMap[i][j].getIndex()),
                        tileMap[i][j].getWidth() + (displayMetrics.getTileWidth() / 4),
                        tileMap[i][j].getHeight() + (displayMetrics.getTileHeight() / 4),
                        paint);

                if(tileMap[i][j].getIndex() == avatar.getPosition())
                {
                    avatar.setLocation(new Point(tileMap[i][j].getWidth(), tileMap[i][j].getHeight()));
                }
            }
        }

        player.setBounds(
                avatar.getLocation().getWidth() + (displayMetrics.getTileWidth() / 3),
                avatar.getLocation().getHeight() + (displayMetrics.getTileHeight() / 3),
                avatar.getLocation().getWidth() + ((displayMetrics.getTileWidth()*3) / 4),
                avatar.getLocation().getHeight() + ((displayMetrics.getTileHeight()*3) / 4));
        player.draw(canvas);

        setImageView((ImageView) findViewById(R.id.game), bitmap);
    }

    @SuppressWarnings("deprecation")
    private void drawDice(int diceRoll)
    {
        ImageView dice = (ImageView) findViewById(R.id.dice);
        Drawable drawable;
        Canvas canvas;
        Bitmap bitmap;

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            switch(diceRoll)
            {
                case 1:
                    drawable = getResources().getDrawable(R.mipmap.dice_1, null);
                    break;
                case 2:
                    drawable = getResources().getDrawable(R.mipmap.dice_2, null);
                    break;
                case 3:
                    drawable = getResources().getDrawable(R.mipmap.dice_3, null);
                    break;
                case 4:
                    drawable = getResources().getDrawable(R.mipmap.dice_4, null);
                    break;
                case 5:
                    drawable = getResources().getDrawable(R.mipmap.dice_5, null);
                    break;
                case 6:
                    drawable = getResources().getDrawable(R.mipmap.dice_6, null);
                    break;
                default:
                    drawable = getResources().getDrawable(R.mipmap.dice_1, null);
                    break;
            }
        }
        else
        {
            switch(diceRoll)
            {
                case 1:
                    drawable = getResources().getDrawable(R.mipmap.dice_1);
                    break;
                case 2:
                    drawable = getResources().getDrawable(R.mipmap.dice_2);
                    break;
                case 3:
                    drawable = getResources().getDrawable(R.mipmap.dice_3);
                    break;
                case 4:
                    drawable = getResources().getDrawable(R.mipmap.dice_4);
                    break;
                case 5:
                    drawable = getResources().getDrawable(R.mipmap.dice_5);
                    break;
                case 6:
                    drawable = getResources().getDrawable(R.mipmap.dice_6);
                    break;
                default:
                    drawable = getResources().getDrawable(R.mipmap.dice_1);
                    break;
            }
        }

        bitmap = Bitmap.createBitmap(diceImageWidth, diceImageHeight, Bitmap.Config.ARGB_8888);

        canvas = new Canvas(bitmap);
        canvas.drawColor(Color.WHITE);

        drawable.setBounds(
                dice.getWidth(),
                dice.getHeight(),
                dice.getWidth() + diceImageWidth,
                dice.getHeight() + diceImageHeight);
        drawable.draw(canvas);

        setImageView((ImageView) findViewById(R.id.dice), bitmap);
    }

    private void setImageView(ImageView imageView, Bitmap bitmap)
    {
        imageView.setImageBitmap(bitmap);
    }

    private void movePlayer(int steps)
    {
        if((avatar.getPosition() + steps) <= (widthTilesCount*heightTilesCount))
        {
            avatar.move(steps);
            drawMap();
        }
    }

    private void rollDice()
    {
        int diceRoll;

        diceRoll = randomNumberGenerator.generateNumber(diceLowLimit, diceHighLimit);

        drawDice(diceRoll);
        movePlayer(diceRoll);
    }

    public void playOnClickEvent(View view)
    {
        rollDice();
    }
}
