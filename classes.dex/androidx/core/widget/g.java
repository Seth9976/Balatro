package androidx.core.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.ColorStateList;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.icu.text.DecimalFormatSymbols;
import android.os.Build.VERSION;
import android.text.Editable;
import android.text.PrecomputedText.Params;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.PasswordTransformationMethod;
import android.view.ActionMode.Callback;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import o.l;

public abstract class g {
    static abstract class a {
        static boolean a(TextView textView0) {
            return textView0.getIncludeFontPadding();
        }

        static int b(TextView textView0) {
            return textView0.getMaxLines();
        }

        static int c(TextView textView0) {
            return textView0.getMinLines();
        }
    }

    static abstract class b {
        static Drawable[] a(TextView textView0) {
            return textView0.getCompoundDrawablesRelative();
        }

        static int b(View view0) {
            return view0.getLayoutDirection();
        }

        static int c(View view0) {
            return view0.getTextDirection();
        }

        static Locale d(TextView textView0) {
            return textView0.getTextLocale();
        }

        static void e(TextView textView0, Drawable drawable0, Drawable drawable1, Drawable drawable2, Drawable drawable3) {
            textView0.setCompoundDrawablesRelative(drawable0, drawable1, drawable2, drawable3);
        }

        static void f(TextView textView0, int v, int v1, int v2, int v3) {
            textView0.setCompoundDrawablesRelativeWithIntrinsicBounds(v, v1, v2, v3);
        }

        static void g(TextView textView0, Drawable drawable0, Drawable drawable1, Drawable drawable2, Drawable drawable3) {
            textView0.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable0, drawable1, drawable2, drawable3);
        }

