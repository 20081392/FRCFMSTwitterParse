/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frcfmstwitterparse;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;


/**
 *
 * @author Alex / Armadi
 */
public class FRCFMSTwitterParse {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    
            
        try {
               
                /**change to twitter xml url before competition*/
	File fXmlFile = new File("G:\\wamp\\www\\songs.xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile);
 
	//optional, but recommended
	//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
	doc.getDocumentElement().normalize();
  
	NodeList nList = doc.getElementsByTagName("item");
 
	System.out.println("----------------------------");
 
	for (int temp = 0; temp < nList.getLength(); temp++) {
                /**asks for only first entry*/
 
		Node nNode = nList.item(temp);
 
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
 
			Element eElement = (Element) nNode;
 
			String tweet;
                                                tweet = ("Tweet : " + eElement.getElementsByTagName("description").item(0).getTextContent());
                                                /**print description tag*/
                                                tweet.replaceAll("#FRC(\\S+)\\sTY\\s([PQE])\\sMC\\s(\\d+)\\sRF\\s(\\d+)\\sBF\\s(\\d+)\\sRA\\s(\\d+)\\s(\\d+)\\s(\\d+)\\sBA\\s(\\d+)\\s(\\d+)\\s(\\d+)\\sRC\\s(\\d+)\\sBC\\s(\\d+)\\sRFP\\s(\\d+)\\sBFP\\s(\\d+)\\sRAS\\s(\\d+)\\sBAS\\s(\\d+)\\sRTS\\s(\\d+)\\sBTS\\s(\\d+)", "Event Name : $1\nType : $2\nMatch Number : $3\n\n*Red Team Stats*\nFinal Score : $4\nTeam 1 # : $6\nTeam 2 # : $7\nTeam 3 # : $8\nClimb Points : $12\nFoul Points : $14\nAuto Score : $16\nTeleop Disc Points : $18\n\n*Blue Team Stats*\nFinal Score : $5\nTeam 1 # : $9\nTeam 2 # : $10\nTeam 3 # : $11\nClimb Points : $13\nFoul Points : $15\nAuto Score : $17\nTeleop Disc Points : $19");
                                                
		}
	}
	System.out.println("----------------------------");
                System.in.read();
	System.out.println("----------------------------");
                /**while(enter==0) {
            
             
               
                };*/
                System.out.println("----------------------------");

                System.exit(0);
        
           } 
           catch (Exception e) {
	e.printStackTrace();
           }
    
    }
}
