package com.kingcheergame.customview.view2_2;

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

public class View9Activity extends AppCompatActivity {

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
        pageModels.add(new PageModel(R.layout.sample_exactly_200dp, R.string.title_exactly_200dp, R.layout.practice_exactly_200dp));
        pageModels.add(new PageModel(R.layout.sample_exactly_match_parent, R.string.title_exactly_match_parent, R.layout.practice_exactly_match_parent));
        pageModels.add(new PageModel(R.layout.sample_at_most, R.string.title_at_most, R.layout.practice_at_most));
        pageModels.add(new PageModel(R.layout.sample_unspecified, R.string.title_unspecified, R.layout.practice_unspecified));
        pageModels.add(new PageModel(R.layout.sample_resolve_size, R.string.title_resolve_size, R.layout.practice_resolve_size));
    }


}
