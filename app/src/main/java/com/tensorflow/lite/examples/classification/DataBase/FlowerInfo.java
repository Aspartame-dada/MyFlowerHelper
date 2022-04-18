package com.tensorflow.lite.examples.classification.DataBase;

import org.litepal.crud.LitePalSupport;

public class FlowerInfo extends LitePalSupport {
    private int objectId;
    private String data;
    private String type;

    public FlowerInfo() {
    }

    public FlowerInfo(int objectId, String data, String type) {
        this.objectId = objectId;
        this.data = data;
        this.type = type;
    }

    public int getObjectId() {
        return objectId;
    }

    public void setObjectId(int objectId) {
        this.objectId = objectId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
