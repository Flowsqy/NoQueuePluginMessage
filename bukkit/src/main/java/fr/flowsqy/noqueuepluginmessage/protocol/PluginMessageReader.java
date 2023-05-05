package fr.flowsqy.noqueuepluginmessage.protocol;

import org.jetbrains.annotations.NotNull;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class PluginMessageReader {

    @NotNull
    public SentData read(byte @NotNull [] data) {
        final ByteArrayInputStream inByteStream = new ByteArrayInputStream(data);
        final DataInputStream inDataStream = new DataInputStream(inByteStream);
        final String channel;
        final byte[] messageData;
        try {
            channel = inDataStream.readUTF();
            messageData = new byte[inDataStream.readShort()];
            inDataStream.readFully(messageData);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new SentData(channel, messageData);
    }

}
