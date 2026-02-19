package androidx.appcompat.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent.DispatcherState;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.View.OnLayoutChangeListener;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.TextView;
import androidx.core.view.v;
import h.b;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

public class SearchView extends y implements b {
    public static class SearchAutoComplete extends d {
        class a implements Runnable {
            final SearchAutoComplete e;

            @Override
            public void run() {
                SearchAutoComplete.this.d();
            }
        }

        private int e;
        private SearchView f;
        private boolean g;
        final Runnable h;

        public SearchAutoComplete(Context context0, AttributeSet attributeSet0) {
            this(context0, attributeSet0, c.a.g);
        }

        public SearchAutoComplete(Context context0, AttributeSet attributeSet0, int v) {
            super(context0, attributeSet0, v);
            this.h = () -> if(SearchAutoComplete.this.g) {
                ((InputMethodManager)SearchAutoComplete.this.getContext().getSystemService("input_method")).showSoftInput(SearchAutoComplete.this, 0);
                SearchAutoComplete.this.g = false;
            };
            this.e = this.getThreshold();
        }

        void b() {
            if(Build.VERSION.SDK_INT >= 29) {
                k.b(this, 1);
                if(this.enoughToFilter()) {
                    this.showDropDown();
                }
            }
            else {
                SearchView.n0.c(this);
            }
        }

        boolean c() {
            return TextUtils.getTrimmedLength(this.getText()) == 0;
        }

        // 检测为 Lambda 实现
        void d() [...]

        @Override  // android.widget.AutoCompleteTextView
        public boolean enoughToFilter() {
            return this.e <= 0 || super.enoughToFilter();
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration0 = this.getResources().getConfiguration();
            int v = configuration0.screenWidthDp;
            int v1 = configuration0.screenHeightDp;
            if(v >= 960 && v1 >= 720 && configuration0.orientation == 2) {
                return 0x100;
            }
            return v >= 600 || v >= 640 && v1 >= 480 ? 0xC0 : 0xA0;
        }

        @Override  // androidx.appcompat.widget.d
        public InputConnection onCreateInputConnection(EditorInfo editorInfo0) {
            InputConnection inputConnection0 = super.onCreateInputConnection(editorInfo0);
            if(this.g) {
                this.removeCallbacks(this.h);
                this.post(this.h);
            }
            return inputConnection0;
        }

        @Override  // android.view.View
        protected void onFinishInflate() {
            super.onFinishInflate();
            DisplayMetrics displayMetrics0 = this.getResources().getDisplayMetrics();
            this.setMinWidth(((int)TypedValue.applyDimension(1, ((float)this.getSearchViewTextMinWidthDp()), displayMetrics0)));
        }

        @Override  // android.widget.AutoCompleteTextView
        protected void onFocusChanged(boolean z, int v, Rect rect0) {
            super.onFocusChanged(z, v, rect0);
            this.f.W();
        }

        @Override  // android.widget.AutoCompleteTextView
        public boolean onKeyPreIme(int v, KeyEvent keyEvent0) {
            if(v == 4) {
                if(keyEvent0.getAction() == 0 && keyEvent0.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyEvent$DispatcherState0 = this.getKeyDispatcherState();
                    if(keyEvent$DispatcherState0 != null) {
                        keyEvent$DispatcherState0.startTracking(keyEvent0, this);
                    }
                    return true;
                }
                if(keyEvent0.getAction() == 1) {
                    KeyEvent.DispatcherState keyEvent$DispatcherState1 = this.getKeyDispatcherState();
                    if(keyEvent$DispatcherState1 != null) {
                        keyEvent$DispatcherState1.handleUpEvent(keyEvent0);
                    }
                    if(keyEvent0.isTracking() && !keyEvent0.isCanceled()) {
                        this.f.clearFocus();
                        this.setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(v, keyEvent0);
        }

        @Override  // android.widget.AutoCompleteTextView
        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if(z && this.f.hasFocus() && this.getVisibility() == 0) {
                this.g = true;
                if(SearchView.J(this.getContext())) {
                    this.b();
                }
            }
        }

        @Override  // android.widget.AutoCompleteTextView
        public void performCompletion() {
        }

        @Override  // android.widget.AutoCompleteTextView
        protected void replaceText(CharSequence charSequence0) {
        }

        void setImeVisibility(boolean z) {
            InputMethodManager inputMethodManager0 = (InputMethodManager)this.getContext().getSystemService("input_method");
            if(!z) {
                this.g = false;
                this.removeCallbacks(this.h);
                inputMethodManager0.hideSoftInputFromWindow(this.getWindowToken(), 0);
                return;
            }
            if(inputMethodManager0.isActive(this)) {
                this.g = false;
                this.removeCallbacks(this.h);
                inputMethodManager0.showSoftInput(this, 0);
                return;
            }
            this.g = true;
        }

        void setSearchView(SearchView searchView0) {
            this.f = searchView0;
        }

        @Override  // android.widget.AutoCompleteTextView
        public void setThreshold(int v) {
            super.setThreshold(v);
            this.e = v;
        }
    }

    class androidx.appcompat.widget.SearchView.a implements TextWatcher {
        final SearchView a;

        @Override  // android.text.TextWatcher
        public void afterTextChanged(Editable editable0) {
        }

        @Override  // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
        }

        @Override  // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
            SearchView.this.V(charSequence0);
        }
    }

