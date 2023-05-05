package fr.flowsqy.noqueuepluginmessage.protocol;

import org.jetbrains.annotations.NotNull;

public record SentData(@NotNull String channel, byte @NotNull [] data) {
}
