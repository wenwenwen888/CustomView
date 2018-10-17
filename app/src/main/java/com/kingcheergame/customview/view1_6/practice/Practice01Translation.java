package com.kingcheergame.customview.view1_6.practice;

import android.content.Context;
import android.graphics.Outline;
import android.graphics.Path;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.kingcheergame.customview.R;

import static android.os.Build.VERSION.SDK_INT;
import static com.kingcheergame.customview.PxDpUtil.dip2px;

public class Practice01Translation extends RelativeLayout {
    Button animateBt;
    ImageView imageView;

    int translationStateCount = SDK_INT > Build.VERSION_CODES.LOLLIPOP ? 6 : 4;
    int translationState = 0;

    public Practice01Translation(Context context) {
        super(context);
    }

    public Practice01Translation(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice01Translation(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        //此方法在onDraw方法之前调用，可以在此方法中去执行一些初始化的操作

        animateBt = findViewById(R.id.animateBt);
        imageView = findViewById(R.id.imageView);
        if (SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            // 给音乐图标加上合适的阴影
            imageView.setOutlineProvider(new MusicOutlineProvider());
        }

        animateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View v) {
                switch (translationState) {
                    case 0:
                        imageView.animate().translationX(dip2px(getContext(),100));
                        break;
                    case 1:
                        imageView.animate().translationX(0);
                        break;
                    case 2:
                        imageView.animate().translationY(dip2px(getContext(),50));
                        break;
                    case 3:
                        imageView.animate().translationY(0);
                        break;
                    case 4:
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            imageView.animate().translationZ(dip2px(getContext(),15));
                        }
                        break;
                    case 5:
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            imageView.animate().translationZ(0);
                        }
                        break;
                }
                translationState++;
                if (translationState == translationStateCount) {
                    translationState = 0;
                }
            }
        });
    }

    /**
     * 为音乐图标设置三角形的 Outline。
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    class MusicOutlineProvider extends ViewOutlineProvider {
        Path path = new Path();

        {
            path.moveTo(0, dip2px(getContext(), 10));
            path.lineTo(dip2px(getContext(), 7), dip2px(getContext(), 2));
            path.lineTo(dip2px(getContext(), 116), dip2px(getContext(), 58));
            path.lineTo(dip2px(getContext(), 116), dip2px(getContext(), 70));
            path.lineTo(dip2px(getContext(), 7), dip2px(getContext(), 128));
            path.lineTo(0, dip2px(getContext(), 120));
            path.close();
        }

        @Override
        public void getOutline(View view, Outline outline) {
            outline.setConvexPath(path);
        }
    }
}