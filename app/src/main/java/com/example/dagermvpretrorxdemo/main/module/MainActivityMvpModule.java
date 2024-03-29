package com.example.dagermvpretrorxdemo.main.module;


import com.example.dagermvpretrorxdemo.main.scopes.ActivityScope;
import com.example.dagermvpretrorxdemo.mvp.MainActivityContract;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityMvpModule {
  private final MainActivityContract.View mView;


  public MainActivityMvpModule(MainActivityContract.View mView) {
    this.mView = mView;
  }

  @Provides
  @ActivityScope
  MainActivityContract.View provideView() {
    return mView;
  }


}
