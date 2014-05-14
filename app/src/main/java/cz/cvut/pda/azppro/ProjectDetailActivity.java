package cz.cvut.pda.azppro;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.*;
import android.widget.*;

import butterknife.ButterKnife;
import butterknife.InjectView;
import com.squareup.picasso.Picasso;


public class ProjectDetailActivity extends Activity {

	private ArrayAdapter<String> mArrayAdapter;
	@InjectView(R.id.screens_grid)
	GridView mGrid;
	SparseArray<Bitmap> mBitmapList;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_detail);
		ButterKnife.inject(this);
		mBitmapList = new SparseArray<>();
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
			FrameLayout layout;
			if(convertView != null){
					layout = (FrameLayout)convertView;
			}else{
				layout = (FrameLayout)LayoutInflater.from(ProjectDetailActivity.this).inflate(R.layout.layout_screen_item, parent, false);
			}

			ImageView imageView = ButterKnife.findById(layout, R.id.screen_thumbnail);
			TextView title = ButterKnife.findById(layout, R.id.itemTitle);
			title.setText("Screen "+ (position%8+1));

			imageView.setImageBitmap(getDrawable(position));


			return layout;
		}
	};

	private final AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			Intent goToScreenIntent = new Intent(ProjectDetailActivity.this, ScreenDetailActivity.class);
			goToScreenIntent.putExtra("screenId", position);
			startActivity(goToScreenIntent);
		}
	};


	private Bitmap getDrawable(int position){

		position = position%8+1;
		if(mBitmapList.get(position) == null){
			mBitmapList.put(position, getDrawableFromResource(position));
		}
		return mBitmapList.get(position);


	}

	private Bitmap getDrawableFromResource(int position){
		switch (position){
			case 1:

				return ((BitmapDrawable)getResources().getDrawable(R.drawable.s1)).getBitmap();
			case 2:
				return ((BitmapDrawable)getResources().getDrawable(R.drawable.s2)).getBitmap();
			case 3:
				return ((BitmapDrawable)getResources().getDrawable(R.drawable.s3)).getBitmap();
			case 4:
				return ((BitmapDrawable)getResources().getDrawable(R.drawable.s4)).getBitmap();
			case 5:
				return ((BitmapDrawable)getResources().getDrawable(R.drawable.s5)).getBitmap();
			case 6:
				return ((BitmapDrawable)getResources().getDrawable(R.drawable.s6)).getBitmap();
			case 7:
				return ((BitmapDrawable)getResources().getDrawable(R.drawable.s7)).getBitmap();
			default:
				return ((BitmapDrawable)getResources().getDrawable(R.drawable.s7)).getBitmap();
		}
	}


}
