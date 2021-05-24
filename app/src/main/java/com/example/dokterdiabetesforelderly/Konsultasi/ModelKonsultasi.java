package com.example.dokterdiabetesforelderly.Konsultasi;

import android.os.Parcel;
import android.os.Parcelable;

public class ModelKonsultasi implements Parcelable {
    private String id;
    private String judul;
    private String detail;
    private String jawaban;
    private int photo;

    //constructor
    public ModelKonsultasi(){

    }

    protected ModelKonsultasi(Parcel in) {
        id = in.readString();
        judul = in.readString();
        detail = in.readString();
        jawaban = in.readString();
        photo = in.readInt();
    }

    public static final Creator<ModelKonsultasi> CREATOR = new Creator<ModelKonsultasi>() {
        @Override
        public ModelKonsultasi createFromParcel(Parcel in) {
            return new ModelKonsultasi(in);
        }

        @Override
        public ModelKonsultasi[] newArray(int size) {
            return new ModelKonsultasi[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getJawaban() {
        return jawaban;
    }

    public void setJawaban(String jawaban) {
        this.jawaban = jawaban;
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
        dest.writeString(id);
        dest.writeString(judul);
        dest.writeString(detail);
        dest.writeString(jawaban);
        dest.writeInt(photo);
    }
}
