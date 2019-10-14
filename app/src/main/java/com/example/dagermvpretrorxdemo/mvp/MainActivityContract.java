package com.example.dagermvpretrorxdemo.mvp;

import com.example.dagermvpretrorxdemo.pojo.CryptoData;

import java.util.List;

public interface MainActivityContract {

  interface View {
    void showData(List<CryptoData> data);

    void showError(String message);

    void showComplete();

    void showProgress();

    void hideProgress();
  }

  interface Presenter {
    void loadData();
  }

}
