package com.kingcheergame.customview.view2_2.practice;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;


import com.kingcheergame.customview.common.PM25View;

import static android.view.View.MeasureSpec.EXACTLY;

/**
 * MeasureSpec.AT_MOST 场景
 * 典型设置就是 LinearLayout 的子控件设定为 layout_width="wrap_content"
 * 最多不要超过某个值。小于他可以，大于他不行 - 大于他会发生什么？ bug!z
 * <p>
 * 可以关注下面注释中带有 ---- 的部分
 */

public class Practice03AtMostView extends PM25View {

    public Practice03AtMostView(Context context) {
        super(context);
    }

    public Practice03AtMostView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice03AtMostView(Context context, AttributeSet attrs, int defStyleAttr) {
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
                w = getMeasuredWidth();
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

        // 如果计算出来的可用宽度或高度大于300，则直接减去200，然后再 resolveSize
        // 这样就符合扔物线视频中说的，最大是 500, 无论设定成 400 还是 500， 都是合法的
        // 所以 在计算结果的基础上可以减少 但不能增加
        w = w > 300 ? w - 200 : w;
        h = h > 300 ? h - 200 : h;

        w = resolveSize(w, widthMeasureSpec);
        h = resolveSize(h, heightMeasureSpec);


        // 强制宽高相等
        if (h > w) {
            h = w;
        }
        if (w > h) {
            w = h;
        }
        // 保存宽高计算结果
        setMeasuredDimension(w, h);

        // 这句代码调用了
        // 并设定了一些PM25View的参数
        setSizes(w, h);
    }
}
