package appium;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Kranthi on 02-07-2017.
 */
public class ReadingXmlFile {
    @Test(enabled = false)
    public void exploringXML() throws IOException, SAXException {
        File f= new File("src\\main\\resources\\testsuitsample.xml");
        DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
        DocumentBuilder DB= null;
        Document d;
        Logger log= Logger.getLogger(ReadingXmlFile.class);
        try {
            DB = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
            d = DB != null ? DB.parse(f) : null;
        d.getDocumentElement().normalize();
        NodeList n1=d.getElementsByTagName("parameter");
        log.info("logging working");
        for (int i=0;i<n1.getLength();i++)
        {
//            Node n=n1.item(i);
            Element e= (Element)n1.item(i);
//            log.info(n.getNodeName());
            log.info(e.getNodeName());
            log.info(e.getAttribute("name"));
        }

    }

    @Test
    public void writeHtmlToFile() throws IOException {
        File f= new File("target/content.html");
        FileWriter filewriter=new FileWriter(f);
        BufferedWriter bufferedwriter= new BufferedWriter(filewriter);
        /* because of buffered writer we can push data multiple times to object **/
        bufferedwriter.write("<html>");
        bufferedwriter.write("<b>hai</b>");
        bufferedwriter.newLine();
        bufferedwriter.write(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()));
        bufferedwriter.write("</html>");
        bufferedwriter.close();
    }

}
