package it.italiaonline.popularmoviesrx;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import it.italiaonline.popularmoviesrx.model.MovieBean;
import it.italiaonline.popularmoviesrx.retrofit.MovieResponse;
import it.italiaonline.popularmoviesrx.retrofit.TheMovieDbService;
import it.italiaonline.popularmoviesrx.retrofit.TheMovieDbServiceFactory;
import rx.functions.Action1;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ExecutorService executorService = Executors.newCachedThreadPool();
        TheMovieDbService service =
                TheMovieDbServiceFactory.createService(TheMovieDbService.class, executorService);
        service.getPopularMovies()
                .subscribe(
                        new Action1<MovieResponse>() {
                             @Override
                             public void call(MovieResponse movieResponse) {
                                 List<MovieBean> movieBeanList = movieResponse.getMovieList();
                                 String output = "";
                                 for (MovieBean mb : movieBeanList) {
                                     output += mb.getTitle() + " ";
                                 }
                                 executorService.shutdown();
                             }
                        },
                        new Action1<Throwable>() {
                            @Override
                            public void call(Throwable throwable) {
                                throwable.printStackTrace();
                                executorService.shutdown();
                            }
                        });
    }
}
