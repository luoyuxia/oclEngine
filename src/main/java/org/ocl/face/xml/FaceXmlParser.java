package org.ocl.face.xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.ocl.face.XmlItem;
import org.ocl.face.uop.Alias;
import org.ocl.face.uop.FaceUopFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class FaceXmlParser {
    private SAXReader saxReader = new SAXReader();
    private FaceUopFactory faceUopFactory = FaceUopFactory.eINSTANCE;
    public List<XmlItem> getAllXmlItem(InputStream xmlInputStream) {
        List<XmlItem> xmlItems = new ArrayList<>();
        try(InputStream inputStream = xmlInputStream) {
            Document document = saxReader.read(inputStream);
            xmlItems.addAll(getUopAlias(document));
        } catch (IOException | DocumentException e) {
            e.printStackTrace();
        }
        return xmlItems;
    }

    public List<XmlItem> getAllXmlItem(File file) {
        List<XmlItem> xmlItems = new ArrayList<>();
        try(InputStream inputStream = new FileInputStream(file)) {
            return getAllXmlItem(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return xmlItems;
    }

    private List<XmlItem> getUopAlias(Document document) {
        List<XmlItem> items = new ArrayList<>();
        List<Element> nodes = document.selectNodes("/face:DataModel/uopModel//alias");
        nodes.forEach(n -> {
            Alias alias = faceUopFactory.createAlias();
            alias.setName(n.valueOf("@name"));
            items.add(alias);
        });
        return items;
    }
}
