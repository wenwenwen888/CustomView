package com.kingcheergame.customview;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.kingcheergame.customview.view1.View1Activity;
import com.kingcheergame.customview.view2.View2Activity;
import com.kingcheergame.customview.view3.View3Activity;
import com.kingcheergame.customview.view4.View4Activity;
import com.kingcheergame.customview.view5.View5Activity;
import com.kingcheergame.customview.view6.View6Activity;
import com.kingcheergame.customview.view7.View7Activity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> array = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Collections.addAll(array, getResources().getStringArray(R.array.view_array));

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MainAdapter());

    }

    class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_main,
                    viewGroup, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
            viewHolder.button.setText(array.get(position));
            viewHolder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent();
                    if (position == 0) {
                        intent.setClass(MainActivity.this, View1Activity.class);
                        startActivity(intent);
                    } else if (position == 1) {
                        intent.setClass(MainActivity.this, View2Activity.class);
                        startActivity(intent);
                    } else if (position == 2) {
                        intent.setClass(MainActivity.this, View3Activity.class);
                        startActivity(intent);
                    } else if (position == 3) {
                        intent.setClass(MainActivity.this, View4Activity.class);
                        startActivity(intent);
                    } else if (position == 4) {
                        intent.setClass(MainActivity.this, View5Activity.class);
                        startActivity(intent);
                    } else if (position == 5) {
                        intent.setClass(MainActivity.this, View6Activity.class);
                        startActivity(intent);
                    } else if (position == 6) {
                        intent.setClass(MainActivity.this, View7Activity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity.this, "请等待开发", Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }

        @Override
        public int getItemCount() {
            return array.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            Button button;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                button = itemView.findViewById(R.id.button);
            }
        }

    }

}
