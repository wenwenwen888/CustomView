package com.kingcheergame.customview.view2_2.sample;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.kingcheergame.customview.common.PM25View;

import static android.view.View.MeasureSpec.EXACTLY;

/**
 * Created by wliu on 25/06/2018.
 */

public class Sample04UnspecifiedView extends PM25View {
    protected static final String TAG = "HenCoder Unspecified";

    public Sample04UnspecifiedView(Context context) {
        super(context);
    }

    public Sample04UnspecifiedView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Sample04UnspecifiedView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int w = 0;
        int h = 0;

        int widthMode = View.MeasureSpec.getMode(widthMeasureSpec);
        switch (widthMode) {
            case View.MeasureSpec.UNSPECIFIED:
                // 横向的ScrollView 自定义控件
                w = 3000;
                break;
            case View.MeasureSpec.AT_MOST:
                // onMeasure 执行多次，但这个数值在并不起作用
                w = 1000;
                break;
            case EXACTLY:
                break;
        }

        int heightMode = View.MeasureSpec.getMode(heightMeasureSpec);
        switch (heightMode) {
            case View.MeasureSpec.UNSPECIFIED:
                break;
            case View.MeasureSpec.AT_MOST:
                h = getMeasuredHeight();
                break;
            case EXACTLY:
                break;
        }

        w = resolveSize(w, widthMeasureSpec);
        h = resolveSize(h, heightMeasureSpec);

        setMeasuredDimension(w, h);

        // 这句代码调用了
        // 并设定了一些PM25View的参数, 比如强制设定 宽高相等
        setSizes(w, h);
    }
}
