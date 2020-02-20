package com.adson.controlflow.command;

import com.adson.controlflow.ControlCommand;
import com.adson.controlflow.structures.OpenContentAction;

public class OpenContentCommand extends ControlCommand {

    public OpenContentCommand(OpenContentAction content) {
        super("open-poi", content);
    }

}
