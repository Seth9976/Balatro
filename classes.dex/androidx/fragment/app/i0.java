package androidx.fragment.app;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.os.b;
import androidx.core.view.t;
import androidx.core.view.v;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class i0 {
    public abstract void a(Object arg1, View arg2);

    public abstract void b(Object arg1, ArrayList arg2);

    public abstract void c(ViewGroup arg1, Object arg2);

    protected static void d(List list0, View view0) {
        int v = list0.size();
        if(i0.g(list0, view0, v)) {
            return;
        }
        if(v.s(view0) != null) {
            list0.add(view0);
        }
        for(int v1 = v; v1 < list0.size(); ++v1) {
            View view1 = (View)list0.get(v1);
            if(view1 instanceof ViewGroup) {
                ViewGroup viewGroup0 = (ViewGroup)view1;
                int v2 = viewGroup0.getChildCount();
                for(int v3 = 0; v3 < v2; ++v3) {
                    View view2 = viewGroup0.getChildAt(v3);
                    if(!i0.g(list0, view2, v) && v.s(view2) != null) {
                        list0.add(view2);
                    }
                }
            }
        }
    }

    public abstract boolean e(Object arg1);

    public abstract Object f(Object arg1);

    private static boolean g(List list0, View view0, int v) {
        for(int v1 = 0; v1 < v; ++v1) {
            if(list0.get(v1) == view0) {
                return true;
            }
        }
        return false;
    }

    protected void h(View view0, Rect rect0) {
        if(!v.v(view0)) {
            return;
        }
        RectF rectF0 = new RectF();
        rectF0.set(0.0f, 0.0f, ((float)view0.getWidth()), ((float)view0.getHeight()));
        view0.getMatrix().mapRect(rectF0);
        rectF0.offset(((float)view0.getLeft()), ((float)view0.getTop()));
        for(ViewParent viewParent0 = view0.getParent(); viewParent0 instanceof View; viewParent0 = ((View)viewParent0).getParent()) {
            rectF0.offset(((float)(-((View)viewParent0).getScrollX())), ((float)(-((View)viewParent0).getScrollY())));
            ((View)viewParent0).getMatrix().mapRect(rectF0);
            rectF0.offset(((float)((View)viewParent0).getLeft()), ((float)((View)viewParent0).getTop()));
        }
        int[] arr_v = new int[2];
        view0.getRootView().getLocationOnScreen(arr_v);
        rectF0.offset(((float)arr_v[0]), ((float)arr_v[1]));
        rect0.set(Math.round(rectF0.left), Math.round(rectF0.top), Math.round(rectF0.right), Math.round(rectF0.bottom));
    }

    protected static boolean i(List list0) {
        return list0 == null || list0.isEmpty();
    }

    public abstract Object j(Object arg1, Object arg2, Object arg3);

    public abstract Object k(Object arg1, Object arg2, Object arg3);

    ArrayList l(ArrayList arrayList0) {
        ArrayList arrayList1 = new ArrayList();
        int v = arrayList0.size();
        for(int v1 = 0; v1 < v; ++v1) {
            View view0 = (View)arrayList0.get(v1);
            arrayList1.add(v.s(view0));
            v.N(view0, null);
        }
        return arrayList1;
    }

    public abstract void m(Object arg1, View arg2, ArrayList arg3);

    public abstract void n(Object arg1, Object arg2, ArrayList arg3, Object arg4, ArrayList arg5, Object arg6, ArrayList arg7);

    public abstract void o(Object arg1, Rect arg2);

    public abstract void p(Object arg1, View arg2);

    public abstract void q(Fragment arg1, Object arg2, b arg3, Runnable arg4);

    void r(View view0, ArrayList arrayList0, ArrayList arrayList1, ArrayList arrayList2, Map map0) {
        class a implements Runnable {
            final int e;
            final ArrayList f;
            final ArrayList g;
            final ArrayList h;
            final ArrayList i;
            final i0 j;

            a(int v, ArrayList arrayList0, ArrayList arrayList1, ArrayList arrayList2, ArrayList arrayList3) {
                this.e = v;
                this.f = arrayList0;
                this.g = arrayList1;
                this.h = arrayList2;
                this.i = arrayList3;
                super();
            }

            @Override
            public void run() {
                for(int v = 0; v < this.e; ++v) {
                    v.N(((View)this.f.get(v)), ((String)this.g.get(v)));
                    v.N(((View)this.h.get(v)), ((String)this.i.get(v)));
                }
            }
        }

        int v = arrayList1.size();
        ArrayList arrayList3 = new ArrayList();
        for(int v1 = 0; v1 < v; ++v1) {
            View view1 = (View)arrayList0.get(v1);
            String s = v.s(view1);
            arrayList3.add(s);
            if(s != null) {
                v.N(view1, null);
                String s1 = (String)map0.get(s);
                for(int v2 = 0; v2 < v; ++v2) {
                    if(s1.equals(arrayList2.get(v2))) {
                        v.N(((View)arrayList1.get(v2)), s);
                        break;
                    }
                }
            }
        }
        t.a(view0, new a(this, v, arrayList1, arrayList2, arrayList0, arrayList3));
    }

    public abstract void s(Object arg1, View arg2, ArrayList arg3);

    public abstract void t(Object arg1, ArrayList arg2, ArrayList arg3);

    public abstract Object u(Object arg1);
}

