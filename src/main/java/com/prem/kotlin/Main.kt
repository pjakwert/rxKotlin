package com.prem.kotlin

import com.prem.kotlin.koans.start
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.schedulers.Schedulers
import java.util.*


fun main(args: Array<String>) {
    println("let's go")

    while (true) {
        getRandomPeople()
                .flatMap { list -> Observable.fromIterable(list) }
                .map { s ->  if (s.lastname.equals("Jakwert", true)) { s.firstname.toUpperCase() + " --- " + s.lastname.toUpperCase() } else { s } }
                .subscribeOn(Schedulers.io())
                .subscribe(System.out::println)

        Thread.sleep(1000)
    }

    //getRandomPerson().subscribe(System.out::println)
}


val fnames = arrayOf("Albert", "Niels", "Prem", "John", "Keith", "Rob", "Rusty", "Elvis", "Tadeusz", "Richi")
val lnames = arrayOf("Einstein", "Bohr", "Jakwert", "Zorn", "Jarret", "Zombie", "Newman", "Presley", "Kowalski", "Monday")


fun getRandomPeople() : Observable<List<Person>> {
    return object : Observable<List<Person>>() {
        override fun subscribeActual(observer: Observer<in List<Person>>?) {
            val n = 10;
            val ret = ArrayList<Person>(n)
            for (i in 0..n-1) {
                ret += Person(fnames[(Math.random() * fnames.size).toInt()], lnames[(Math.random() * lnames.size).toInt()])
            }
            observer?.onNext(ret)
        }
    }
}


fun getRandomPerson() : Observable<Person> {
    return object : Observable<Person>() {
        override fun subscribeActual(observer: Observer<in Person>?) {
            observer?.onNext( Person(fnames[(Math.random() * fnames.size).toInt()], lnames[(Math.random() * lnames.size).toInt()]) )
        }
    }
}