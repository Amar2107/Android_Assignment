package com.example.androidassignment.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidassignment.NoticeActivity;
import com.example.androidassignment.R;
import com.example.androidassignment.Notice;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyviewHolder> {

    private Context mcontext;
    private List<Notice> mdata;

    public RecyclerViewAdapter(Context mcontext, List<Notice> mdata) {
        this.mcontext = mcontext;
        this.mdata = mdata;
    }


    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater inflater = LayoutInflater.from(mcontext);
        view = inflater.inflate(R.layout.notice_row_item,parent,false);
        final MyviewHolder viewHolder = new MyviewHolder(view);
        viewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mcontext, NoticeActivity.class);
                i.putExtra("title",mdata.get(viewHolder.getAdapterPosition()).getTitle());
                i.putExtra("date",mdata.get(viewHolder.getAdapterPosition()).getDate());
                i.putExtra("teacher",mdata.get(viewHolder.getAdapterPosition()).getTeacher_name());
                i.putExtra("text",mdata.get(viewHolder.getAdapterPosition()).getNoticeText());
                i.putExtra("img",mdata.get(viewHolder.getAdapterPosition()).getImg_url());

                mcontext.startActivity(i);
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {
        holder.Notice_title.setText(mdata.get(position).getTitle());
        holder.Notice_date.setText(mdata.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public static class MyviewHolder extends RecyclerView.ViewHolder{


        TextView Notice_title;
        TextView Notice_date;
        LinearLayout view_container;

        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            view_container = itemView.findViewById(R.id.containerId);
            Notice_title = itemView.findViewById(R.id.NTtext);
            Notice_date =  itemView.findViewById(R.id.DText);

        }
    }

}
