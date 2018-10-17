package com.kingcheergame.customview.view1_1.practice;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice7DrawArcView extends View {

    private Paint paint;

    public Practice7DrawArcView(Context context) {
        super(context);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    public Practice7DrawArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    public Practice7DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawArc() 方法画弧形和扇形

        paint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(350, 200, 700, 400, 180, 60, false, paint);

        paint.setStyle(Paint.Style.FILL);
        canvas.drawArc(350, 200, 700, 400, 250, 100, true, paint);

        canvas.drawArc(350, 200, 700, 400, 20, 140, false, paint);

    }
}
