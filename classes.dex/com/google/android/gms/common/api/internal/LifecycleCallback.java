package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import e1.e0;
import e1.e;
import e1.f;
import e1.g0;
import g1.q;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class LifecycleCallback {
    protected final f a;

    protected LifecycleCallback(f f0) {
        this.a = f0;
    }

    public void a(String s, FileDescriptor fileDescriptor0, PrintWriter printWriter0, String[] arr_s) {
    }

    public Activity b() {
        Activity activity0 = this.a.f();
        q.i(activity0);
        return activity0;
    }

    public static f c(Activity activity0) {
        return LifecycleCallback.d(new e(activity0));
    }

    protected static f d(e e0) {
        if(e0.d()) {
            return g0.D1(e0.b());
        }
        if(!e0.c()) {
            throw new IllegalArgumentException("Can\'t get fragment for unexpected activity.");
        }
        return e0.d(e0.a());
    }

    public void e(int v, int v1, Intent intent0) {
    }

    public void f(Bundle bundle0) {
    }

    public void g() {
    }

    private static f getChimeraLifecycleFragmentImpl(e e0) {
        throw new IllegalStateException("Method not available in SDK.");
    }

    public void h() {
    }

    public void i(Bundle bundle0) {
    }

    public void j() {
    }

    public void k() {
    }
}

