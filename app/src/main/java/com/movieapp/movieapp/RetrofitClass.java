package com.movieapp.movieapp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClass {

    private static Gson gson = new GsonBuilder()
            .setLenient()
            .create();

    private static Retrofit retrofit= new Retrofit.Builder()
            .baseUrl("https://fullmovieapp.000webhostapp.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();

    /*
     public static Retrofit getClient() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();


        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.12:80/MovieApp/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();



        return retrofit;
    }


    public static Retrofit getRetrofit() {
        if (retrofit == null){
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder().addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();

                Request.Builder builder = originalRequest.newBuilder().header("Authorization",
                        Credentials.basic("root", ""));

                Request newRequest = builder.build();
                return chain.proceed(newRequest);
            }
        }).build();

        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.12:80/MovieApp/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();//10.0.2.2:63342
        ///192.168.1.8 (port 80) from /192.168.1.14 (port 37862)
             }
        return retrofit;
    }

     */

    public static <S> S createService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }

}
