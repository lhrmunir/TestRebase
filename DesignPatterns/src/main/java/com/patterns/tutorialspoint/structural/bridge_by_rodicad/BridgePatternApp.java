package com.patterns.tutorialspoint.structural.bridge_by_rodicad;

import com.patterns.tutorialspoint.structural.bridge_by_rodicad.shape.BlueCircle;
import com.patterns.tutorialspoint.structural.bridge_by_rodicad.shape.Circle;
import com.patterns.tutorialspoint.structural.bridge_by_rodicad.shape.RedCircle;
import com.patterns.tutorialspoint.structural.bridge_by_rodicad.shape.Shape;

/**
 * Created by rodicad on 26/10/2017.
 */
public class BridgePatternApp {

    public static void main(String[] args) {
        Shape circle = new Circle( 10,12,5, new RedCircle() );
        Shape blueCircle = new Circle( 10,12,5, new BlueCircle() );

        circle.draw();
        blueCircle.draw();
    }
}
