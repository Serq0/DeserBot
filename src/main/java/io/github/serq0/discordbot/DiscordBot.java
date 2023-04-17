package io.github.serq0.discordbot;


import io.github.serq0.discordbot.database.Database;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DiscordBot implements EventListener {
    private static final Logger log = LoggerFactory.getLogger(DiscordBot.class);
    private JDA jda;
    private String token;

    private String commandPrefix;
    private MessageReceivedEventHandler eventHandler;
    private DateParser dateParser;
    private Database database;

    public DiscordBot() {

    }

    void init() {
        this.jda = JDABuilder.createDefault(getToken())
                .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                .addEventListeners(this)
                .build();
        log.info(this.getClass().getName() + " initialized");
    }

    @Override
    public void onEvent(GenericEvent event) {

        if (event instanceof ReadyEvent) {
            log.info(this.getClass().getName() + " BOT is ready to use");
        }
        if (event instanceof MessageReceivedEvent) {
            getEventHandler().handleEvent((MessageReceivedEvent) event);
        }
    }

    public void runBot() {
        try {
            getJda().awaitReady();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                getJda().awaitShutdown();
            } catch (Exception e) {
            }
        }
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCommandPrefix() {
        return commandPrefix;
    }

    public void setCommandPrefix(String commandPrefix) {
        this.commandPrefix = commandPrefix;
    }

    public JDA getJda() {
        return jda;
    }

    public void setJda(JDA jda) {
        this.jda = jda;
    }


    public MessageReceivedEventHandler getEventHandler() {
        return eventHandler;
    }

    public void setEventHandler(MessageReceivedEventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }

    public Database getDatabase() {
        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }

    public DateParser getDateConverter() {
        return dateParser;
    }

    public void setDateConverter(DateParser dateParser) {
        this.dateParser = dateParser;
    }

    public DateParser getDateParser() {
        return dateParser;
    }

    public void setDateParser(DateParser dateParser) {
        this.dateParser = dateParser;
    }
}
