package com.example.a48hours.ui.gallery;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ClockViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ClockViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Clock in fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}