package com.example.dagermvpretrorxdemo;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dagermvpretrorxdemo.main.component.ApplicationComponent;
import com.example.dagermvpretrorxdemo.main.component.DaggerMainActivityComponent;
import com.example.dagermvpretrorxdemo.main.component.MainActivityComponent;
import com.example.dagermvpretrorxdemo.main.module.MainActivityContextModule;
import com.example.dagermvpretrorxdemo.main.module.MainActivityMvpModule;
import com.example.dagermvpretrorxdemo.main.qualifier.ActivityContext;
import com.example.dagermvpretrorxdemo.main.qualifier.ApplicationContext;
import com.example.dagermvpretrorxdemo.mvp.MainActivityContract;
import com.example.dagermvpretrorxdemo.mvp.PresenterImpl;
import com.example.dagermvpretrorxdemo.pojo.CryptoData;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View, RecyclerViewAdapter.ClickListener {

  private RecyclerView recyclerView;
  private ProgressBar progressBar;
  MainActivityComponent mainActivityComponent;

  @Inject
  public RecyclerViewAdapter recyclerViewAdapter;

  @Inject
  @ApplicationContext
  public Context mContext;

  @Inject
  @ActivityContext
  public Context activityContext;

  @Inject
  PresenterImpl presenter;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);


    ApplicationComponent applicationComponent = MyApplication.get(this).getApplicationComponent();
    mainActivityComponent = DaggerMainActivityComponent.builder()
            .mainActivityContextModule(new MainActivityContextModule(this))
            .mainActivityMvpModule(new MainActivityMvpModule(this))
            .applicationComponent(applicationComponent)
            .build();

    mainActivityComponent.injectMainActivity(this);

    recyclerView = findViewById(R.id.recyclerView);
    recyclerView.setLayoutManager(new LinearLayoutManager(activityContext));
    recyclerView.setAdapter(recyclerViewAdapter);
    progressBar = findViewById(R.id.progressBar);

    presenter.loadData();


  }

  @Override
  public void launchIntent(String name) {
    Toast.makeText(mContext, name, Toast.LENGTH_SHORT).show();
    // startActivity(new Intent(activityContext, DetailActivity.class).putExtra("name", name));
  }

  @Override
  public void showData(List<CryptoData> data) {
    recyclerViewAdapter.setData(data);
  }

  @Override
  public void showError(String message) {
    Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
  }

  @Override
  public void showComplete() {

  }

  @Override
  public void showProgress() {
    progressBar.setVisibility(View.VISIBLE);
  }

  @Override
  public void hideProgress() {
    progressBar.setVisibility(View.GONE);
  }
}
