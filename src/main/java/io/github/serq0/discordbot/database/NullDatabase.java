package io.github.serq0.discordbot.database;

public class NullDatabase implements Database {
    @Override
    public void hello() {
        System.out.println(this.getClass().getName() + " says hello");
    }

    @Override
    public void initDb() {
        System.out.println(this.getClass().getName() + " initialized");
    }

    public void init() {
        System.out.println("INIT " + this.getClass().getName());
    }

    public void destroy() {
        System.out.println("DESTROY " + this.getClass().getName());
    }
}
