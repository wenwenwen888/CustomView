package com.kingcheergame.customview;

import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;


public class PageModel {

    int sampleRes;
    int practiceLayoutRes;
    int titleRes;

    public PageModel(int sampleRes, int titleRes, int practiceLayoutRes) {
        this.sampleRes = sampleRes;
        this.titleRes = titleRes;
        this.practiceLayoutRes = practiceLayoutRes;
    }

    public int getSampleRes() {
        return sampleRes;
    }

    public void setSampleRes(int sampleRes) {
        this.sampleRes = sampleRes;
    }

    public int getPracticeLayoutRes() {
        return practiceLayoutRes;
    }

    public void setPracticeLayoutRes(int practiceLayoutRes) {
        this.practiceLayoutRes = practiceLayoutRes;
    }

    public int getTitleRes() {
        return titleRes;
    }

    public void setTitleRes(int titleRes) {
        this.titleRes = titleRes;
    }
}
