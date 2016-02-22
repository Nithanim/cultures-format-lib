package me.nithanim.cultures.format.lib;

import io.netty.buffer.ByteBuf;
import io.netty.util.CharsetUtil;
import java.io.IOException;
import me.nithanim.cultures.format.common.Codec;

public class DirMetaCodec implements Codec<DirMeta> {

    @Override
    public DirMeta unpack(ByteBuf buf) throws IOException {
        int nameLength = buf.readInt();
        byte[] chars = new byte[nameLength];
        buf.readBytes(chars);
        int level = buf.readInt();
        return new DirMeta(new String(chars, CharsetUtil.ISO_8859_1), level);
    }

}
