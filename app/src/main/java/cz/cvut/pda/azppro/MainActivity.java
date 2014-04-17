package cz.cvut.pda.azppro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class MainActivity extends Activity {
	private final String[] mData = {"projekt 1", "projekt 2", "projekt 3"};

	@InjectView(R.id.projects_list)
	ListView mProjectList;
	private  ArrayAdapter<String> mArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
	    setTitle("Projects");
	    ButterKnife.inject(this);
	    mArrayAdapter = new ArrayAdapter<>(this, R.layout.layout_project_list_item, R.id.project_title, mData);
		mProjectList.setAdapter(mArrayAdapter);
	    mProjectList.setOnItemClickListener(mOnItemClickListener);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

	private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			Intent openProjectIntent = new Intent(MainActivity.this, ProjectDetailActivity.class);
			openProjectIntent.putExtra("projectId", position);
			startActivity(openProjectIntent);
		}
	};


}