    class androidx.appcompat.widget.SearchView.b implements Runnable {
        final SearchView e;

        @Override
        public void run() {
            SearchView.this.c0();
        }
    }

    class c implements Runnable {
        final SearchView e;

        @Override
        public void run() {
            q.a a0 = SearchView.this.O;
            if(a0 instanceof g0) {
                a0.b(null);
            }
        }
    }

    class f implements View.OnClickListener {
        final SearchView a;

        @Override  // android.view.View$OnClickListener
        public void onClick(View view0) {
            SearchView searchView0 = SearchView.this;
            if(view0 == searchView0.t) {
                searchView0.S();
                return;
            }
            if(view0 == searchView0.v) {
                searchView0.O();
                return;
            }
            if(view0 == searchView0.u) {
                searchView0.T();
                return;
            }
            if(view0 == searchView0.w) {
                searchView0.X();
                return;
            }
            if(view0 == searchView0.p) {
                searchView0.E();
            }
        }
    }

    class g implements View.OnKeyListener {
        final SearchView a;

        @Override  // android.view.View$OnKeyListener
        public boolean onKey(View view0, int v, KeyEvent keyEvent0) {
            SearchView searchView0 = SearchView.this;
            if(searchView0.c0 == null) {
                return false;
            }
            if(searchView0.p.isPopupShowing() && SearchView.this.p.getListSelection() != -1) {
                return SearchView.this.U(view0, v, keyEvent0);
            }
            if(!SearchView.this.p.c() && keyEvent0.hasNoModifiers() && keyEvent0.getAction() == 1 && v == 66) {
                view0.cancelLongPress();
                String s = SearchView.this.p.getText().toString();
                SearchView.this.M(0, null, s);
                return true;
            }
            return false;
        }
    }

    class h implements TextView.OnEditorActionListener {
        final SearchView a;

        @Override  // android.widget.TextView$OnEditorActionListener
        public boolean onEditorAction(TextView textView0, int v, KeyEvent keyEvent0) {
            SearchView.this.T();
            return true;
        }
    }

    class i implements AdapterView.OnItemClickListener {
        final SearchView a;

        @Override  // android.widget.AdapterView$OnItemClickListener
        public void onItemClick(AdapterView adapterView0, View view0, int v, long v1) {
            SearchView.this.P(v, 0, null);
        }
    }

    class j implements AdapterView.OnItemSelectedListener {
        final SearchView a;

        @Override  // android.widget.AdapterView$OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView0, View view0, int v, long v1) {
            SearchView.this.Q(v);
        }

