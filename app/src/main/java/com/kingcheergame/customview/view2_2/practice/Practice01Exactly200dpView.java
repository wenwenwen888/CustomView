package com.kingcheergame.customview.view2_2.practice;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.kingcheergame.customview.common.PM25View;

import static android.view.View.MeasureSpec.EXACTLY;

/**
 * MeasureSpec.EXACTLY 场景
 *
 * layout_width = "200dp"
 * 固定设定为 200dp 的宽度 或 高度，那么 getMeasuredWidth() 就返回了应有的固定宽度
 *
 * 可以关注下面注释中带有 ---- 的部分
 */

public class Practice01Exactly200dpView extends PM25View {

    public Practice01Exactly200dpView(Context context) {
        super(context);
    }

    public Practice01Exactly200dpView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice01Exactly200dpView(Context context, AttributeSet attrs, int defStyleAttr) {
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

        // 如果没有 resolveSize，这12次onMeasure过程当中有时候得到的宽度或高度为0
        // 加上 resolveSize 则不会出现这个情况，从第一次到最后一次都能得到固定值
        w = resolveSize(w, widthMeasureSpec);
        h = resolveSize(h, widthMeasureSpec);

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
