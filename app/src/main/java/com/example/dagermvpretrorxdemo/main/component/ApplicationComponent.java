package com.example.dagermvpretrorxdemo.main.component;

import android.content.Context;


import com.example.dagermvpretrorxdemo.MyApplication;
import com.example.dagermvpretrorxdemo.main.module.ContextModule;
import com.example.dagermvpretrorxdemo.main.module.RetrofitModule;
import com.example.dagermvpretrorxdemo.main.qualifier.ApplicationContext;
import com.example.dagermvpretrorxdemo.main.scopes.ApplicationScope;
import com.example.dagermvpretrorxdemo.retrofit.APIInterface;

import dagger.Component;

@ApplicationScope
@Component(modules = {ContextModule.class, RetrofitModule.class})
public interface ApplicationComponent {

  APIInterface getApiInterface();

  @ApplicationContext
  Context getContext();

  void injectApplication(MyApplication myApplication);
}
