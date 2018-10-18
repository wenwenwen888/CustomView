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

public class Sample02ExactlyMatchParentView extends PM25View {
    public Sample02ExactlyMatchParentView(Context context) {
        super(context);
    }

    public Sample02ExactlyMatchParentView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Sample02ExactlyMatchParentView(Context context, AttributeSet attrs, int defStyleAttr) {
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
                break;
            case View.MeasureSpec.AT_MOST:
                break;
            case EXACTLY:
                w = getMeasuredWidth();
                break;
        }

        int heightMode = View.MeasureSpec.getMode(heightMeasureSpec);
        switch (heightMode) {
            case View.MeasureSpec.UNSPECIFIED:
                break;
            case View.MeasureSpec.AT_MOST:
                break;
            case EXACTLY:
                h = getMeasuredHeight();
                break;
        }

        if (h > w) {
            h = w;
        }
        if (w > h) {
            w = h;
        }
        setMeasuredDimension(w, h);
        // 这句代码调用了
        // 并设定了一些PM25View的参数
        setSizes(w, h);
    }
}
