package org.ocl.face.xml;

import org.junit.Assert;
import org.junit.Test;
import org.ocl.face.XmlItem;

import java.util.List;

public class FaceXmlParserTest {
    @Test
    public void testParserFace() {
        FaceXmlParser faceXmlParser = new FaceXmlParser();
        List<XmlItem> xmlItems = faceXmlParser.getAllXmlItem(this.getClass().getResourceAsStream("/faceTest.face"));
        Assert.assertEquals(2, xmlItems.size());
    }
}
