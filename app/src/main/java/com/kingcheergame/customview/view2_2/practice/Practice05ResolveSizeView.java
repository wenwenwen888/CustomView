package com.kingcheergame.customview.view2_2.practice;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.kingcheergame.customview.common.PM25View;

import static android.view.View.MeasureSpec.EXACTLY;

/**
 * 用 resolveSize 使计算结果符合用户限制。
 *
 * 可以关注下面注释中带有 ---- 的部分
 */

public class Practice05ResolveSizeView extends PM25View {
    private static final String TAG = "HenCoder ResolveSize";

    public Practice05ResolveSizeView(Context context) {
        super(context);
    }

    public Practice05ResolveSizeView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice05ResolveSizeView(Context context, AttributeSet attrs, int defStyleAttr) {
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
                // 不管设定的是 100dp 还是多少dp 我都给他设定成 1080 像素
                // 这样就会出现扔物线视频当中提到的： 会发生什么？ bug！
                // 但resolveSize可以帮助符合这个用户设定的限制
                w = 1080;
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

        // 打开resolveSize 则符合用户设定
         w = resolveSize(w, widthMeasureSpec);
         h = resolveSize(h, widthMeasureSpec);

        setMeasuredDimension(w, h);
        // 这句代码调用了
        // 并设定了一些PM25View的参数
        setSizes(w, h);
    }
}
