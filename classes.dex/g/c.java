package g;

import android.content.res.Resources.Theme;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

public abstract class c {
    public static Drawable a(Resources resources0, XmlPullParser xmlPullParser0, AttributeSet attributeSet0, Resources.Theme resources$Theme0) {
        return Drawable.createFromXmlInner(resources0, xmlPullParser0, attributeSet0, resources$Theme0);
    }

    public static int b(TypedArray typedArray0) {
        return typedArray0.getChangingConfigurations();
    }

    public static void c(Drawable drawable0, Resources resources0, XmlPullParser xmlPullParser0, AttributeSet attributeSet0, Resources.Theme resources$Theme0) {
        drawable0.inflate(resources0, xmlPullParser0, attributeSet0, resources$Theme0);
    }
}

