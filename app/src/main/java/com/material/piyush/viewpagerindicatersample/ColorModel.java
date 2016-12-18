package com.material.piyush.viewpagerindicatersample;

public enum ColorModel {

    RED_MODEL(R.string.red, R.layout.layout_red),
    BLUE_MODEL(R.string.blue, R.layout.layout_blue),
    GREEN_MODEL(R.string.green, R.layout.layout_green),
    YELLOW_MODEL(R.string.yellow, R.layout.layout_yellow);

    private int mTitleResId;
    private int mLayoutResId;

    ColorModel(int titleResId, int layoutResId) {
        mTitleResId = titleResId;
        mLayoutResId = layoutResId;
    }

    public int getTitleResId() {
        return mTitleResId;
    }

    public int getLayoutResId() {
        return mLayoutResId;
    }

}