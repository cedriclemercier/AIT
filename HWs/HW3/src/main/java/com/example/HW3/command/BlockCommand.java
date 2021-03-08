package com.example.HW3.command;

public class BlockCommand implements Command {

    private ActionReceiver actionReceiver;

    public BlockCommand(ActionReceiver actionReceiver) {
        super();
        this.actionReceiver = actionReceiver;
    }

    @Override
    public void execute() {
        this.actionReceiver.block();
    }

}
