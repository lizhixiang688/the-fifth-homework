package com.example.homework;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.ViewHolder> {
    private List<People> mpeople;

    @Override
    public int getItemCount() {
        return mpeople.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView peopleImage;
        TextView peopleName;
        public ViewHolder(View view){
            super(view);
            peopleImage=(ImageView)view.findViewById(R.id.people_image);
            peopleName=(TextView)view.findViewById(R.id.people_name);
        }
    }
    public PeopleAdapter(List<People>peopleList){
        mpeople=peopleList;
    }
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.people_item,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }
    public void onBindViewHolder(ViewHolder holder,int position){

        People people=mpeople.get(position);
        holder.peopleImage.setImageResource(people.getImgid());
        holder.peopleName.setText(people.getName());
    }

}