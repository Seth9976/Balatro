package q1;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import c2.m0;
import c2.r;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import n1.a;
import u1.b;

public abstract class e extends r implements f {
    public e() {
        super("com.google.android.gms.games.internal.IGamesCallbacks");
    }

    @Override  // c2.r
    protected final boolean a(int v, Parcel parcel0, Parcel parcel1, int v1) {
        switch(v) {
            case 5002: {
                DataHolder dataHolder0 = (DataHolder)m0.a(parcel0, DataHolder.CREATOR);
                m0.b(parcel0);
                this.Q(dataHolder0);
                break;
            }
            case 5003: {
                int v2 = parcel0.readInt();
                String s = parcel0.readString();
                m0.b(parcel0);
                this.N(v2, s);
                break;
            }
            case 5004: {
                DataHolder dataHolder1 = (DataHolder)m0.a(parcel0, DataHolder.CREATOR);
                m0.b(parcel0);
                this.K(dataHolder1);
                break;
            }
            case 5005: {
                DataHolder dataHolder2 = (DataHolder)m0.a(parcel0, DataHolder.CREATOR);
                DataHolder dataHolder3 = (DataHolder)m0.a(parcel0, DataHolder.CREATOR);
                m0.b(parcel0);
                this.U(dataHolder2, dataHolder3);
                break;
            }
            case 5006: {
                DataHolder dataHolder4 = (DataHolder)m0.a(parcel0, DataHolder.CREATOR);
                m0.b(parcel0);
                this.i(dataHolder4);
                break;
            }
            case 5007: {
                DataHolder dataHolder5 = (DataHolder)m0.a(parcel0, DataHolder.CREATOR);
                m0.b(parcel0);
                this.H(dataHolder5);
                break;
            }
            case 5008: {
                DataHolder dataHolder6 = (DataHolder)m0.a(parcel0, DataHolder.CREATOR);
                m0.b(parcel0);
                this.T(dataHolder6);
                break;
            }
            case 5016: {
                this.I();
                break;
            }
            case 5026: 
            case 5027: 
            case 5028: 
            case 5029: 
            case 5030: 
            case 5031: {
                DataHolder dataHolder8 = (DataHolder)m0.a(parcel0, DataHolder.CREATOR);
                parcel0.createStringArray();
                m0.b(parcel0);
                break;
            }
            case 5032: {
                b b0 = (b)m0.a(parcel0, b.CREATOR);
                m0.b(parcel0);
                break;
            }
            case 5033: {
                parcel0.readInt();
                parcel0.readInt();
                parcel0.readString();
                m0.b(parcel0);
                break;
            }
            case 5034: {
                parcel0.readInt();
                parcel0.readString();
                m0.e(parcel0);
                m0.b(parcel0);
                break;
            }
            case 8001: {
                DataHolder dataHolder9 = (DataHolder)m0.a(parcel0, DataHolder.CREATOR);
                m0.b(parcel0);
                this.s(dataHolder9);
                break;
            }
            case 5001: 
            case 5020: 
            case 8007: {
                parcel0.readInt();
                parcel0.readString();
                m0.b(parcel0);
                break;
            }
            case 12001: {
                DataHolder dataHolder10 = (DataHolder)m0.a(parcel0, DataHolder.CREATOR);
                m0.b(parcel0);
                this.R(dataHolder10);
                break;
            }
            case 12004: {
                DataHolder dataHolder11 = (DataHolder)m0.a(parcel0, DataHolder.CREATOR);
                a a0 = (a)m0.a(parcel0, a.CREATOR);
                m0.b(parcel0);
                this.y(dataHolder11, a0);
                break;
            }
            case 12005: {
                DataHolder dataHolder12 = (DataHolder)m0.a(parcel0, DataHolder.CREATOR);
                m0.b(parcel0);
                this.A(dataHolder12);
                break;
            }
            case 12011: {
                DataHolder dataHolder13 = (DataHolder)m0.a(parcel0, DataHolder.CREATOR);
                m0.b(parcel0);
                this.w(dataHolder13);
                break;
            }
            case 12012: {
                int v3 = parcel0.readInt();
                String s1 = parcel0.readString();
                m0.b(parcel0);
                this.J(v3, s1);
                break;
            }
            case 0x2EF1: {
                Parcelable parcelable0 = m0.a(parcel0, DataHolder.CREATOR);
                String s2 = parcel0.readString();
                Parcelable parcelable1 = m0.a(parcel0, a.CREATOR);
                Parcelable parcelable2 = m0.a(parcel0, a.CREATOR);
                Parcelable parcelable3 = m0.a(parcel0, a.CREATOR);
                m0.b(parcel0);
                this.z(((DataHolder)parcelable0), s2, ((a)parcelable1), ((a)parcelable2), ((a)parcelable3));
                break;
            }
            case 14001: {
                DataHolder[] arr_dataHolder = (DataHolder[])parcel0.createTypedArray(DataHolder.CREATOR);
                m0.b(parcel0);
                break;
            }
            case 15001: {
                DataHolder dataHolder14 = (DataHolder)m0.a(parcel0, DataHolder.CREATOR);
                m0.b(parcel0);
                this.O(dataHolder14);
                break;
            }
            case 19001: {
                parcel0.readInt();
                w1.a a1 = (w1.a)m0.a(parcel0, w1.a.CREATOR);
                m0.b(parcel0);
                break;
            }
            case 19002: {
                parcel0.readInt();
                m0.e(parcel0);
                m0.b(parcel0);
                break;
            }
            case 5009: 
            case 5010: 
            case 5011: 
            case 5017: 
            case 5018: 
            case 5019: 
            case 5021: 
            case 5022: 
            case 5023: 
            case 5024: 
            case 5025: 
            case 5035: 
            case 5037: 
            case 5038: 
            case 5039: 
            case 8003: 
            case 8004: 
            case 8005: 
            case 8006: 
            case 8008: 
            case 9001: 
            case 10001: 
            case 10003: 
            case 10004: 
            case 10006: 
            case 12006: 
            case 12007: 
            case 12008: 
            case 12014: 
            case 0x2EF0: 
            case 13001: 
            case 20001: 
            case 20002: 
            case 20003: 
            case 20004: 
            case 20005: 
            case 20006: 
            case 20007: 
            case 20008: 
            case 20009: {
                DataHolder dataHolder7 = (DataHolder)m0.a(parcel0, DataHolder.CREATOR);
                m0.b(parcel0);
                break;
            }
            case 8002: 
            case 10005: 
            case 11001: 
            case 0x2EEF: 
            case 20020: {
                parcel0.readInt();
                Bundle bundle0 = (Bundle)m0.a(parcel0, Bundle.CREATOR);
                m0.b(parcel0);
                break;
            }
            case 24002: {
                m0.e(parcel0);
                m0.b(parcel0);
                break;
            }
            case 6001: 
            case 6002: 
            case 8009: 
            case 8010: 
            case 10002: 
            case 25002: {
                parcel0.readString();
                m0.b(parcel0);
                break;
            }
            case 25003: {
                Status status1 = (Status)m0.a(parcel0, Status.CREATOR);
                String s3 = parcel0.readString();
                m0.b(parcel0);
                this.g(status1, s3);
                break;
            }
            case 20012: 
            case 25004: {
                Status status0 = (Status)m0.a(parcel0, Status.CREATOR);
                m0.b(parcel0);
                break;
            }
            case 25005: {
                parcel0.readInt();
                r1.f f0 = (r1.f)m0.a(parcel0, r1.f.CREATOR);
                m0.b(parcel0);
                break;
            }
            case 5036: 
            case 5040: 
            case 13002: 
            case 17002: 
            case 19008: 
            case 19009: 
            case 19010: 
            case 20019: 
            case 23001: 
            case 23002: 
            case 23003: 
            case 23004: 
            case 23005: 
            case 25006: {
                parcel0.readInt();
                m0.b(parcel0);
                break;
            }
            default: {
                return false;
            }
        }
        parcel1.writeNoException();
        return true;
    }
}

