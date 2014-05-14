package cz.cvut.pda.azppro.entities;

import java.io.Serializable;
import java.util.List;

/**
 * Created by simekadam on 28/04/14.
 */
public class Screen implements Serializable{

	private int mId;
	private String mTitle;
	private List<ActiveArea> mActiveAreaList;

	public Screen(int id, String title, List<ActiveArea> activeAreaList) {
		mId = id;
		mTitle = title;
		mActiveAreaList = activeAreaList;
	}

	public Screen() {
	}

	public int getId() {
		return mId;
	}

	public String getTitle() {
		return mTitle;
	}

	public List<ActiveArea> getActiveAreaList() {
		return mActiveAreaList;
	}

	public void addActiveArea(ActiveArea activeArea){
		mActiveAreaList.add(activeArea);
	}
}
