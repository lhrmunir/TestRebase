package com.methodreference.advancedArpitMedium;

public class Color {

    String name;
    String htmlCode;

    public Color(String name, String htmlCode) {
        super();
        this.name = name;
        this.htmlCode = htmlCode;
    }

    public Color()
    {
        name = "black";
        htmlCode="#000000";
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getHtmlCode() {
        return htmlCode;
    }
    public void setHtmlCode(String htmlCode) {
        this.htmlCode = htmlCode;
    }

    @Override
    public String toString() {
        return "Color [name:"+name+" HtmlCode:"+htmlCode+"]";
    }

}
