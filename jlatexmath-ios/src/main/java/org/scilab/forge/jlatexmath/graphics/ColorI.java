package org.scilab.forge.jlatexmath.graphics;

import org.scilab.forge.jlatexmath.platform.graphics.Color;

public class ColorI implements Color {
	
	private int mColor;

	public ColorI(int color) {
		mColor = color;
	}
	
	public ColorI(int red, int green, int blue) {
		mColor = rgb(red, green, blue);
	}

	public Object getNativeObject() {
		return new Integer(mColor);
	}

	public int getColor() {
		return mColor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + mColor;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ColorI other = (ColorI) obj;
		if (mColor != other.mColor)
			return false;
		return true;
	}
	
	private int rgb(int red, int green, int blue){
		return (0xFF << 24) | (red << 16) | (green << 8) | blue;
	}


}
