package com.kingcheergame.customview.view2_2.practice;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import com.kingcheergame.customview.common.PM25View;

import static android.view.View.MeasureSpec.EXACTLY;

/**
 * MeasureSpec.EXACTLY 场景
 * <p>
 * layout_width = "MATCH_PARENT"
 * 设定为 match_parent 的宽度 或 高度，那么 getMeasuredWidth() 就返回了应有的固定宽度
 * <p>
 * 可以关注下面注释中带有 ---- 的部分
 */

public class Practice02ExactlyMatchParentView extends PM25View {
    public Practice02ExactlyMatchParentView(Context context) {
        super(context);
    }

    public Practice02ExactlyMatchParentView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice02ExactlyMatchParentView(Context context, AttributeSet attrs, int defStyleAttr) {
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
