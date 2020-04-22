package com.example.listview.Interface;




import com.example.listview.Models.Country;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

public interface Interface
{

    @GET("/s/2iodh4vg0eortkl/facts.json")
    void country_details(
            Callback<Country> hello) ;


}
