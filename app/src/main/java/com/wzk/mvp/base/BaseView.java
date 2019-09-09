package com.wzk.mvp.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseView<P extends BasePresenter, CONTRACT> extends AppCompatActivity {
  P p;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    p = getP();
    p.bindView(this);
  }

  public abstract P getP();

  public abstract CONTRACT getContract();

  public void error(Exception e) {
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    p.unBindView();
  }
}
