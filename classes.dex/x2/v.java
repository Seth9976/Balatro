package x2;

import android.net.Uri;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map.Entry;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONObject;

public class v extends w {
    private final k0 b;

    public v() {
        super("https://sdk-api-v1.singular.net/api/v1");
        this.b = k0.f("v");
    }

    @Override  // x2.w
    public void b(String s, Map map0, Map map1, a w$a0) {
        class x2.v.a implements Runnable {
            final String e;
            final Map f;
            final Map g;
            final a h;
            final v i;

            x2.v.a(String s, Map map0, Map map1, a w$a0) {
                this.e = s;
                this.f = map0;
                this.g = map1;
                this.h = w$a0;
                super();
            }

            @Override
            public void run() {
                v.this.d(this.e, this.f, this.g, this.h);
            }
        }

        Executors.newSingleThreadExecutor().execute(new x2.v.a(this, s, map0, map1, w$a0));
    }

    private HttpURLConnection c(String s, Map map0) {
        try {
            HttpURLConnection httpURLConnection0 = (HttpsURLConnection)new URL(s).openConnection();
            httpURLConnection0.setConnectTimeout(10000);
            httpURLConnection0.setReadTimeout(10000);
            httpURLConnection0.setRequestMethod("POST");
            httpURLConnection0.setDoInput(true);
            httpURLConnection0.setDoOutput(true);
            httpURLConnection0.setUseCaches(false);
            httpURLConnection0.setRequestProperty("User-Agent", "Singular/SDK-v12.5.6.PROD");
            httpURLConnection0.setRequestProperty("Content-Type", "application/json");
            httpURLConnection0.setRequestProperty("Accept-Encoding", "gzip");
            if(map0 == null) {
                goto label_13;
            }
            else {
                try {
                    JSONObject jSONObject0 = new JSONObject(map0);
                    goto label_14;
                label_13:
                    jSONObject0 = new JSONObject();
                label_14:
                    OutputStreamWriter outputStreamWriter0 = new OutputStreamWriter(httpURLConnection0.getOutputStream(), "UTF-8");
                    outputStreamWriter0.write(jSONObject0.toString());
                    outputStreamWriter0.close();
                    return httpURLConnection0;
                }
                catch(Throwable throwable1) {
                    goto label_19;
                }
            }
            goto label_14;
        label_19:
            this.b.d("Error in JSON Serialization ", throwable1);
            String s1 = p0.h(throwable1);
            this.b.c(s1);
        }
        catch(Throwable throwable0) {
            String s2 = p0.h(throwable0);
            this.b.c(s2);
        }
        return null;
    }

    public void d(String s, Map map0, Map map1, a w$a0) {
        HttpURLConnection httpURLConnection0;
        String s1 = "?a=" + i0.t().B().a;
        if(map0 != null) {
            for(Object object0: map0.entrySet()) {
                s1 = s1 + "&" + Uri.encode(((String)((Map.Entry)object0).getKey())) + "=" + Uri.encode(((String)((Map.Entry)object0).getValue()));
            }
        }
        String s2 = this.a() + s + (s1 + "&h=" + p0.l0(s1, i0.t().B().b));
        try {
            httpURLConnection0 = null;
            httpURLConnection0 = this.c(s2, map1);
            if(httpURLConnection0 == null) {
                w$a0.a("Error sending request: connection is null");
                this.b.c("Error sending request: connection is null");
                return;
            }
            httpURLConnection0.connect();
            int v = httpURLConnection0.getResponseCode();
            StringBuffer stringBuffer0 = new StringBuffer();
            InputStream inputStream0 = httpURLConnection0.getInputStream();
            BufferedReader bufferedReader0 = new BufferedReader((httpURLConnection0.getContentEncoding() == null || !httpURLConnection0.getContentEncoding().equals("gzip") ? new InputStreamReader(inputStream0) : new InputStreamReader(new GZIPInputStream(inputStream0))));
            String s3;
            while((s3 = bufferedReader0.readLine()) != null) {
                stringBuffer0.append(s3);
            }
            w$a0.b(stringBuffer0.toString(), v);
        }
        catch(Throwable throwable0) {
            try {
                w$a0.a("Error sending request: message - " + throwable0.getMessage());
                String s4 = p0.h(throwable0);
                this.b.c(s4);
            }
            catch(Throwable throwable1) {
                if(httpURLConnection0 != null) {
                    httpURLConnection0.disconnect();
                }
                throw throwable1;
            }
            if(httpURLConnection0 != null) {
                httpURLConnection0.disconnect();
                return;
            }
            return;
        }
        httpURLConnection0.disconnect();
    }
}

