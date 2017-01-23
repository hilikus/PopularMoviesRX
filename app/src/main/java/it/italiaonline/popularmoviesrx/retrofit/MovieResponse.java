package it.italiaonline.popularmoviesrx.retrofit;

import java.util.List;

import it.italiaonline.popularmoviesrx.model.MovieBean;

/**
 * Created by d7137 on 16/12/2016.
 */
public class MovieResponse {

    private List<MovieBean> movieList;

    public MovieResponse(List<MovieBean> movieList) {
        this.movieList = movieList;
    }

    public List<MovieBean> getMovieList() {
        return movieList;
    }

}
