package com.example.HW3.proxy;

public class CommandAccessProxy implements CommandAccess {

    private boolean isAdmin;
    private CommandAccess access;

    public CommandAccessProxy(String user, String pwd) {
        if ("Chaklam".equals(user) && "ch@klam".equals(pwd)) {
            isAdmin = true;
        }
        access = new CommandAccessImpl();
    }

    @Override
    public Process runServer(String cmd) throws Exception {
        Process p = null;
        if (isAdmin) {
            p = access.runServer(cmd);
        } else {
            if (cmd.trim().startsWith("exe")) {
                throw new Exception("exe command is not allowed for non-admin users");
            } else {
                p = access.runServer(cmd);
            }
        }

        return p;
    }

}
