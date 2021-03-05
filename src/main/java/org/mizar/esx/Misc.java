package org.mizar.esx;

import org.dom4j.Element;

public class Misc {

    public static String assignAttrValue(Element e, String attrName) {
        return e.attribute(attrName) == null ? null : e.attributeValue(attrName);
    }

    public static String normalizeName(String string) {
        String str = string.replace("-", "");
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
