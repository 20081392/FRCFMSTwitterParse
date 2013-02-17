package frcfmstwitterparse;

/**Authors: Alex & Armadi */
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class FRCFMSTwitterParse
{
    public static void main(String[] args) 
    {
        try {
            new FRCFMSTwitterParse().start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void start() throws Exception
    {
        URL url = new URL("https://api.twitter.com/1/statuses/user_timeline.rss?screen_name=frcfms");
        URLConnection connection = url.openConnection();

        Document doc = parseXML(connection.getInputStream());
        NodeList nList = doc.getElementsByTagName("item");
 //       NodeList descNodes = doc.getElementsByTagName("item");
        
        for(int i=0; i<1;i++)
            //descNodes.getLength(
        {
             Node nNode = nList.item(i);
            Element eElement = (Element) nNode;
            String tweet;
            String newtweet;
            tweet = ("Tweet : " + eElement.getElementsByTagName("description").item(0).getTextContent());
            //System.out.println(descNodes.item(i).getTextContent());
            newtweet = tweet.replaceAll("#FRC(\\S+)\\sTY\\s([PQE])\\sMC\\s(\\d+)\\sRF\\s(\\d+)\\sBF\\s(\\d+)\\sRA\\s(\\d+)\\s(\\d+)\\s(\\d+)\\sBA\\s(\\d+)\\s(\\d+)\\s(\\d+)\\sRC\\s(\\d+)\\sBC\\s(\\d+)\\sRFP\\s(\\d+)\\sBFP\\s(\\d+)\\sRAS\\s(\\d+)\\sBAS\\s(\\d+)\\sRTS\\s(\\d+)\\sBTS\\s(\\d+)", "Event Name : $1\nType : $2\nMatch Number : $3\n\n*Red Team Stats*\nFinal Score : $4\nTeam 1 # : $6\nTeam 2 # : $7\nTeam 3 # : $8\nClimb Points : $12\nFoul Points : $14\nAuto Score : $16\nTeleop Disc Points : $18\n\n*Blue Team Stats*\nFinal Score : $5\nTeam 1 # : $9\nTeam 2 # : $10\nTeam 3 # : $11\nClimb Points : $13\nFoul Points : $15\nAuto Score : $17\nTeleop Disc Points : $19");
            System.out.println(newtweet);
        }
    }
    private Document parseXML(InputStream stream)
    throws Exception
    {
        DocumentBuilderFactory objDocumentBuilderFactory = null;
        DocumentBuilder objDocumentBuilder = null;
        Document doc = null;
        try
        {
            objDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
            objDocumentBuilder = objDocumentBuilderFactory.newDocumentBuilder();

            doc = objDocumentBuilder.parse(stream);
        }
        catch(Exception ex)
        {
            throw ex;
        }       

        return doc;
    }
}