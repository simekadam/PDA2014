package cz.cvut.pda.azppro.app;

import android.app.Application;

import cz.cvut.pda.azppro.memory.Memory;

/**
 * Created by simekadam on 28/04/14.
 */
public class App extends Application {

	public static final String PREFERENCES = "preferences";

	private Memory mMemory;
	private static App sInstance;

	public App() {
		super();
		mMemory = Memory.load();
	}

	public static App getInstance(){
		if(sInstance == null){
			sInstance = new App();
		}
		return sInstance;
	}


	public Memory loadState(){
		mMemory = Memory.load();
		return mMemory;
	}

	public Memory getMemory() {
		return mMemory;
	}

	public void saveState(){
		Memory.persist(mMemory);
	}

}
