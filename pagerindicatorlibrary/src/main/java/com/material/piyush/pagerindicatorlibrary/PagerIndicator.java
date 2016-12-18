package com.material.piyush.pagerindicatorlibrary;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by Piyush on 12/10/2016.
 */

public class PagerIndicator extends LinearLayout {

    private int mCount;
    private int mStrokeColor;
    private int mSolidColor;
    private int mSelectedStrokeColor;
    private int mSelectedSolidColor;
    private int mSelectedIndex=0;
    private Context mContext;
    private CircularTextView[] tv;

    public PagerIndicator(Context context) {
        super(context);
        this.mContext = context;
    }

    public PagerIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        loadPropertiesFromAttrs(attrs);
    }

    public PagerIndicator(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        loadPropertiesFromAttrs(attrs);
    }

    private void loadPropertiesFromAttrs(AttributeSet attributeSet) {
        if (attributeSet == null) return;
        TypedArray typedArray = null;
        try {
            typedArray = getContext().obtainStyledAttributes(attributeSet, com.material.piyush.pagerindicatorlibrary.R.styleable.PagerIndicatorView);
            mCount = typedArray.getInt(com.material.piyush.pagerindicatorlibrary.R.styleable.PagerIndicatorView_numIndicator, 5);
            mStrokeColor = typedArray.getColor(com.material.piyush.pagerindicatorlibrary.R.styleable.PagerIndicatorView_strokeColor, 0x000000);
            mSolidColor = typedArray.getColor(com.material.piyush.pagerindicatorlibrary.R.styleable.PagerIndicatorView_solidColor, 0xFFFFFF);
            mSelectedStrokeColor = typedArray.getColor(com.material.piyush.pagerindicatorlibrary.R.styleable.PagerIndicatorView_strokeColor, 0xFFFFFF);
            mSelectedSolidColor = typedArray.getColor(com.material.piyush.pagerindicatorlibrary.R.styleable.PagerIndicatorView_solidColor, 0x000000);
            createIndicator();
        } finally {
            if (typedArray != null) {
                typedArray.recycle();
            }
        }
    }

    private void setupIndicator()
    {

        if(tv==null)
        {
            tv = new CircularTextView[mCount];
            for (int i = 0; i < mCount; i++) {
                tv[i] = new CircularTextView(mContext);
                LinearLayout.LayoutParams buttonLayoutParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
                buttonLayoutParams.setMargins(10, 0, 0, 0);
                tv[i].setLayoutParams(buttonLayoutParams);
                tv[i].setText(" ");
                tv[i].setStrokeWidth(1);
                tv[i].setStrokeColor(mStrokeColor);
                tv[i].setSolidColor(mSolidColor);
            }
        }
        else if(mSelectedIndex>-1)
        {
            if(mCount<=mSelectedIndex)
                return;
            for (int i = 0; i < mCount; i++) {
                if (i == mSelectedIndex) {
                    tv[i].setStrokeColor(mSelectedStrokeColor);
                    tv[i].setSolidColor(mSelectedSolidColor);
                } else {
                    tv[i].setStrokeColor(mStrokeColor);
                    tv[i].setSolidColor(mSolidColor);
                }
                tv[i].setText(" ");
                tv[i].setStrokeWidth(1);
            }
        }
        else
        {
            for (int i = 0; i < mCount; i++) {
                tv[i].setText(" ");
                tv[i].setStrokeWidth(1);
                tv[i].setStrokeColor(mStrokeColor);
                tv[i].setSolidColor(mSolidColor);
            }
        }
    }
    private void createIndicator() {
        if (mCount <= 0)
            return;

        removeAllViews();
        LinearLayout layout = new LinearLayout(mContext);
        layout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        layout.setOrientation(LinearLayout.HORIZONTAL);

        tv = new CircularTextView[mCount];
        for (int i = 0; i < mCount; i++) {
            tv[i] = new CircularTextView(mContext);
            LinearLayout.LayoutParams buttonLayoutParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            buttonLayoutParams.setMargins(7, 0, 0, 0);
            tv[i].setLayoutParams(buttonLayoutParams);

            tv[i].setText(" ");
            tv[i].setStrokeWidth(1);
            if (i == mSelectedIndex) {
                tv[i].setStrokeColor(mSelectedStrokeColor);
                tv[i].setSolidColor(mSelectedSolidColor);
            } else {
                tv[i].setStrokeColor(mStrokeColor);
                tv[i].setSolidColor(mSolidColor);
            }
            layout.addView(tv[i]);
        }
        addView(layout);
    }

    public void setSelectedIndex(int index) {

        mSelectedIndex = index;
        setupIndicator();
        invalidate();
    }

    public void setPagerIndicatorCount(int count) {
        this.mCount = count;
        createIndicator();
        invalidate();
    }

    public void setSolidColor(int solidColor) {
        this.mSolidColor = solidColor;
        setupIndicator();
        invalidate();
    }

    public void setStrokeColor(int strokeColor) {
        this.mStrokeColor = strokeColor;
        setupIndicator();
        invalidate();
    }

    public void setSelectedSolidColor(int selectedSolidColor) {
        this.mSelectedSolidColor = selectedSolidColor;
        setupIndicator();
        invalidate();
    }

    public void setSelectedStrokeColor(int selectedStrokeColor) {
        this.mSelectedStrokeColor = selectedStrokeColor;
        setupIndicator();
        invalidate();
    }
}