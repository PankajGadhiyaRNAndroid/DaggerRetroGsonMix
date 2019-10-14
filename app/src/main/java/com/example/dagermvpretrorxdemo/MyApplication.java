package com.example.dagermvpretrorxdemo;


import android.app.Activity;
import android.app.Application;
import android.content.Context;

import androidx.multidex.MultiDex;

import com.example.dagermvpretrorxdemo.main.component.ApplicationComponent;
import com.example.dagermvpretrorxdemo.main.component.DaggerApplicationComponent;
import com.example.dagermvpretrorxdemo.main.module.ContextModule;


public class MyApplication extends Application {

  ApplicationComponent applicationComponent;

  @Override
  public void onCreate() {
    super.onCreate();

    applicationComponent = DaggerApplicationComponent.builder().contextModule(new ContextModule(this)).build();
    applicationComponent.injectApplication(this);

  }

  @Override
  protected void attachBaseContext(Context base) {
    super.attachBaseContext(base);
    MultiDex.install(this);
  }

  public static MyApplication get(Activity activity){
    return (MyApplication) activity.getApplication();
  }

  public ApplicationComponent getApplicationComponent() {
    return applicationComponent;
  }
}
