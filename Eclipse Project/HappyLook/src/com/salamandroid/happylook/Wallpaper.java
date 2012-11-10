package com.salamandroid.happylook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import android.annotation.SuppressLint;
import android.app.WallpaperManager;
import android.content.Context;
import android.widget.Toast;

@SuppressLint("ShowToast")
public class Wallpaper {
	
	public void setWallpaper(WallpaperManager wm, Context appcontext, String filename){
		File root = android.os.Environment.getExternalStorageDirectory();
    	//WallpaperManager wm = WallpaperManager.getInstance(this);
    	try {
			InputStream in = new FileInputStream(root.getAbsolutePath() + "/happylook/"+filename);
			try {
				wm.setStream(in);
			} catch (IOException e) {
				e.printStackTrace();
			}
    	} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    	          
        //Toast.makeText(appcontext, "Wallpaper has been set", 10);
	}

}
