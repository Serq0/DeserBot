package io.github.serq0.discordbot.database;

public class SQLiteDatabase implements Database {
    @Override
    public void hello() {
        System.out.println(this.getClass().getName() + " says hello");
    }

    @Override
    public void initDb() {

    }

    public void destroy() {
        System.out.println("DESTROY " + this.getClass().getName());
    }
}
