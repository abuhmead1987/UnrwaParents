package com.moh.android.unrwaparents.Adapters;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.moh.android.unrwaparents.Models.Student;
import com.moh.android.unrwaparents.R;

public class StudentsListAdapter extends FirebaseRecyclerAdapter<Student,StudentsListAdapter.ItemViewHolder> {
    public StudentsListAdapter(@NonNull FirebaseRecyclerOptions<Student> options, Context context, FragmentManager fb) {
        super(options);
    }
    @Override
    protected void onBindViewHolder(@NonNull ItemViewHolder holder, int position, @NonNull Student student) {
        holder.tv_Name.setText(student.getName());
        holder.tv_Number.setText(student.getName());
        holder.tv_Gender.setText(student.getGender());
        holder.tv_Grade.setText(student.getGrade());
        holder.tv_Name.setText(student.getName());
        try {
            Glide.with(holder.img_Photo.getContext()).load(Uri.parse(student.getImagePath())).into(holder.img_Photo);
        }catch (Exception e){
            Log.i("LIFFS","LoadingImageFromFireStorage "+e.getMessage());}

    }
    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int index) {
        return new ItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.childs_list_item,parent,false));
    }
    public class ItemViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener {

        TextView tv_Name,tv_Number, tv_Gender, tv_Grade;
        ImageView img_Photo;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_Name=itemView.findViewById(R.id.tv_stdName);
            tv_Number=itemView.findViewById(R.id.tv_stdNumber);
            tv_Gender=itemView.findViewById(R.id.tv_stdGrade);
            tv_Grade=itemView.findViewById(R.id.tv_stdGrade);
            img_Photo=itemView.findViewById(R.id.img_stdImage);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {


        }
    }
}
