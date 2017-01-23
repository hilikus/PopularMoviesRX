package it.italiaonline.popularmoviesrx.application;

import it.italiaonline.popularmoviesrx.model.MovieBean;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;

/**
 * Created by d7137 on 07/12/2016.
 */

public class MyRxJava {
    public static void main(String[] args) {

        try {
            Class<MovieBean> movieBeanClass = (Class<MovieBean>) Class.forName("MovieBean");
            MovieBean mb = movieBeanClass.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                for (int i = 0; i < 100; i += 2) {
                    subscriber.onNext(i);
                }
                subscriber.onCompleted();
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Integer integer) {
                System.out.println(integer);
            }
        });

    }
}
