package com.patterns.tutorialspoint.structural.proxy;

/*
    https://www.tutorialspoint.com/design_pattern/proxy_pattern.htm

    In proxy pattern, a class represents functionality of another class.
    This type of design pattern comes under structural pattern.

    In proxy pattern, we create object having original object to interface its functionality to outer world.

    Implementation:
    ================
    We are going to create an Image interface and concrete classes implementing the Image interface. ProxyImage
    is a a proxy class to reduce memory footprint of RealImage object loading.

    ProxyPatternDemo, our demo class, will use ProxyImage to get an Image object to load and display as it needs.
    ========================================================================================================================

 */
public interface Image {
    void display();
}