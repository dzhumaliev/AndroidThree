package com.example.androidthree.ui.onboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.androidthree.R;
import com.example.androidthree.data.entity.OnBoardEntity;
import com.example.androidthree.ui.main.MainActivity;

import java.util.ArrayList;

public class OnBoardActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private Button button;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_board);
        initViews();
        setupViewPager();
        setupClickListener();


    }

    private void setupClickListener() {
    }



    private void initViews() {
        toolbar = findViewById(R.id.toolbarTransparent);
        setSupportActionBar(toolbar);
        button = findViewById(R.id.button1);
        viewPager = findViewById(R.id.viewPager);

    }

    public void setupViewPager() {
        PagerAdapter adapter = new Adapter(getResource()) {
        };
        viewPager.setAdapter(adapter);


    }

    private ArrayList<OnBoardEntity> getResource() {
        ArrayList<OnBoardEntity> list = new ArrayList<>();

        list.add(new OnBoardEntity("В данном приложении вы можете учиться))", R.drawable.step1_create));
        list.add(new OnBoardEntity("В данном приложении вы можете обновлять))", R.drawable.update));
        list.add(new OnBoardEntity("В данном приложении вы можете удалять))", R.drawable.delete));
        list.add(new OnBoardEntity("Спасибо что вы с нами))", R.drawable.thanks));


        return list;
    }

    public static void start(Context context) {
        context.startActivity(new Intent(context, OnBoardActivity.class));


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        {
            if (id == R.id.skip) ;

        }
        return super.onOptionsItemSelected(item);
    }

    public void onClick(MenuItem item) {
        MainActivity.start(this);
    }

    public void Click(View view) {
        viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);

    }
}
