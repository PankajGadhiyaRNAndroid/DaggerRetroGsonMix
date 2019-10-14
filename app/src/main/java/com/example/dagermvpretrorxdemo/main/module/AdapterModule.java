package com.example.dagermvpretrorxdemo.main.module;


import com.example.dagermvpretrorxdemo.MainActivity;
import com.example.dagermvpretrorxdemo.RecyclerViewAdapter;
import com.example.dagermvpretrorxdemo.main.scopes.ActivityScope;

import dagger.Module;
import dagger.Provides;

@Module(includes = {MainActivityContextModule.class})
public class AdapterModule {

  @Provides
  @ActivityScope
  public RecyclerViewAdapter getCoinList(RecyclerViewAdapter.ClickListener clickListener) {
    return new RecyclerViewAdapter(clickListener);
  }

  @Provides
  @ActivityScope
  public RecyclerViewAdapter.ClickListener getClickListener(MainActivity mainActivity) {
    return mainActivity;
  }
}
