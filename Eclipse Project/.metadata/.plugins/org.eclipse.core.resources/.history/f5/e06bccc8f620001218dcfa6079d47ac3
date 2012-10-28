package com.salamandroid.happylook;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ToggleButton;

@SuppressLint("ShowToast")
public class MainActivity extends Activity {
	public static final String PREFS_NAME = "MyPrefs";
	private Preferences pref = new Preferences();
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
              
        
        //----Get Preferences-------------------------------------
        
        
        	
        Log.d("anmal-on create", "value: "+pref.animalsp);
    }

    protected void onResume(){
    	super.onResume();
    	SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
    	
    	
    	ToggleButton bt = (ToggleButton)findViewById(R.id.imageButton1);
    	ToggleButton bt2 = (ToggleButton)findViewById(R.id.imageButton2);
    	ToggleButton bt3 = (ToggleButton)findViewById(R.id.imageButton3);
    	ToggleButton bt4 = (ToggleButton)findViewById(R.id.imageButton4);
    	ToggleButton bt5 = (ToggleButton)findViewById(R.id.imageButton5);
    	ToggleButton bt6 = (ToggleButton)findViewById(R.id.imageButton6);
    	ToggleButton bt7 = (ToggleButton)findViewById(R.id.imageButton7);
    	ToggleButton bt8 = (ToggleButton)findViewById(R.id.imageButton8);
    	ToggleButton bt9 = (ToggleButton)findViewById(R.id.toggleButton1);
    	ToggleButton bt10 = (ToggleButton)findViewById(R.id.toggleButton2);
    	ToggleButton bt11 = (ToggleButton)findViewById(R.id.toggleButton3);
    	ToggleButton bt12 = (ToggleButton)findViewById(R.id.toggleButton4);
    	
    	if(settings.getBoolean("abstract", true)==false){
    		pref.abstractp = false;
    		bt.setBackgroundDrawable(getResources().getDrawable(R.drawable.p_abstract));
    		bt.setChecked(true);
    	}
    	Log.d("animal-on resume", "valueb: "+pref.animalsp);
        if(settings.getBoolean("animals", true)==false){
        	pref.animalsp = false;
        	bt2.setBackgroundDrawable(getResources().getDrawable(R.drawable.p_animals));
        	bt2.setChecked(true);
        }
        Log.d("animal-on resume", "valuea: "+pref.animalsp);
        if(settings.getBoolean("cars", true)==false){
        	pref.carsp=false;
        	bt3.setBackgroundDrawable(getResources().getDrawable(R.drawable.p_car));
        	bt3.setChecked(true);
        }        	
        if(settings.getBoolean("cities", true)==false){
        	pref.citiesp=false;
        	bt4.setBackgroundDrawable(getResources().getDrawable(R.drawable.p_city));
        	bt4.setChecked(true);
        }
        if(settings.getBoolean("films", true)==false){
        	pref.filmsp=false;
        	bt5.setBackgroundDrawable(getResources().getDrawable(R.drawable.p_film));
        	bt5.setChecked(true);
        }
        if(settings.getBoolean("foods", true)==false){
        	pref.foodsp=false;
        	bt6.setBackgroundDrawable(getResources().getDrawable(R.drawable.p_food));
        	bt6.setChecked(true);
        }        	
        if(settings.getBoolean("minimal", true)==false){
        	pref.minimalp=false;
        	bt7.setBackgroundDrawable(getResources().getDrawable(R.drawable.p_minimalistic));
        	bt7.setChecked(true);
        }        	
        if(settings.getBoolean("nature", true)==false){
        	pref.naturep=false;
        	bt8.setBackgroundDrawable(getResources().getDrawable(R.drawable.p_nature));
        	bt8.setChecked(true);
        }
        
        if(settings.getBoolean("sunday", true))
        	bt9.setChecked(true);
        else
        	pref.sunday=false;
        
        if(settings.getBoolean("monday", true))
        	bt10.setChecked(true);
        else
        	pref.monday=false;
        
        if(settings.getBoolean("wednesday", true))
        	bt11.setChecked(true);
        else
        	pref.wednesday=false;
        
        if(settings.getBoolean("friday", true))
        	bt12.setChecked(true);
        else
        	pref.friday=false;
        
        Log.d("animal-on resume", "value: "+pref.animalsp);
        
    }
    protected void onStop(){
        super.onStop();

       // We need an Editor object to make preference changes.
       // All objects are from android.context.Context
       
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
    	SharedPreferences.Editor editor = settings.edit();
    	
       editor.putBoolean("abstract", pref.abstractp);
       editor.putBoolean("animals", pref.animalsp);
       editor.putBoolean("cars", pref.carsp);
       editor.putBoolean("cities", pref.citiesp);
       editor.putBoolean("films", pref.filmsp);
       editor.putBoolean("foods", pref.foodsp);
       editor.putBoolean("minimal", pref.minimalp);
       editor.putBoolean("nature", pref.naturep);
       editor.putBoolean("sunday", pref.sunday);
       editor.putBoolean("monday", pref.monday);
       editor.putBoolean("wednesday", pref.wednesday);
       editor.putBoolean("friday", pref.friday);
       
       // Commit the edits!
       editor.commit();
       Log.d("animal-on stop", "value: "+pref.animalsp);
       Log.d("animal-on stop-pref", "value: "+settings.getBoolean("animals", true));
       
     }

    public void abstractbtn(View view){
    	SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
    	SharedPreferences.Editor editor = settings.edit();
    	
    	ToggleButton bt = (ToggleButton)findViewById(R.id.imageButton1);
    	if(bt.isChecked())
    		bt.setBackgroundDrawable(getResources().getDrawable(R.drawable.p_abstract));
    	else
    		bt.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnabstract));
    	
    	pref.tglAbstract();
    	Log.d("abstract", "value: "+pref.abstractp);

        editor.putBoolean("abstract", pref.abstractp);
        editor.commit();
    }
    
    public void animalsbtn(View view){
    	
    	ToggleButton bt = (ToggleButton)findViewById(R.id.imageButton2);
    	if(bt.isChecked())
    		bt.setBackgroundDrawable(getResources().getDrawable(R.drawable.p_animals));
    	else
    		bt.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnanimals));
    	
    	pref.tglAnimals();
    }
    
    public void carbtn(View view){
    	
    	ToggleButton bt = (ToggleButton)findViewById(R.id.imageButton3);
    	if(bt.isChecked())
    		bt.setBackgroundDrawable(getResources().getDrawable(R.drawable.p_car));
    	else
    		bt.setBackgroundDrawable(getResources().getDrawable(R.drawable.btncar));
    	
    	pref.tglCars();
    }
    
    public void citybtn(View view){
    	
    	ToggleButton bt = (ToggleButton)findViewById(R.id.imageButton4);
    	if(bt.isChecked())
    		bt.setBackgroundDrawable(getResources().getDrawable(R.drawable.p_city));
    	else
    		bt.setBackgroundDrawable(getResources().getDrawable(R.drawable.btncity));
    	
    	pref.tglCities();
    }

    
    public void filmbtn(View view){
    	
    	ToggleButton bt = (ToggleButton)findViewById(R.id.imageButton5);
    	if(bt.isChecked())
    		bt.setBackgroundDrawable(getResources().getDrawable(R.drawable.p_film));
    	else
    		bt.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnfilm));
    	
    	pref.tglFilms();
    }
    
    public void foodbtn(View view){
    	
    	ToggleButton bt = (ToggleButton)findViewById(R.id.imageButton6);
    	if(bt.isChecked())
    		bt.setBackgroundDrawable(getResources().getDrawable(R.drawable.p_food));
    	else
    		bt.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnfood));
    	
    	pref.tglFoods();
    }

    public void minimalbtn(View view){
    	
    	ToggleButton bt = (ToggleButton)findViewById(R.id.imageButton7);
    	if(bt.isChecked())
    		bt.setBackgroundDrawable(getResources().getDrawable(R.drawable.p_minimalistic));
    	else
    		bt.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnminimalistic));
    	
    	pref.tglMinimal();
    }

    public void naturebtn(View view){
    	
    	ToggleButton bt = (ToggleButton)findViewById(R.id.imageButton8);
    	if(bt.isChecked())
    		bt.setBackgroundDrawable(getResources().getDrawable(R.drawable.p_nature));
    	else
    		bt.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnnature));
    	
    	pref.tglNature();
    }
    
    public void sundaybtn(View view){
    	pref.tglSunday();
    }
    
    public void mondaybtn(View view){
    	pref.tglMonday();
    }
    
    public void wednesdaybtn(View view){
    	pref.tglWednesday();
    }
    
    public void fridaybtn(View view){
    	pref.tglFriday();
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
