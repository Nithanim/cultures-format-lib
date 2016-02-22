package me.nithanim.cultures.format.lib;

import io.netty.buffer.ByteBuf;
import java.io.IOException;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import me.nithanim.mmf4j.MemoryMap;

public class LibFile {
    private final MemoryMap mm;
    private final Header header;
    private final List<DirMeta> dirMetas;
    private final List<FileMeta> fileMetas;

    LibFile(MemoryMap mm) throws IOException {
        this.mm = mm;
        //a growable buffer is needed here...
        ByteBuf buf = mm.mapView(0, 267643967).order(ByteOrder.LITTLE_ENDIAN).writerIndex(267643967);
        header = new HeaderCodec().unpack(buf);

        DirMetaCodec dirMetaCodec = new DirMetaCodec();
        dirMetas = new ArrayList<>();
        for (int i = 0; i < header.getDirCount(); i++) {
            dirMetas.add(dirMetaCodec.unpack(buf));
        }

        FileMetaCodec fileMetaCodec = new FileMetaCodec();
        fileMetas = new ArrayList<>();
        for (int i = 0; i < header.getFileCount(); i++) {
            fileMetas.add(fileMetaCodec.unpack(buf));
        }
        buf.release();
    }

    public Header getHeader() {
        return header;
    }

    public List<DirMeta> getDirMetas() {
        return dirMetas;
    }

    public List<FileMeta> getFileMetas() {
        return fileMetas;
    }

    public ByteBuf getFileContents(FileMeta fileMeta) {
        return mm.mapView(fileMeta.getPos(), fileMeta.getLen());
    }
}
