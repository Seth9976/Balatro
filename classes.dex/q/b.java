package q;

import android.database.Cursor;
import android.widget.Filter.FilterResults;
import android.widget.Filter;

class b extends Filter {
    interface a {
        CharSequence a(Cursor arg1);

        void b(Cursor arg1);

        Cursor c();

        Cursor d(CharSequence arg1);
    }

    a a;

    b(a b$a0) {
        this.a = b$a0;
    }

    @Override  // android.widget.Filter
    public CharSequence convertResultToString(Object object0) {
        return this.a.a(((Cursor)object0));
    }

    @Override  // android.widget.Filter
    protected Filter.FilterResults performFiltering(CharSequence charSequence0) {
        Cursor cursor0 = this.a.d(charSequence0);
        Filter.FilterResults filter$FilterResults0 = new Filter.FilterResults();
        if(cursor0 == null) {
            filter$FilterResults0.count = 0;
            cursor0 = null;
        }
        else {
            filter$FilterResults0.count = cursor0.getCount();
        }
        filter$FilterResults0.values = cursor0;
        return filter$FilterResults0;
    }

    @Override  // android.widget.Filter
    protected void publishResults(CharSequence charSequence0, Filter.FilterResults filter$FilterResults0) {
        Cursor cursor0 = this.a.c();
        Object object0 = filter$FilterResults0.values;
        if(object0 != null && object0 != cursor0) {
            this.a.b(((Cursor)object0));
        }
    }
}

