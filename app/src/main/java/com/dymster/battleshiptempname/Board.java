package com.dymster.battleshiptempname;

import android.content.Context;
import android.support.v7.view.menu.MenuView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.GridLayout;

/**
 * Created by Dimster on 10/19/2017.
 */


public class Board extends FrameLayout implements View.OnClickListener {

    private GridLayout mGridView;
    private int mRowsCount;
    private int mColsCount;
    private int mCellSpace;
    private OnItemClickListener mOnItemClickListener;

    public Board(Context context) {
        super(context);
        init(context, null);
    }

    // other constructors

    private void init(Context context, AttributeSet attrs) {
        // default values
        mRowsCount = 1;
        mColsCount = 1;
//        View layout = inflate(getContext(), R.layout.view_lights_board, null);
//        mGridView = (GridLayout) layout.findViewById(R.id.view_grid);
        mGridView.setRowCount(mRowsCount);
        mGridView.setColumnCount(mColsCount);
//        mGridView.post(new Runnable() {
//            @Override
//            public void run() {
//                int width = getMeasuredWidth() / getColumnsCount();
//                int height = getMeasuredHeight() / getRowsCount();
//                for (int i = 0; i < getRowsCount(); i++) {
//                    for (int j = 0; j < getColumnsCount(); j++) {
//                        GridLayout.LayoutParams params = (GridLayout.LayoutParams)
//                                getChildAt(i, j).getLayoutParams();
//                        params.width = width;
//                        params.height = height;
//                        getChildAt(i, j).setLayoutParams(params);
//                    }
//                }
//            }
//        });
//        addView(layout);
    }

    // this method allows to dinamically create grid
    public void buildChildren(int rowsCount, int colsCount) {
        mRowsCount = rowsCount;
        mColsCount = colsCount;
        mGridView.setRowCount(mRowsCount);
        mGridView.setColumnCount(mColsCount);
        buildChildren();
    }

    public void buildChildren() {
//        for (int i = 0; i < getRowsCount(); i++) {
//            for (int j = 0; j < getColumnsCount(); j++) {
//                ItemView view = new ItemView(getContext(), i, j);
//                view.setOnClickListener(this);
//                mGridView.addView(view);
//            }
//        }
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mOnItemClickListener = listener;
    }

//    public ItemView getChildAt(int rowIndex, int columnIndex) {
public void getChildAt(int rowIndex, int columnIndex) {
        int index = (getColumnsCount() * rowIndex) + columnIndex;
//        return (ItemView) mGridView.getChildAt(index);
    }

//    public boolean isTouchOn(int rowIndex, int columnIndex) {
public void isTouchOn(int rowIndex, int columnIndex) {
//        return getChildAt(rowIndex, columnIndex).isTouchOn();
    }

    public int getColumnsCount() {
        return mGridView.getColumnCount();
    }

    public int getRowsCount() {
        return mGridView.getRowCount();
    }

    @Override
    public void onClick(View v) {
//        if (v instanceof ItemView) {
//            ItemView view = (ItemView) v;
//            if (mOnItemClickListener != null) {
//                mOnItemClickListener.onItemClick(view);
//            }
//        }
    }

    public interface OnItemClickListener {

//        void onItemClick(ItemView view);

    }

}