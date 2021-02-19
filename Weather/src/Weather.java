import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import javax.swing.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Weather {

	public static void main(String[] args) {
		JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,li1,li2,li3,li4,li5,li6,li7,a1,a2,a3,a4,a5,a6;
		JTextField tf;
		JButton b1;
		
		
		
		
		JFrame jf=new JFrame("Weather");
		l1=new JLabel("Search: ");
		l1.setBounds(30,20,100,30);
		tf=new JTextField("Ambala");
		tf.setBounds(90,25,200,20);
		b1=new JButton("Search");
		b1.setBounds(300,25,90,20);
		l2=new JLabel("<html><font size='10' colour=red>31*</font></html>");
		l2.setBounds(30,50,100,100);
		l3=new JLabel("<html><font size='4' colour=purple>26*</font></html>");
		l3.setBounds(110, 60, 50, 50);
		l4=new JLabel("partly cloudy");
		l4.setBounds(110, 80, 150, 50);
		l5=new JLabel("<html><font size='4' colour=purple>33*</font></html>");
		l5.setBounds(225, 60, 50, 50);
		l6=new JLabel("Ambala");
		l6.setBounds(30, 160, 100, 30);
		l7=new JLabel("Ambala Cantt,Haryana");
		l7.setBounds(30, 190, 200, 30);
		l8=new JLabel("Visiblity:");
		l8.setBounds(30, 230, 100, 30);
		l9=new JLabel("9.99km");
		l9.setBounds(90, 230, 100, 30);
		li1=new JLabel("Humadity:");
		li1.setBounds(170, 230, 100, 30);
		li2=new JLabel("70%");
		li2.setBounds(235, 230, 100, 30);
		li3=new JLabel("Wind:");
		li3.setBounds(300, 230, 100, 30);
		li4=new JLabel("16.9kmpl");
		li4.setBounds(340, 230, 100, 30);
		li5=new JLabel("<html><b>MON</b></html>");
		li5.setBounds(30, 270, 100, 30);
		li6=new JLabel("<html><b>TUES</b></html>");
		li6.setBounds(170, 270, 100, 30);
		li7=new JLabel("<html><b>WED</b></html>");
		li7.setBounds(300, 270, 100, 30);
		a1=new JLabel("23");
		a1.setBounds(30, 400, 100, 30);
		a2=new JLabel("33");
		a2.setBounds(90, 400, 100, 30);
		a3=new JLabel("23");
		a3.setBounds(170, 400, 100, 30);
		a4=new JLabel("33");
		a4.setBounds(235, 400, 100, 30);
		a5=new JLabel("23");
		a5.setBounds(300, 400, 100, 30);
		a6=new JLabel("33");
		a6.setBounds(350, 400, 100, 30);
		
		
		
		
		
		jf.add(l1);jf.add(tf);jf.add(b1);jf.add(l2);jf.add(l3);jf.add(l4);jf.add(l5);
		jf.add(l6);jf.add(l7);jf.add(l8);jf.add(l9);jf.add(li1);jf.add(li2);
		jf.add(li3);jf.add(li4);jf.add(li5);jf.add(li6);jf.add(li7);
		jf.add(a1);jf.add(a2);jf.add(a3);jf.add(a4);jf.add(a5);jf.add(a6);
		
//		    setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
		    jf.setSize(500,500);  
		    jf.setLayout(null);  
		    jf.setVisible(true); 
		    
		    
		    try {

	            URL url = new URL("http://api.openweathermap.org/data/2.5/forecast?q=London&appid=eb4c4596b206c10d41a08519926be3d0");

	            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	            conn.setRequestMethod("GET");
	            conn.connect();

	            //Getting the response code
	            int responsecode = conn.getResponseCode();

	            if (responsecode != 200) {
	                throw new RuntimeException("HttpResponseCode: " + responsecode);
	            } else {

	                String inline = "";
	                Scanner scanner = new Scanner(url.openStream());

	                //Write all the JSON data into a string using a scanner
	                while (scanner.hasNext()) {
	                    inline += scanner.nextLine();
	                }

	                //Close the scanner
	                scanner.close();

	               //Using the JSON simple library parse the string into a json object
	                JSONParser parse = new JSONParser();
	                JSONObject data_obj = (JSONObject) parse.parse(inline);

	                
	                JSONArray arr = (JSONArray) data_obj.get("list");

	                for (int i = 0; i < arr.size(); i++) {

	                	JSONObject new_obj = (JSONObject) arr.get(i);
//	      (if we have traverse list=>main)JSONObject new_obj1 = (JSONObject) new_obj.get("main");
	                	
//	                System.out.println(new_obj.get("icon"));
	                	
	                	JSONArray arry = (JSONArray) new_obj.get("weather");
	                	JSONObject new_obj1 = (JSONObject) arry.get(0);
	                	
	                	li7.setText("<html><img src='http://openweathermap.org/img/wn/"+ new_obj1.get("icon") +"@2x.png'></html>");
	                
	                }
	                
	                
//	                l9.setText(""+data_obj.get("visibility"));
//	                li2.setText(""+data_obj.get("humidity"));
	                
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		    
		    
	}

}
