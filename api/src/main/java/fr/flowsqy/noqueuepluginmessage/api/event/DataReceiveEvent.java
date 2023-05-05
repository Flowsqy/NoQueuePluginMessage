package fr.flowsqy.noqueuepluginmessage.api.event;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class DataReceiveEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final Player receiver;
    private final String channel;
    private byte[] data;

    public DataReceiveEvent(boolean isAsync, @NotNull Player receiver, @NotNull String channel, byte @NotNull [] data) {
        super(isAsync);
        this.receiver = receiver;
        this.channel = channel;
        this.data = data;
    }

    @SuppressWarnings("unused")
    public static HandlerList getHandlerList() {
        return handlers;
    }

    @NotNull
    public Player getReceiver() {
        return receiver;
    }

    @NotNull
    public String getChannel() {
        return channel;
    }

    public byte @NotNull [] getData() {
        return data;
    }

    public void setData(byte @NotNull [] data) {
        this.data = data;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

}
