package com.adson.controlflow.command;

import com.adson.controlflow.ControlCommand;
import com.adson.controlflow.structures.ContentLocation;

public class UpdateContentCommand extends ControlCommand {

    public UpdateContentCommand(ContentLocation content) {
        super("update-content", content);
    }
}
