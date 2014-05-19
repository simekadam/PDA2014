package cz.cvut.pda.azppro;

import android.app.Activity;
import android.os.Bundle;

import cz.cvut.pda.azppro.app.App;
import cz.cvut.pda.azppro.entities.Screen;

/**
 * Created by simekadam on 28/04/14.
 */
public class MockupActivity extends Activity{

	public static final String KEY_PROJECT = "key_project";
	public static final String KEY_SCREEN = "key_screen";
	private Screen mScreen;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.mockupActivity);
		Bundle extras = getIntent().getExtras();
		int projectId = extras.getInt(KEY_PROJECT);
		int screenId = extras.getInt(KEY_SCREEN);
		mScreen = App.getInstance().getMemory().getProjectList().get(projectId).getScreenList().get(screenId);
	}


	private void init(){


	}
}
