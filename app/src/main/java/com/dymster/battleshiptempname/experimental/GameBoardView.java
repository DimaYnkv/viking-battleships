package com.dymster.battleshiptempname.experimental;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.GridLayout;

import com.dymster.battleshiptempname.GridImageButton;
import com.dymster.battleshiptempname.R;

/**
 * Created by Dimster on 10/21/2017.
 */


////EXPERIMENT:
    /// A Wrapper class of GridLayout that functions as a game board
public class GameBoardView extends FrameLayout implements View.OnClickListener {

    private GridLayout mGridView;
    private int mRowsCount;
    private int mColsCount;
    private int mCellSpace;
    private OnItemClickListener mOnItemClickListener;

    public GameBoardView(Context context) {
        super(context);
        init(context, null);
    }

    public GameBoardView(Context context, int rows, int cols) {
        super(context);
        mRowsCount = rows;
        mColsCount = cols;
        init(context, null);

    }

    private void init(Context context, AttributeSet attrs) {
        // default values
//        View layout = inflate(getContext(), R.layout.view_lights_board, null);
//        View layout = findViewById(R.id.activity_game_board);
//        mGridView = (GridLayout) findViewById(R.id.gridview_game_board);
        mGridView = new GridLayout(context);
        Log.i("GameBoardView", "setting grid");
        mGridView.setBackgroundResource(R.drawable.temp_grid);
        mGridView.setRowCount(mRowsCount);
        mGridView.setColumnCount(mColsCount);
        mGridView.post(new Runnable() {
            @Override
            public void run() {
                int width = getMeasuredWidth() / getColumnsCount();
                int height = getMeasuredHeight() / getRowsCount();
                for (int i = 0; i < getRowsCount(); i++) {
                    for (int j = 0; j < getColumnsCount(); j++) {
                        GridLayout.LayoutParams params = (GridLayout.LayoutParams)
                                getChildAt(i, j).getLayoutParams();
                        params.width = width;
                        params.height = height;
                        getChildAt(i, j).setLayoutParams(params);
                    }
                }
            }
        });
//        addView();
    }

    // this method allows to dinamically create grid
    public void buildChildren(int rowsCount, int colsCount) {
//        mRowsCount = rowsCount;
//        mColsCount = colsCount;
//        mGridView.setRowCount(mRowsCount);
//        mGridView.setColumnCount(mColsCount);
        buildChildren();
    }

    public void buildChildren() {
        for (int i = 0; i < getRowsCount(); i++) {
            for (int j = 0; j < getColumnsCount(); j++) {
                GridImageButton view = new GridImageButton(getContext(), i, j);
                view.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (view instanceof GridImageButton) {
                            GridImageButton gridImView = (GridImageButton) view;
                            if (mOnItemClickListener != null) {
                                mOnItemClickListener.onItemClick(gridImView);
                            }
                        }
                    }
                });
                mGridView.addView(view);
            }
        }
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mOnItemClickListener = listener;
    }

    public GridImageButton getChildAt(int rowIndex, int columnIndex) {
        int index = (getColumnsCount() * rowIndex) + columnIndex;
        return (GridImageButton) mGridView.getChildAt(index);
    }

//    public boolean isTouchOn(int rowIndex, int columnIndex) {
//        return getChildAt(rowIndex, columnIndex).isTouchOn();
//    }

    public int getColumnsCount() {
        return mGridView.getColumnCount();
    }

    public int getRowsCount() {
        return mGridView.getRowCount();
    }

    @Override
    public void onClick(View view) {
        if(view instanceof GridImageButton){
            GridImageButton btn = (GridImageButton) view;
            if(this.mOnItemClickListener != null){
                mOnItemClickListener.onItemClick(btn);
            }
        }
    }

//    @Override
//    public void onClick(View v) {
//        if (v instanceof GridImageButton) {
//            GridImageButton view = (GridImageButton) v;
//            if (mOnItemClickListener != null) {
//                mOnItemClickListener.onItemClick(view);
//            }
//        }
//    }

    public interface OnItemClickListener {

        void onItemClick(GridImageButton view);

    }

}
