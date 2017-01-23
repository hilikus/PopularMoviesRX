package it.italiaonline.popularmoviesrx.retrofit;

import retrofit.http.GET;
import rx.Observable;

/**
 * Created by d7137 on 13/12/2016.
 */

public interface TheMovieDbService {

    @GET("/movie/popular")
    Observable<MovieResponse> getPopularMovies();

    @GET("/movie/top_rated")
    Observable<MovieResponse> getTopRatedMovies();

}
