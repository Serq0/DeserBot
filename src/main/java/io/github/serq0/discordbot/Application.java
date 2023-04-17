package io.github.serq0.discordbot;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DiscordBot discordBot = (DiscordBot) context.getBean("discordBot");
        discordBot.runBot();
        context.close();
    }

}