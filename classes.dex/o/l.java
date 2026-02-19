package o;

import android.os.Build.VERSION;
import android.os.LocaleList;
import android.text.PrecomputedText.Params;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;

public abstract class l implements Spannable {
    public static final class a {
        public static class o.l.a.a {
            private final TextPaint a;
            private TextDirectionHeuristic b;
            private int c;
            private int d;

            public o.l.a.a(TextPaint textPaint0) {
                this.a = textPaint0;
                this.c = 1;
                this.d = 1;
                this.b = TextDirectionHeuristics.FIRSTSTRONG_LTR;
            }

            public a a() {
                return new a(this.a, this.b, this.c, this.d);
            }

            public o.l.a.a b(int v) {
                this.c = v;
                return this;
            }

            public o.l.a.a c(int v) {
                this.d = v;
                return this;
            }

            public o.l.a.a d(TextDirectionHeuristic textDirectionHeuristic0) {
                this.b = textDirectionHeuristic0;
                return this;
            }
        }

        private final TextPaint a;
        private final TextDirectionHeuristic b;
        private final int c;
        private final int d;
        final PrecomputedText.Params e;

        public a(PrecomputedText.Params precomputedText$Params0) {
            this.a = precomputedText$Params0.getTextPaint();
            this.b = precomputedText$Params0.getTextDirection();
            this.c = precomputedText$Params0.getBreakStrategy();
            this.d = precomputedText$Params0.getHyphenationFrequency();
            if(Build.VERSION.SDK_INT < 29) {
                precomputedText$Params0 = null;
            }
            this.e = precomputedText$Params0;
        }

        a(TextPaint textPaint0, TextDirectionHeuristic textDirectionHeuristic0, int v, int v1) {
            this.e = Build.VERSION.SDK_INT < 29 ? null : b.a(textPaint0).setBreakStrategy(v).setHyphenationFrequency(v1).setTextDirection(textDirectionHeuristic0).build();
            this.a = textPaint0;
            this.b = textDirectionHeuristic0;
            this.c = v;
            this.d = v1;
        }

        public boolean a(a l$a0) {
            int v = Build.VERSION.SDK_INT;
            if(this.c != l$a0.b()) {
                return false;
            }
            if(this.d != l$a0.c()) {
                return false;
            }
            if(this.a.getTextSize() != l$a0.e().getTextSize()) {
                return false;
            }
            if(this.a.getTextScaleX() != l$a0.e().getTextScaleX()) {
                return false;
            }
            if(this.a.getTextSkewX() != l$a0.e().getTextSkewX()) {
                return false;
            }
            if(this.a.getLetterSpacing() != l$a0.e().getLetterSpacing()) {
                return false;
            }
            if(!TextUtils.equals(this.a.getFontFeatureSettings(), l$a0.e().getFontFeatureSettings())) {
                return false;
            }
            if(this.a.getFlags() != l$a0.e().getFlags()) {
                return false;
            }
            if(v >= 24) {
                if(!this.a.getTextLocales().equals(l$a0.e().getTextLocales())) {
                    return false;
                }
            }
            else if(!this.a.getTextLocale().equals(l$a0.e().getTextLocale())) {
                return false;
            }
            return this.a.getTypeface() == null ? l$a0.e().getTypeface() == null : this.a.getTypeface().equals(l$a0.e().getTypeface());
        }

        public int b() {
            return this.c;
        }

        public int c() {
            return this.d;
        }

        public TextDirectionHeuristic d() {
            return this.b;
        }

        public TextPaint e() {
            return this.a;
        }

        @Override
        public boolean equals(Object object0) {
            if(object0 == this) {
                return true;
            }
            if(!(object0 instanceof a)) {
                return false;
            }
            return this.a(((a)object0)) ? this.b == ((a)object0).d() : false;
        }

        @Override
        public int hashCode() {
            return Build.VERSION.SDK_INT < 24 ? androidx.core.util.b.b(new Object[]{this.a.getTextSize(), this.a.getTextScaleX(), this.a.getTextSkewX(), this.a.getLetterSpacing(), this.a.getFlags(), this.a.getTextLocale(), this.a.getTypeface(), Boolean.valueOf(this.a.isElegantTextHeight()), this.b, this.c, this.d}) : androidx.core.util.b.b(new Object[]{this.a.getTextSize(), this.a.getTextScaleX(), this.a.getTextSkewX(), this.a.getLetterSpacing(), this.a.getFlags(), this.a.getTextLocales(), this.a.getTypeface(), Boolean.valueOf(this.a.isElegantTextHeight()), this.b, this.c, this.d});
        }

        @Override
        public String toString() {
            LocaleList localeList0;
            StringBuilder stringBuilder1;
            StringBuilder stringBuilder0 = new StringBuilder("{");
            stringBuilder0.append("textSize=" + this.a.getTextSize());
            stringBuilder0.append(", textScaleX=" + this.a.getTextScaleX());
            stringBuilder0.append(", textSkewX=" + this.a.getTextSkewX());
            int v = Build.VERSION.SDK_INT;
            stringBuilder0.append(", letterSpacing=" + this.a.getLetterSpacing());
            stringBuilder0.append(", elegantTextHeight=" + this.a.isElegantTextHeight());
            if(v >= 24) {
                stringBuilder1 = new StringBuilder();
                stringBuilder1.append(", textLocale=");
                localeList0 = this.a.getTextLocales();
            }
            else {
                stringBuilder1 = new StringBuilder();
                stringBuilder1.append(", textLocale=");
                localeList0 = this.a.getTextLocale();
            }
            stringBuilder1.append(localeList0);
            stringBuilder0.append(stringBuilder1.toString());
            stringBuilder0.append(", typeface=" + this.a.getTypeface());
            if(v >= 26) {
                stringBuilder0.append(", variationSettings=" + this.a.getFontVariationSettings());
            }
            stringBuilder0.append(", textDir=" + this.b);
            stringBuilder0.append(", breakStrategy=" + this.c);
            stringBuilder0.append(", hyphenationFrequency=" + this.d);
            stringBuilder0.append("}");
            return stringBuilder0.toString();
        }
    }

}

