package x2;

import android.content.Context;
import java.util.HashMap;
import org.json.JSONObject;

public class e {
    class b implements Runnable {
        final e e;

        @Override
        public void run() {
            String s;
            k0 k00;
            boolean z = false;
            if(!i0.t().G()) {
                z = true;
                k00 = e.e;
                s = "Singular is not initialized!";
            }
            else if(!p0.R(e.this.a)) {
                z = true;
                k00 = e.e;
                s = "Oops, not connected to internet!";
            }
            if(z) {
                k00.a(s);
                return;
            }
            try {
                String s1 = e.this.b.b();
                if(s1 == null) {
                    e.e.a("Queue is empty");
                    return;
                }
                h h0 = h.j(s1);
                e.e.b("api = %s", new Object[]{h0.getClass().getName()});
                if(h0.a(i0.t())) {
                    String s2 = Long.toString(h0.f());
                    p0.f0(e.this.a, s2);
                    e.this.b.remove();
                    e.this.e();
                }
            }
            catch(Throwable throwable0) {
                e.e.e("IOException in processing an event: %s", new Object[]{throwable0.getMessage()});
            }
        }
    }

    final Context a;
    private a0 b;
    private o0 c;
    final Runnable d;
    private static final k0 e;

    static {
        e.e = k0.f("e");
    }

    public e(o0 o00, Context context0, a0 a00) {
        this.d = new b(this);
        this.a = context0;
        this.b = a00;
        if(a00 == null) {
            return;
        }
        Object[] arr_object = {a00.getClass().getSimpleName()};
        e.e.b("Queue: %s", arr_object);
        if(o00 == null) {
            return;
        }
        this.c = o00;
        o00.start();
    }

    void c(h h0) {
        if(h0 != null && this.b != null) {
            try {
                if(!(h0 instanceof c) && !(h0 instanceof d)) {
                    h0.g("event_index", String.valueOf(p0.y(this.a)));
                }
                h0.g("singular_install_id", p0.G(this.a).toString());
                this.d(h0);
                this.b.a(h0.o());
                this.e();
                return;
            }
            catch(IndexOutOfBoundsException throwable0) {
            }
            catch(Throwable unused_ex) {
                return;
            }
            e.e.d("error in enqueue()", throwable0);
        }
    }

    private void d(h h0) {
        class a extends HashMap {
            final Boolean e;
            final e f;

            a(Boolean boolean0) {
                this.e = boolean0;
                super();
                this.put("limit_data_sharing", Boolean.valueOf(boolean0.booleanValue()));
            }
        }

        i0 i00 = i0.t();
        JSONObject jSONObject0 = i00.q();
        if(jSONObject0.length() != 0) {
            h0.g("global_properties", jSONObject0.toString());
        }
        Boolean boolean0 = i00.w();
        if(boolean0 != null) {
            h0.g("data_sharing_options", new JSONObject(new a(this, boolean0)).toString());
        }
    }

    void e() {
        o0 o00 = this.c;
        if(o00 == null) {
            return;
        }
        o00.b().removeCallbacksAndMessages(null);
        this.c.c(this.d);
    }
}

