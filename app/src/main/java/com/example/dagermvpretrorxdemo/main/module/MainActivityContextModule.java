package com.example.dagermvpretrorxdemo.main.module;

import android.content.Context;


import com.example.dagermvpretrorxdemo.MainActivity;
import com.example.dagermvpretrorxdemo.main.qualifier.ActivityContext;
import com.example.dagermvpretrorxdemo.main.scopes.ActivityScope;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityContextModule {
  private MainActivity mainActivity;

  public Context context;

  public MainActivityContextModule(MainActivity mainActivity) {
    this.mainActivity = mainActivity;
    context = mainActivity;
  }

  @Provides
  @ActivityScope
  public MainActivity providesMainActivity() {
    return mainActivity;
  }

  @Provides
  @ActivityScope
  @ActivityContext
  public Context provideContext() {
    return context;
  }

}
