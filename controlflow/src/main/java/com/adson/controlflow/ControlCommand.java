package com.adson.controlflow;

public class ControlCommand {

    private String command;

    private ControlContent content;

    protected ControlCommand(String command, ControlContent content) {
        this.command = command;
        this.content = content;
    }

    String getCommand() {
        return command;
    }

    ControlContent getContent() {
        return content;
    }
}
