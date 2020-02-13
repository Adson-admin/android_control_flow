package com.adson.controlflow.structures;

import android.os.Bundle;
import com.adson.controlflow.ControlContent;

public class ContentLocation implements ControlContent {

    private String contentFilePath;

    public ContentLocation() {
    }

    public ContentLocation(String location) {
        this.contentFilePath = location;
    }

    public String getContentFilePath() {
        return contentFilePath;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString("path", contentFilePath);
        return bundle;
    }

    public void fromBundle(Bundle bundle) {
        this.contentFilePath = bundle.getString("path", null);
    }
}
