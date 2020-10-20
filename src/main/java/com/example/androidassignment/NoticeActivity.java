package com.example.androidassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.androidassignment.R;
public class NoticeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);

        String title  = getIntent().getExtras().getString("title");
        String date  = getIntent().getExtras().getString("date");
        String teacher  = getIntent().getExtras().getString("teacher");
        String text  = getIntent().getExtras().getString("text");
        String img  = getIntent().getExtras().getString("img");

        TextView notice_title  = findViewById(R.id.NTtext2);
        TextView notice_date  = findViewById(R.id.DText2);
        TextView notice_teacher  = findViewById(R.id.Ttext1);
        TextView notice_text  = findViewById(R.id.NTextex);
        ImageView notice_image = findViewById(R.id.image1);

        notice_title.setText(title);
        notice_date.setText(date);
        notice_teacher.setText(teacher);
        notice_text.setText(text);
        Glide.with(this).load(img).into(notice_image);

    }
}