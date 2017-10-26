package com.dymster.battleshiptempname;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.GridLayout;
import android.widget.Toast;

public class GameBoardActivity extends AppCompatActivity {

    public final int TURN_PLAYER = 1;
    public final int TURN_OPPONENT = 2;
    public final int GRID_COLUMN_COUNT = 10;
    public final int GRID_ROW_COUNT = 10;

    GridImageButton[] gridChildren;
    private GridLayout gameGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_board);
    }

    public void prepGameBoard(View view) {
        gameGrid = (GridLayout) findViewById(R.id.gridview_game_board);
        gridChildren = new GridImageButton[GRID_COLUMN_COUNT * GRID_ROW_COUNT];
        int tagNum = 0;

        for (int i = 0; i < GRID_ROW_COUNT; i++) {
            for (int j = 0; j < GRID_COLUMN_COUNT; j++) {
                Log.i("GameBoardActivity", "inner loop");
                final GridImageButton cellView = new GridImageButton(this, i, j);
                cellView.setTag(tagNum);
//                GridLayout.LayoutParams itemLayoutParams = new GridLayout.LayoutParams(GridLayout.spec(i), GridLayout.spec(j));
                gridChildren[tagNum] = cellView;
                cellView.setBackgroundResource(R.drawable.item_square);
                gameGrid.addView(cellView);
                tagNum++;
                final String toast = "onclicked - tag = " + cellView.getTag();
                cellView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        shoot(view);
                        Toast.makeText(getApplicationContext(), toast, Toast.LENGTH_LONG).show();
                    }
                });
            }
        }

        gameGrid.getViewTreeObserver().addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener() {

                    @Override
                    public void onGlobalLayout() {
//                        final int MARGIN = 1;
                        int pWidth = gameGrid.getWidth();
                        int pHeight = gameGrid.getHeight();
                        int numOfCol = gameGrid.getColumnCount();
                        int numOfRow = gameGrid.getRowCount();
                        int w = pWidth / numOfCol;
                        int h = pHeight / numOfRow;

                        for (int yPos = 0; yPos < numOfRow; yPos++) {
                            for (int xPos = 0; xPos < numOfCol; xPos++) {
                                GridLayout.LayoutParams params =
                                        (GridLayout.LayoutParams) gridChildren[yPos * numOfCol + xPos].getLayoutParams();
                                params.width = w;
                                params.height = h;
                                gridChildren[yPos * numOfCol + xPos].setLayoutParams(params);
                            }
                        }

                    }
                });
    }

    public void shoot(View target){

        //TODO:

        ///Hit
        this.hit(target);
        //2.2. give player another turn

        ///Miss
        this.miss(target);
        //3.2. switch to opponent turn
    }

    private void hit(final View view){
        MediaPlayer player = MediaPlayer.create(getApplicationContext(), R.raw.explode);
        player.start();
        view.setBackgroundResource(R.drawable.explode_hit);
        view.setAlpha(0f);
        view.animate().alpha(1f).setDuration(1000).withEndAction(new Runnable() {
            @Override
            public void run() {
                view.animate().alpha(0f).setDuration(300).withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        view.setBackgroundResource(R.drawable.green_hit);
                        view.setAlpha(1f);
                    }
                });
            }
        });
    }

    private void miss(final View view){
//        MediaPlayer player = MediaPlayer.create(getApplicationContext(), R.raw.water_splash);
//        player.start();
        view.setBackgroundResource(R.drawable.red_miss);
        view.setAlpha(0f);
        view.animate().alpha(1f).setDuration(1000);
    }
}