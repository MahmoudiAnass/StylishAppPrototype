package com.example.prototypestylish;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class imageSliderAdapter extends RecyclerView.Adapter<imageSliderAdapter.myViewHolder> {

    int[] images;
    String[] texts;
    Context context;

    public imageSliderAdapter(int[] images, String[] texts, Context context) {
        this.images = images;
        this.texts = texts;
        this.context = context;
    }


    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.imageitem, parent, false);
        return new myViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.imageView.setImageResource(images[position]);
        holder.textView.setText(texts[position]); // Set text
        holder.button.setOnClickListener(v -> {
            // Handle button click here, e.g., show a Toast
            Toast.makeText(context, "Button clicked on page " + position, Toast.LENGTH_SHORT).show();
        });
    }


    @Override
    public int getItemCount() {
        return images.length;
    }

    class myViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;
        androidx.appcompat.widget.AppCompatButton button;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.text_view);
            button = itemView.findViewById(R.id.button);
        }
    }


}