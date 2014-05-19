package cz.cvut.pda.azppro;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by simekadam on 18/05/14.
 */
public class RedRectangleView extends View implements View.OnTouchListener, View.OnClickListener {

	private final int HEIGHT = 300;

	private Paint mPaint;
	private Paint mPaintFill;
	private float mXposition;
	private float mLastY;
	private OnActiveAreaClickListener mListener;
	private float mFirstY;

	public RedRectangleView(Context context) {
		this(context, null, 0);
	}

	public RedRectangleView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public RedRectangleView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		mPaint = new Paint();
		mPaint.setStyle(Paint.Style.STROKE);
		mPaint.setStrokeWidth(5);
		mPaint.setColor(Color.RED);
		mPaintFill = new Paint();
		mPaintFill.setStyle(Paint.Style.FILL);
		mPaintFill.setColor(Color.RED);
		mPaintFill.setAlpha(128);
		mXposition = 100;
		mLastY = -1;
		mFirstY = -1;
		this.setOnTouchListener(this);
		this.setOnClickListener(this);
		this.setClickable(true);
	}



	@Override
	protected void onDraw(Canvas canvas) {


		super.onDraw(canvas);
		canvas.drawRect(5, mXposition, canvas.getWidth()-5, mXposition+HEIGHT, mPaint);
		canvas.drawRect(5, mXposition, canvas.getWidth()-5, mXposition+HEIGHT, mPaintFill);

	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		switch(event.getAction()){
			case MotionEvent.ACTION_DOWN:
				if(event.getY() >= mXposition && event.getY() <= mXposition+HEIGHT){
					mLastY = event.getY();
					mFirstY = mLastY;
					return true;
				}
			case MotionEvent.ACTION_MOVE:
				if(mLastY != -1){
					mXposition +=  event.getY() - mLastY;
					mLastY = event.getY();
					Log.d("test", "test " + mLastY);
					invalidate();
					return true;
				}
			case MotionEvent.ACTION_UP:
				if(mFirstY == mLastY){
					mListener.onActiveAreaClicked();
					mFirstY = -1;
				}
				mLastY = -1;
				return true;

		}
		return super.onTouchEvent(event);
	}



	public void addOnActionAreaClickListener(OnActiveAreaClickListener listener){
		mListener = listener;
	}

	@Override
	public void onClick(View v) {
		if(mLastY >= mXposition && mLastY <= mXposition+HEIGHT){
			mListener.onActiveAreaClicked();
		}
	}




	interface OnActiveAreaClickListener{
		public void onActiveAreaClicked();
	}

}
