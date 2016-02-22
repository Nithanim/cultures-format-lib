package me.nithanim.cultures.format.lib;

import io.netty.buffer.ByteBuf;
import java.io.IOException;
import me.nithanim.cultures.format.common.Codec;

public class HeaderCodec implements Codec<Header> {

    @Override
    public Header unpack(ByteBuf buf) throws IOException {
        int unknown = buf.readInt();
        int dirCount = buf.readInt();
        int fileCount = buf.readInt();
        return new Header(unknown, dirCount, fileCount
        );
    }

}
