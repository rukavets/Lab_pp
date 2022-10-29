package com.Records.InfoTrack;
public class Track {
    private  String name;
    private String style;
    private double duration;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "name: "+ name+ "\n style: "+ style+"\n duration: "+ duration;
    }
}
