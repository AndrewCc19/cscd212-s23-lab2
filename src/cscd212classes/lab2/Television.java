package cscd212classes.lab2;

import java.util.Objects;

public class Television implements Comparable<Television>{
    private final boolean fourK;
    private final String make;
    private final String model;
    private final int resolution;
    private final int screenSize;
    private final boolean smart;

    public Television(final String make, final String model, final boolean smart, final int screenSize, final int resolution){
        if(model == null || model.isEmpty() || make == null || make.isEmpty() || screenSize < 32 || resolution < 720)
            throw new IllegalArgumentException("Invalid parameter in constructor");

        this.fourK = (resolution == 2160);
        this.model = model;
        this.smart = smart;
        this.screenSize = screenSize;
        this.resolution = resolution;
        this.make = make;
    }

    public Television(final String model, final boolean smart, final int screenSize, final int resolution, final String make){
        this(make, model, smart, screenSize, resolution);
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getResolution() {
        return resolution;
    }

    public int getScreenSize() {
        return screenSize;
    }

    @Override
    public String toString(){
        String smartOrNot = (smart) ? "smart " : "";
        String fourKOrNot = (fourK) ? "4K" : String.valueOf(resolution);
        return make + "-" + model + ", " + screenSize + " inch " + smartOrNot + "tv with " + fourKOrNot + " resolution";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Television that)) return false;
        return fourK == that.fourK && resolution == that.resolution && screenSize == that.screenSize && smart == that.smart && Objects.equals(make, that.make) && Objects.equals(model, that.model);
    }

    @Override
    public int hashCode() {
        return make.hashCode() + model.hashCode() + resolution + Boolean.hashCode(smart) + Boolean.hashCode(fourK);
    }


    @Override
    public int compareTo(Television another) {
        if(another == null)
            throw new IllegalArgumentException("null parameter in the compareTo method");

        if(this.make.equals(another.make)) {
            if (this.model.equals(another.model)) {
                return this.screenSize - another.screenSize;
            } else {
                return this.model.compareTo(another.model);
            }
        }
        else{
            return this.make.compareTo(another.make);
        }
    }
}
