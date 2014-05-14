package cz.cvut.pda.azppro.entities;

import java.io.Serializable;

/**
 * Created by simekadam on 28/04/14.
 */
public class ActiveArea  implements Serializable{

	private float X;
	private float y;
	private float width;
	private float height;
	private Type type;
	private String caption;
	private int linkedScreenId;


	public enum Type{
		EDITEXT, BUTTON, CAPTION
	}

	public ActiveArea(float x, float y, float width, float height, Type type, String caption, int linkedScreenId) {
		X = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.type = type;
		this.caption = caption;
		this.linkedScreenId = linkedScreenId;
	}

	public ActiveArea() {
	}

	public float getX() {
		return X;
	}

	public float getY() {
		return y;
	}

	public float getWidth() {
		return width;
	}

	public float getHeight() {
		return height;
	}

	public Type getType() {
		return type;
	}

	public String getCaption() {
		return caption;
	}

	public int getLinkedScreenId() {
		return linkedScreenId;
	}
}
