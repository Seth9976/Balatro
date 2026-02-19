package g1;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import e1.f;

public abstract class d0 implements DialogInterface.OnClickListener {
    protected abstract void a();

    public static d0 b(Activity activity0, Intent intent0, int v) {
        return new b0(intent0, activity0, v);
    }

    public static d0 c(f f0, Intent intent0, int v) {
        return new c0(intent0, f0, 2);
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public final void onClick(DialogInterface dialogInterface0, int v) {
        try {
            this.a();
        }
        catch(ActivityNotFoundException activityNotFoundException0) {
            Log.e("DialogRedirect", "Failed to start resolution intent.", activityNotFoundException0);
        }
        finally {
            dialogInterface0.dismiss();
        }
    }
}

