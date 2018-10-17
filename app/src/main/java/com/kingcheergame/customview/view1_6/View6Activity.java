package com.kingcheergame.customview.view1_6;

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

public class View6Activity extends AppCompatActivity {

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
        pageModels.add(new PageModel(R.layout.sample_translation, R.string.title_translation, R.layout.practice_translation));
        pageModels.add(new PageModel(R.layout.sample_rotation, R.string.title_rotation, R.layout.practice_rotation));
        pageModels.add(new PageModel(R.layout.sample_scale_view6, R.string.title_scale_draw6, R.layout.practice_scale_view6));
        pageModels.add(new PageModel(R.layout.sample_alpha, R.string.title_alpha, R.layout.practice_alpha));
        pageModels.add(new PageModel(R.layout.sample_multi_properties, R.string.title_multi_properties, R.layout.practice_multi_properties));
        pageModels.add(new PageModel(R.layout.sample_duration, R.string.title_duration, R.layout.practice_duration));
        pageModels.add(new PageModel(R.layout.sample_interpolator, R.string.title_interpolator, R.layout.practice_interpolator));
        pageModels.add(new PageModel(R.layout.sample_object_anomator, R.string.title_object_animator, R.layout.practice_object_animator));
    }


}
