package com.observer.infoworld;
/*
    https://www.infoworld.com/article/2077258/observer-and-observable.html
 */
import java.util.Observable;

public class ObservableValue extends Observable
{
   private int nValue = 0;
   private int nLow = 0;
   private int nHigh = 0;

   public ObservableValue(int nValue, int nLow, int nHigh)
   {
      this.nValue = nValue;
      this.nLow = nLow;
      this.nHigh = nHigh;
   }
   public ObservableValue(int nValue)
   {
      this.nValue = nValue;
   }

   public void setValue(int nValue)
   {
      this.nValue = nValue;

      setChanged();
      notifyObservers();
   }

   public int getValue()
   {
      return nValue;
   }

   public int getLowerBound()
   {
      return nLow;
   }

   public int getHigherBound()
   {
      return nHigh;
   }
}
