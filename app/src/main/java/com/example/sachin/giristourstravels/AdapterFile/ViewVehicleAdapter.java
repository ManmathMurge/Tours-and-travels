package com.example.sachin.giristourstravels.AdapterFile;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sachin.giristourstravels.ModuleClass.Customer;
import com.example.sachin.giristourstravels.ModuleClass.Vehicle_Details;
import com.example.sachin.giristourstravels.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ViewVehicleAdapter extends RecyclerView.Adapter<ViewVehicleAdapter.RecyclerViewHolder> {
    private Context context;
    private List<Vehicle_Details> vehicleDetails;

    public ViewVehicleAdapter(Context context, List<Vehicle_Details> vehicle_details) {
        this.context = context;
        this.vehicleDetails = vehicle_details;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.vehicle_list_item,viewGroup,false);
        return new RecyclerViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder recyclerViewHolder, int i) {

        final Vehicle_Details vehicleDetails1=vehicleDetails.get(i);
        recyclerViewHolder.vname.setText(vehicleDetails1.getVName());
        recyclerViewHolder.vnumber.setText(vehicleDetails1.getVNumber());
        recyclerViewHolder.vsource.setText(vehicleDetails1.getSourse());
        recyclerViewHolder.vdestiation.setText(vehicleDetails1.getDestination());
        recyclerViewHolder.Fare.setText(vehicleDetails1.getNoOfSeat());
        Picasso.with(context).load(vehicleDetails1.getVPhoto()).into(recyclerViewHolder.imageView);

    }

    @Override
    public int getItemCount() {
       return vehicleDetails.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder{

        TextView vname;
        TextView vnumber;
        TextView vsource;
        TextView vdestiation;
        TextView Fare;
        ImageView imageView;
        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

            vname=itemView.findViewById(R.id.vName);
            vnumber=itemView.findViewById(R.id.vNumber);
            vsource=itemView.findViewById(R.id.vsource);
            vdestiation=itemView.findViewById(R.id.vdestination);
            Fare=itemView.findViewById(R.id.fare);
            imageView=itemView.findViewById(R.id.vehicle_image);
        }
    }


}
