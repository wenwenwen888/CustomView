package com.kingcheergame.customview.view1.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.kingcheergame.customview.PxDpUtil;

public class Practice1DrawCircleView extends View {

    private Paint paint;

    public Practice1DrawCircleView(Context context) {
        super(context);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    public Practice1DrawCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    public Practice1DrawCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawCircle() 方法画圆
//        一共四个圆：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 的空心圆

        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(300, 200, 180, paint);


        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(PxDpUtil.dip2px(getContext(),1));
        canvas.drawCircle(750, 200, 180, paint);


        paint.setColor(Color.parseColor("#4185de"));
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(300, 600, 180, paint);


        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(PxDpUtil.dip2px(getContext(),20));
        canvas.drawCircle(750, 600, 180, paint);

    }
}
