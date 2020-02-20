package com.adson.controlflow.structures.analytics;

import android.os.Bundle;
import com.adson.controlflow.ControlContent;
import com.google.gson.Gson;

public class AnalyticsChunkEvent implements ControlContent {

    private AnalyticsEvent[] events;

    public AnalyticsChunkEvent() {
    }

    public AnalyticsChunkEvent(AnalyticsEvent[] events) {
        this.events = events;
    }

    @Override
    public Bundle toBundle() {
        Gson gson = new Gson();
        String eventsJson = gson.toJson(events);
        Bundle bundle = new Bundle();
        bundle.putString("events", eventsJson);
        return bundle;
    }

    @Override
    public void fromBundle(Bundle bundle) {
        String eventsJson = bundle.getString("events");
        Gson gson = new Gson();
        this.events = gson.fromJson(eventsJson, AnalyticsEvent[].class);
    }

    public AnalyticsEvent[] getEvents() {
        return events;
    }
}
