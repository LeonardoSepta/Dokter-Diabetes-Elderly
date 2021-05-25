package com.example.dokterdiabetesforelderly.Resep;

import android.os.Parcel;
import android.os.Parcelable;

public class ModelResep implements Parcelable {
    private String judul;
    private String detail;
    private int img;

    public ModelResep(){

    }

    protected ModelResep(Parcel in) {
        judul = in.readString();
        detail = in.readString();
        img = in.readInt();
    }

    public static final Creator<ModelResep> CREATOR = new Creator<ModelResep>() {
        @Override
        public ModelResep createFromParcel(Parcel in) {
            return new ModelResep(in);
        }

        @Override
        public ModelResep[] newArray(int size) {
            return new ModelResep[size];
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

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(judul);
        dest.writeString(detail);
        dest.writeInt(img);
    }
}
