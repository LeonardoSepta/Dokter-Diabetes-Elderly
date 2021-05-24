package com.example.dokterdiabetesforelderly.Pesan;

import android.os.Parcel;
import android.os.Parcelable;

public class ModelPesan implements Parcelable {
    private String judul;

    //untuk detail dari artikel
    private String detail;

    public ModelPesan() {

    }

    protected ModelPesan(Parcel in) {
        judul = in.readString();
        detail = in.readString();
    }

    public static final Creator<ModelPesan> CREATOR = new Creator<ModelPesan>() {
        @Override
        public ModelPesan createFromParcel(Parcel in) {
            return new ModelPesan(in);
        }

        @Override
        public ModelPesan[] newArray(int size) {
            return new ModelPesan[size];
        }
    };

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(judul);
        dest.writeString(detail);
    }
}
