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

public class PageFragment extends Fragment {

    private static final String TAG = "PageFragment";

    @DrawableRes
    int sampleImageRes;
    @LayoutRes
    int practiceLayoutRes;

    public static PageFragment newInstance(@DrawableRes int sampleImageRes, @LayoutRes int practiceLayoutRes) {
        PageFragment fragment = new PageFragment();
        Bundle args = new Bundle();
        args.putInt("sampleImageRes", sampleImageRes);
        args.putInt("practiceLayoutRes", practiceLayoutRes);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            sampleImageRes = args.getInt("sampleImageRes");
            practiceLayoutRes = args.getInt("practiceLayoutRes");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page, container, false);

        ImageView imageView = view.findViewById(R.id.iv_sample);
        if (sampleImageRes == R.drawable.sample_pie_chart || sampleImageRes == R.drawable.sample_histogram) {
            imageView.setBackgroundColor(Color.parseColor("#506E7A"));
        }
        imageView.setImageResource(sampleImageRes);

        ViewStub practiceStub = view.findViewById(R.id.practiceStub);
        practiceStub.setLayoutResource(practiceLayoutRes);
        practiceStub.inflate();

        return view;
    }

}
