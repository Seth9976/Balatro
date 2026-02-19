package androidx.core.widget;

import android.widget.ListView;

public abstract class e {
    static abstract class a {
        static boolean a(ListView listView0, int v) {
            return listView0.canScrollList(v);
        }

        static void b(ListView listView0, int v) {
            listView0.scrollListBy(v);
        }
    }

    public static void a(ListView listView0, int v) {
        a.b(listView0, v);
    }
}

