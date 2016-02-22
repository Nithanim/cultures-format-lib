package me.nithanim.cultures.format.lib;

import io.netty.buffer.ByteBuf;
import io.netty.util.CharsetUtil;
import java.io.IOException;
import me.nithanim.cultures.format.common.Codec;

public class FileMetaCodec implements Codec<FileMeta> {

    @Override
    public FileMeta unpack(ByteBuf buf) throws IOException {
        int nameLength = buf.readInt();
        byte[] chars = new byte[nameLength];
        buf.readBytes(chars);
        String name = new String(chars, CharsetUtil.ISO_8859_1);
        int pos = buf.readInt();
        int len = buf.readInt();
        return new FileMeta(name, pos, len);
    }

}
