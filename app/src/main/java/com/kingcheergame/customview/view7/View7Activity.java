package com.kingcheergame.customview.view7;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.kingcheergame.customview.PageFragment;
import com.kingcheergame.customview.PageModel;
import com.kingcheergame.customview.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class View7Activity extends AppCompatActivity {

    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;

    List<PageModel> pageModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        ButterKnife.bind(this);

        initModel();

        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                PageModel pageModel = pageModels.get(position);
                return PageFragment.newInstance(false, pageModel.getSampleRes(), pageModel.getPracticeLayoutRes());
            }

            @Override
            public int getCount() {
                return pageModels.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return getString(pageModels.get(position).getTitleRes());
            }
        });

        tabLayout.setupWithViewPager(viewPager);

    }


    private void initModel() {
        pageModels.add(new PageModel(R.layout.sample_argb_evaluator, R.string.title_argb_evaluator, R.layout.practice_argb_evaluator));
        pageModels.add(new PageModel(R.layout.sample_hsv_evaluator, R.string.title_hsv_evaluator, R.layout.practice_hsv_evaluator));
        pageModels.add(new PageModel(R.layout.sample_of_object, R.string.title_of_object, R.layout.practice_of_object));
        pageModels.add(new PageModel(R.layout.sample_property_values_holder, R.string.title_property_values_holder, R.layout.practice_property_values_holder));
        pageModels.add(new PageModel(R.layout.sample_animator_set, R.string.title_animator_set, R.layout.practice_animator_set));
        pageModels.add(new PageModel(R.layout.sample_keyframe, R.string.title_keyframe, R.layout.practice_keyframe));
    }


}
