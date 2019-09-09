package com.wzk.mvp.img_download;

import android.widget.ImageView;

import com.wzk.mvp.ImgDownLoadActivity;
import com.wzk.mvp.base.BasePresenter;
import com.wzk.mvp.bean.BaseEntity;

public class ImgDownLoadPresenter extends BasePresenter<ImgDownLoadActivity, ImgDownLoadModel, ImgDownloadContract.Present> {
  @Override
  public ImgDownloadContract.Present getContract() {
    return new ImgDownloadContract.Present() {
      @Override
      public void requestShowImage(String path, ImageView iv) {
        getModel().getContract().showImage(path, iv);
      }

      @Override
      public void responseShowImage(BaseEntity baseEntity) {
        getView().getContract().handlerResult(baseEntity);
      }
    };
  }

  @Override
  public ImgDownLoadModel getModel() {
    return new ImgDownLoadModel(this);
  }
}
