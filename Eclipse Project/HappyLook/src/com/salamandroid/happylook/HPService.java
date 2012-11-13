package com.salamandroid.happylook;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

@SuppressLint("ShowToast")
public class HPService extends Service
{

    private Preferences pref;
    private Timer timer;
    private long SERVICE_INTERVAL_PERIOD = 10000;
    private Wallpaper wallpaper;

    @Override
    public IBinder onBind(Intent arg0)
    {
	return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
	timer = new Timer();
	wallpaper = new Wallpaper();
	pref = (Preferences) intent.getSerializableExtra("preferences");
	WallpaperUpdaterService();
	return START_STICKY;
    }

    private void WallpaperUpdaterService()
    {
	timer.scheduleAtFixedRate(new TimerTask()
	{

	    public void run()
	    {
		if (rightDayForUpdate() && rightTimeForUpdate())
		    wallpaper.updateWallpaper(pref, getApplicationContext());
	    }
	}, 0, SERVICE_INTERVAL_PERIOD);
    }

    private boolean rightDayForUpdate()
    {
	final Calendar calendar = Calendar.getInstance();
	if ((pref.sunday == true &&
		calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
		|| (pref.monday == true &&
		calendar.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY)
		|| (pref.wednesday == true &&
		calendar.get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY)
		|| (pref.friday == true &&
		calendar.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY))
	    return true;
	else
	    return true;
    }

    private boolean rightTimeForUpdate()
    {
	final Calendar calendar = Calendar.getInstance();
	if (calendar.get(Calendar.HOUR_OF_DAY) == 6)
	    return true;
	else
	    return true;
    }

    @Override
    public void onDestroy()
    {
	timer.cancel();
	super.onDestroy();
    }
}
