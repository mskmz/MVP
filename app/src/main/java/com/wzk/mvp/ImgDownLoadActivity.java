package com.wzk.mvp;


import android.os.Bundle;
import android.widget.ImageView;

import com.wzk.mvp.base.BaseView;
import com.wzk.mvp.bean.BaseEntity;
import com.wzk.mvp.img_download.ImgDownLoadPresenter;
import com.wzk.mvp.img_download.ImgDownloadContract;


public class ImgDownLoadActivity extends BaseView<ImgDownLoadPresenter, ImgDownloadContract.View> {
  private static final String path = "https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=1950314936,3309356447&fm=58&bpow=300&bpoh=300";
  private ImageView imgIv;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    imgIv = findViewById(R.id.iv_img);
    getP().getContract().requestShowImage(path, imgIv);
  }

  @Override
  public ImgDownLoadPresenter getP() {
    return new ImgDownLoadPresenter();
  }

  @Override
  public ImgDownloadContract.View getContract() {
    return new ImgDownloadContract.View() {
      @Override
      public void handlerResult(BaseEntity baseEntity) {

      }
    };
  }

}