        static void h(View view0, int v) {
            view0.setTextDirection(v);
        }
    }

    static abstract class c {
        static int a(TextView textView0) {
            return textView0.getBreakStrategy();
        }

        static ColorStateList b(TextView textView0) {
            return textView0.getCompoundDrawableTintList();
        }

        static PorterDuff.Mode c(TextView textView0) {
            return textView0.getCompoundDrawableTintMode();
        }

        static int d(TextView textView0) {
            return textView0.getHyphenationFrequency();
        }

        static void e(TextView textView0, int v) {
            textView0.setBreakStrategy(v);
        }

        static void f(TextView textView0, ColorStateList colorStateList0) {
            textView0.setCompoundDrawableTintList(colorStateList0);
        }

        static void g(TextView textView0, PorterDuff.Mode porterDuff$Mode0) {
            textView0.setCompoundDrawableTintMode(porterDuff$Mode0);
        }

        static void h(TextView textView0, int v) {
            textView0.setHyphenationFrequency(v);
        }
    }

    static abstract class d {
        static DecimalFormatSymbols a(Locale locale0) {
            return DecimalFormatSymbols.getInstance(locale0);
        }
    }

    static abstract class e {
        static String[] a(DecimalFormatSymbols decimalFormatSymbols0) {
            return decimalFormatSymbols0.getDigitStrings();
        }

        static PrecomputedText.Params b(TextView textView0) {
            return textView0.getTextMetricsParams();
        }

        static void c(TextView textView0, int v) {
            textView0.setFirstBaselineToTopHeight(v);
        }
    }

    static class f implements ActionMode.Callback {
        private final ActionMode.Callback a;
        private final TextView b;
        private Class c;
        private Method d;
        private boolean e;
        private boolean f;

        f(ActionMode.Callback actionMode$Callback0, TextView textView0) {
            this.a = actionMode$Callback0;
            this.b = textView0;
            this.f = false;
        }

        private Intent a() {
            return new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
        }

        private Intent b(ResolveInfo resolveInfo0, TextView textView0) {
            return this.a().putExtra("android.intent.extra.PROCESS_TEXT_READONLY", !this.e(textView0)).setClassName(resolveInfo0.activityInfo.packageName, resolveInfo0.activityInfo.name);
        }

        private List c(Context context0, PackageManager packageManager0) {
            List list0 = new ArrayList();
            if(!(context0 instanceof Activity)) {
                return list0;
            }
            for(Object object0: packageManager0.queryIntentActivities(this.a(), 0)) {
                ResolveInfo resolveInfo0 = (ResolveInfo)object0;
                if(this.f(resolveInfo0, context0)) {
                    list0.add(resolveInfo0);
                }
            }
            return list0;
        }

        ActionMode.Callback d() {
            return this.a;
        }

        // 去混淆评级： 低(30)
        private boolean e(TextView textView0) {
            return textView0 instanceof Editable && textView0.onCheckIsTextEditor() && textView0.isEnabled();
        }

        private boolean f(ResolveInfo resolveInfo0, Context context0) {
            if("com.playstack.balatro.android".equals(resolveInfo0.activityInfo.packageName)) {
                return true;
            }
            return resolveInfo0.activityInfo.exported ? resolveInfo0.activityInfo.permission == null || context0.checkSelfPermission(resolveInfo0.activityInfo.permission) == 0 : false;
        }

        private void g(Menu menu0) {
            Context context0 = this.b.getContext();
            PackageManager packageManager0 = context0.getPackageManager();
            if(!this.f) {
                try {
                    this.f = true;
                    Class class0 = Class.forName("com.android.internal.view.menu.MenuBuilder");
                    this.c = class0;
                    this.d = class0.getDeclaredMethod("removeItemAt", Integer.TYPE);
                    this.e = true;
                }
                catch(ClassNotFoundException | NoSuchMethodException unused_ex) {
                    this.c = null;
                    this.d = null;
                    this.e = false;
                }
            }
            try {
                Method method0 = !this.e || !this.c.isInstance(menu0) ? menu0.getClass().getDeclaredMethod("removeItemAt", Integer.TYPE) : this.d;
                for(int v = menu0.size() - 1; v >= 0; --v) {
                    MenuItem menuItem0 = menu0.getItem(v);
                    if(menuItem0.getIntent() != null && "android.intent.action.PROCESS_TEXT".equals(menuItem0.getIntent().getAction())) {
                        method0.invoke(menu0, v);
                    }
                }
            }
            catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException unused_ex) {
                return;
            }
            List list0 = this.c(context0, packageManager0);
            for(int v1 = 0; v1 < list0.size(); ++v1) {
                ResolveInfo resolveInfo0 = (ResolveInfo)list0.get(v1);
                menu0.add(0, 0, v1 + 100, resolveInfo0.loadLabel(packageManager0)).setIntent(this.b(resolveInfo0, this.b)).setShowAsAction(1);
            }
        }

        @Override  // android.view.ActionMode$Callback
        public boolean onActionItemClicked(ActionMode actionMode0, MenuItem menuItem0) {
            return this.a.onActionItemClicked(actionMode0, menuItem0);
        }

        @Override  // android.view.ActionMode$Callback
        public boolean onCreateActionMode(ActionMode actionMode0, Menu menu0) {
            return this.a.onCreateActionMode(actionMode0, menu0);
        }

        @Override  // android.view.ActionMode$Callback
        public void onDestroyActionMode(ActionMode actionMode0) {
            this.a.onDestroyActionMode(actionMode0);
        }

        @Override  // android.view.ActionMode$Callback
        public boolean onPrepareActionMode(ActionMode actionMode0, Menu menu0) {
            this.g(menu0);
            return this.a.onPrepareActionMode(actionMode0, menu0);
        }
    }

    public static int a(TextView textView0) {
        return textView0.getPaddingTop() - textView0.getPaint().getFontMetricsInt().top;
    }

    public static int b(TextView textView0) {
        return textView0.getPaddingBottom() + textView0.getPaint().getFontMetricsInt().bottom;
    }

    private static int c(TextDirectionHeuristic textDirectionHeuristic0) {
        if(textDirectionHeuristic0 == TextDirectionHeuristics.FIRSTSTRONG_RTL) {
            return 1;
        }
        if(textDirectionHeuristic0 == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
            return 1;
        }
        if(textDirectionHeuristic0 == TextDirectionHeuristics.ANYRTL_LTR) {
            return 2;
        }
        if(textDirectionHeuristic0 == TextDirectionHeuristics.LTR) {
            return 3;
        }
        if(textDirectionHeuristic0 == TextDirectionHeuristics.RTL) {
            return 4;
        }
        if(textDirectionHeuristic0 == TextDirectionHeuristics.LOCALE) {
            return 5;
        }
        if(textDirectionHeuristic0 == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
            return 6;
        }
        return textDirectionHeuristic0 == TextDirectionHeuristics.FIRSTSTRONG_RTL ? 7 : 1;
    }

    private static TextDirectionHeuristic d(TextView textView0) {
        boolean z = false;
        if(textView0.getTransformationMethod() instanceof PasswordTransformationMethod) {
            return TextDirectionHeuristics.LTR;
        }
        if(Build.VERSION.SDK_INT >= 28 && (textView0.getInputType() & 15) == 3) {
            switch(Character.getDirectionality(e.a(d.a(b.d(textView0)))[0].codePointAt(0))) {
                case 1: 
                case 2: {
                    return TextDirectionHeuristics.RTL;
                }
                default: {
                    return TextDirectionHeuristics.LTR;
                }
            }
        }
        if(b.b(textView0) == 1) {
            z = true;
        }
        switch(b.c(textView0)) {
            case 2: {
                return TextDirectionHeuristics.ANYRTL_LTR;
            }
            case 3: {
                return TextDirectionHeuristics.LTR;
            }
            case 4: {
                return TextDirectionHeuristics.RTL;
            }
            case 5: {
                return TextDirectionHeuristics.LOCALE;
            }
            case 6: {
                return TextDirectionHeuristics.FIRSTSTRONG_LTR;
            }
            case 7: {
                return TextDirectionHeuristics.FIRSTSTRONG_RTL;
            }
            default: {
                return z ? TextDirectionHeuristics.FIRSTSTRONG_RTL : TextDirectionHeuristics.FIRSTSTRONG_LTR;
            }
        }
    }

    public static o.l.a e(TextView textView0) {
        if(Build.VERSION.SDK_INT >= 28) {
            return new o.l.a(e.b(textView0));
        }
        o.l.a.a l$a$a0 = new o.l.a.a(new TextPaint(textView0.getPaint()));
        l$a$a0.b(c.a(textView0));
        l$a$a0.c(c.d(textView0));
        l$a$a0.d(g.d(textView0));
        return l$a$a0.a();
    }

    public static void f(TextView textView0, ColorStateList colorStateList0) {
        androidx.core.util.c.d(textView0);
        if(Build.VERSION.SDK_INT >= 24) {
            c.f(textView0, colorStateList0);
            return;
        }
        if(textView0 instanceof h) {
            ((h)textView0).setSupportCompoundDrawablesTintList(colorStateList0);
        }
    }

    public static void g(TextView textView0, PorterDuff.Mode porterDuff$Mode0) {
        androidx.core.util.c.d(textView0);
        if(Build.VERSION.SDK_INT >= 24) {
            c.g(textView0, porterDuff$Mode0);
            return;
        }
        if(textView0 instanceof h) {
            ((h)textView0).setSupportCompoundDrawablesTintMode(porterDuff$Mode0);
        }
    }

    public static void h(TextView textView0, int v) {
        androidx.core.util.c.b(v);
        if(Build.VERSION.SDK_INT >= 28) {
            e.c(textView0, v);
            return;
        }
        Paint.FontMetricsInt paint$FontMetricsInt0 = textView0.getPaint().getFontMetricsInt();
        int v1 = a.a(textView0) ? paint$FontMetricsInt0.top : paint$FontMetricsInt0.ascent;
        if(v > Math.abs(v1)) {
            textView0.setPadding(textView0.getPaddingLeft(), v + v1, textView0.getPaddingRight(), textView0.getPaddingBottom());
        }
    }

    public static void i(TextView textView0, int v) {
        androidx.core.util.c.b(v);
        Paint.FontMetricsInt paint$FontMetricsInt0 = textView0.getPaint().getFontMetricsInt();
        int v1 = a.a(textView0) ? paint$FontMetricsInt0.bottom : paint$FontMetricsInt0.descent;
        if(v > Math.abs(v1)) {
            textView0.setPadding(textView0.getPaddingLeft(), textView0.getPaddingTop(), textView0.getPaddingRight(), v - v1);
        }
    }

    public static void j(TextView textView0, int v) {
        androidx.core.util.c.b(v);
        int v1 = textView0.getPaint().getFontMetricsInt(null);
        if(v != v1) {
            textView0.setLineSpacing(((float)(v - v1)), 1.0f);
        }
    }

    public static void k(TextView textView0, l l0) {
        if(Build.VERSION.SDK_INT >= 29) {
            throw null;
        }
        g.e(textView0);
        throw null;
    }

    public static void l(TextView textView0, o.l.a l$a0) {
        b.h(textView0, g.c(l$a0.d()));
        textView0.getPaint().set(l$a0.e());
        c.e(textView0, l$a0.b());
        c.h(textView0, l$a0.c());
    }

    public static ActionMode.Callback m(ActionMode.Callback actionMode$Callback0) {
        return !(actionMode$Callback0 instanceof f) || Build.VERSION.SDK_INT < 26 ? actionMode$Callback0 : ((f)actionMode$Callback0).d();
    }

    public static ActionMode.Callback n(TextView textView0, ActionMode.Callback actionMode$Callback0) {
        return Build.VERSION.SDK_INT >= 26 && Build.VERSION.SDK_INT <= 27 && !(actionMode$Callback0 instanceof f) && actionMode$Callback0 != null ? new f(actionMode$Callback0, textView0) : actionMode$Callback0;
    }
}

