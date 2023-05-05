package fr.flowsqy.noqueuepluginmessage.protocol;

import org.jetbrains.annotations.NotNull;

public record SentData(@NotNull String[] serverNames, @NotNull String channel, byte @NotNull [] data) {
}
