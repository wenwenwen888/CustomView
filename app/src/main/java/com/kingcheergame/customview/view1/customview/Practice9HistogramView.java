package com.kingcheergame.customview.view1.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.kingcheergame.customview.PxDpUtil;

public class Practice9HistogramView extends View {

    private Paint paint;
    private Path path = new Path();

    public Practice9HistogramView(Context context) {
        super(context);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    public Practice9HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    public Practice9HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图


        //绘制坐标系
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(PxDpUtil.dip2px(getContext(), 1));

        path.moveTo(100, 100);
        path.lineTo(100, 700);
        path.rLineTo(900, 0);

        canvas.drawPath(path, paint);


        //绘制矩形
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.FILL);

        path.reset();

        path.addRect(120, 695, 220, 700, Path.Direction.CCW);
        path.addRect(240, 680, 340, 700, Path.Direction.CCW);
        path.addRect(360, 680, 460, 700, Path.Direction.CCW);
        path.addRect(480, 500, 580, 700, Path.Direction.CCW);
        path.addRect(600, 400, 700, 700, Path.Direction.CCW);
        path.addRect(720, 300, 820, 700, Path.Direction.CCW);
        path.addRect(840, 600, 940, 700, Path.Direction.CCW);

        canvas.drawPath(path, paint);


        //绘制文字
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(PxDpUtil.dip2px(getContext(), 0));
        paint.setTextSize(25);
        String str[] = {"Froyo", "G B", "H C", "I C S", "J B", "K", "L"};
        int x = 120;
        for (String aStr : str) {
            float textWidth = paint.measureText(aStr);
            float textX = x + (100 - textWidth) / 2;
            canvas.drawText(aStr, textX, 730, paint);
            x += 120;
        }

    }
}
