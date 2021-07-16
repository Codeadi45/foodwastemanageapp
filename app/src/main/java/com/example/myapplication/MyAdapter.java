package com.example.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class MyAdapter  extends FirebaseRecyclerAdapter<model,MyAdapter.Myviewholder> {


    public MyAdapter(@NonNull FirebaseRecyclerOptions<model> options) {
        super(options);



    }
    class Myviewholder extends RecyclerView.ViewHolder {

        TextView name,location,food,phone;
        ImageView call,map,delete;




        public Myviewholder(@NonNull View itemView) {
            super(itemView);




            name = (TextView) itemView.findViewById(R.id.Name);
            location = (TextView) itemView.findViewById(R.id.location);
            food = (TextView) itemView.findViewById(R.id.desc);

            phone = (TextView) itemView.findViewById(R.id.number);
            call = (ImageView) itemView.findViewById(R.id.Call);
            map = (ImageView) itemView.findViewById(R.id.Map);
            delete = (ImageView) itemView.findViewById(R.id.del);



        }

    }


    @Override
    protected void onBindViewHolder(@NonNull final Myviewholder myviewholder, int i, @NonNull final model Model) {
        myviewholder.name.setText(Model.getName());
        myviewholder.phone.setText(Model.getPhone());
        myviewholder.location.setText(Model.getLocation());
        myviewholder.food.setText(Model.getFood());
        myviewholder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(v.getContext());
                dialog.setTitle("REMOVE THIS ITEM");
                dialog.setMessage("Are you sure you have taken this food?");
                dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        FirebaseDatabase.getInstance().getReference().child("delivery").child(getRef(i).getKey()).removeValue();
                    }
                });
                dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.show();
            }
        });




    }




    @NonNull
    @Override
    public Myviewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {


        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview, null, false);

        return new MyAdapter.Myviewholder(view);
    }






}
