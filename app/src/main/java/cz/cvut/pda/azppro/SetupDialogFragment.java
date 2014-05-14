package cz.cvut.pda.azppro;

import java.io.Serializable;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import butterknife.ButterKnife;

/**
 * Created by simekadam on 20/04/14.
 */
public class SetupDialogFragment extends DialogFragment {
	SparseArray<Bitmap> mBitmapList;


	public SetupDialogFragment() {
		mBitmapList = new SparseArray<>();
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		AlertDialog.Builder aBuilder = new AlertDialog.Builder(new ContextThemeWrapper(getActivity(), R.style.AppTheme));
		LayoutInflater inflater = getActivity().getLayoutInflater();
		View view = inflater.inflate(R.layout.dialog_setup, null);
		GridView mGrid = ButterKnife.findById(view, R.id.listView);
		mGrid.setAdapter(mAdapter);
		aBuilder.setView(view);

		aBuilder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dismiss();
			}
		});
		aBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dismiss();
			}
		});
		return aBuilder.create();
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
				layout = (FrameLayout)LayoutInflater.from(getActivity()).inflate(R.layout.layout_screen_item, parent, false);
			}

			ImageView imageView = ButterKnife.findById(layout, R.id.screen_thumbnail);
			TextView title = ButterKnife.findById(layout, R.id.itemTitle);
			title.setText("Screen "+ (position%8+1));

			imageView.setImageBitmap(getDrawable(position));


			return layout;
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
