package x2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Map;
import java.util.TreeMap;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

abstract class n0 {
    private static final k0 a;
    static int b;
    private static final String[] c;

    static {
        n0.a = k0.f("n0");
        n0.b = 0;
        n0.c = new String[]{"e", "global_properties", "referrer_data"};
    }

    private static String a(String s, String s1) {
        if(s == null) {
            return "";
        }
        String s2 = p0.l0(String.format("?%s", s), s1);
        n0.a.b("hash = %s", new Object[]{s2});
        return p0.V(s2) ? s : s + "&h=" + s2;
    }

    static HttpURLConnection b(i0 i00, String s, Map map0, long v) {
        Map map1 = n0.e(map0);
        String s1 = s + "?" + n0.a(n0.f(i00, map0, v), i00.B().b);
        URL uRL0 = new URL(s1);
        HttpURLConnection httpURLConnection0 = uRL0.getProtocol().equalsIgnoreCase("https") ? n0.d(uRL0) : n0.c(uRL0);
        n0.j(httpURLConnection0);
        n0.k(httpURLConnection0, map1, i00.B().b);
        Object[] arr_object = {httpURLConnection0.getRequestMethod(), s1};
        n0.a.b("__API__ %s %s", arr_object);
        return httpURLConnection0;
    }

    public static HttpURLConnection c(URL uRL0) {
        return uRL0 == null ? null : ((HttpURLConnection)uRL0.openConnection());
    }

    public static HttpURLConnection d(URL uRL0) {
        return uRL0 == null ? null : ((HttpsURLConnection)uRL0.openConnection());
    }

    private static Map e(Map map0) {
        Map map1 = new HashMap();
        String[] arr_s = n0.c;
        for(int v = 0; v < arr_s.length; ++v) {
            String s = arr_s[v];
            if(map0.containsKey(s)) {
                map1.put(s, map0.get(s));
                map0.remove(s);
            }
        }
        return map1;
    }

    private static String f(i0 i00, Map map0, long v) {
        StringBuilder stringBuilder0 = new StringBuilder();
        if(map0 == null) {
            map0 = new HashMap();
        }
        TreeMap treeMap0 = new TreeMap(map0);
        treeMap0.put("rt", "json");
        treeMap0.put("lag", String.valueOf(p0.e0(v)));
        treeMap0.put("c", p0.u(i00.n()));
        if((!treeMap0.containsKey("u") || p0.V(((String)treeMap0.get("u")))) && !p0.V(i00.p().d)) {
            treeMap0.put("u", i00.p().d);
            treeMap0.put("k", "OAID");
        }
        for(Object object0: treeMap0.entrySet()) {
            String s = URLEncoder.encode(((String)((Map.Entry)object0).getKey()), "UTF-8");
            String s1 = (String)((Map.Entry)object0).getValue();
            String s2 = s1 == null ? "" : URLEncoder.encode(s1, "UTF-8");
            if(stringBuilder0.length() > 0) {
                stringBuilder0.append("&");
            }
            stringBuilder0.append(s);
            stringBuilder0.append("=");
            stringBuilder0.append(s2);
        }
        return stringBuilder0.toString();
    }

    static boolean g(i0 i00, String s, Map map0, long v, a a$a0) {
        boolean z;
        int v1 = n0.b + 1;
        n0.b = v1;
        n0.a.b("---------------------------> /%d", new Object[]{v1});
        n0.a.b("url = %s", new Object[]{s});
        n0.a.b("params = %s", new Object[]{map0});
        HttpURLConnection httpURLConnection0 = n0.b(i00, s, map0, v);
        try {
            try {
                z = n0.i(i00, a$a0, 1771482090007L, v1, httpURLConnection0);
            }
            catch(IOException iOException0) {
                throw iOException0;
            }
        }
        catch(Throwable throwable0) {
            if(httpURLConnection0 != null) {
                httpURLConnection0.disconnect();
            }
            throw throwable0;
        }
        if(httpURLConnection0 != null) {
            httpURLConnection0.disconnect();
        }
        return z;
    }

    private static String h(HttpURLConnection httpURLConnection0) {
        StringBuffer stringBuffer0 = new StringBuffer();
        InputStream inputStream0 = httpURLConnection0.getInputStream();
        BufferedReader bufferedReader0 = new BufferedReader((httpURLConnection0.getContentEncoding() == null || !httpURLConnection0.getContentEncoding().equals("gzip") ? new InputStreamReader(inputStream0) : new InputStreamReader(new GZIPInputStream(inputStream0))));
        String s;
        while((s = bufferedReader0.readLine()) != null) {
            stringBuffer0.append(s);
        }
        return stringBuffer0.toString();
    }

    static boolean i(i0 i00, a a$a0, long v, int v1, HttpURLConnection httpURLConnection0) {
        httpURLConnection0.connect();
        int v2 = httpURLConnection0.getResponseCode();
        String s = n0.h(httpURLConnection0);
        httpURLConnection0.disconnect();
        n0.a.b("%d %s", new Object[]{v2, s});
        n0.a.b("<--------------------------- /%d - took %dms", new Object[]{v1, ((long)(0x19C748F8B01L - v))});
        return a$a0.a(i00, v2, s);
    }

    private static void j(HttpURLConnection httpURLConnection0) {
        httpURLConnection0.setConnectTimeout(10000);
        httpURLConnection0.setReadTimeout(10000);
        httpURLConnection0.setRequestMethod("POST");
        httpURLConnection0.setDoInput(true);
        httpURLConnection0.setUseCaches(false);
        httpURLConnection0.setRequestProperty("User-Agent", "Singular/SDK-v12.5.6.PROD");
        httpURLConnection0.setRequestProperty("Content-Type", "application/json");
    }

    private static void k(HttpURLConnection httpURLConnection0, Map map0, String s) {
        if(httpURLConnection0 == null) {
            return;
        }
        try {
            JSONObject jSONObject0 = new JSONObject();
            if(map0 != null && map0.size() > 0) {
                String s1 = new JSONObject(map0).toString();
                String s2 = p0.l0(s1, s);
                jSONObject0.put("payload", s1);
                jSONObject0.put("signature", s2);
            }
            OutputStreamWriter outputStreamWriter0 = new OutputStreamWriter(httpURLConnection0.getOutputStream(), "UTF-8");
            outputStreamWriter0.write(jSONObject0.toString());
            outputStreamWriter0.close();
        }
        catch(JSONException | IOException jSONException0) {
            n0.a.d("Error in JSON parsing or I/O ", jSONException0);
        }
    }
}

