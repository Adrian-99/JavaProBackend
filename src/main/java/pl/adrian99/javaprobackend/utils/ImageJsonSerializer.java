package pl.adrian99.javaprobackend.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class ImageJsonSerializer extends StdSerializer<byte[]> {

    protected ImageJsonSerializer() {
        super((Class<byte[]>) null);
    }

    protected ImageJsonSerializer(Class<byte[]> t) {
        super(t);
    }

    @Override
    public void serialize(byte[] value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        if (value != null) {
            gen.writeString("NOT NULL");
        }
    }
}
