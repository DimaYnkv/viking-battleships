package com.dymster.battleshiptempname;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;


/**
 * Created by Dimster on 10/21/2017.
 */

public class GridImageButton extends View {
    int idX = 0;
    int idY = 0;

    public GridImageButton(Context context) {
        super(context);
        init();
    }
    public GridImageButton(Context context, int x, int y) {
        super(context);
        idX = x;
        idY = y;
        init();
    }

    public GridImageButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    public GridImageButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
//        Log.i("GridImageButton", "initting gridImageButton");
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec),
                MeasureSpec.getSize(heightMeasureSpec));
    }

    @Override
    protected void onDraw(Canvas canvas) {
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    @Override
    public boolean performClick() {
        super.performClick();
        return true;
    }

    public int getIdX(){
        return idX;
    }

    public int getIdY(){
        return idY;
    }


}
