package c1;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface;
import android.os.Bundle;
import g1.q;

public class b extends DialogFragment {
    private Dialog a;
    private DialogInterface.OnCancelListener b;
    private Dialog c;

    public static b a(Dialog dialog0, DialogInterface.OnCancelListener dialogInterface$OnCancelListener0) {
        b b0 = new b();
        Dialog dialog1 = (Dialog)q.j(dialog0, "Cannot display null dialog");
        dialog1.setOnCancelListener(null);
        dialog1.setOnDismissListener(null);
        b0.a = dialog1;
        if(dialogInterface$OnCancelListener0 != null) {
            b0.b = dialogInterface$OnCancelListener0;
        }
        return b0;
    }

    @Override  // android.app.DialogFragment
    public void onCancel(DialogInterface dialogInterface0) {
        DialogInterface.OnCancelListener dialogInterface$OnCancelListener0 = this.b;
        if(dialogInterface$OnCancelListener0 != null) {
            dialogInterface$OnCancelListener0.onCancel(dialogInterface0);
        }
    }

    @Override  // android.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle0) {
        Dialog dialog0 = this.a;
        if(dialog0 == null) {
            this.setShowsDialog(false);
            if(this.c == null) {
                this.c = new AlertDialog.Builder(((Context)q.i(this.getActivity()))).create();
            }
            return this.c;
        }
        return dialog0;
    }

    @Override  // android.app.DialogFragment
    public void show(FragmentManager fragmentManager0, String s) {
        super.show(fragmentManager0, s);
    }
}

