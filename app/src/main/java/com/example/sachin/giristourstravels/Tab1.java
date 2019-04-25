package com.example.sachin.giristourstravels;


import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sachin.giristourstravels.ModuleClass.Destination;
import com.example.sachin.giristourstravels.ModuleClass.Source;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


/**
 * A simple {@link Fragment} subclass.
 */
public class Tab1 extends Fragment {

    private int Year, Month, Day;
    Context context;
    Button vsearch;
    Spinner Sourse, Destination;
    EditText Date;
    private DatePickerDialog.OnDateSetListener datesetListener;


    public Tab1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab1, container, false);

        Sourse = view.findViewById(R.id.source);
        Destination = view.findViewById(R.id.destination);
        Date = view.findViewById(R.id.search_date);
        vsearch = view.findViewById(R.id.vehiclesearch);

        vsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()) {
                    Intent intent = new Intent(getActivity(), vehicle_list.class);
                    getActivity().startActivity(intent);


                }


            }
        });

        creatSource();
        creatDestination();

        // Search Date Alertdialog box
        Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(getContext(), Tab1.this.datesetListener, year, month, day);
//                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        datesetListener = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                // Log.d(TAG,"onDataSet: dd/mm/yyyy: " +dayOfMonth+"/" +month+"/"+year);
                String date = dayOfMonth + "/" + month + "/" + year;
                Date.setText(date);
            }
        };

        return view;

    }

    private boolean validate() {
        //just to highlight that this is an error
        if (Sourse.getSelectedItem().toString().equals(Destination.getSelectedItem().toString())) {
            TextView errorText = (TextView) Destination.getSelectedView();
            errorText.setTextColor(Color.RED);
            errorText.setError("Destination");
            errorText.setText("Select Destination");
            return false;
        } else {

            return true;
        }

    }

    private void creatSource() {
        Retrofit retrofit = RetrofitApi.getRetrofitApi();
        CustomerApi customerApi = retrofit.create(CustomerApi.class);
        final Call<List<Source>> sources = customerApi.sources();
        sources.enqueue(new Callback<List<Source>>() {
            @Override
            public void onResponse(Call<List<Source>> call, Response<List<Source>> response) {

                final List<Source> vehicles = response.body();
                final List<String> sources1 = new ArrayList<>();

                for (Source sourse : vehicles) {
                    String s = sourse.getSourse();
                    sources1.add(s);
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, sources1.toArray(new String[0]));
                Sourse.setAdapter(adapter);

                Sourse.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

            }

            @Override
            public void onFailure(Call<List<Source>> call, Throwable t) {
                Toast.makeText(context, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void creatDestination() {

        Retrofit retrofit = RetrofitApi.getRetrofitApi();
        CustomerApi customerApi = retrofit.create(CustomerApi.class);
        final Call<List<com.example.sachin.giristourstravels.ModuleClass.Destination>> destination = customerApi.destination();
        destination.enqueue(new Callback<List<Destination>>() {
            @Override
            public void onResponse(Call<List<Destination>> call, Response<List<Destination>> response) {

                final List<Destination> vehicles = response.body();
                final List<String> destinations = new ArrayList<>();

                for (Destination destination1 : vehicles) {
                    String s = destination1.getDestination();
                    destinations.add(s);
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, destinations.toArray(new String[0]));
                Destination.setAdapter(adapter);

                Destination.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

            }

            @Override
            public void onFailure(Call<List<Destination>> call, Throwable t) {

            }
        });

    }

    public interface OnFragmentInteractionListner {
    }
}
