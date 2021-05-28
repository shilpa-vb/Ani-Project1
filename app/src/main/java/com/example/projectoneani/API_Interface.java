package com.example.projectoneani;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API_Interface {

    @GET("api/?key=21762589-eccf546162757c2653ac25ec6&q=nature&image_type=all")


    Call<JSON_Response> getGridImages();

}
