package c1;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.e;
import androidx.fragment.app.x;
import g1.q;

public class o extends e {
    private Dialog t0;
    private DialogInterface.OnCancelListener u0;
    private Dialog v0;

    @Override  // androidx.fragment.app.e
    public Dialog G1(Bundle bundle0) {
        Dialog dialog0 = this.t0;
        if(dialog0 == null) {
            this.K1(false);
            if(this.v0 == null) {
                this.v0 = new AlertDialog.Builder(((Context)q.i(this.t()))).create();
            }
            return this.v0;
        }
        return dialog0;
    }

    @Override  // androidx.fragment.app.e
    public void M1(x x0, String s) {
        super.M1(x0, s);
    }

    public static o N1(Dialog dialog0, DialogInterface.OnCancelListener dialogInterface$OnCancelListener0) {
        o o0 = new o();
        Dialog dialog1 = (Dialog)q.j(dialog0, "Cannot display null dialog");
        dialog1.setOnCancelListener(null);
        dialog1.setOnDismissListener(null);
        o0.t0 = dialog1;
        if(dialogInterface$OnCancelListener0 != null) {
            o0.u0 = dialogInterface$OnCancelListener0;
        }
        return o0;
    }

    @Override  // androidx.fragment.app.e
    public void onCancel(DialogInterface dialogInterface0) {
        DialogInterface.OnCancelListener dialogInterface$OnCancelListener0 = this.u0;
        if(dialogInterface$OnCancelListener0 != null) {
            dialogInterface$OnCancelListener0.onCancel(dialogInterface0);
        }
    }
}

