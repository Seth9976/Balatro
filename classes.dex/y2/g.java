package y2;

import android.content.Context;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Map;

public class g {
    public void a(Context context0, e e0) {
        class a implements e {
            final e a;
            final g b;

            a(e e0) {
                this.a = e0;
                super();
            }

            @Override  // y2.e
            public void a(Map map0) {
                HashMap hashMap0;
                e e0;
                if(map0 == null) {
                    e0 = this.a;
                    hashMap0 = null;
                }
                else {
                    hashMap0 = new HashMap();
                    for(Object object0: map0.entrySet()) {
                        hashMap0.put("samsung_" + ((String)((Map.Entry)object0).getKey()), ((Map.Entry)object0).getValue());
                    }
                    e0 = this.a;
                }
                e0.a(hashMap0);
            }
        }

        new f(context0, "com.samsung.android.sdk.sinstallreferrer.api", new a(this, e0)).j();
    }
}

