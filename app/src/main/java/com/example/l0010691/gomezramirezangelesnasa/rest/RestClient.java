package com.example.l0010691.gomezramirezangelesnasa.rest;

import java.io.IOException;

import com.example.l0010691.gomezramirezangelesnasa.models.ResultNasa;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Response;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;
import retrofit.http.Query;
/**
 * Created by L0010691 on 14/02/2016.
 */
public class RestClient {
    private static GitApiInterface gitApiInterface ;
    private static String baseUrl = "https://api.nasa.gov" ;

    public static GitApiInterface getClient() {
        if (gitApiInterface == null) {

            OkHttpClient okClient = new OkHttpClient();
            okClient.interceptors().add(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Response response = chain.proceed(chain.request());
                    return response;
                }
            });

            Retrofit client = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverter(String.class, new ToStringConverter())
                    .client(okClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            gitApiInterface = client.create(GitApiInterface.class);
        }
        return gitApiInterface ;
    }

    public interface GitApiInterface {

        @GET("/mars-photos/api/v1/rovers/curiosity/photos")
        Call<ResultNasa> getPhotos(@Query("sol") int sol, @Query("api_key") String key);


    }

}
