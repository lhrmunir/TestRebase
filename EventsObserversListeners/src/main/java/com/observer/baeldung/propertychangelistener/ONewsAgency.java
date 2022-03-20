package com.observer.baeldung.propertychangelistener;
/*
    https://www.baeldung.com/java-observer-pattern
*/
import java.util.Observable;

public class ONewsAgency extends Observable {
    private String news;

    public void setNews(String news) {
        this.news = news;
        setChanged();
        notifyObservers(news);
    }
}
