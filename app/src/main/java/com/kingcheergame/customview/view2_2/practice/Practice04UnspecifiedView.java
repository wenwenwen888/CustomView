package com.kingcheergame.customview.view2_2.practice;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.kingcheergame.customview.common.PM25View;

import static android.view.View.MeasureSpec.EXACTLY;

/**
 * MeasureSpec.UNSPECIFIED 场景
 *
 * 典型应用场景为
 * ScrollView 的高度是根据其子View的高度来计算出来的
 * 那么自定义的View的高度 （或者 HorizontalScrollView 来说就是宽度）就是不固定的
 * 就需要自己计算获得，没有限制
 *
 * 可以任意设定，用resolveSize方法不会影响结果
 *
 * 可以关注下面注释中带有 ---- 的部分
 */

public class Practice04UnspecifiedView extends PM25View {
    protected static final String TAG = "HenCoder Unspecified";

    public Practice04UnspecifiedView(Context context) {
        super(context);
    }

    public Practice04UnspecifiedView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice04UnspecifiedView(Context context, AttributeSet attrs, int defStyleAttr) {
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
                // 不限定宽度，可以任意指定值
                 w = 800;
//                 w = 3000;
                break;
            case View.MeasureSpec.AT_MOST:
                // onMeasure 执行多次，此处也会执行到。但这个数值在并不起作用
                Log.w(TAG, "width mode == at most");
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
