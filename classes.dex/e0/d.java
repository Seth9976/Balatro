package e0;

import android.os.Bundle;

public class d {
    private final Bundle a;

    public d(Bundle bundle0) {
        this.a = bundle0;
    }

    public long a() {
        return this.a.getLong("install_begin_timestamp_seconds");
    }

    public long b() {
        return this.a.getLong("install_begin_timestamp_server_seconds");
    }

    public String c() {
        return this.a.getString("install_referrer");
    }

    public String d() {
        return this.a.getString("install_version");
    }

    public long e() {
        return this.a.getLong("referrer_click_timestamp_seconds");
    }

    public long f() {
        return this.a.getLong("referrer_click_timestamp_server_seconds");
    }
}

