package fr.flowsqy.noqueuepluginmessage.protocol;

import org.jetbrains.annotations.NotNull;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class PluginMessageWriter {

    public byte @NotNull [] write(@NotNull String[] serverNames, @NotNull String channel, byte @NotNull [] data) {
        final ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
        final DataOutputStream dataOutputStream = new DataOutputStream(outByteStream);
        try {
            dataOutputStream.writeByte(serverNames.length);
            for (String serverName : serverNames) {
                dataOutputStream.writeUTF(serverName);
            }
            dataOutputStream.writeUTF(channel);
            dataOutputStream.writeShort(data.length);
            dataOutputStream.write(data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return outByteStream.toByteArray();
    }

}
