package com.movieapp.movieapp.models;

import com.movieapp.movieapp.BR;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class UsersModel extends BaseObservable {

    private String username;
    private String password;
    private int response;

    public int getResponse() {
        return response;
    }

    public void setResponse(int response) {
        this.response = response;
    }

    @Bindable
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        notifyPropertyChanged(BR.username);
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }
}
