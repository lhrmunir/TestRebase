package com.observer.infoworld;
/*
    https://www.infoworld.com/article/2077258/observer-and-observable.html
 */
import java.awt.*;
import java.util.Observer;
import java.util.Observable;

public class TextObserver extends Frame implements Observer
{
   private ObservableValue ov = null;

   private TextField tf = null;
   private Label l = null;

   private int nLow = 0;
   private int nHigh = 0;

   public TextObserver(ObservableValue ov)
   {
      super("Text Observer Tool");

      this.ov = ov;

      setLayout(new GridLayout(0, 1));

      nLow = ov.getLowerBound();
      nHigh = ov.getHigherBound();

      tf = new TextField(String.valueOf(ov.getValue()));

      add(tf);

      l = new Label();

      add(l);

      pack();
      show();
   }

   public boolean action(Event evt, Object obj)
   {
      if (evt.target == tf)
      {
         int n = 0;

         boolean boolValid = false;

         try
         {
            n = Integer.parseInt(tf.getText());
            boolValid = true;
         }
         catch (NumberFormatException nfe)
         {
            boolValid = false;
         }
            
         if (n < nLow || n > nHigh)
         {
            boolValid = false;
         }

         if (boolValid)
         {
            ov.setValue(n);

            l.setText("");
         }
         else
         {
            l.setText("invalid value -- please try again...");
         }

         return true;
      }

      return false;
   }

   public boolean handleEvent(Event evt)
   {
      if (evt.id == Event.WINDOW_DESTROY)
      {
         ov.deleteObserver(this);

         dispose();

         return true;
      }   
  
      return super.handleEvent(evt);
   }

   public void update(Observable obs, Object obj)
   {
      if (obs == ov)
      {
         tf.setText(String.valueOf(ov.getValue()));
      }
   }
}
