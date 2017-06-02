package com.example.pedro.carcollection.adapters;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pedro.carcollection.CarActivity;
import com.example.pedro.carcollection.MainActivity;
import com.example.pedro.carcollection.R;
import com.example.pedro.carcollection.models.Car;

import java.util.List;

/**
 * Created by Pedro on 30-05-2017.
 */

public class CarsAdapter extends RecyclerView.Adapter<CarsAdapter.ViewHolder> {

    private List<Car> cars = Car.listAll(Car.class);


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_car, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Car car = cars.get(position);
        TextView textView = holder.textView;
        String text = car.getBrand() + " " + car.getModel() + " - " + car.getYear();
        textView.setText(text);

        /*textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), CarActivity.class).putExtra(MainActivity.CAR_ID, car.getId());
                holder.itemView.getContext().startActivity(intent);
            }
        });*/


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), CarActivity.class).putExtra(MainActivity.CAR_ID, car.getId());
                holder.itemView.getContext().startActivity(intent);
            }
        });

    }

    public void update() {
        cars = Car.listAll(Car.class);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.titleTv);
        }
    }
}
