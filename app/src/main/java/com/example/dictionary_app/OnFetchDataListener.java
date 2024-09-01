package com.example.dictionary_app;

import com.example.dictionary_app.Models.APIResponse;

import java.util.List;

public interface OnFetchDataListener
{
    void OnFetchData(APIResponse apiResponse , String message);
    void OnError(String message);
}
