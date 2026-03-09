package br.com.gustainMars.serializer;

import br.com.gustainMars.enums.GenderEnum;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class GenderSerializer extends JsonSerializer<String> {

    @Override
    public void serialize(String gender, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        String formated = GenderEnum.M.getMessage().equalsIgnoreCase(gender)
                ? GenderEnum.M.name()
                : GenderEnum.F.name();
        gen.writeString(formated);
    }
}
