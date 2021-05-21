package com.example.dokterdiabetesforelderly;

import android.os.Parcel;
import android.os.Parcelable;

public class ModelArtikel implements Parcelable {
    private String judul;

    //untuk detail dari artikel
    private String detail;

    //untuk foto tampilan dari artikel
    private int photo;

    public ModelArtikel(){

    }

    protected ModelArtikel(Parcel in) {
        judul = in.readString();
        detail = in.readString();
        photo = in.readInt();
    }

    public static final Creator<ModelArtikel> CREATOR = new Creator<ModelArtikel>() {
        @Override
        public ModelArtikel createFromParcel(Parcel in) {
            return new ModelArtikel(in);
        }

        @Override
        public ModelArtikel[] newArray(int size) {
            return new ModelArtikel[size];
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

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(judul);
        dest.writeString(detail);
        dest.writeInt(photo);
    }
}
