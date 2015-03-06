package org.demoiselle.json;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

public class JsonDateDeserializer extends JsonDeserializer<Date>{
    
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Date deserialize(JsonParser jsonparser, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String date = jsonparser.getText();
        try {
            return dateFormat.parse(date);
        } catch (ParseException e) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                return dateFormat.parse(date);
            }
            catch (ParseException e1){
                throw new RuntimeException(e1);
            }
        }

    }
    
}
