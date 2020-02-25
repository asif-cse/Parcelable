package com.example.parcelable;

import android.os.Parcel;
import android.os.Parcelable;

class Student implements Parcelable {

    private String name;
    private Long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public static Creator<Student> getCREATOR() {
        return CREATOR;
    }

    private String grade;

    public Student(String name, Long id, String grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    protected Student(Parcel in) {
        name = in.readString();
        id = in.readLong();
        grade = in.readString();
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(this.name);
        dest.writeLong(this.id);
        dest.writeString(this.grade);
    }
}
