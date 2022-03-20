package com.observer.infoworld;
/*
    https://www.infoworld.com/article/2077258/observer-and-observable.html
 */
import java.awt.*;
import java.util.Observer;
import java.util.Observable;

public class ScrollObserver extends Frame implements Observer
{
   private ObservableValue ov = null;

   private Scrollbar sb = null;

   public ScrollObserver(ObservableValue ov)
   {
      super("Scroll Observer Tool");

      this.ov = ov;

      setLayout(new GridLayout(0, 1));

      sb = new Scrollbar(Scrollbar.HORIZONTAL,
                         ov.getValue(), 10,
                         ov.getLowerBound(),
                         ov.getHigherBound());

      add(sb);

      pack();
      show();
   }

   public boolean handleEvent(Event evt)
   {
      if (evt.id == Event.WINDOW_DESTROY)
      {
         ov.deleteObserver(this);

         dispose();

         return true;
      }
      else if (evt.id == Event.SCROLL_LINE_UP)
      {
         ov.setValue(sb.getValue());
         return true;
      }
      else if (evt.id == Event.SCROLL_LINE_DOWN)
      {
         ov.setValue(sb.getValue());
         return true;
      }
      else if (evt.id == Event.SCROLL_PAGE_UP)
      {
         ov.setValue(sb.getValue());
         return true;
      }
      else if (evt.id == Event.SCROLL_PAGE_DOWN)
      {
         ov.setValue(sb.getValue());
         return true;
      }
      else if (evt.id == Event.SCROLL_ABSOLUTE)
      {
         ov.setValue(sb.getValue());
         return true;
      }
  
      return super.handleEvent(evt);
   }

   public void update(Observable obs, Object obj)
   {
      if (obs == ov)
      {
         sb.setValue(ov.getValue());
      }
   }
}
