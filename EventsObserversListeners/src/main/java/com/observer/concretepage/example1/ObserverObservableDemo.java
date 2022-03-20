package com.observer.concretepage.example1;
/*
        https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Observer.html
        https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Observable.html
        https://www.concretepage.com/java/example-observer-observable-java

    1. The java.util.Observer is an interface and it must be implemented by the class which needs
       to be informed about changes in our observable class. Observe class has only 1 below method:

                void update(Observable o, Object arg) -> This method is called whenever the observed object is changed.

    2. The java.util.Observable class must be extended by the class which is being observed.
    3. In Observer interface, there is a method update() that is called by Observable class.
    4. The Observable class calls its setChanged() method to the change its return value as true.
    5. The notifyObservers() method of Observable class notifies observers about the changes.
*/

/*
    Class java.util.Observable

    void	        addObserver(Observer o)	        Adds an observer to the set of observers for this object, provided that it is not the same as some observer already in the set.
    protected void	clearChanged()	                Indicates that this object has no longer changed, or that it has already notified all of its observers of its most recent change, so that the hasChanged method will now return false.
    int	            countObservers()	            Returns the number of observers of this Observable object.
    void	        deleteObserver(Observer o)	    Deletes an observer from the set of observers of this object.
    void	        deleteObservers()	            Clears the observer list so that this object no longer has any observers.
    boolean	        hasChanged()	                Tests if this object has changed.
    void	        notifyObservers()	            If this object has changed, as indicated by the hasChanged method, then notify all of its observers and then call the clearChanged method to indicate that this object has no longer changed.
    void	        notifyObservers(Object arg)	    If this object has changed, as indicated by the hasChanged method, then notify all of its observers and then call the clearChanged method to indicate that this object has no longer changed.
    protected void	setChanged()	                Marks this Observable object as having been changed; the hasChanged method will now return true.
*/
import java.util.Observable;
import java.util.Observer;

// First observer
class FirstNewsReader implements Observer
{
    // 	update(Observable o, Object arg) method is defined in Observer Interface
    public void update(Observable obj, Object arg) {
        System.out.println("FirstNewsReader got The news : " + (String)arg);
    }
}

//Second Observer
class SecondNewsReader implements Observer
{
    public void update(Observable obj, Object arg) {
        System.out.println("SecondNewsReader got The news : " + (String)arg + " >>>> from : " +((News)obj).getIdentity());
    }
}

// This is the class being observed.
class News extends Observable
{
    // public static final String = null; // String = "Hey! I am News Observable...";
    // String = "Hey! I am News Observable...";
    public String getIdentity()
    {
        return "Hey! I am News Observable...";
    }

    void news()
    {
        String[] news = {"News 1", "News 2", "News 3"};

        for(String s: news)
        {
            //set change
            setChanged();   /*  IF WE COMMENT THIS LINE THEN OVERRIDDEN update(Observable obj, Object arg) IN
                                OBSERVER CLASSES i,e. FirstNewsReader and SecondNewsReader WILL NEVER BE CALLED.
                                AND
                                hasChanged() ---> WILL RETURN false
                            */
            System.out.println("inside Observale class i,e. News -> hasChanged() = " + hasChanged());

            //notify observers for change
            notifyObservers(s); // calls the update() methods in observer classes i,e. FirstNewReader and SecondNewsReader
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Error Occurred.");
            }
        }
    }
}

// Run Observer and Observable
public class ObserverObservableDemo
{
    public static void main(String args[])
    {
        News observedNews = new News();                         // News is Observable
        FirstNewsReader reader1 = new FirstNewsReader();        // FirstNewsReader is Observer
        SecondNewsReader reader2 = new SecondNewsReader();      // SecondNewsReader is Observer

        observedNews.addObserver(reader1);
        observedNews.addObserver(reader2);

        observedNews.news();

    }
}
