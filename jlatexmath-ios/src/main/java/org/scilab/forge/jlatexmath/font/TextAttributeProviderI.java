package org.scilab.forge.jlatexmath.font;

import org.scilab.forge.jlatexmath.platform.font.TextAttribute;
import org.scilab.forge.jlatexmath.platform.font.TextAttributeProvider;
import org.robovm.apple.uikit.NSAttributedStringAttribute;

public class TextAttributeProviderI implements TextAttributeProvider{
	
	public TextAttribute getTextAttribute(String name) {
		try { // to avoid problems with Java 1.5
            return new TextAttributeI((NSAttributedStringAttribute) TextAttribute.class.getField(name).get(TextAttribute.class));
        } catch (Exception e) { 
        	return null;
        }
	}

	public Integer getTextAttributeValue(String name) {
		try {
			return (Integer) (TextAttribute.class.getField(name).get(TextAttribute.class));
		} catch (Exception e) {
			return null;
		}
	}
}
