package com.salamandroid.happylook;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ToggleButton;

@SuppressLint("ShowToast")
public class MainActivity extends Activity
{

    public enum Buttons {
	ABSTRACT, ANIMALS, CARS, CITIES, FILMS, FOODS, MINIMAL, NATURE, SUNDAY, MONDAY, WEDNESDAY, FRIDAY
    }

    public static final String PREFS_NAME = "MyPrefs";
    private Preferences pref = new Preferences();
    private Intent serviceIntent;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main);
	Log.d("onCreate", "Passed");
    }

    protected void onResume()
    {
	Log.d("onResume", "Before Super");
	super.onResume();
	Log.d("onResume", "After Super");
	loadPreferences();
	Log.d("onResume", "After Load Preferences");
	startServiceWithNewConfig();
	updateUIWithNewPref();
	Log.d("onResume", "After UI With Pref");
    }

    private void loadPreferences()
    {
	SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
	pref.abstractp = settings.getBoolean("abstract", true);
	pref.animalsp = settings.getBoolean("animals", true);
	pref.carsp = settings.getBoolean("cars", true);
	pref.citiesp = settings.getBoolean("cities", true);
	pref.filmsp = settings.getBoolean("films", true);
	pref.foodsp = settings.getBoolean("foods", true);
	pref.minimalp = settings.getBoolean("minimal", true);
	pref.naturep = settings.getBoolean("nature", true);
	pref.sunday = settings.getBoolean("sunday", true);
	pref.monday = settings.getBoolean("monday", true);
	pref.wednesday = settings.getBoolean("wednesday", true);
	pref.friday = settings.getBoolean("friday", true);
	Log.d("Load Pref", "Abstract Val:" + pref.abstractp);
	Log.d("Load Pref", "Animals Val:" + pref.animalsp);
	Log.d("Load Pref", "cars Val:" + pref.carsp);
	Log.d("Load Pref", "cities Val:" + pref.citiesp);
    }

    private void updateUIWithNewPref()
    {
	updateButton(Buttons.ABSTRACT, pref.abstractp);
	updateButton(Buttons.ANIMALS, pref.animalsp);
	updateButton(Buttons.CARS, pref.carsp);
	updateButton(Buttons.CITIES, pref.citiesp);
	updateButton(Buttons.FILMS, pref.filmsp);
	updateButton(Buttons.FOODS, pref.foodsp);
	updateButton(Buttons.MINIMAL, pref.minimalp);
	updateButton(Buttons.NATURE, pref.naturep);
	updateButton(Buttons.SUNDAY, pref.sunday);
	updateButton(Buttons.MONDAY, pref.monday);
	updateButton(Buttons.WEDNESDAY, pref.wednesday);
	updateButton(Buttons.FRIDAY, pref.friday);
    }

    private void updateButton(Buttons buttonName, boolean state)
    {
	switch (buttonName) {
	    case ABSTRACT:
		ToggleButton abstractBT = (ToggleButton) findViewById(R.id.imageButton1);
		abstractBT.setChecked(state);
		if (abstractBT.isChecked())
		    abstractBT.setBackgroundDrawable(getResources()
			    .getDrawable(
				    R.drawable.btnabstract));
		else
		    abstractBT.setBackgroundDrawable(getResources()
			    .getDrawable(
				    R.drawable.p_abstract));
		break;
	    case ANIMALS:
		ToggleButton animalsBT = (ToggleButton) findViewById(R.id.imageButton2);
		animalsBT.setChecked(state);
		if (animalsBT.isChecked())
		    animalsBT.setBackgroundDrawable(getResources().getDrawable(
			    R.drawable.btnanimals));
		else
		    animalsBT.setBackgroundDrawable(getResources().getDrawable(
			    R.drawable.p_animals));
		break;
	    case CARS:
		ToggleButton carsBT = (ToggleButton) findViewById(R.id.imageButton3);
		carsBT.setChecked(state);
		if (carsBT.isChecked())
		    carsBT.setBackgroundDrawable(getResources().getDrawable(
			    R.drawable.btncar));
		else
		    carsBT.setBackgroundDrawable(getResources().getDrawable(
			    R.drawable.p_car));
		break;
	    case CITIES:
		ToggleButton citiesBT = (ToggleButton) findViewById(R.id.imageButton4);
		citiesBT.setChecked(state);
		if (citiesBT.isChecked())
		    citiesBT.setBackgroundDrawable(getResources().getDrawable(
			    R.drawable.btncity));
		else
		    citiesBT.setBackgroundDrawable(getResources().getDrawable(
			    R.drawable.p_city));
		break;
	    case FILMS:
		ToggleButton filmsBT = (ToggleButton) findViewById(R.id.imageButton5);
		filmsBT.setChecked(state);
		if (filmsBT.isChecked())
		    filmsBT.setBackgroundDrawable(getResources().getDrawable(
			    R.drawable.btnfilm));
		else
		    filmsBT.setBackgroundDrawable(getResources().getDrawable(
			    R.drawable.p_film));
		break;
	    case FOODS:
		ToggleButton foodsBT = (ToggleButton) findViewById(R.id.imageButton6);
		foodsBT.setChecked(state);
		if (foodsBT.isChecked())
		    foodsBT.setBackgroundDrawable(getResources().getDrawable(
			    R.drawable.btnfood));
		else
		    foodsBT.setBackgroundDrawable(getResources().getDrawable(
			    R.drawable.p_food));
		break;
	    case MINIMAL:
		ToggleButton minimalBT = (ToggleButton) findViewById(R.id.imageButton7);
		minimalBT.setChecked(state);
		if (minimalBT.isChecked())
		    minimalBT.setBackgroundDrawable(getResources().getDrawable(
			    R.drawable.btnminimalistic));
		else
		    minimalBT.setBackgroundDrawable(getResources().getDrawable(
			    R.drawable.p_minimalistic));
		break;
	    case NATURE:
		ToggleButton natureBT = (ToggleButton) findViewById(R.id.imageButton8);
		natureBT.setChecked(state);
		if (natureBT.isChecked())
		    natureBT.setBackgroundDrawable(getResources().getDrawable(
			    R.drawable.btnnature));
		else
		    natureBT.setBackgroundDrawable(getResources().getDrawable(
			    R.drawable.p_nature));
		break;
	    case SUNDAY:
		ToggleButton sundayBT = (ToggleButton) findViewById(R.id.toggleButton1);
		sundayBT.setChecked(state);
		break;
	    case MONDAY:
		ToggleButton mondayBT = (ToggleButton) findViewById(R.id.toggleButton2);
		mondayBT.setChecked(state);
		break;
	    case WEDNESDAY:
		ToggleButton wednesdayBT = (ToggleButton) findViewById(R.id.toggleButton3);
		wednesdayBT.setChecked(state);
		break;
	    case FRIDAY:
		ToggleButton fridayBT = (ToggleButton) findViewById(R.id.toggleButton4);
		fridayBT.setChecked(state);
		break;
	}
    }

    private void startServiceWithNewConfig()
    {
	serviceIntent = new Intent(getBaseContext(), HPService.class);
	serviceIntent.putExtra("preferences", pref);
	startService(serviceIntent);
    }

    @Override
    protected void onPause()
    {
	super.onPause();
	restartServiceWithNewConfigs();
    }

    private void restartServiceWithNewConfigs()
    {
	stopService(serviceIntent);
	serviceIntent = null; // for garbage collection
	startServiceWithNewConfig();
    }

    protected void onStop()
    {
	super.onStop();
	savePreferences();
    }

    private void savePreferences()
    {
	SharedPreferences preferencesStorage = getSharedPreferences(PREFS_NAME,
		0);
	SharedPreferences.Editor prefStorageEditor = preferencesStorage.edit();
	prefStorageEditor.putBoolean("abstract", pref.abstractp);
	prefStorageEditor.putBoolean("animals", pref.animalsp);
	prefStorageEditor.putBoolean("cars", pref.carsp);
	prefStorageEditor.putBoolean("cities", pref.citiesp);
	prefStorageEditor.putBoolean("films", pref.filmsp);
	prefStorageEditor.putBoolean("foods", pref.foodsp);
	prefStorageEditor.putBoolean("minimal", pref.minimalp);
	prefStorageEditor.putBoolean("nature", pref.naturep);
	prefStorageEditor.putBoolean("sunday", pref.sunday);
	prefStorageEditor.putBoolean("monday", pref.monday);
	prefStorageEditor.putBoolean("wednesday", pref.wednesday);
	prefStorageEditor.putBoolean("friday", pref.friday);
	prefStorageEditor.commit();
    }

    public void abstractbtn(View view)
    {
	pref.tglAbstract();
	updateButton(Buttons.ABSTRACT, pref.abstractp);
    }

    public void animalsbtn(View view)
    {
	pref.tglAnimals();
	updateButton(Buttons.ANIMALS, pref.animalsp);
    }

    public void carbtn(View view)
    {
	pref.tglCars();
	updateButton(Buttons.CARS, pref.carsp);
    }

    public void citybtn(View view)
    {
	pref.tglCities();
	updateButton(Buttons.CITIES, pref.citiesp);
    }

    public void filmbtn(View view)
    {
	pref.tglFilms();
	updateButton(Buttons.FILMS, pref.filmsp);
    }

    public void foodbtn(View view)
    {
	pref.tglFoods();
	updateButton(Buttons.FOODS, pref.foodsp);
    }

    public void minimalbtn(View view)
    {
	pref.tglMinimal();
	updateButton(Buttons.MINIMAL, pref.minimalp);
    }

    public void naturebtn(View view)
    {
	pref.tglNature();
	updateButton(Buttons.NATURE, pref.naturep);
    }

    public void sundaybtn(View view)
    {
	pref.tglSunday();
    }

    public void mondaybtn(View view)
    {
	pref.tglMonday();
    }

    public void wednesdaybtn(View view)
    {
	pref.tglWednesday();
    }

    public void fridaybtn(View view)
    {
	pref.tglFriday();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
	getMenuInflater().inflate(R.menu.activity_main, menu);
	return true;
    }
}
