package com.example.androidthree.ui.onboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.example.androidthree.R;
import com.example.androidthree.data.entity.OnBoardEntity;
import com.example.androidthree.ui.main.MainActivity;

import java.util.ArrayList;

public abstract class Adapter extends PagerAdapter {

    private ArrayList<OnBoardEntity> resource;
    private Context mContext;


    public Adapter(ArrayList<OnBoardEntity> resource) {
        this.resource = resource;

    }

    @Override
    public int getCount() {
        return (resource.size());
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull final ViewGroup container, int position) {
        TextView textView;
        ImageView image;
        Button button1;
        TextView textView2;

        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.activity_view_holder, null);

        image = view.findViewById(R.id.step1);
        textView = view.findViewById(R.id.text1);
        button1 = view.findViewById(R.id.button1);
        textView2 = view.findViewById(R.id.skip1);



        image.setImageDrawable(container.getContext().getResources().getDrawable(resource.get(position).getImg()));
        textView.setText(resource.get(position).getTitle());

        switch (position) {
            case 0:
                button1.setText("Далее");
                break;
            case 1:
                button1.setText("Далее ");
                break;
            case 2:
                button1.setText("Далее  ");
                break;
            case 3:
                button1.setText("Начинать");

                button1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MainActivity.start(container.getContext());
                    }
                });
                break;

        }

        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.start(container.getContext());
            }
        });


        container.addView(view);
        return view;




    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout) object);
    }
}
