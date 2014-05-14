package cz.cvut.pda.azppro.memory;

import java.io.*;
import java.util.List;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.util.Log;

import cz.cvut.pda.azppro.app.App;
import cz.cvut.pda.azppro.entities.Project;

/**
 * Created by simekadam on 28/04/14.
 */
public class Memory implements Serializable {

	public Memory() {
	}

	public static final String KEY_MEMORY = "memory";
	List<Project> mProjectList;

	public void addProject(Project project){

		mProjectList.add(project);
	}


	public List<Project> getProjectList() {
		return mProjectList;
	}

	public static void persist(Memory memory){
		File file = new File(Environment.getDataDirectory(), KEY_MEMORY);
		file.mkdirs();
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(memory);
			objectOutputStream.close();
			fileOutputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Memory load(){
		File file = new File(Environment.getDataDirectory(), KEY_MEMORY);
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			Memory memory = (Memory)objectInputStream.readObject();
			fileInputStream.close();
			objectInputStream.close();
			return memory;
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(ClassCastException e){
			Log.d("prdel", "kurva");
		}

		return null;
	}




}
