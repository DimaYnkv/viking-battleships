package com.dymster.battleshiptempname;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;

public class GameBoardActivity extends AppCompatActivity {

    public final int GRID_COLUMN_COUNT = 10;
    public final int GRID_ROW_COUNT = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_board);
    }


    public void prepGameBoard(View view){

        GridLayout gameGrid = (GridLayout) findViewById(R.id.gridview_game_board);
        ///TODO: see if can make foreach
        int tagNum = 0;
        for(int i = 0; i < GRID_ROW_COUNT; i++){
            for(int j = 0; j < GRID_COLUMN_COUNT; j++){
                Log.i("GameBoardActivity", "inner loop");
                ImageView cellView = new ImageView(getApplicationContext());
                cellView.setImageResource(R.drawable.temppoint);
                cellView.setTag(tagNum);
                GridLayout.LayoutParams itemLayoutParams = new GridLayout.LayoutParams(GridLayout.spec(i), GridLayout.spec(j));
                tagNum++;
                gameGrid.addView(cellView, itemLayoutParams);


            }
        }
    }

}
