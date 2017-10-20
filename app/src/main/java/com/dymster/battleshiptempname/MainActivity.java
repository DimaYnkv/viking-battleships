package com.dymster.battleshiptempname;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void beginGame(View view){
        Log.d("MainActivity", "in begin Game");
        Intent intent = new Intent(getApplicationContext(), GameBoardActivity.class);

        startActivity(intent);
    }
}
