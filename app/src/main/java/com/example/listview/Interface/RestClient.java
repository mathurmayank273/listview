package com.example.listview.Interface;

import android.content.Context;


public class RestClient extends AbstractRestClient
{
    public static final String BASE_URL = "https://dl.dropboxusercontent.com";

    //public static final String login = "TMSCustLogin?mobileNo=";
    private Interface DataService;

    public RestClient(Context context)
    {
        super(context, BASE_URL);
    }
    @Override
    public void initApi()
    {
        DataService = restAdapter.create(Interface.class);
    }

    public Interface getDataService()
    {
        return DataService;
    }
}
