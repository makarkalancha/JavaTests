package com.everything.json_utils.parent_child.test002;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.deser.std.StdDeserializer;
import org.codehaus.jackson.node.IntNode;

import java.io.IOException;

/**
 * Created by mcalancea
 * Date: 24 Apr 2018
 * Time: 12:10
 */
public class UserDeserialize extends StdDeserializer<User2>{
    public UserDeserialize() {
        super(User2.class);
    }

    @Override
    public User2 deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode jsonNode = jsonParser.getCodec().readTree(jsonParser);
        User2 user2 = null;
        if(jsonNode != null) {
            int userId = (Integer) ((IntNode) jsonNode.get("id")).getNumberValue();
            JsonNode parentNode = jsonNode.findParent("user");
            System.out.println(parentNode);
//            user2 = new User2(userId, jsonNode.get("name").asText());
        }
        return user2;
    }
}
