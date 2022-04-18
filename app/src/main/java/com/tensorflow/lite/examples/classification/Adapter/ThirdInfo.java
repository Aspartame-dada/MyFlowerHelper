package com.tensorflow.lite.examples.classification.Adapter;

public class ThirdInfo {
    private int imageId;

    public ThirdInfo(int imageId,String iconId){
        this.imageId=imageId;
        this.iconId=iconId;

    }
    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getIconId() {
        return iconId;
    }

    public void setIconId(String iconId) {
        this.iconId = iconId;
    }

    private String iconId;

}
