package com.example.HW3.command;

public class AttackCommand implements Command {

    private ActionReceiver actionReceiver;

    public AttackCommand(ActionReceiver actionReceiver) {
        super();
        this.actionReceiver = actionReceiver;
    }

    @Override
    public void execute() {
        this.actionReceiver.attack();
    }

}
