package cz.cvut.pda.azppro.entities;

import java.io.Serializable;
import java.util.List;

/**
 * Created by simekadam on 28/04/14.
 */
public class Project  implements Serializable {

	private int id;
	private String title;
	private List<Screen> mScreenList;

	public Project(int id, String title, List<Screen> screenList) {
		this.id = id;
		this.title = title;
		mScreenList = screenList;
	}

	public Project() {
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public List<Screen> getScreenList() {
		return mScreenList;
	}

	public void addScreen(Screen screen){
		mScreenList.add(screen);
	}
}
