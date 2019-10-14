package com.example.dagermvpretrorxdemo.main.module;

import android.content.Context;

import com.example.dagermvpretrorxdemo.main.qualifier.ApplicationContext;
import com.example.dagermvpretrorxdemo.main.scopes.ApplicationScope;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {
  private Context context;

  public ContextModule(Context context) {
    this.context = context;
  }

  @Provides
  @ApplicationScope
  @ApplicationContext
  public Context provideContext() {
    return context;
  }
}
