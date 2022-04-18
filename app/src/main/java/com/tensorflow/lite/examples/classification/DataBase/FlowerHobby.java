package com.tensorflow.lite.examples.classification.DataBase;

import org.litepal.LitePal;
import org.litepal.crud.LitePalSupport;

public class FlowerHobby extends LitePalSupport {
    String flower_name;
    String flower_Time;
    String flower_is_wet;

    public FlowerHobby(String flower_name, String flower_Time, String flower_is_wet) {
        this.flower_name = flower_name;
        this.flower_Time = flower_Time;
        this.flower_is_wet = flower_is_wet;
    }

    public String getFlower_name() {
        return flower_name;
    }

    public void setFlower_name(String flower_name) {
        this.flower_name = flower_name;
    }

    public String getFlower_Time() {
        return flower_Time;
    }

    public void setFlower_Time(String flower_Time) {
        this.flower_Time = flower_Time;
    }

    public String getFlower_is_wet() {
        return flower_is_wet;
    }

    public void setFlower_is_wet(String flower_is_wet) {
        this.flower_is_wet = flower_is_wet;
    }
}
