package org.scilab.forge.jlatexmath.parser;

import org.scilab.forge.jlatexmath.platform.parser.Attr;
import org.w3c.dom.Node;

public class AttrI extends NodeI implements Attr{
	public org.w3c.dom.Attr impl;

	public AttrI(org.w3c.dom.Attr impl) {
		super((Node) impl);
		this.impl = impl;
	}

	public String getName() {
		return impl.getName();
	}

	public boolean isSpecified() {
		return impl.getSpecified();
	}

	public String getValue() {
		return impl.getValue();
	}
}
