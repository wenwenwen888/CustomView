package com.kingcheergame.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

public class CustomView1 extends View {

    private Paint paint;

    private int nums[] = {100, 200, 300, 400, 500, 600, 700, 800, 900,
            1000, 1100, 1200, 1300, 1400, 1500, 1600, 1700, 1800};

    public CustomView1(Context context) {
        super(context);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);//抗锯齿
    }

    public CustomView1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);//抗锯齿
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.parseColor("#88880000"));//绘制背景颜色

        paint.setColor(Color.parseColor("#262626"));//画笔颜色
        paint.setStrokeWidth(10);//线条宽度

        initRuler(canvas);

//        drawCircle(canvas);
//
//        drawRect(canvas);
//
//        drawPoint(canvas);
//
//        drawOval(canvas);
//
//        drawLine(canvas);
//
//        drawRoundRect(canvas);
//
//        drawArc(canvas);

    }

    /**
     * 画尺子
     */
    private void initRuler(Canvas canvas) {
        float[] pointXs = {100, 150, 1050, 150, 100, 150, 100, 130, 200, 150, 200, 130, 300, 150, 300, 130,
                400, 150, 400, 130, 500, 150, 500, 130, 600, 150, 600, 130, 700, 150, 700, 130,
                800, 150, 800, 130, 900, 150, 900, 130, 1000, 150, 1000, 130};
        canvas.drawLines(pointXs, paint);

        float[] pointYs = {100, 150, 100, 1900, 100, 150, 80, 150, 100, 250, 80, 250, 100, 350, 80, 350,
                100, 450, 80, 450, 100, 550, 80, 550, 100, 650, 80, 650, 100, 750, 80, 750,
                100, 850, 80, 850, 100, 950, 80, 950, 100, 1050, 80, 1050, 100, 1150, 80, 1150,
                100, 1250, 80, 1250, 100, 1350, 80, 1350, 100, 1450, 80, 1450, 100, 1550, 80, 1550,
                100, 1650, 80, 1650, 100, 1750, 80, 1750, 100, 1850, 80, 1850};
        canvas.drawLines(pointYs, paint);

        paint.setTextSize(35);

        //x轴数字
        int x = 70;
        for (int i = 0; i < 10; i++) {
            canvas.drawText(String.valueOf(nums[i]), x, 110, paint);
            x = i == 8 ? x + 90 : x + 100;
        }

        //y轴数字
        int y = 160;
        for (int num : nums) {
            canvas.drawText(String.valueOf(num), 0, y, paint);
            y += 100;
        }

    }

    /**
     * 画圆
     */
    private void drawCircle(Canvas canvas) {
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(300, 300, 200, paint);//绘制一个圆

        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(800, 300, 200, paint);//绘制一个圆
    }

    /**
     * 画矩形
     */
    private void drawRect(Canvas canvas) {
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(100, 600, 500, 800, paint);//绘制一个矩形

        paint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(600, 600, 1000, 800, paint);//绘制一个矩形
    }

    /**
     * 画点
     */
    private void drawPoint(Canvas canvas) {
        paint.setStrokeCap(Paint.Cap.BUTT);//平头的点
        canvas.drawPoint(770, 300, paint);//绘制一个点
        paint.setStrokeCap(Paint.Cap.ROUND);//圆形的点
        canvas.drawPoint(800, 300, paint);//绘制一个点
        paint.setStrokeCap(Paint.Cap.SQUARE);//方头的点
        canvas.drawPoint(830, 300, paint);//绘制一个点

        float[] points = {0, 0, 200, 900, 250, 900, 300, 900, 350, 900, 400, 900};
        // 绘制四个点：(50, 50) (50, 100) (100, 50) (100, 100)
        canvas.drawPoints(points, 2 /* 跳过两个数，即前两个 0 */,
                10 /* 一共绘制 10 个数（5 个点）*/, paint);
    }

    /**
     * 画椭圆
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void drawOval(Canvas canvas) {
        paint.setStyle(Paint.Style.FILL);
        canvas.drawOval(100, 1000, 500, 1200, paint);//绘制椭圆

        paint.setStyle(Paint.Style.STROKE);
        canvas.drawOval(600, 1000, 1000, 1200, paint);//绘制椭圆
    }

    /**
     * 画椭圆
     */
    private void drawLine(Canvas canvas) {
        canvas.drawLine(650, 900, 950, 900, paint);//绘制直线
    }

    /**
     * 画圆角矩形
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void drawRoundRect(Canvas canvas) {
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRoundRect(100, 1300, 500, 1500, 30, 30, paint);//绘制圆角矩形

        paint.setStyle(Paint.Style.STROKE);
        canvas.drawRoundRect(600, 1300, 1000, 1500, 30, 30, paint);//绘制圆角矩形
    }

    /**
     * 画弧形或扇形
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void drawArc(Canvas canvas) {
        paint.setStyle(Paint.Style.FILL);
        canvas.drawArc(100, 1600, 500, 1800, -90, 90, true, paint); // 绘制扇形
        canvas.drawArc(100, 1600, 500, 1800, 20, 90, false, paint); // 绘制弧形
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(100, 1600, 500, 1800, 180, 60, false, paint); // 绘制不封口的弧形
    }

}
