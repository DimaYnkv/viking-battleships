package com.dymster.battleshiptempname;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.GridLayout;
import android.widget.Toast;

public class GameBoardActivity extends AppCompatActivity {

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
                        ///TODO: onClick action - shoot
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
}