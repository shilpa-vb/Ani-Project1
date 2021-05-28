package com.example.projectoneani;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    GridView gridImage;
    GridImages_Adapter adapter;
    List<GridImages_Class> imageList;
    TextView txtConnection;
    boolean connected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridImage = (GridView)findViewById(R.id.image_gridview);
        txtConnection = (TextView)findViewById(R.id.txt_connection);
        imageList = new ArrayList<>();

        //for checking connectivity
        checkInternetConnection();

        //on gridview image clicked
        gridImage.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(MainActivity.this, EnlargeImage.class).putExtra("largeImage", imageList.get(position)));
            }
        });

    }

    private void checkInternetConnection() {
        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED)
        {
            connected = true;
        }
        else
        {
            connected = false;
        }
//        Log.i("internet", String.valueOf(connected));
        if(connected==true) {
            txtConnection.setText("GridView Images");
            getImages();
        }
        else{
            txtConnection.setText("Please connect to Internet and Come back again");
        }
    }

    //Using Retrofit
    public void getImages(){
        Call<JSON_Response> call_images = API_Client.apiInterface().getGridImages();
//        Log.i("call images", call_images.toString());
        call_images.enqueue(new Callback<JSON_Response>() {
            @Override
            public void onResponse(Call<JSON_Response> call_images, Response<JSON_Response> response) {
        Log.i("response", response.toString());
                if(response.isSuccessful()) {
                    JSON_Response jsonRes = response.body();
                    imageList = new ArrayList<>(Arrays.asList(jsonRes.getHits()));
                    adapter = new GridImages_Adapter(imageList, MainActivity.this);
                    gridImage.setAdapter(adapter);
                    Toast.makeText(getApplicationContext(), "Successfull!!!!!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Error Occurred", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<JSON_Response> call_images, Throwable t) {
                Toast.makeText(getApplicationContext(), "Error Occurred" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                Log.i("Localized Message", t.getLocalizedMessage());
            }
        });
    }
}