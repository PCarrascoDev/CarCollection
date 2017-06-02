package com.example.pedro.carcollection;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.pedro.carcollection.models.Car;

public class CarActivity extends AppCompatActivity {

    private Car car;
    private boolean isCreating;
    private CarListFragment carListFragment;
    public static final String RESULT = "com.example.pedro.carcollection.KEY.RESULT";

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car);

        isCreating = getIntent().getBooleanExtra(MainActivity.CREATE_BOOL, false);
        carListFragment = (CarListFragment) getSupportFragmentManager().findFragmentById(R.id.carListfragment);

        final EditText brandEt = (EditText) findViewById(R.id.brandEt);
        final EditText modelEt = (EditText) findViewById(R.id.modelEt);
        final Spinner yearSpin = (Spinner) findViewById(R.id.yearSpin);
        final Spinner bodySpin = (Spinner) findViewById(R.id.bodySpin);
        final CheckBox absCb = (CheckBox) findViewById(R.id.absCb);

        if (!isCreating)
        {
            long id = getIntent().getLongExtra(MainActivity.CAR_ID, 0);
            car = Car.findById(Car.class, id);

            brandEt.setText(car.getBrand());
            modelEt.setText(car.getModel());
            yearSpin.setSelection(car.getYearPos());
            bodySpin.setSelection(car.getBodyPos());
            absCb.setChecked(car.isAbs());

        }
        else
        {
            car = new Car();
        }

        ImageButton saveBtn = (ImageButton) findViewById(R.id.saveBtn);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (brandEt.getText().toString().matches("") || modelEt.getText().toString().matches(""))
                {
                    Toast.makeText(CarActivity.this, "There's an empty field!", Toast.LENGTH_SHORT).show();
                }
                else
                {

                    car.setBrand(String.valueOf(brandEt.getText()));
                    car.setModel(String.valueOf(modelEt.getText()));
                    car.setAbs(absCb.isChecked());
                    car.setYear(Integer.valueOf(yearSpin.getSelectedItem().toString()));
                    car.setBody(bodySpin.getSelectedItem().toString());

                    car.save();
                    Toast.makeText(CarActivity.this, "Changes Saved :)", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });


    }


}
