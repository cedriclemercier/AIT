package com.example.HW3.command;

public class CounterCommand implements Command {

    private ActionReceiver actionReceiver;

    public CounterCommand(ActionReceiver actionReceiver) {
        super();
        this.actionReceiver = actionReceiver;
    }

    @Override
    public void execute() {
        this.actionReceiver.counter();
    }

}
