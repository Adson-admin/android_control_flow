package com.adson.controlflow.structures;

import android.os.Bundle;
import com.adson.controlflow.ControlContent;

public class OpenContentAction implements ControlContent {

    private int contentId;

    private OpenContentActionType type;

    public OpenContentAction() {
    }

    public OpenContentAction(int contentId, OpenContentActionType type) {
        this.contentId = contentId;
        this.type = type;
    }

    public int getContentId() {
        return contentId;
    }

    public OpenContentActionType getType() {
        return type;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt("contentId", contentId);
        bundle.putInt("type", type.ordinal());
        return bundle;
    }

    public void fromBundle(Bundle bundle) {
        this.contentId = bundle.getInt("contentId", 0);
        int value = bundle.getInt("type", 0);
        this.type = OpenContentActionType.values()[value];
    }
}
