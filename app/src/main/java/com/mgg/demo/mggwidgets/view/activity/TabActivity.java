package com.mgg.demo.mggwidgets.view.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mgg.demo.mggwidgets.R;
import com.mgg.demo.mggwidgets.view.adapter.TabAdapter;
import com.mgg.demo.mggwidgets.bean.TabBean;
import com.mgg.demo.mggwidgets.view.widgets.CommonNavigationView;

import java.util.ArrayList;
import java.util.List;

public class TabActivity extends AppCompatActivity {

    RecyclerView recycler;
    CommonNavigationView nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        recycler = findViewById(R.id.recycler);
        nav = findViewById(R.id.nav);

        List<TabBean> tabs = new ArrayList<>();
        tabs.add(new TabBean(R.drawable.ic_learn, R.drawable.ic_learn_sel));
        tabs.add(new TabBean(R.drawable.ic_course, R.drawable.ic_course_sel));
        tabs.add(new TabBean(R.drawable.ic_train, R.drawable.ic_train_sel));
        tabs.add(new TabBean(R.drawable.ic_me, R.drawable.ic_me_sel));

        GridLayoutManager layoutManager = new GridLayoutManager(this, tabs.size());
        recycler.setLayoutManager(layoutManager);
        recycler.setAdapter(new TabAdapter(TabActivity.this, tabs));

        nav.addTab(R.drawable.ic_learn, R.drawable.ic_learn_sel, "学习");
        nav.addTab(R.drawable.ic_course, R.drawable.ic_course_sel, "课程");
        nav.addTab(R.drawable.ic_train, R.drawable.ic_train_sel, "训练");
        nav.addTab(R.drawable.ic_me, R.drawable.ic_me_sel, "我的");
        nav.selectTab(0, false);
    }
}
