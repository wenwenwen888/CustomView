package com.kingcheergame.customview.view1.practice;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice8DrawPathView extends View {

    private Paint paint;
    private Path path = new Path();

    public Practice8DrawPathView(Context context) {
        super(context);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    public Practice8DrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    public Practice8DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawPath() 方法画心形

//        paint.setStyle(Paint.Style.STROKE);

        path.addArc(350, 200, 550, 400, 135, 225); // 半径 100 的扇形 225度，从-225开始
        path.arcTo(550, 200, 750, 400, 180, 225, false); // false 不留下移笔痕迹
        path.lineTo(550, 542); // 从原点画直线到坐标400,542
        path.close();

        canvas.drawPath(path, paint);

    }
}
