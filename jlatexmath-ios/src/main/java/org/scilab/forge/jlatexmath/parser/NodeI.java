package org.scilab.forge.jlatexmath.parser;

import org.scilab.forge.jlatexmath.platform.parser.Attr;
import org.scilab.forge.jlatexmath.platform.parser.Element;
import org.scilab.forge.jlatexmath.platform.parser.Node;

public class NodeI implements Node {
	
	private org.w3c.dom.Node impl;
	
	public NodeI(org.w3c.dom.Node impl) {
		this.impl = impl;
	}

	public short getNodeType() {
		return impl.getNodeType();
	}

	public Element castToElement() {
		return new ElementI((org.w3c.dom.Element) impl);
	}

	public Attr castToAttr() {
		return new AttrI((org.w3c.dom.Attr) impl);
	}
}