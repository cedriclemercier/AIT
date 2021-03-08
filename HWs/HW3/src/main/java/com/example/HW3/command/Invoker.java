package com.example.HW3.command;

public class Invoker {
    public Command command;

    public Invoker(Command command) {
        super();
        this.command = command;
    }

    public void execute() {
        this.command.execute();
    }
}
