package com.salamandroid.happylook;

public class Preferences {
	protected boolean abstractp = true;
	protected boolean animalsp= true;
	protected boolean carsp= true;
	protected boolean citiesp= true;
	protected boolean filmsp= true;
	protected boolean foodsp= true;
	protected boolean minimalp= true;
	protected boolean naturep= true;
	protected boolean sunday=true;
	protected boolean monday=true;
	protected boolean wednesday=true;
	protected boolean friday=true;
	
	public void tglAbstract(){
		if(this.abstractp==true)
			this.abstractp = false;
		else
			this.abstractp = true;
	}
	
	public void tglAnimals(){
		if(this.animalsp==true)
			this.animalsp= false;
		else
			this.animalsp = true;
	}
	
	public void tglCars(){
		if(this.carsp==true)
			this.carsp= false;
		else
			this.carsp= true;
	}
	
	public void tglCities(){
		if(this.citiesp==true)
			this.citiesp= false;
		else
			this.citiesp= true;
	}
	
	public void tglFilms(){
		if(this.filmsp==true)
			this.filmsp= false;
		else
			this.filmsp= true;
	}
	
	public void tglFoods(){
		if(this.foodsp==true)
			this.foodsp= false;
		else
			this.foodsp= true;
	}
	
	public void tglMinimal(){
		if(this.minimalp==true)
			this.minimalp= false;
		else
			this.minimalp= true;
	}
	
	public void tglNature(){
		if(this.naturep==true)
			this.naturep= false;
		else
			this.naturep= true;
	}
	
	public void tglSunday(){
		if(this.sunday==true)
			this.sunday=false;
		else
			this.sunday=true;
	}
	
	public void tglMonday(){
		if(this.monday)
			this.monday=false;
		else
			this.monday=true;
	}
	
	public void tglWednesday(){
		if(this.wednesday)
			this.wednesday=false;
		else
			this.wednesday=true;
	}
	
	public void tglFriday(){
		if(this.friday)
			this.friday=false;
		else
			this.friday=true;
	}
}
