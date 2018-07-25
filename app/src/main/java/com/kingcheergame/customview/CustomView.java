package com.kingcheergame.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class CustomView extends View {

    private Paint paint;
    private Path path;

    private int nums[] = {100, 200, 300, 400, 500, 600, 700, 800, 900,
            1000, 1100, 1200, 1300, 1400, 1500, 1600, 1700, 1800};

    public CustomView(Context context) {
        super(context);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);//抗锯齿
        path = new Path();
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);//抗锯齿
        path = new Path();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.parseColor("#88880000"));//绘制背景颜色

        paint.setColor(Color.parseColor("#262626"));//画笔颜色
        paint.setStrokeWidth(10);//线条宽度

        initRuler(canvas);

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLUE);//画笔颜色
        canvas.drawArc(390, 790, 790, 1190, 180, 120, true, paint);
        paint.setColor(Color.YELLOW);//画笔颜色
        canvas.drawArc(400, 800, 800, 1200, -60, 90, true, paint);
        paint.setColor(Color.GREEN);//画笔颜色
        canvas.drawArc(400, 800, 800, 1200, 33, 147, true, paint);

//        pathDrawLine(canvas);
//
//        pathDrawArc(canvas);

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
        float[] pointXs = {100, 100, 1050, 100, 100, 100, 100, 70, 200, 100, 200, 70, 300, 100, 300, 70,
                400, 100, 400, 70, 500, 100, 500, 70, 600, 100, 600, 70, 700, 100, 700, 70,
                800, 100, 800, 70, 900, 100, 900, 70, 1000, 100, 1000, 70};
        canvas.drawLines(pointXs, paint);

        float[] pointYs = {100, 100, 100, 1900, 100, 100, 80, 100, 100, 200, 80, 200, 100, 300, 80, 300,
                100, 400, 80, 400, 100, 500, 80, 500, 100, 600, 80, 600, 100, 700, 80, 700,
                100, 800, 80, 800, 100, 900, 80, 900, 100, 1000, 80, 1000, 100, 1100, 80, 1100,
                100, 1200, 80, 1200, 100, 1300, 80, 1300, 100, 1400, 80, 1400, 100, 1500, 80, 1500,
                100, 1600, 80, 1600, 100, 1700, 80, 1700, 100, 1800, 80, 1800};
        canvas.drawLines(pointYs, paint);

        paint.setTextSize(35);

        //x轴数字
        int x = 70;
        for (int i = 0; i < 10; i++) {
            canvas.drawText(String.valueOf(nums[i]), x, 50, paint);
            x = i == 8 ? x + 90 : x + 100;
        }

        //y轴数字
        int y = 110;
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

    /**
     * 用path画弧形
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void pathDrawLine(Canvas canvas) {
        paint.setStyle(Paint.Style.STROKE);

        path.moveTo(200, 800);
        path.lineTo(400, 200);
        path.lineTo(600, 800);
        path.lineTo(800, 200);
        path.lineTo(1000, 800);
        path.lineTo(800, 1400);
        path.lineTo(600, 800);
        path.lineTo(400, 1400);
        path.lineTo(200, 800);

        canvas.drawPath(path, paint);
    }

    /**
     * 用path画弧形
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void pathDrawArc(Canvas canvas) {
        paint.setStyle(Paint.Style.STROKE);

        path.moveTo(300, 300);
        path.lineTo(500, 500);
        //使用addArc相当于forceMoveTo = true
        path.arcTo(500, 500, 700, 700, -90, 90, false); // 强制移动到弧形起点（有痕迹）

        canvas.drawPath(path, paint);
    }

}
