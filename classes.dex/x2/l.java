package x2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

abstract class l {
    static class a extends BroadcastReceiver {
        private final i0 a;

        a(i0 i00) {
            this.a = i00;
        }

        public static int b$002(k0 k00, String s, Object[] arr_object) {
            return k00.b(s, arr_object);
        }

        public static void execute$003(Executor executor0, Runnable runnable0) {
            executor0.execute(runnable0);
        }

        public static String getAction$001(Intent intent0) {
            return intent0.getAction();
        }

        @Override  // android.content.BroadcastReceiver
        public void onReceive(Context context0, Intent intent0) {
            class x2.l.a.a implements Runnable {
                final a e;

                @Override
                public void run() {
                    i0.t().p().k.f(i0.t().p(), i0.t().n());
                    a.this.a.m().e();
                }
            }

            if(p0.Q(context0)) {
                Executors.newSingleThreadExecutor().execute(new x2.l.a.a(this));
            }
        }
    }

    private static final k0 a;

    static {
        l.a = k0.f("l");
    }

    static k0 a() {
        return l.a;
    }
}

