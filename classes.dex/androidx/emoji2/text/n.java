package androidx.emoji2.text;

import android.os.Build.VERSION;
import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import androidx.core.util.c;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class n extends SpannableStringBuilder {
    static class a implements SpanWatcher, TextWatcher {
        final Object a;
        private final AtomicInteger b;

        a(Object object0) {
            this.b = new AtomicInteger(0);
            this.a = object0;
        }

        final void a() {
            this.b.incrementAndGet();
        }

        @Override  // android.text.TextWatcher
        public void afterTextChanged(Editable editable0) {
            ((TextWatcher)this.a).afterTextChanged(editable0);
        }

        private boolean b(Object object0) {
            return object0 instanceof i;
        }

        @Override  // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
            ((TextWatcher)this.a).beforeTextChanged(charSequence0, v, v1, v2);
        }

        final void c() {
            this.b.decrementAndGet();
        }

        @Override  // android.text.SpanWatcher
        public void onSpanAdded(Spannable spannable0, Object object0, int v, int v1) {
            if(this.b.get() > 0 && this.b(object0)) {
                return;
            }
            ((SpanWatcher)this.a).onSpanAdded(spannable0, object0, v, v1);
        }

        @Override  // android.text.SpanWatcher
        public void onSpanChanged(Spannable spannable0, Object object0, int v, int v1, int v2, int v3) {
            int v5;
            int v4;
            if(this.b.get() > 0 && this.b(object0)) {
                return;
            }
            if(Build.VERSION.SDK_INT < 28) {
                if(v > v1) {
                    v = 0;
                }
                if(v2 > v3) {
                    v4 = v;
                    v5 = 0;
                }
                else {
                    v4 = v;
                    v5 = v2;
                }
            }
            else {
                v4 = v;
                v5 = v2;
            }
            ((SpanWatcher)this.a).onSpanChanged(spannable0, object0, v4, v1, v5, v3);
        }

        @Override  // android.text.SpanWatcher
        public void onSpanRemoved(Spannable spannable0, Object object0, int v, int v1) {
            if(this.b.get() > 0 && this.b(object0)) {
                return;
            }
            ((SpanWatcher)this.a).onSpanRemoved(spannable0, object0, v, v1);
        }

        @Override  // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
            ((TextWatcher)this.a).onTextChanged(charSequence0, v, v1, v2);
        }
    }

    private final Class e;
    private final List f;

    n(Class class0, CharSequence charSequence0) {
        super(charSequence0);
        this.f = new ArrayList();
        c.e(class0, "watcherClass cannot be null");
        this.e = class0;
    }

    n(Class class0, CharSequence charSequence0, int v, int v1) {
        super(charSequence0, v, v1);
        this.f = new ArrayList();
        c.e(class0, "watcherClass cannot be null");
        this.e = class0;
    }

    public void a() {
        this.b();
    }

    @Override  // android.text.SpannableStringBuilder
    public Editable append(char c) {
        return this.append(c);
    }

    @Override  // android.text.SpannableStringBuilder
    public Editable append(CharSequence charSequence0) {
        return this.append(charSequence0);
    }

    @Override  // android.text.SpannableStringBuilder
    public Editable append(CharSequence charSequence0, int v, int v1) {
        return this.append(charSequence0, v, v1);
    }

    @Override  // android.text.SpannableStringBuilder
    public SpannableStringBuilder append(char c) {
        super.append(c);
        return this;
    }

    @Override  // android.text.SpannableStringBuilder
    public SpannableStringBuilder append(CharSequence charSequence0) {
        super.append(charSequence0);
        return this;
    }

    @Override  // android.text.SpannableStringBuilder
    public SpannableStringBuilder append(CharSequence charSequence0, int v, int v1) {
        super.append(charSequence0, v, v1);
        return this;
    }

    @Override  // android.text.SpannableStringBuilder
    public SpannableStringBuilder append(CharSequence charSequence0, Object object0, int v) {
        super.append(charSequence0, object0, v);
        return this;
    }

    @Override  // android.text.SpannableStringBuilder
    public Appendable append(char c) {
        return this.append(c);
    }

    @Override  // android.text.SpannableStringBuilder
    public Appendable append(CharSequence charSequence0) {
        return this.append(charSequence0);
    }

    @Override  // android.text.SpannableStringBuilder
    public Appendable append(CharSequence charSequence0, int v, int v1) {
        return this.append(charSequence0, v, v1);
    }

    private void b() {
        for(int v = 0; v < this.f.size(); ++v) {
            ((a)this.f.get(v)).a();
        }
    }

    public static n c(Class class0, CharSequence charSequence0) {
        return new n(class0, charSequence0);
    }

    public void d() {
        this.i();
        this.e();
    }

    @Override  // android.text.SpannableStringBuilder
    public Editable delete(int v, int v1) {
        return this.delete(v, v1);
    }

    @Override  // android.text.SpannableStringBuilder
    public SpannableStringBuilder delete(int v, int v1) {
        super.delete(v, v1);
        return this;
    }

    private void e() {
        for(int v = 0; v < this.f.size(); ++v) {
            ((a)this.f.get(v)).onTextChanged(this, 0, this.length(), this.length());
        }
    }

    private a f(Object object0) {
        for(int v = 0; v < this.f.size(); ++v) {
            a n$a0 = (a)this.f.get(v);
            if(n$a0.a == object0) {
                return n$a0;
            }
        }
        return null;
    }

    private boolean g(Class class0) {
        return this.e == class0;
    }

    @Override  // android.text.SpannableStringBuilder
    public int getSpanEnd(Object object0) {
        if(this.h(object0)) {
            a n$a0 = this.f(object0);
            if(n$a0 != null) {
                object0 = n$a0;
            }
        }
        return super.getSpanEnd(object0);
    }

    @Override  // android.text.SpannableStringBuilder
    public int getSpanFlags(Object object0) {
        if(this.h(object0)) {
            a n$a0 = this.f(object0);
            if(n$a0 != null) {
                object0 = n$a0;
            }
        }
        return super.getSpanFlags(object0);
    }

    @Override  // android.text.SpannableStringBuilder
    public int getSpanStart(Object object0) {
        if(this.h(object0)) {
            a n$a0 = this.f(object0);
            if(n$a0 != null) {
                object0 = n$a0;
            }
        }
        return super.getSpanStart(object0);
    }

    @Override  // android.text.SpannableStringBuilder
    public Object[] getSpans(int v, int v1, Class class0) {
        if(this.g(class0)) {
            a[] arr_n$a = (a[])super.getSpans(v, v1, a.class);
            Object[] arr_object = (Object[])Array.newInstance(class0, arr_n$a.length);
            for(int v2 = 0; v2 < arr_n$a.length; ++v2) {
                arr_object[v2] = arr_n$a[v2].a;
            }
            return arr_object;
        }
        return super.getSpans(v, v1, class0);
    }

    private boolean h(Object object0) {
        return object0 != null && this.g(object0.getClass());
    }

    private void i() {
        for(int v = 0; v < this.f.size(); ++v) {
            ((a)this.f.get(v)).c();
        }
    }

    @Override  // android.text.SpannableStringBuilder
    public Editable insert(int v, CharSequence charSequence0) {
        return this.insert(v, charSequence0);
    }

    @Override  // android.text.SpannableStringBuilder
    public Editable insert(int v, CharSequence charSequence0, int v1, int v2) {
        return this.insert(v, charSequence0, v1, v2);
    }

    @Override  // android.text.SpannableStringBuilder
    public SpannableStringBuilder insert(int v, CharSequence charSequence0) {
        super.insert(v, charSequence0);
        return this;
    }

    @Override  // android.text.SpannableStringBuilder
    public SpannableStringBuilder insert(int v, CharSequence charSequence0, int v1, int v2) {
        super.insert(v, charSequence0, v1, v2);
        return this;
    }

    @Override  // android.text.SpannableStringBuilder
    public int nextSpanTransition(int v, int v1, Class class0) {
        if(class0 == null || this.g(class0)) {
            class0 = a.class;
        }
        return super.nextSpanTransition(v, v1, class0);
    }

    @Override  // android.text.SpannableStringBuilder
    public void removeSpan(Object object0) {
        a n$a0;
        if(this.h(object0)) {
            n$a0 = this.f(object0);
            if(n$a0 != null) {
                object0 = n$a0;
            }
        }
        else {
            n$a0 = null;
        }
        super.removeSpan(object0);
        if(n$a0 != null) {
            this.f.remove(n$a0);
        }
    }

    @Override  // android.text.SpannableStringBuilder
    public Editable replace(int v, int v1, CharSequence charSequence0) {
        return this.replace(v, v1, charSequence0);
    }

    @Override  // android.text.SpannableStringBuilder
    public Editable replace(int v, int v1, CharSequence charSequence0, int v2, int v3) {
        return this.replace(v, v1, charSequence0, v2, v3);
    }

    @Override  // android.text.SpannableStringBuilder
    public SpannableStringBuilder replace(int v, int v1, CharSequence charSequence0) {
        this.b();
        super.replace(v, v1, charSequence0);
        this.i();
        return this;
    }

    @Override  // android.text.SpannableStringBuilder
    public SpannableStringBuilder replace(int v, int v1, CharSequence charSequence0, int v2, int v3) {
        this.b();
        super.replace(v, v1, charSequence0, v2, v3);
        this.i();
        return this;
    }

    @Override  // android.text.SpannableStringBuilder
    public void setSpan(Object object0, int v, int v1, int v2) {
        if(this.h(object0)) {
            a n$a0 = new a(object0);
            this.f.add(n$a0);
            object0 = n$a0;
        }
        super.setSpan(object0, v, v1, v2);
    }

    @Override  // android.text.SpannableStringBuilder
    public CharSequence subSequence(int v, int v1) {
        return new n(this.e, this, v, v1);
    }
}

