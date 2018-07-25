package com.kingcheergame.customview.view1;

import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;


public class PageModel {

    @DrawableRes
    int sampleImageRes;
    @LayoutRes
    int practiceLayoutRes;
    @StringRes
    int titleRes;

    public PageModel(@DrawableRes int sampleImageRes, @StringRes int titleRes, @LayoutRes int practiceLayoutRes) {
        this.sampleImageRes = sampleImageRes;
        this.titleRes = titleRes;
        this.practiceLayoutRes = practiceLayoutRes;
    }
}
