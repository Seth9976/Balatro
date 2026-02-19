package d1;

import com.google.android.gms.common.api.Status;

public class b extends Exception {
    protected final Status e;

    public b(Status status0) {
        super(status0.l0() + ": " + (status0.m0() == null ? "" : status0.m0()));
        this.e = status0;
    }

    public Status a() {
        return this.e;
    }

    public int b() {
        return this.e.l0();
    }
}

