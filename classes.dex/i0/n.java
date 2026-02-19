package i0;

import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.io.Reader;

public abstract class n {
    static n a(long v) {
        return new h(v);
    }

    public static n b(Reader reader0) {
        try(JsonReader jsonReader0 = new JsonReader(reader0)) {
            jsonReader0.beginObject();
            while(true) {
                if(!jsonReader0.hasNext()) {
                    break;
                }
                if(jsonReader0.nextName().equals("nextRequestWaitMillis")) {
                    return jsonReader0.peek() == JsonToken.STRING ? n.a(Long.parseLong(jsonReader0.nextString())) : n.a(jsonReader0.nextLong());
                }
                jsonReader0.skipValue();
            }
            throw new IOException("Response is missing nextRequestWaitMillis field.");
        }
    }

    public abstract long c();
}

