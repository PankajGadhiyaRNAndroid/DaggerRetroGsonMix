package com.example.dagermvpretrorxdemo.main.component;

import android.content.Context;


import com.example.dagermvpretrorxdemo.MainActivity;
import com.example.dagermvpretrorxdemo.main.module.AdapterModule;
import com.example.dagermvpretrorxdemo.main.module.MainActivityMvpModule;
import com.example.dagermvpretrorxdemo.main.qualifier.ActivityContext;
import com.example.dagermvpretrorxdemo.main.scopes.ActivityScope;

import dagger.Component;


@ActivityScope
@Component(modules = {AdapterModule.class, MainActivityMvpModule.class}, dependencies = ApplicationComponent.class)
public interface MainActivityComponent {

  @ActivityContext
  Context getContext();
  void injectMainActivity(MainActivity mainActivity);
}
