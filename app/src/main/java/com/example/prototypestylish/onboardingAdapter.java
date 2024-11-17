package com.example.prototypestylish;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import java.util.List;

public class onboardingAdapter extends RecyclerView.Adapter<onboardingAdapter.myViewHolder> {


    Context context;
    List<onBoardingitem> onBoardingitems;
    ViewPager2 viewPager2;

    public onboardingAdapter(Context context, List<onBoardingitem> onBoardingitems, ViewPager2 viewPager2) {
        this.context = context;
        this.onBoardingitems = onBoardingitems;
        this.viewPager2 = viewPager2;
    }



    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.onboarding_container,parent,false);
        return new myViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        holder.counter.setText(onBoardingitems.get(position).getCounter());
        holder.image.setImageResource(onBoardingitems.get(position).getImage());
        holder.title.setText(onBoardingitems.get(position).getTitle());
        holder.description.setText(onBoardingitems.get(position).getDescription());
        holder.next.setText(onBoardingitems.get(position).getNextButton());
        holder.previous.setText(onBoardingitems.get(position).getPreviousButton());

        holder.next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(position< onBoardingitems.size()-1){
                    viewPager2.setCurrentItem(position+1,true);
                }
            }
        });

        holder.previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager2.setCurrentItem(position-1 , true);
            }
        });

        holder.previous.setVisibility(position ==0 ? View.INVISIBLE:View.VISIBLE);


    }

    @Override
    public int getItemCount() {
        return onBoardingitems.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder {

        TextView counter;
        ImageView image;
        TextView title;
        TextView description;
        Button next;
        Button previous;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            counter = itemView.findViewById(R.id.pagenumber);
            image = itemView.findViewById(R.id.productimage);
            title = itemView.findViewById(R.id.choseproducttitle);
            description = itemView.findViewById(R.id.choseproductdescription);
            next = itemView.findViewById(R.id.nextButton);
            previous = itemView.findViewById(R.id.prevButton);
        }
    }
}
