package com.wzk.mvp.img_download;

import android.widget.ImageView;

import com.wzk.mvp.bean.BaseEntity;

public interface ImgDownloadContract {
  public interface View<T extends BaseEntity> {
    void handlerResult(T t);
  }

  interface Model {
    void showImage(String http, ImageView iv);
  }

  interface Present<T extends BaseEntity> {
    void requestShowImage(String path, ImageView iv);

    void responseShowImage(T t);
  }
}
