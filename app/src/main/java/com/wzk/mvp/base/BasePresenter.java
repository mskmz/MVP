package com.wzk.mvp.base;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<V extends BaseView, M extends BaseModel, CONTRACT> {
  private WeakReference<V> vWeakReference;

  M m;

  public BasePresenter() {
    m = getModel();
  }

  public abstract CONTRACT getContract();

  public abstract M getModel();

  public V getView() {
    if (vWeakReference != null) {
      return vWeakReference.get();
    }
    return null;
  }

  public void bindView(V v) {
    vWeakReference = new WeakReference<>(v);
  }

  public void unBindView() {
    if (vWeakReference != null) {
      vWeakReference.clear();
      vWeakReference = null;
      System.gc();
    }
  }
}

