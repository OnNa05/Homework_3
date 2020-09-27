package com.example.homework3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.homework3.WordItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyAdapter adapter = new MyAdapter();

        LinearLayoutManager lm = new LinearLayoutManager(MainActivity.this);

        RecyclerView rv = findViewById(R.id.wordList_recyclerView);
        rv.setLayoutManager(lm);
        rv.setAdapter(adapter);
    }
}

class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private WordItem[] items = {
            new WordItem(R.drawable.brunei, "Brunei Darussalam","เมืองหลวง : บันดาร์ เสรี เบกาวัน"),
            new WordItem(R.drawable.cambodia, "Cambodia","เมืองหลวง : กรุงพนมเปญ"),
            new WordItem(R.drawable.indonesia, "Indonesia","เมืองหลวง : จาการ์ตา"),
            new WordItem(R.drawable.laos, "Laos","เมืองหลวง : นครหลวงเวียงจันทร์"),
            new WordItem(R.drawable.malaysia, "Malaysia","เมืองหลวง : กรุงกัวลาลัมเปอร์"),
            new WordItem(R.drawable.myanmar, "Myanmar","เมืองหลวง : เนปีดอ"),
            new WordItem(R.drawable.philipinnes, "Philippines","เมืองหลวง : กรุงมะนิลา"),
            new WordItem(R.drawable.singapore, "Singapore","เมืองหลวง : สิงคโปร์"),
            new WordItem(R.drawable.vietnam, "Vietnam","เมืองหลวง : กรุงฮานอย"),
            new WordItem(R.drawable.thailand, "Thailand","เมืองหลวง : กรุงเทพมหานคร")
    };


    public MyAdapter() {
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_word, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.imageView.setImageResource(items[position].imageResId);
        holder.wordTextView.setText(items[position].word);
        holder.wordTextView2.setText(items[position].word2);
    }

    @Override
    public int getItemCount() {
        return items.length;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView wordTextView;
        TextView wordTextView2;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
            wordTextView = itemView.findViewById(R.id.word_text_view);
            wordTextView2 = itemView.findViewById(R.id.word_text_view2);
        }
    }
}
