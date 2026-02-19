package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import p1.d;
import p1.e0;

public final class a extends e0 implements d {
    public a(DataHolder dataHolder0, int v) {
        super(dataHolder0, v);
    }

    @Override  // p1.d
    public final String B() {
        return this.C("external_game_id");
    }

    @Override  // p1.d
    public final boolean I() {
        return this.x("gamepad_support") > 0;
    }

    @Override  // p1.d
    public final String L() {
        return this.C("primary_category");
    }

    @Override  // p1.d
    public final String S() {
        return this.C("theme_color");
    }

    @Override  // p1.d
    public final String a() {
        return this.C("package_name");
    }

    @Override  // p1.d
    public final boolean b() {
        return this.o("identity_sharing_confirmed");
    }

    @Override  // p1.d
    public final boolean c() {
        return this.x("installed") > 0;
    }

    // 去混淆评级： 低(20)
    @Override  // p1.d
    public final boolean d() {
        return !this.H("profileless_recall_enabled_v3") || this.K("profileless_recall_enabled_v3") ? false : this.o("profileless_recall_enabled_v3");
    }

    @Override  // p1.d
    public final Uri d0() {
        return this.U("featured_image_uri");
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override  // p1.d
    public final boolean e() {
        return this.o("muted");
    }

    @Override  // p1.d
    public final boolean e0() {
        return this.x("snapshots_enabled") > 0;
    }

    @Override
    public final boolean equals(Object object0) {
        return GameEntity.s0(this, object0);
    }

    @Override  // p1.d
    public final boolean f() {
        return this.o("play_enabled_game");
    }

    @Override  // p1.d
    public final boolean g() {
        return this.x("turn_based_support") > 0;
    }

    @Override  // p1.d
    public String getFeaturedImageUrl() {
        return this.C("featured_image_url");
    }

    @Override  // p1.d
    public String getHiResImageUrl() {
        return this.C("game_hi_res_image_url");
    }

    @Override  // p1.d
    public String getIconImageUrl() {
        return this.C("game_icon_image_url");
    }

    @Override  // p1.d
    public final boolean h() {
        return this.x("real_time_support") > 0;
    }

    @Override
    public final int hashCode() {
        return GameEntity.n0(this);
    }

    @Override  // p1.d
    public final String i() {
        return this.C("game_description");
    }

    @Override  // p1.d
    public final Uri j() {
        return this.U("game_hi_res_image_uri");
    }

    @Override  // p1.d
    public final String k() {
        return this.C("display_name");
    }

    @Override  // p1.d
    public final Uri l() {
        return this.U("game_icon_image_uri");
    }

    @Override  // p1.d
    public final String m() {
        return this.C("developer_name");
    }

    @Override  // p1.d
    public final int q() {
        return this.x("leaderboard_count");
    }

    @Override
    public final String toString() {
        return GameEntity.p0(this);
    }

    @Override  // p1.d
    public final int v() {
        return this.x("achievement_total_count");
    }

    @Override  // p1.d
    public final String w() {
        return this.C("secondary_category");
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        new GameEntity(this).writeToParcel(parcel0, v);
    }
}

