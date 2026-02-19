package x2;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class h0 extends HandlerThread {
    private Handler e;
    private Context f;
    private t g;
    private static h0 h;

    static {
    }

    private h0(String s, Context context0) {
        super(s);
        this.e = null;
        this.f = null;
        this.g = null;
        this.start();
        this.e = new Handler(this.getLooper());
        this.f = context0;
    }

    public static h0 e(Context context0, Boolean boolean0) {
        if(h0.h == null) {
            synchronized(h0.class) {
                h0 h00 = new h0("singular_exception_reporter", context0);
                h0.h = h00;
                h00.f(boolean0);
                return h0.h;
            }
        }
        return h0.h;
    }

    private void f(Boolean boolean0) {
        class a implements Runnable {
            final Boolean e;
            final h0 f;

            a(Boolean boolean0) {
                this.e = boolean0;
                super();
            }

            @Override
            public void run() {
                try {
                    t t0 = new t(h0.this.f, false, this.e);
                    h0.this.g = t0;
                }
                catch(Throwable unused_ex) {
                }
            }
        }

        if(this.g == null && this.e != null && this.f != null) {
            a h0$a0 = new a(this, boolean0);
            this.e.post(h0$a0);
        }
    }

    private int g(JSONObject jSONObject0) {
        try {
            HttpURLConnection httpURLConnection0 = (HttpURLConnection)new URL("https://exceptions.singular.net/v2/exceptions/android").openConnection();
            httpURLConnection0.setRequestMethod("POST");
            httpURLConnection0.setRequestProperty("Content-Type", "application/json");
            httpURLConnection0.setConnectTimeout(10000);
            httpURLConnection0.setReadTimeout(10000);
            httpURLConnection0.setDoOutput(true);
            byte[] arr_b = jSONObject0.toString().getBytes();
            httpURLConnection0.setRequestProperty("Content-Length", Integer.toString(arr_b.length));
            httpURLConnection0.getOutputStream().write(arr_b);
            httpURLConnection0.connect();
            return httpURLConnection0.getResponseCode();
        }
        catch(Throwable unused_ex) {
            return -1;
        }
    }

    public void h(Throwable throwable0) {
        class b implements Runnable {
            final Throwable e;
            final h0 f;

            b(Throwable throwable0) {
                this.e = throwable0;
                super();
            }

            @Override
            public void run() {
                try {
                    JSONObject jSONObject0 = new JSONObject();
                    Throwable throwable0 = this.e;
                    if(throwable0 == null) {
                        jSONObject0.put("error", "Throwable is null!");
                    }
                    else {
                        jSONObject0.put("name", throwable0.getClass().getSimpleName());
                        jSONObject0.put("message", this.e.getMessage());
                        jSONObject0.put("stack_trace", Log.getStackTraceString(this.e));
                        if(h0.this.g != null) {
                            JSONObject jSONObject1 = new JSONObject();
                            jSONObject1.put("aifa", h0.this.g.b);
                            jSONObject1.put("appName", h0.this.g.s);
                            jSONObject1.put("appVersion", h0.this.g.m);
                            jSONObject1.put("deviceModel", h0.this.g.r);
                            jSONObject1.put("deviceBrand", h0.this.g.n);
                            jSONObject1.put("deviceManufacturer", h0.this.g.q);
                            jSONObject1.put("osVersion", h0.this.g.w);
                            jSONObject1.put("sdkVersion", h0.this.g.v);
                            jSONObject1.put("isGooglePlayServicesAvailable", h0.this.g.f);
                            jSONObject0.put("device_info", jSONObject1);
                        }
                    }
                    h0.this.g(jSONObject0);
                }
                catch(Throwable unused_ex) {
                }
            }
        }

        if(this.e != null) {
            b h0$b0 = new b(this, throwable0);
            this.e.removeCallbacksAndMessages(null);
            this.e.post(h0$b0);
        }
    }
}

