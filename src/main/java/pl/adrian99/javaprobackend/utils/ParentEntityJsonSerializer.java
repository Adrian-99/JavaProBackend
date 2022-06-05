package pl.adrian99.javaprobackend.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class ParentEntityJsonSerializer<T extends IEntity> extends StdSerializer<T> {

    protected ParentEntityJsonSerializer() {
        super((Class<T>) null);
    }

    protected ParentEntityJsonSerializer(Class<T> t) {
        super(t);
    }

    @Override
    public void serialize(T value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeNumber(value.getId());
    }
}
