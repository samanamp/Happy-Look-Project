package com.salamandroid.happylook;

import java.net.URL;
import java.util.Calendar;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import android.annotation.SuppressLint;
import android.app.Service;
import android.app.WallpaperManager;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.util.Log;

@SuppressLint("ShowToast")
public class HPService extends Service {
	private Preferences pref;
	private Timer timer = new Timer();
	private long SERVICE_INTERVAL_PERIOD = 20000;
	private ImageDownloader imagedownloader;
	private Wallpaper wallpaper;

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		imagedownloader = new ImageDownloader();
		wallpaper = new Wallpaper();
		Log.d("Service", "onStart");
		pref = (Preferences) intent.getSerializableExtra("preferences");
		Log.d("Service-pref", "val: " + pref.abstractp);
		updater();
		//new ss().execute(0);
		return START_STICKY;
	}

	public void setPreferences(Preferences pref) {
		this.pref = pref;
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		timer.cancel();
		super.onDestroy();
	}

	private void updater() {
		final Calendar calendar = Calendar.getInstance();
		int dayOfWeek;
		
		timer.scheduleAtFixedRate(new TimerTask() {
			int i;
			public void run() {

/*				if ((pref.sunday == true && calendar.get(Calendar.DAY_OF_WEEK) == 1)
						|| (pref.wednesday == true && calendar
								.get(Calendar.DAY_OF_WEEK) == 4)
						|| (pref.friday == true && calendar
								.get(Calendar.DAY_OF_WEEK) == 6)
						|| (pref.monday == true && calendar
								.get(Calendar.DAY_OF_WEEK) == 2))
					if (calendar.get(Calendar.HOUR_OF_DAY) == 6)     */	 
					{
						i = 0;
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
						Log.d("Service", "i:"+i);
						Random randomgenerator = new Random();
						String category= categories[randomgenerator.nextInt(i)];
						int date = calendar.get(Calendar.DAY_OF_YEAR);
						imagedownloader.DownloadFromUrl(
								"http://sharproid.com/happylook/today-"
										+ category + ".jpg",
								Integer.toString(date) + ".jpg");
						wallpaper.setWallpaper(WallpaperManager.getInstance(getApplicationContext()), getApplicationContext(), Integer.toString(date) + ".jpg");
						
					}
				Log.d("Service", "onRun");
				// Toast.makeText(getApplicationContext(), "Service Run",
				// Toast.LENGTH_SHORT).show();
			}
		}, 0, SERVICE_INTERVAL_PERIOD);
	}

	
	private class ss extends AsyncTask<Integer, Integer, Integer>{

		@Override
		protected Integer doInBackground(Integer... params) {
			Log.d("ss : ", "calling updater in background");
			updater();
			return null;
		}
		
	}
	
}
