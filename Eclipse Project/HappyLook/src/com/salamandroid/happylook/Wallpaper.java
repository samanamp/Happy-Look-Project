package com.salamandroid.happylook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Random;

import android.annotation.SuppressLint;
import android.app.WallpaperManager;
import android.content.Context;
import android.util.Log;

@SuppressLint("ShowToast")
public class Wallpaper
{

    public void updateWallpaper(Preferences pref, Context applicationContext)
    {
	final Calendar calendar = Calendar.getInstance();
	int i = 0;
	ImageDownloader imagedownloader = new ImageDownloader();
	String[] categories = new String[8];
	if (pref.abstractp)
	    categories[i++] = "abstract";
	if (pref.animalsp)
	    categories[i++] = "animal";
	if (pref.carsp)
	    categories[i++] = "car";
	if (pref.citiesp)
	    categories[i++] = "city";
	if (pref.filmsp)
	    categories[i++] = "film";
	if (pref.foodsp)
	    categories[i++] = "food";
	if (pref.minimalp)
	    categories[i++] = "minimal";
	if (pref.naturep)
	    categories[i++] = "nature";
	Log.d("Service", "i:" + i);
	Random randomgenerator = new Random();
	String category = categories[randomgenerator.nextInt(i)];
	int date = calendar.get(Calendar.DAY_OF_YEAR);
	imagedownloader.DownloadFromUrl(
		"http://sharproid.com/happylook/today-"
			+ category + ".jpg",
		Integer.toString(date) + ".jpg");
	setWallpaper(applicationContext, Integer.toString(date) + ".jpg");
    }

    private void setWallpaper(Context applicationContext, String filename)
    {
	File root = android.os.Environment.getExternalStorageDirectory();
	WallpaperManager wm = WallpaperManager.getInstance(applicationContext);
	try {
	    InputStream in = new FileInputStream(root.getAbsolutePath()
		    + "/happylook/" + filename);
	    try {
		wm.setStream(in);
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	}
    }
}
