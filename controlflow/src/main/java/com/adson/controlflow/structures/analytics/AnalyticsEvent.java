package com.adson.controlflow.structures.analytics;

public class AnalyticsEvent {

    private int contentId;

    private String category;

    private String action;

    private String label;

    public AnalyticsEvent(int contentId, String action) {
        this.contentId = contentId;
        this.action = action;
    }

    public AnalyticsEvent(int contentId, String category, String action, String label) {
        this.contentId = contentId;
        this.category = category;
        this.action = action;
        this.label = label;
    }


    public int getContentId() {
        return contentId;
    }

    public String getCategory() {
        return category;
    }

    public String getAction() {
        return action;
    }

    public String getLabel() {
        return label;
    }
}
