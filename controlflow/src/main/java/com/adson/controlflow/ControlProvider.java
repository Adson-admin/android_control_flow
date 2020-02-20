package com.adson.controlflow;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class ControlProvider {

    private String scheme;

    private ControlProvider() {
    }

    private ControlProvider(String scheme) {
        this.scheme = scheme;
    }

    public void open(Context context, ControlCommand action) {

        Uri uri = Uri.parse(scheme + "://" + action.getCommand());
        Intent intent = createIntent(uri, action);

        try {
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void send(Context context, ControlCommand action) {
        Uri uri = Uri.parse(scheme + "-receiver://" + action.getCommand());
        Intent intent = createIntent(uri, action);
        context.sendBroadcast(intent);
    }

    public <T extends ControlContent> T handle(Intent intent, Class<T> tClass) {

        if (intent == null) {
            return null;
        }

        String name = tClass.getSimpleName();
        Bundle bundle = intent.getBundleExtra(name);

        if (bundle == null) {
            return null;
        }

        try {
            T result = tClass.newInstance();
            result.fromBundle(bundle);
            return result;
        } catch (Exception e) {
            return null;
        }
    }

    private Intent createIntent(Uri uri, ControlCommand action) {

        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        ControlContent content = action.getContent();

        String name = content.getClass().getSimpleName();
        intent.putExtra(name, content.toBundle());

        return intent;
    }

    public static class Builder {

        public ControlProvider buildAdsonStub() {
            return new ControlProvider("adsonstub");
        }

        public ControlProvider buildCompanion() {
            return new ControlProvider("adson-companion");
        }
    }

}
