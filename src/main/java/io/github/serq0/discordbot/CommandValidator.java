package io.github.serq0.discordbot;

import io.github.serq0.discordbot.commands.Command;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.*;

public class CommandValidator {
    public CommandValidator(DiscordBot discordBot) {
        this.discordBot = discordBot;
    }

    public CommandValidator() {
    }

    private Map<String, Command> commandMap = new HashMap<>();
    private DiscordBot discordBot;

    public Command recognizeCommand(MessageReceivedEvent event) {
        List<String> fullCommand = getCommandsToListFromMessage(discordBot.getCommandPrefix(), event.getMessage().getContentRaw());
        String firstWord = getFirstWordFromCommands(fullCommand);
        if (getCommandMap().containsKey(firstWord)) {
            return getCommandMap().get(firstWord);
        }
        return null;
    }

    public static List<String> getCommandsToListFromMessage(String messagePrefix, String message) {
        if (message.startsWith(messagePrefix)) {
            message = message.replace(messagePrefix, "");
            String[] words = message.split(" ");
            return new ArrayList<>(Arrays.asList(words));
        }
        return null;
    }

    public static String getFirstWordFromCommands(List<String> commands) {
        if (commands != null && commands.size() > 0) {
            return commands.get(0);
        } else {
            return null;
        }
    }

    public Map<String, Command> getCommandMap() {
        return commandMap;
    }

    public void addCommand(String commandName, Command command) {
        commandMap.put(commandName, command);
    }

    public void setCommandMap(Map<String, Command> commandMap) {
        this.commandMap = commandMap;
    }

    public DiscordBot getDiscordBot() {
        return discordBot;
    }

    public void setDiscordBot(DiscordBot discordBot) {
        this.discordBot = discordBot;
    }
}