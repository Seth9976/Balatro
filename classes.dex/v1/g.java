package v1;

import android.net.Uri;
import com.google.android.gms.common.data.BitmapTeleporter;

public interface g {
    public static final class a {
        private String a;
        private Long b;
        private Long c;
        private BitmapTeleporter d;
        private Uri e;

        public g a() {
            return new h(this.a, this.b, this.d, this.e, this.c);
        }

        public a b(String s) {
            this.a = s;
            return this;
        }
    }

    BitmapTeleporter a();
}

