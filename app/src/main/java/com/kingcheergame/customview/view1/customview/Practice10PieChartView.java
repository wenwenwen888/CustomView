package com.kingcheergame.customview.view1.customview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.kingcheergame.customview.PxDpUtil;

public class Practice10PieChartView extends View {

//    private Path path = new Path();

    private Paint paint;
    private Paint paintLine;

    public Practice10PieChartView(Context context) {
        super(context);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    public Practice10PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        paintLine = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    public Practice10PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图

        paint.setStrokeWidth(3);
        paint.setStyle(Paint.Style.FILL);

        paintLine.setStrokeWidth(1);
        paintLine.setStyle(Paint.Style.STROKE);
        paintLine.setColor(Color.WHITE);

        int widthCenter = canvas.getWidth() / 2;
        int heightCenter = canvas.getHeight() / 2;

        int radius = widthCenter / 2;

        //两个饼图的矩形
        RectF rectF = new RectF(widthCenter - radius,
                heightCenter - radius, widthCenter + radius, heightCenter + radius);
        RectF rectFRed = new RectF(widthCenter - radius - 10,
                heightCenter - radius - 10, widthCenter + radius - 10, heightCenter + radius - 10);

        //画线
        paintLine.setStrokeWidth(PxDpUtil.dip2px(getContext(), 1));

        Path path = new Path();
        path.moveTo(widthCenter - 0.66f * radius, heightCenter + 0.66f * radius);
        path.lineTo(widthCenter - 0.8f * radius, heightCenter + 0.8f * radius);
        path.lineTo(widthCenter - 0.8f * radius - 60, heightCenter + 0.8f * radius);
        canvas.drawPath(path, paintLine);

        //先画线后画图原因是线的位置不准，会被饼图遮盖（后画会覆盖）
        paintLine.setTextSize(30);
        paintLine.setStyle(Paint.Style.FILL);
        canvas.drawText("KitKat", widthCenter - 0.8f * radius - 150,
                heightCenter + 0.8f * radius + 5, paintLine);

        //红色
        paint.setColor(Color.parseColor("#EE2B29"));
        canvas.drawArc(rectFRed, 180, 120, true, paint);
        //蓝色
        paint.setColor(Color.parseColor("#1E80F0"));
        canvas.drawArc(rectF, 75, 105, true, paint);
        //绿色
        paint.setColor(Color.parseColor("#118575"));
        canvas.drawArc(rectF, 20, 50, true, paint);
        //灰色
        paint.setColor(Color.parseColor("#8c8c8c"));
        canvas.drawArc(rectF, 10, 8, true, paint);
        //紫色
        paint.setColor(Color.parseColor("#830A9B"));
        canvas.drawArc(rectF, 0, 8, true, paint);
        //背景色
        paint.setColor(Color.parseColor("#506E7A"));
        canvas.drawArc(rectF, 355, 5, true, paint);
        //黄色
        paint.setColor(Color.parseColor("#FDB60D"));
        canvas.drawArc(rectF, 300, 55, true, paint);

    }
}
