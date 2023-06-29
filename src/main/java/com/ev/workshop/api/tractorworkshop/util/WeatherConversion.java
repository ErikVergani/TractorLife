package com.ev.workshop.api.tractorworkshop.util;

import com.google.gson.Gson;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class WeatherConversion
{
    public String getWather() throws Exception
    {
        Gson gson = new Gson();

        Map<String, Object> jsonMap = new HashMap<>();

        URL url = new URL( "https://api.hgbrasil.com/weather?format=json&key=f812e0c9&user_ip=remote" );

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod( "GET" );

        connection.addRequestProperty(  HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE );

        int responseCode = connection.getResponseCode();

        if ( responseCode >= 200 && responseCode <= 299 )
        {
            InputStream responseStream = connection.getInputStream();
            jsonMap = gson.fromJson( new String(responseStream.readAllBytes()) , Map.class);
        }
        else
        {
            throw new Exception( connection.getResponseMessage() + responseCode );
        }

        return gson.toJson( jsonMap );
    }
}
