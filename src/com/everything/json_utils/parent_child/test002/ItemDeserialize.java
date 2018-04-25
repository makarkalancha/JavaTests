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
public class ItemDeserialize extends StdDeserializer<Item2>{
    public ItemDeserialize() {
        super(Item2.class);
    }

    @Override
    public Item2 deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode jsonNode = jsonParser.getCodec().readTree(jsonParser);
        JsonNode userNode = jsonNode.get("user");
        User2 user2 = null;
        if(userNode != null) {
            int userId = (Integer) ((IntNode) jsonNode.get("user").get("id")).getNumberValue();
            user2 = new User2(userId, jsonNode.get("name").asText());
        }

        Item2 item2 = new Item2();
        item2.setId((Integer) ((IntNode) jsonNode.get("id")).getNumberValue());
        item2.setName(jsonNode.get("name").asText());
        item2.setUser(user2);
        return item2;
    }
}
