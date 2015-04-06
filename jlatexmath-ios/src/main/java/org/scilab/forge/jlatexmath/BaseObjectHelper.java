package org.scilab.forge.jlatexmath;

import org.scilab.forge.jlatexmath.cyrillic.CyrillicRegistration;
import org.scilab.forge.jlatexmath.greek.GreekRegistration;

public class BaseObjectHelper {
	public static String getPath(Object base, String name) {
		String ret = null;
		if (base == CyrillicRegistration.class) {
			ret = "cyrillic/" + name;
		} else if (base == GreekRegistration.class) {
			ret = "greek/" + name;
		} else {
			ret = name;
		}
		return ret;
	}
	
	public static String getExt(Object base, String name){
		String ext = "";
		int i = name.lastIndexOf('.');
		if (i > 0) {
		    ext = name.substring(i+1);
		    return ext;
		}
		return null;
		
	}
}