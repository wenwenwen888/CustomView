package com.kingcheergame.customview.view1_1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.kingcheergame.customview.PxDpUtil;

public class Practice3DrawPointView extends View {

    private static final String TAG = "Practice3DrawPointView";

    private Paint paint;

    public Practice3DrawPointView(Context context) {
        super(context);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    public Practice3DrawPointView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    public Practice3DrawPointView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawPoint() 方法画点
//        一个圆点，一个方点
//        圆点和方点的切换使用 paint.setStrokeCap(cap)：`ROUND` 是圆点，`BUTT` 或 `SQUARE` 是方点

        paint.setStrokeWidth(PxDpUtil.dip2px(getContext(),30));

        paint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawPoint(350, 300, paint);

        paint.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawPoint(700, 300, paint);

    }
}
