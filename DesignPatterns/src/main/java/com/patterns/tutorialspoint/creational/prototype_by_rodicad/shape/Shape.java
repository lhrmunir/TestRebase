package com.patterns.tutorialspoint.creational.prototype_by_rodicad.shape;

/**
 * Created by rodicad on 25/10/2017.
 */
public abstract class Shape implements Cloneable {
    String id;
    String type;

    abstract void draw();


    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setId( String id ) {
        this.id = id;
    }

    public void setType( String type ) {
        this.type = type;
    }

    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch ( CloneNotSupportedException e ) {
            e.printStackTrace();
        }
        return clone;
    }


}
