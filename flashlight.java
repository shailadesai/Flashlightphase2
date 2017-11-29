package com.example.shail.flashlightphase2;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.view.View;

/**
 * Created by shail on 11/28/2017.
 */


public class flashlight {
    int i ;
    public MainActivity mainActivity;
    flashlight(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        blink();

    }

    public void blink() {
        for (i = 1; i <= 1000; i++) {

            try {
                Thread.sleep(200);//Turn ON
                flasLight();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {

                Thread.sleep(200);//Turn ON
                flasLoff();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }



    public void flasLight() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            CameraManager camManager = (CameraManager) mainActivity.getSystemService(Context.CAMERA_SERVICE);
            String cameraId = null; // Usually back camera is at 0 position.
            try {
                try {
                    cameraId = camManager.getCameraIdList()[0];
                } catch (CameraAccessException e) {
                    e.printStackTrace();
                }


                camManager.setTorchMode(cameraId, true);
                MediaPlayer ring= MediaPlayer.create(mainActivity,R.raw.beep);
                ring.start();

            } catch (CameraAccessException e) {
                e.printStackTrace();
            }


        }
    }
    public void flasLoff() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            CameraManager camManager = (CameraManager) mainActivity.getSystemService(Context.CAMERA_SERVICE);
            String cameraId = null; // Usually back camera is at 0 position.
            try {
                try {
                    cameraId = camManager.getCameraIdList()[0];
                } catch (CameraAccessException e) {
                    e.printStackTrace();
                }


                camManager.setTorchMode(cameraId, false);
                Thread.sleep(80);//Turn ON//Turn ON
            } catch (CameraAccessException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }


    }

}




