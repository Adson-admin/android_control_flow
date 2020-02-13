package com.adson.controlflow.command.adson;

import com.adson.controlflow.ControlCommand;
import com.adson.controlflow.structures.OpenContentAction;

public class OpenContentCommand extends ControlCommand {

    public OpenContentCommand(OpenContentAction content) {
        super("open-poi", content);
    }

}
