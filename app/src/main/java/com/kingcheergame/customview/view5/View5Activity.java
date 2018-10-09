package com.kingcheergame.customview.view5;

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

public class View5Activity extends AppCompatActivity {

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
        pageModels.add(new PageModel(R.layout.sample_after_on_draw, R.string.title_after_on_draw, R.layout.practice_after_on_draw));
        pageModels.add(new PageModel(R.layout.sample_before_on_draw, R.string.title_before_on_draw, R.layout.practice_before_on_draw));
        pageModels.add(new PageModel(R.layout.sample_on_draw_layout, R.string.title_on_draw_layout, R.layout.practice_on_draw_layout));
        pageModels.add(new PageModel(R.layout.sample_dispatch_draw, R.string.title_dispatch_draw, R.layout.practice_dispatch_draw));
        pageModels.add(new PageModel(R.layout.sample_after_on_draw_foreground, R.string.title_after_on_draw_foreground, R.layout.practice_after_on_draw_foreground));
        pageModels.add(new PageModel(R.layout.sample_before_on_draw_foreground, R.string.title_before_on_draw_foreground, R.layout.practice_before_on_draw_foreground));
        pageModels.add(new PageModel(R.layout.sample_after_draw, R.string.title_after_draw, R.layout.practice_after_draw));
        pageModels.add(new PageModel(R.layout.sample_before_draw, R.string.title_before_draw, R.layout.practice_before_draw));
    }


}
