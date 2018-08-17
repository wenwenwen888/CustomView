package com.kingcheergame.customview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class PageFragment extends Fragment {

    private static final String TAG = "PageFragment";

    private boolean isImage;
    private int sampleRes;
    private int practiceLayoutRes;

    public static PageFragment newInstance(boolean isImage ,int sampleRes, int practiceLayoutRes) {
        PageFragment fragment = new PageFragment();
        Bundle args = new Bundle();
        args.putBoolean("isImage", isImage);
        args.putInt("sampleRes", sampleRes);
        args.putInt("practiceLayoutRes", practiceLayoutRes);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            isImage = args.getBoolean("isImage");
            sampleRes = args.getInt("sampleRes");
            practiceLayoutRes = args.getInt("practiceLayoutRes");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page, container, false);

        RelativeLayout relativeLayout = view.findViewById(R.id.rl_sample);
        ImageView imageView = view.findViewById(R.id.iv_sample);
        if (isImage){
            if (sampleRes == R.drawable.sample_pie_chart || sampleRes == R.drawable.sample_histogram) {
                imageView.setBackgroundColor(Color.parseColor("#506E7A"));
            }
            imageView.setImageResource(sampleRes);
        }else {
            imageView.setVisibility(View.GONE);
            relativeLayout.setVisibility(View.VISIBLE);

            ViewStub sampleStub = (ViewStub) view.findViewById(R.id.sampleStub);
            sampleStub.setLayoutResource(sampleRes);
            sampleStub.inflate();
        }


        ViewStub practiceStub = view.findViewById(R.id.practiceStub);
        practiceStub.setLayoutResource(practiceLayoutRes);
        practiceStub.inflate();

        return view;
    }

}
