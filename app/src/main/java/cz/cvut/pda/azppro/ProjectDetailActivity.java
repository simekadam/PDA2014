package cz.cvut.pda.azppro;

import java.util.zip.Inflater;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

import butterknife.ButterKnife;
import butterknife.InjectView;
import com.squareup.picasso.Picasso;


public class ProjectDetailActivity extends Activity {

	private ArrayAdapter<String> mArrayAdapter;
	@InjectView(R.id.screens_grid)
	GridView mGrid;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_detail);
		ButterKnife.inject(this);
		mGrid.setAdapter(mAdapter);
		int projectId = getIntent().getIntExtra("projectId", 0);
		setTitle("Projekt "+projectId);
		mGrid.setOnItemClickListener(mOnItemClickListener);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.project_detail, menu);
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


	private String getUrl(int id){
		return "http://robohash.gopagoda.com/"+id;

	}

	private BaseAdapter mAdapter = new BaseAdapter() {



		@Override
		public int getCount() {
			return 1000;
		}

		@Override
		public Object getItem(int position) {
			return null;
		}

		@Override
		public long getItemId(int position) {
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			LinearLayout layout;
			if(convertView != null){
					layout = (LinearLayout)convertView;
			}else{
				layout = (LinearLayout)LayoutInflater.from(ProjectDetailActivity.this).inflate(R.layout.layout_screen_item, parent, false);
			}
			ImageView imageView = ButterKnife.findById(layout, R.id.screen_thumbnail);
			Picasso.with(ProjectDetailActivity.this).load(getUrl(position)).into(imageView);
			return layout;
		}
	};

	private final AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			Intent goToScreenIntent = new Intent(ProjectDetailActivity.this, ScreenDetailActivity.class);
			goToScreenIntent.putExtra("screenId", getUrl(position));
			startActivity(goToScreenIntent);
		}
	};

}
