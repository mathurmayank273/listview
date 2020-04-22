package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.listview.Adapter.CountryAdapter;
import com.example.listview.Interface.RestClient;
import com.example.listview.Models.Country;
import com.example.listview.Models.Row;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity
{

    ArrayList<Row> resultDetails;
    CountryAdapter adapter;

    ListView country_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        country_list = (ListView) findViewById(R.id.country_list) ;

        new RestClient(getApplicationContext()).getDataService().country_details(new Callback<Country>()
        {
            @Override
            public void success(Country country, Response response)
            {
                if (country.getTitle().equals("About Canada"))
                {
                    resultDetails = (ArrayList<Row>) country.getRows();

                    adapter = new CountryAdapter(getApplicationContext(), resultDetails);
                    country_list.setAdapter(adapter);
                }
                else if (country != null && country.getTitle().equalsIgnoreCase("error"))
                {

                }
            }
            @Override
            public void failure(RetrofitError error)
            {
                Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                Log.d("error", error.toString());
            }

        });


    }
}
