package com.example.flashlight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button;


    public Boolean is_on=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean flash=getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
                try{
                CameraManager cameraManager=(CameraManager)getSystemService(Context.CAMERA_SERVICE);
                String cameraId=cameraManager.getCameraIdList()[0];
                cameraManager.setTorchMode(cameraId,is_on);
                if (is_on)

                    is_on =false;
                else
                    is_on=true;
            }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
}