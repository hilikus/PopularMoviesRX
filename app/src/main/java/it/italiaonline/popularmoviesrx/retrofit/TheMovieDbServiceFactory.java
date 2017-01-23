package it.italiaonline.popularmoviesrx.retrofit;

import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.Executor;

import retrofit.RestAdapter;
import retrofit.client.OkClient;


/**
 * Created by d7137 on 13/12/2016.
 */

public class TheMovieDbServiceFactory {

    private static final String TMDB_API_BASE_URL = "http://api.themoviedb.org/3";
    private static final String TMDB_API_KEY = "40c667ceacfe11a1b2b1c0688915c7af";

    public static <T> T createService(Class<T> serviceClass, Executor executor) {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(TMDB_API_BASE_URL)
                .setClient(new OkClient(new OkHttpClient()))
                .setExecutors(executor, executor)
                .setRequestInterceptor(request -> {
                    request.addQueryParam("api_key", TMDB_API_KEY);
                })
                .build();
        restAdapter.setLogLevel(RestAdapter.LogLevel.BASIC);
        return restAdapter.create(serviceClass);
    }

}
