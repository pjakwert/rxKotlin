package com.prem.kotlin;

import io.reactivex.*;


public class Library {
    public boolean someLibraryMethod() {
        return true;
    }

    public static void main(String[] args) {
        //System.out.println(new Person("Prem Jakwert").getName());
        Flowable.just(new Person("Prem", "Jakwert")).subscribe(System.out::println);

        Flowable.just("hello").subscribe(System.out::println);


        Observable ob = Observable.create((ObservableOnSubscribe<Person>) e -> {
            //e.onNext();
        });




    }
}