        @Override  // android.widget.AdapterView$OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView0) {
        }
    }

    static abstract class k {
        static void a(AutoCompleteTextView autoCompleteTextView0) {
            autoCompleteTextView0.refreshAutoCompleteResults();
        }

        static void b(SearchAutoComplete searchView$SearchAutoComplete0, int v) {
            searchView$SearchAutoComplete0.setInputMethodMode(v);
        }
    }

    public interface l {
    }

    public interface m {
    }

    public interface n {
    }

    static class o {
        private Method a;
        private Method b;
        private Method c;

        o() {
            Class class0 = AutoCompleteTextView.class;
            super();
            this.a = null;
            this.b = null;
            this.c = null;
            o.d();
            try {
                Method method0 = class0.getDeclaredMethod("doBeforeTextChanged");
                this.a = method0;
                method0.setAccessible(true);
            }
            catch(NoSuchMethodException unused_ex) {
            }
            try {
                Method method1 = class0.getDeclaredMethod("doAfterTextChanged");
                this.b = method1;
                method1.setAccessible(true);
            }
            catch(NoSuchMethodException unused_ex) {
            }
            try {
                Method method2 = class0.getMethod("ensureImeVisible", Boolean.TYPE);
                this.c = method2;
                method2.setAccessible(true);
            }
            catch(NoSuchMethodException unused_ex) {
            }
        }

        void a(AutoCompleteTextView autoCompleteTextView0) {
            o.d();
            Method method0 = this.b;
            if(method0 != null) {
                try {
                    method0.invoke(autoCompleteTextView0);
                }
                catch(Exception unused_ex) {
                }
            }
        }

        void b(AutoCompleteTextView autoCompleteTextView0) {
            o.d();
            Method method0 = this.a;
            if(method0 != null) {
                try {
                    method0.invoke(autoCompleteTextView0);
                }
                catch(Exception unused_ex) {
                }
            }
        }

        void c(AutoCompleteTextView autoCompleteTextView0) {
            o.d();
            Method method0 = this.c;
            if(method0 != null) {
                try {
                    method0.invoke(autoCompleteTextView0, Boolean.TRUE);
                }
                catch(Exception unused_ex) {
                }
            }
        }

        private static void d() {
            if(Build.VERSION.SDK_INT >= 29) {
                throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
            }
        }
    }

    static class p extends r.a {
        class androidx.appcompat.widget.SearchView.p.a implements Parcelable.ClassLoaderCreator {
            androidx.appcompat.widget.SearchView.p.a() {
                super();
            }

            public p a(Parcel parcel0) {
                return new p(parcel0, null);
            }

            public p b(Parcel parcel0, ClassLoader classLoader0) {
                return new p(parcel0, classLoader0);
            }

            public p[] c(int v) {
                return new p[v];
            }

            @Override  // android.os.Parcelable$Creator
            public Object createFromParcel(Parcel parcel0) {
                return this.a(parcel0);
            }

            @Override  // android.os.Parcelable$ClassLoaderCreator
            public Object createFromParcel(Parcel parcel0, ClassLoader classLoader0) {
                return this.b(parcel0, classLoader0);
            }

            @Override  // android.os.Parcelable$Creator
            public Object[] newArray(int v) {
                return this.c(v);
            }
        }

        public static final Parcelable.Creator CREATOR;
        boolean g;

        static {
            p.CREATOR = new androidx.appcompat.widget.SearchView.p.a();
        }

        public p(Parcel parcel0, ClassLoader classLoader0) {
            super(parcel0, classLoader0);
            this.g = ((Boolean)parcel0.readValue(null)).booleanValue();
        }

        p(Parcelable parcelable0) {
            super(parcelable0);
        }

        @Override
        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.g + "}";
        }

        @Override  // r.a
        public void writeToParcel(Parcel parcel0, int v) {
            super.writeToParcel(parcel0, v);
            parcel0.writeValue(Boolean.valueOf(this.g));
        }
    }

    static class q extends TouchDelegate {
        private final View a;
        private final Rect b;
        private final Rect c;
        private final Rect d;
        private final int e;
        private boolean f;

        public q(Rect rect0, Rect rect1, View view0) {
            super(rect0, view0);
            this.e = ViewConfiguration.get(view0.getContext()).getScaledTouchSlop();
            this.b = new Rect();
            this.d = new Rect();
            this.c = new Rect();
            this.a(rect0, rect1);
            this.a = view0;
        }

        public void a(Rect rect0, Rect rect1) {
            this.b.set(rect0);
            this.d.set(rect0);
            this.d.inset(-this.e, -this.e);
            this.c.set(rect1);
        }

        @Override  // android.view.TouchDelegate
        public boolean onTouchEvent(MotionEvent motionEvent0) {
            int v3;
            float f;
            boolean z2;
            boolean z1;
            int v = (int)motionEvent0.getX();
            int v1 = (int)motionEvent0.getY();
            int v2 = motionEvent0.getAction();
            boolean z = true;
            switch(v2) {
                case 0: {
                    if(this.b.contains(v, v1)) {
                        this.f = true;
                        z2 = true;
                    }
                    else {
                        z2 = true;
                        z = false;
                    }
                    break;
                }
                case 1: 
                case 2: {
                    z1 = this.f;
                    if(!z1 || this.d.contains(v, v1)) {
                        z = z1;
                        z2 = true;
                    }
                    else {
                        z2 = false;
                    }
                    break;
                }
                default: {
                    if(v2 == 3) {
                        z1 = this.f;
                        this.f = false;
                        z = z1;
                        z2 = true;
                    }
                    else {
                        z2 = true;
                        z = false;
                    }
                }
            }
            if(z) {
                if(!z2 || this.c.contains(v, v1)) {
                    f = (float)(v - this.c.left);
                    v3 = v1 - this.c.top;
                }
                else {
                    f = (float)(this.a.getWidth() / 2);
                    v3 = this.a.getHeight() / 2;
                }
                motionEvent0.setLocation(f, ((float)v3));
                return this.a.dispatchTouchEvent(motionEvent0);
            }
            return false;
        }
    }

    private Rect A;
    private int[] B;
    private int[] C;
    private final ImageView D;
    private final Drawable E;
    private final int F;
    private final int G;
    private final Intent H;
    private final Intent I;
    private final CharSequence J;
    View.OnFocusChangeListener K;
    private View.OnClickListener L;
    private boolean M;
    private boolean N;
    q.a O;
    private boolean P;
    private CharSequence Q;
    private boolean R;
    private boolean S;
    private int T;
    private boolean U;
    private CharSequence V;
    private CharSequence W;
    private boolean a0;
    private int b0;
    SearchableInfo c0;
    private Bundle d0;
    private final Runnable e0;
    private Runnable f0;
    private final WeakHashMap g0;
    private final View.OnClickListener h0;
    View.OnKeyListener i0;
    private final TextView.OnEditorActionListener j0;
    private final AdapterView.OnItemClickListener k0;
    private final AdapterView.OnItemSelectedListener l0;
    private TextWatcher m0;
    static final o n0;
    final SearchAutoComplete p;
    private final View q;
    private final View r;
    private final View s;
    final ImageView t;
    final ImageView u;
    final ImageView v;
    final ImageView w;
    private final View x;
    private q y;
    private Rect z;

    static {
        SearchView.n0 = Build.VERSION.SDK_INT >= 29 ? null : new o();
    }

    public SearchView(Context context0) {
        this(context0, null);
    }

    public SearchView(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, c.a.p);
    }

    public SearchView(Context context0, AttributeSet attributeSet0, int v) {
        class androidx.appcompat.widget.SearchView.d implements View.OnFocusChangeListener {
            final SearchView a;

            @Override  // android.view.View$OnFocusChangeListener
            public void onFocusChange(View view0, boolean z) {
                SearchView searchView0 = SearchView.this;
                View.OnFocusChangeListener view$OnFocusChangeListener0 = searchView0.K;
                if(view$OnFocusChangeListener0 != null) {
                    view$OnFocusChangeListener0.onFocusChange(searchView0, z);
                }
            }
        }


        class e implements View.OnLayoutChangeListener {
            final SearchView a;

            @Override  // android.view.View$OnLayoutChangeListener
            public void onLayoutChange(View view0, int v, int v1, int v2, int v3, int v4, int v5, int v6, int v7) {
                SearchView.this.y();
            }
        }

        super(context0, attributeSet0, v);
        this.z = new Rect();
        this.A = new Rect();
        this.B = new int[2];
        this.C = new int[2];
        this.e0 = () -> {
            int[] arr_v = SearchView.this.p.hasFocus() ? ViewGroup.FOCUSED_STATE_SET : ViewGroup.EMPTY_STATE_SET;
            Drawable drawable0 = SearchView.this.r.getBackground();
            if(drawable0 != null) {
                drawable0.setState(arr_v);
            }
            Drawable drawable1 = SearchView.this.s.getBackground();
            if(drawable1 != null) {
                drawable1.setState(arr_v);
            }
            SearchView.this.invalidate();
        };
        this.f0 = new c(this);
        this.g0 = new WeakHashMap();
        f searchView$f0 = new f(this);
        this.h0 = searchView$f0;
        this.i0 = new g(this);
        h searchView$h0 = new h(this);
        this.j0 = searchView$h0;
        i searchView$i0 = (/* 缺少LAMBDA参数 */, /* 缺少LAMBDA参数 */, int v, /* 缺少LAMBDA参数 */) -> {
            SearchView.this.N(v, 0, null);
            SearchView.this.p.setImeVisibility(false);
            SearchView.this.D();
            return true;
        };
        this.k0 = searchView$i0;
        j searchView$j0 = new j(this);
        this.l0 = searchView$j0;
        this.m0 = new androidx.appcompat.widget.SearchView.a(this);
        l0 l00 = l0.s(context0, attributeSet0, c.i.w1, v, 0);
        v.F(this, context0, c.i.w1, attributeSet0, l00.o(), v, 0);
        LayoutInflater.from(context0).inflate(l00.l(c.i.G1, c.f.l), this, true);
        SearchAutoComplete searchView$SearchAutoComplete0 = (SearchAutoComplete)this.findViewById(c.e.t);
        this.p = searchView$SearchAutoComplete0;
        searchView$SearchAutoComplete0.setSearchView(this);
        this.q = this.findViewById(c.e.p);
        View view0 = this.findViewById(c.e.s);
        this.r = view0;
        View view1 = this.findViewById(c.e.z);
        this.s = view1;
        ImageView imageView0 = (ImageView)this.findViewById(c.e.n);
        this.t = imageView0;
        ImageView imageView1 = (ImageView)this.findViewById(c.e.q);
        this.u = imageView1;
        ImageView imageView2 = (ImageView)this.findViewById(c.e.o);
        this.v = imageView2;
        ImageView imageView3 = (ImageView)this.findViewById(c.e.u);
        this.w = imageView3;
        ImageView imageView4 = (ImageView)this.findViewById(c.e.r);
        this.D = imageView4;
        v.J(view0, l00.f(c.i.H1));
        v.J(view1, l00.f(c.i.L1));
        imageView0.setImageDrawable(l00.f(c.i.K1));
        imageView1.setImageDrawable(l00.f(c.i.E1));
        imageView2.setImageDrawable(l00.f(c.i.B1));
        imageView3.setImageDrawable(l00.f(c.i.N1));
        imageView4.setImageDrawable(l00.f(c.i.K1));
        this.E = l00.f(c.i.J1);
        p0.a(imageView0, this.getResources().getString(c.g.l));
        this.F = l00.l(c.i.M1, c.f.k);
        this.G = l00.l(c.i.C1, 0);
        imageView0.setOnClickListener(searchView$f0);
        imageView2.setOnClickListener(searchView$f0);
        imageView1.setOnClickListener(searchView$f0);
        imageView3.setOnClickListener(searchView$f0);
        searchView$SearchAutoComplete0.setOnClickListener(searchView$f0);
        searchView$SearchAutoComplete0.addTextChangedListener(this.m0);
        searchView$SearchAutoComplete0.setOnEditorActionListener(searchView$h0);
        searchView$SearchAutoComplete0.setOnItemClickListener(searchView$i0);
        searchView$SearchAutoComplete0.setOnItemSelectedListener(searchView$j0);
        searchView$SearchAutoComplete0.setOnKeyListener(this.i0);
        searchView$SearchAutoComplete0.setOnFocusChangeListener(new androidx.appcompat.widget.SearchView.d(this));
        this.setIconifiedByDefault(l00.a(c.i.F1, true));
        int v1 = l00.e(c.i.y1, -1);
        if(v1 != -1) {
            this.setMaxWidth(v1);
        }
        this.J = l00.n(c.i.D1);
        this.Q = l00.n(c.i.I1);
        int v2 = l00.i(c.i.A1, -1);
        if(v2 != -1) {
            this.setImeOptions(v2);
        }
        int v3 = l00.i(c.i.z1, -1);
        if(v3 != -1) {
            this.setInputType(v3);
        }
        this.setFocusable(l00.a(c.i.x1, true));
        l00.t();
        Intent intent0 = new Intent("android.speech.action.WEB_SEARCH");
        this.H = intent0;
        intent0.addFlags(0x10000000);
        intent0.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent1 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.I = intent1;
        intent1.addFlags(0x10000000);
        View view2 = this.findViewById(searchView$SearchAutoComplete0.getDropDownAnchor());
        this.x = view2;
        if(view2 != null) {
            view2.addOnLayoutChangeListener((/* 缺少LAMBDA参数 */, /* 缺少LAMBDA参数 */, /* 缺少LAMBDA参数 */, /* 缺少LAMBDA参数 */, /* 缺少LAMBDA参数 */, /* 缺少LAMBDA参数 */, /* 缺少LAMBDA参数 */, /* 缺少LAMBDA参数 */, /* 缺少LAMBDA参数 */) -> if(SearchView.this.x.getWidth() > 1) {
                Resources resources0 = SearchView.this.getContext().getResources();
                int v = SearchView.this.r.getPaddingLeft();
                Rect rect0 = new Rect();
                boolean z = v0.a(SearchView.this);
                int v1 = SearchView.this.M ? resources0.getDimensionPixelSize(c.c.c) + resources0.getDimensionPixelSize(c.c.d) : 0;
                SearchView.this.p.getDropDownBackground().getPadding(rect0);
                SearchView.this.p.setDropDownHorizontalOffset((z ? -rect0.left : v - (rect0.left + v1)));
                int v2 = SearchView.this.x.getWidth();
                SearchView.this.p.setDropDownWidth(v2 + rect0.left + rect0.right + v1 - v);
            });
        }
        this.h0(this.M);
        this.d0();
    }

    private Intent A(Cursor cursor0, int v, String s) {
        int v1;
        try {
            String s1 = g0.o(cursor0, "suggest_intent_action");
            if(s1 == null) {
                s1 = this.c0.getSuggestIntentAction();
            }
            if(s1 == null) {
                s1 = "android.intent.action.SEARCH";
            }
            String s2 = g0.o(cursor0, "suggest_intent_data");
            if(s2 == null) {
                s2 = this.c0.getSuggestIntentData();
            }
            if(s2 != null) {
                String s3 = g0.o(cursor0, "suggest_intent_data_id");
                if(s3 != null) {
                    s2 = s2 + "/" + Uri.encode(s3);
                }
            }
            Uri uri0 = s2 == null ? null : Uri.parse(s2);
            String s4 = g0.o(cursor0, "suggest_intent_query");
            return this.z(s1, uri0, g0.o(cursor0, "suggest_intent_extra_data"), s4, v, s);
        }
        catch(RuntimeException runtimeException0) {
            try {
                v1 = -1;
                v1 = cursor0.getPosition();
            }
            catch(RuntimeException unused_ex) {
            }
            Log.w("SearchView", "Search suggestions cursor at row " + v1 + " returned exception.", runtimeException0);
            return null;
        }
    }

    private Intent B(Intent intent0, SearchableInfo searchableInfo0) {
        ComponentName componentName0 = searchableInfo0.getSearchActivity();
        Intent intent1 = new Intent("android.intent.action.SEARCH");
        intent1.setComponent(componentName0);
        PendingIntent pendingIntent0 = PendingIntent.getActivity(this.getContext(), 0, intent1, 0x42000000);
        Bundle bundle0 = new Bundle();
        Bundle bundle1 = this.d0;
        if(bundle1 != null) {
            bundle0.putParcelable("app_data", bundle1);
        }
        Intent intent2 = new Intent(intent0);
        Resources resources0 = this.getResources();
        String s = searchableInfo0.getVoiceLanguageModeId() == 0 ? "free_form" : resources0.getString(searchableInfo0.getVoiceLanguageModeId());
        String s1 = null;
        String s2 = searchableInfo0.getVoicePromptTextId() == 0 ? null : resources0.getString(searchableInfo0.getVoicePromptTextId());
        String s3 = searchableInfo0.getVoiceLanguageId() == 0 ? null : resources0.getString(searchableInfo0.getVoiceLanguageId());
        int v = searchableInfo0.getVoiceMaxResults() == 0 ? 1 : searchableInfo0.getVoiceMaxResults();
        intent2.putExtra("android.speech.extra.LANGUAGE_MODEL", s);
        intent2.putExtra("android.speech.extra.PROMPT", s2);
        intent2.putExtra("android.speech.extra.LANGUAGE", s3);
        intent2.putExtra("android.speech.extra.MAX_RESULTS", v);
        if(componentName0 != null) {
            s1 = componentName0.flattenToShortString();
        }
        intent2.putExtra("calling_package", s1);
        intent2.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", pendingIntent0);
        intent2.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle0);
        return intent2;
    }

    private Intent C(Intent intent0, SearchableInfo searchableInfo0) {
        Intent intent1 = new Intent(intent0);
        ComponentName componentName0 = searchableInfo0.getSearchActivity();
        intent1.putExtra("calling_package", (componentName0 == null ? null : componentName0.flattenToShortString()));
        return intent1;
    }

    private void D() {
        this.p.dismissDropDown();
    }

    void E() {
        if(Build.VERSION.SDK_INT >= 29) {
            k.a(this.p);
            return;
        }
        SearchView.n0.b(this.p);
        SearchView.n0.a(this.p);
    }

    private void F(View view0, Rect rect0) {
        view0.getLocationInWindow(this.B);
        this.getLocationInWindow(this.C);
        int[] arr_v = this.B;
        int[] arr_v1 = this.C;
        int v = arr_v[1] - arr_v1[1];
        int v1 = arr_v[0] - arr_v1[0];
        rect0.set(v1, v, view0.getWidth() + v1, view0.getHeight() + v);
    }

    private CharSequence G(CharSequence charSequence0) {
        if(this.M && this.E != null) {
            int v = (int)(((double)this.p.getTextSize()) * 1.25);
            this.E.setBounds(0, 0, v, v);
            CharSequence charSequence1 = new SpannableStringBuilder("   ");
            ((SpannableStringBuilder)charSequence1).setSpan(new ImageSpan(this.E), 1, 2, 33);
            ((SpannableStringBuilder)charSequence1).append(charSequence0);
            return charSequence1;
        }
        return charSequence0;
    }

    private boolean H() {
        if(this.c0 != null && this.c0.getVoiceSearchEnabled()) {
            if(this.c0.getVoiceSearchLaunchWebSearch()) {
                return this.H != null && this.getContext().getPackageManager().resolveActivity(this.H, 0x10000) != null;
            }
            Intent intent0 = this.c0.getVoiceSearchLaunchRecognizer() ? this.I : null;
            return intent0 != null && this.getContext().getPackageManager().resolveActivity(intent0, 0x10000) != null;
        }
        return false;
    }

    public boolean I() {
        return this.N;
    }

    static boolean J(Context context0) {
        return context0.getResources().getConfiguration().orientation == 2;
    }

    // 去混淆评级： 低(30)
    private boolean K() {
        return (this.P || this.U) && !this.I();
    }

    private void L(Intent intent0) {
        if(intent0 == null) {
            return;
        }
        try {
            this.getContext().startActivity(intent0);
        }
        catch(RuntimeException runtimeException0) {
            Log.e("SearchView", "Failed launch activity: " + intent0, runtimeException0);
        }
    }

    void M(int v, String s, String s1) {
        Intent intent0 = this.z("android.intent.action.SEARCH", null, null, s1, v, s);
        this.getContext().startActivity(intent0);
    }

    private boolean N(int v, int v1, String s) {
        Cursor cursor0 = this.O.c();
        if(cursor0 != null && cursor0.moveToPosition(v)) {
            this.L(this.A(cursor0, v1, s));
            return true;
        }
        return false;
    }

    void O() {
        if(!TextUtils.isEmpty(this.p.getText())) {
            this.p.setText("");
            this.p.requestFocus();
            this.p.setImeVisibility(true);
        }
        else if(this.M) {
            this.clearFocus();
            this.h0(true);
        }
    }

    // 检测为 Lambda 实现
    boolean P(int v, int v1, String s) [...]

    boolean Q(int v) {
        this.Z(v);
        return true;
    }

    protected void R(CharSequence charSequence0) {
        this.setQuery(charSequence0);
    }

    void S() {
        this.h0(false);
        this.p.requestFocus();
        this.p.setImeVisibility(true);
        View.OnClickListener view$OnClickListener0 = this.L;
        if(view$OnClickListener0 != null) {
            view$OnClickListener0.onClick(this);
        }
    }

    void T() {
        Editable editable0 = this.p.getText();
        if(editable0 != null && TextUtils.getTrimmedLength(editable0) > 0) {
            if(this.c0 != null) {
                this.M(0, null, editable0.toString());
            }
            this.p.setImeVisibility(false);
            this.D();
        }
    }

    boolean U(View view0, int v, KeyEvent keyEvent0) {
        if(this.c0 == null) {
            return false;
        }
        if(this.O == null) {
            return false;
        }
        if(keyEvent0.getAction() == 0 && keyEvent0.hasNoModifiers()) {
            switch(v) {
                case 19: {
                    this.p.getListSelection();
                    return false;
                }
                case 21: 
                case 22: {
                    int v1 = v == 21 ? 0 : this.p.length();
                    this.p.setSelection(v1);
                    this.p.setListSelection(0);
                    this.p.clearListSelection();
                    this.p.b();
                    return true;
                }
                case 61: 
                case 66: 
                case 84: {
                    return this.P(this.p.getListSelection(), 0, null);
                }
                default: {
                    return false;
                }
            }
        }
        return false;
    }

    void V(CharSequence charSequence0) {
        Editable editable0 = this.p.getText();
        this.W = editable0;
        boolean z = TextUtils.isEmpty(editable0);
        this.g0(!z);
        this.i0(z);
        this.b0();
        this.f0();
        this.V = charSequence0.toString();
    }

    void W() {
        this.h0(this.I());
        this.Y();
        if(this.p.hasFocus()) {
            this.E();
        }
    }

    void X() {
        Intent intent0;
        try {
            SearchableInfo searchableInfo0 = this.c0;
            if(searchableInfo0 == null) {
                return;
            }
            boolean z = false;
            if(searchableInfo0.getVoiceSearchLaunchWebSearch()) {
                z = true;
                intent0 = this.C(this.H, searchableInfo0);
            }
            else if(searchableInfo0.getVoiceSearchLaunchRecognizer()) {
                z = true;
                intent0 = this.B(this.I, searchableInfo0);
            }
            if(z) {
                this.getContext().startActivity(intent0);
            }
        }
        catch(ActivityNotFoundException unused_ex) {
            Log.w("SearchView", "Could not find voice search activity");
        }
    }

    private void Y() {
        this.post(this.e0);
    }

    private void Z(int v) {
        Editable editable0 = this.p.getText();
        Cursor cursor0 = this.O.c();
        if(cursor0 == null) {
            return;
        }
        if(cursor0.moveToPosition(v)) {
            CharSequence charSequence0 = this.O.a(cursor0);
            if(charSequence0 != null) {
                this.setQuery(charSequence0);
                return;
            }
        }
        this.setQuery(editable0);
    }

    public void a0(CharSequence charSequence0, boolean z) {
        this.p.setText(charSequence0);
        if(charSequence0 != null) {
            int v = this.p.length();
            this.p.setSelection(v);
            this.W = charSequence0;
        }
        if(z && !TextUtils.isEmpty(charSequence0)) {
            this.T();
        }
    }

    @Override  // h.b
    public void b() {
        if(this.a0) {
            return;
        }
        this.a0 = true;
        int v = this.p.getImeOptions();
        this.b0 = v;
        this.p.setImeOptions(v | 0x2000000);
        this.p.setText("");
        this.setIconified(false);
    }

    private void b0() {
        boolean z = TextUtils.isEmpty(this.p.getText());
        boolean z1 = true;
        int v = 0;
        if(!z == 0 && (!this.M || this.a0)) {
            z1 = false;
        }
        ImageView imageView0 = this.v;
        if(!z1) {
            v = 8;
        }
        imageView0.setVisibility(v);
        Drawable drawable0 = this.v.getDrawable();
        if(drawable0 != null) {
            drawable0.setState((!z == 0 ? ViewGroup.EMPTY_STATE_SET : ViewGroup.ENABLED_STATE_SET));
        }
    }

    @Override  // h.b
    public void c() {
        this.a0("", false);
        this.clearFocus();
        this.h0(true);
        this.p.setImeOptions(this.b0);
        this.a0 = false;
    }

    // 检测为 Lambda 实现
    void c0() [...]

    @Override  // android.view.ViewGroup
    public void clearFocus() {
        this.S = true;
        super.clearFocus();
        this.p.clearFocus();
        this.p.setImeVisibility(false);
        this.S = false;
    }

    private void d0() {
        CharSequence charSequence0 = this.getQueryHint();
        SearchAutoComplete searchView$SearchAutoComplete0 = this.p;
        if(charSequence0 == null) {
            charSequence0 = "";
        }
        searchView$SearchAutoComplete0.setHint(this.G(charSequence0));
    }

    private void e0() {
        int v = this.c0.getSuggestThreshold();
        this.p.setThreshold(v);
        int v1 = this.c0.getImeOptions();
        this.p.setImeOptions(v1);
        int v2 = this.c0.getInputType();
        int v3 = 1;
        if((v2 & 15) == 1) {
            v2 &= 0xFFFEFFFF;
            if(this.c0.getSuggestAuthority() != null) {
                v2 |= 0x90000;
            }
        }
        this.p.setInputType(v2);
        q.a a0 = this.O;
        if(a0 != null) {
            a0.b(null);
        }
        if(this.c0.getSuggestAuthority() != null) {
            g0 g00 = new g0(this.getContext(), this, this.c0, this.g0);
            this.O = g00;
            this.p.setAdapter(g00);
            g0 g01 = (g0)this.O;
            if(this.R) {
                v3 = 2;
            }
            g01.x(v3);
        }
    }

    private void f0() {
        int v = !this.K() || this.u.getVisibility() != 0 && this.w.getVisibility() != 0 ? 8 : 0;
        this.s.setVisibility(v);
    }

    private void g0(boolean z) {
        int v = !this.P || !this.K() || !this.hasFocus() || !z && this.U ? 8 : 0;
        this.u.setVisibility(v);
    }

    public int getImeOptions() {
        return this.p.getImeOptions();
    }

    public int getInputType() {
        return this.p.getInputType();
    }

    public int getMaxWidth() {
        return this.T;
    }

    private int getPreferredHeight() {
        return this.getContext().getResources().getDimensionPixelSize(c.c.e);
    }

    private int getPreferredWidth() {
        return this.getContext().getResources().getDimensionPixelSize(c.c.f);
    }

    public CharSequence getQuery() {
        return this.p.getText();
    }

    public CharSequence getQueryHint() {
        CharSequence charSequence0 = this.Q;
        if(charSequence0 == null) {
            return this.c0 == null || this.c0.getHintId() == 0 ? this.J : this.getContext().getText(this.c0.getHintId());
        }
        return charSequence0;
    }

    int getSuggestionCommitIconResId() {
        return this.G;
    }

    int getSuggestionRowLayout() {
        return this.F;
    }

    public q.a getSuggestionsAdapter() {
        return this.O;
    }

    private void h0(boolean z) {
        this.N = z;
        int v = 0;
        boolean z1 = TextUtils.isEmpty(this.p.getText());
        this.t.setVisibility((z ? 0 : 8));
        this.g0(!z1);
        this.q.setVisibility((z ? 8 : 0));
        if(this.D.getDrawable() == null || this.M) {
            v = 8;
        }
        this.D.setVisibility(v);
        this.b0();
        this.i0(z1);
        this.f0();
    }

    private void i0(boolean z) {
        int v = 8;
        if(this.U && !this.I() && z) {
            this.u.setVisibility(8);
            v = 0;
        }
        this.w.setVisibility(v);
    }

    @Override  // android.view.ViewGroup
    protected void onDetachedFromWindow() {
        this.removeCallbacks(this.e0);
        this.post(this.f0);
        super.onDetachedFromWindow();
    }

    @Override  // androidx.appcompat.widget.y
    protected void onLayout(boolean z, int v, int v1, int v2, int v3) {
        super.onLayout(z, v, v1, v2, v3);
        if(z) {
            this.F(this.p, this.z);
            this.A.set(this.z.left, 0, this.z.right, v3 - v1);
            q searchView$q0 = this.y;
            if(searchView$q0 == null) {
                q searchView$q1 = new q(this.A, this.z, this.p);
                this.y = searchView$q1;
                this.setTouchDelegate(searchView$q1);
                return;
            }
            searchView$q0.a(this.A, this.z);
        }
    }

    @Override  // androidx.appcompat.widget.y
    protected void onMeasure(int v, int v1) {
        if(this.I()) {
            super.onMeasure(v, v1);
            return;
        }
        int v2 = View.MeasureSpec.getMode(v);
        int v3 = View.MeasureSpec.getSize(v);
        switch(v2) {
            case 0x80000000: {
                v3 = Math.min((this.T > 0 ? this.T : this.getPreferredWidth()), v3);
                break;
            }
            case 0: {
                v3 = this.T;
                if(v3 <= 0) {
                    v3 = this.getPreferredWidth();
                }
                break;
            }
            case 0x40000000: {
                int v4 = this.T;
                if(v4 > 0) {
                    v3 = Math.min(v4, v3);
                }
            }
        }
        int v5 = View.MeasureSpec.getMode(v1);
        int v6 = View.MeasureSpec.getSize(v1);
        switch(v5) {
            case 0x80000000: {
                v6 = Math.min(this.getPreferredHeight(), v6);
                break;
            }
            case 0: {
                v6 = this.getPreferredHeight();
            }
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(v3, 0x40000000), View.MeasureSpec.makeMeasureSpec(v6, 0x40000000));
    }

    @Override  // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable0) {
        if(!(parcelable0 instanceof p)) {
            super.onRestoreInstanceState(parcelable0);
            return;
        }
        super.onRestoreInstanceState(((p)parcelable0).o());
        this.h0(((p)parcelable0).g);
        this.requestLayout();
    }

    @Override  // android.view.View
    protected Parcelable onSaveInstanceState() {
        Parcelable parcelable0 = new p(super.onSaveInstanceState());
        parcelable0.g = this.I();
        return parcelable0;
    }

    @Override  // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.Y();
    }

    @Override  // android.view.ViewGroup
    public boolean requestFocus(int v, Rect rect0) {
        if(this.S) {
            return false;
        }
        if(!this.isFocusable()) {
            return false;
        }
        if(!this.I()) {
            boolean z = this.p.requestFocus(v, rect0);
            if(z) {
                this.h0(false);
            }
            return z;
        }
        return super.requestFocus(v, rect0);
    }

    public void setAppSearchData(Bundle bundle0) {
        this.d0 = bundle0;
    }

    public void setIconified(boolean z) {
        if(z) {
            this.O();
            return;
        }
        this.S();
    }

    public void setIconifiedByDefault(boolean z) {
        if(this.M == z) {
            return;
        }
        this.M = z;
        this.h0(z);
        this.d0();
    }

    public void setImeOptions(int v) {
        this.p.setImeOptions(v);
    }

    public void setInputType(int v) {
        this.p.setInputType(v);
    }

    public void setMaxWidth(int v) {
        this.T = v;
        this.requestLayout();
    }

    public void setOnCloseListener(l searchView$l0) {
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener view$OnFocusChangeListener0) {
        this.K = view$OnFocusChangeListener0;
    }

    public void setOnQueryTextListener(m searchView$m0) {
    }

    public void setOnSearchClickListener(View.OnClickListener view$OnClickListener0) {
        this.L = view$OnClickListener0;
    }

    public void setOnSuggestionListener(n searchView$n0) {
    }

    private void setQuery(CharSequence charSequence0) {
        this.p.setText(charSequence0);
        int v = TextUtils.isEmpty(charSequence0) ? 0 : charSequence0.length();
        this.p.setSelection(v);
    }

    public void setQueryHint(CharSequence charSequence0) {
        this.Q = charSequence0;
        this.d0();
    }

    public void setQueryRefinementEnabled(boolean z) {
        this.R = z;
        q.a a0 = this.O;
        if(a0 instanceof g0) {
            ((g0)a0).x((z ? 2 : 1));
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo0) {
        this.c0 = searchableInfo0;
        if(searchableInfo0 != null) {
            this.e0();
            this.d0();
        }
        boolean z = this.H();
        this.U = z;
        if(z) {
            this.p.setPrivateImeOptions("nm");
        }
        this.h0(this.I());
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.P = z;
        this.h0(this.I());
    }

    public void setSuggestionsAdapter(q.a a0) {
        this.O = a0;
        this.p.setAdapter(a0);
    }

    // 检测为 Lambda 实现
    void y() [...]

    private Intent z(String s, Uri uri0, String s1, String s2, int v, String s3) {
        Intent intent0 = new Intent(s);
        intent0.addFlags(0x10000000);
        if(uri0 != null) {
            intent0.setData(uri0);
        }
        intent0.putExtra("user_query", this.W);
        if(s2 != null) {
            intent0.putExtra("query", s2);
        }
        if(s1 != null) {
            intent0.putExtra("intent_extra_data_key", s1);
        }
        Bundle bundle0 = this.d0;
        if(bundle0 != null) {
            intent0.putExtra("app_data", bundle0);
        }
        if(v != 0) {
            intent0.putExtra("action_key", v);
            intent0.putExtra("action_msg", s3);
        }
        intent0.setComponent(this.c0.getSearchActivity());
        return intent0;
    }
}

