package com.wzk.mvp.img_download;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import com.wzk.mvp.base.BaseModel;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ImgDownLoadModel extends BaseModel<ImgDownLoadPresenter, ImgDownloadContract.Model> {


  public ImgDownLoadModel(ImgDownLoadPresenter imgDownLoadPresenter) {
    super(imgDownLoadPresenter);
  }

  @Override
  public ImgDownloadContract.Model getContract() {
    return new ImgDownloadContract.Model() {
      @Override
      public void showImage(String path, ImageView iv) {
        InputStream in = null;
        try {
          URL url = new URL(path);
          HttpURLConnection conn = (HttpURLConnection) url.openConnection();
          conn.setRequestMethod("GET");
          conn.setConnectTimeout(5000);
          in = conn.getInputStream();
          Bitmap bitmap = BitmapFactory.decodeStream(in);
          iv.setImageBitmap(bitmap);
        } catch (MalformedURLException e) {
          e.printStackTrace();
        } catch (IOException e) {
          e.printStackTrace();
        } finally {
          if (in != null) {
            try {
              in.close();
            } catch (IOException e) {
              e.printStackTrace();
            }
          }
        }
      }
    };
  }
}
