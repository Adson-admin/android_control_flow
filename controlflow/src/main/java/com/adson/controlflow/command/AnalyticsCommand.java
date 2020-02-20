package com.adson.controlflow.command;

import com.adson.controlflow.ControlCommand;
import com.adson.controlflow.structures.analytics.AnalyticsChunkEvent;

public class AnalyticsCommand extends ControlCommand {

    public AnalyticsCommand(AnalyticsChunkEvent event) {
        super("analytics", event);
    }
}
