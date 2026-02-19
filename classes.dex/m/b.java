package m;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.view.MenuItem;

public interface b extends MenuItem {
    @Override  // android.view.MenuItem
    MenuItem setAlphabeticShortcut(char arg1, int arg2);

    b setContentDescription(CharSequence arg1);

    @Override  // android.view.MenuItem
    MenuItem setIconTintList(ColorStateList arg1);

    @Override  // android.view.MenuItem
    MenuItem setIconTintMode(PorterDuff.Mode arg1);

    @Override  // android.view.MenuItem
    MenuItem setNumericShortcut(char arg1, int arg2);

    b setTooltipText(CharSequence arg1);
}

