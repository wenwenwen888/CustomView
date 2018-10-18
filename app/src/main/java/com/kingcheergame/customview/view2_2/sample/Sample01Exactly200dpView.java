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

public class Sample01Exactly200dpView extends PM25View {
    public Sample01Exactly200dpView(Context context) {
        super(context);
    }

    public Sample01Exactly200dpView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Sample01Exactly200dpView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int w = 0;
        int h = 0;

        int widthMode = View.MeasureSpec.getMode(widthMeasureSpec);
        switch (widthMode) {
            case View.MeasureSpec.UNSPECIFIED://不限制
                break;
            case View.MeasureSpec.AT_MOST://限制上限
                break;
            case EXACTLY:
                w = getMeasuredWidth();//限制固定值
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

        // 如果没有 resolveSize，这12次onMeasure过程当中有时候得到的宽度或高度为0
        // 加上 resolveSize 则不会出现这个情况，从第一次到最后一次都能得到固定值
        // 这是因为 measureMode == EXACTLY 的时候，在resolveSize方法里面直接返回
        // specSize ---- 扔物线视频中讲到
        w = resolveSize(w, widthMeasureSpec);
        h = resolveSize(h, widthMeasureSpec);

        // 强制设定宽高相等
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
