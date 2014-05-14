package cz.cvut.pda.azppro;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import com.squareup.picasso.Picasso;


public class ScreenDetailActivity extends Activity {

	@InjectView(R.id.screen_preview)
	ImageView mScreenPreview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_detail);
	    ButterKnife.inject(this);
	    int imgUrl = getIntent().getIntExtra("screenId", 1);
	    mScreenPreview.setImageBitmap(getDrawable(imgUrl));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.screen_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()){
	        case R.id.action_setup:
		        openDialog();
		        return true;
        }

        return super.onOptionsItemSelected(item);
    }

	private void openDialog() {
		new SetupDialogFragment().show(getFragmentManager(), "Setup");
	}


	private Bitmap getDrawable(int position){

		position = position%8+1;
		return getDrawableFromResource(position);



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
