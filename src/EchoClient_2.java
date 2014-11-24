import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
//import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class EchoClient_2 {
	static int PORT = 12000; 
	    static Socket echoSocket	 = null; // open channel communication
        static PrintWriter out		 = null; // send message to server
        static BufferedReader in 	 = null;
        static BufferedReader stdIn ;
	 	static String nameOk;
	 	static String[] str;
        static BufferedReader inputFile;
		static String ip;
        
        private static JTextField textField;
    	private static TextArea textArea ;
		private static JFrame frame;
		private static String name ;
		private static JButton btnLogout;
		private static JButton btnYes;
		private static JButton btnNo;
		private static JButton btnA;
		private static JButton btnB;
		private static JButton btnC;
		private static JButton btnD;
		private static JLabel lblYesOrNo;
		private static JLabel lblAbcdChoice ;
		
		
	public static void main(String[] args) throws IOException {
		frame = new JFrame();
		frame.setBounds(100, 100, 471, 371);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		 textArea = new TextArea();
		textArea.setBounds(10, 10, 332, 289);
		frame.getContentPane().add(textArea);
		
		btnLogout = new JButton("Logout");
		btnLogout.setBounds(352, 301, 89, 23);
		frame.getContentPane().add(btnLogout);
		
		btnYes = new JButton("YES");
		btnYes.setBounds(352, 55, 89, 23);
		frame.getContentPane().add(btnYes);
		
		btnNo = new JButton("NO");
		btnNo.setBounds(352, 84, 89, 23);
		frame.getContentPane().add(btnNo);
		
		btnA = new JButton("A");
		btnA.setBounds(352, 148, 89, 23);
		frame.getContentPane().add(btnA);
		
		btnB = new JButton("B");
		btnB.setBounds(352, 178, 89, 23);
		frame.getContentPane().add(btnB);
		
		btnC = new JButton("C");
		btnC.setBounds(352, 207, 89, 23);
		frame.getContentPane().add(btnC);
		
	    btnD = new JButton("D");
		btnD.setBounds(352, 234, 89, 23);
		frame.getContentPane().add(btnD);
		
		lblYesOrNo = new JLabel("YES or NO Choice");
		lblYesOrNo.setBounds(356, 30, 85, 14);
		frame.getContentPane().add(lblYesOrNo);
		
		lblAbcdChoice = new JLabel("ABCD Choice");
		lblAbcdChoice.setBounds(356, 123, 85, 14);
		frame.getContentPane().add(lblAbcdChoice);
		
		btnYes.setEnabled(false);
		  btnNo.setEnabled(false);
		  btnA.setEnabled(false);
		  btnB.setEnabled(false);
		  btnC.setEnabled(false);
		  btnD.setEnabled(false);
		  
		  btnLogout.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//String mgs;
				out.println("QUIT");
				//in.readLine();
				
			}
		});
		  
		  btnYes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				out.println("ANSWER QUESTION Yes");
			}
		});
		  
		  btnNo.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					out.println("ANSWER QUESTION No");
				}
			});
		  
		  btnA.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					out.println("ANSWER QUESTION A");
				}
			});
		  
		  btnB.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					out.println("ANSWER QUESTION B");
				}
			});
		  
		  btnC.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					out.println("ANSWER QUESTION C");
				}
			});
		  
		  btnD.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					out.println("ANSWER QUESTION D");
				}
			});
		  
		// inser no a b c d 
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {// Add Listeners
    		public void actionPerformed(ActionEvent e) {
    			String str = textField.getText();
    			out.println(str);
    			textArea.append(name+" send ->"+str+"\n");
    			textField.setText("");	}
    });
		
		textField.setBounds(10, 305, 332, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		frame.setVisible(true);
		
		/*FileReader freader = new FileReader("data1.txt");
	    inputFile = new BufferedReader(freader);
	    ip = inputFile.readLine();*/  //READ FILE
		
	    String serverHostname = new String ("127.0.0.1");
		//String serverHostname = new String ("localhost");//access
		textArea.append("Connecting to Host " +serverHostname + "\n");
		System.out.println("HHH");
        try {
        	
            echoSocket = new Socket(serverHostname, PORT); //client start
            	System.out.println("KKK");
            	out = new PrintWriter(echoSocket.getOutputStream(), true);
            	in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
        } catch (UnknownHostException e) {
        			//System.err.println("Don't know about host: " + serverHostname);
        	textArea.append("Don't know about host: " + serverHostname+ "\n");
        			System.exit(1);
        } catch (IOException e) {
        			//System.err.println("Couldn't get I/O for "  + "the connection to: " + serverHostname);
        	textArea.append("Couldn't get I/O for "  + "the connection to: " + serverHostname+ "\n");
        			System.exit(1);
        }
        
        
       
        stdIn = new BufferedReader( new InputStreamReader(System.in));
               String inputLine;
        	   		inputLine = in.readLine() ;
        			textArea.append("TEACHER RESPONSE:: " + inputLine+ "\n");
        		 	inputLine = in.readLine() ;
        		 	textArea.append("TEACHER RESPONSE:: " + inputLine+ "\n");
        	   /////
        		 	
        		 	boolean checkname = true;

        		 	while(checkname)
        		 	{
        		 		
        		 		name =  JOptionPane.showInputDialog(frame,"Choose a screen ID:","Screen ID selection", 
        				 										JOptionPane.PLAIN_MESSAGE);
        		 		//System.out.println(name);
        		 		textArea.append(name+" ");
        		 		out.println(name);
        		 		nameOk = in.readLine() ;
        		 		str = nameOk.split(" ");
        		 		
        		 		if(str[1].equals("OK"))
        		 			checkname = false;
        		 		else System.out.println("NOOO");
        		 		//System.out.println(str[1]);
        		 		textArea.append(str[1]+"\n");
        		 	}
        	            //textArea.append(str[2] +"\n");
        	  //// 
        	  boolean test =true;
        	
        	  String chq;
        	  while(( chq= in.readLine())!=null)        			  
        	  {
        		  //System.out.println(chq+" ");
        		  String[] array = chq.split(" "); 
        		  textArea.append(chq +"\n");
        		  System.out.println(chq);
    //    		  if(array[0].equals("QUESTION"))
    //    		  {
	        		  if(chq.equals("YN"))
	        		  {
	        			  btnYes.setEnabled(true);
	        			  btnNo.setEnabled(true);
	        			  btnA.setEnabled(false);
	        			  btnB.setEnabled(false);
	        			  btnC.setEnabled(false);
	        			  btnD.setEnabled(false);
	        			  
	        			  
	        		  }
	        		  else if(chq.equals("MU"))
	        		  {
	        			  btnYes.setEnabled(false);
	        			  btnNo.setEnabled(false);
	        			  btnA.setEnabled(true);
	        			  btnB.setEnabled(true);
	        			  btnC.setEnabled(true);
	        			  btnD.setEnabled(true);
	        		  }
   //     		  }
        		 /* else if(array[0].equals("GOOD-BYE"))
        		  {
        			  if(in.readLine().equals("KILL"))
        			  {
        				  echoSocket.close();
        			  }
        		  }*/
        		 
        		  // Scanner sc = new Scanner(System.in);
        		 // String awser = sc.nextLine();
        		  
        	 }
        	
        		 
        	
        String userInput1;
		while ((userInput1 = stdIn.readLine()) != null)  {
    		     //out.println(userInput);
    			if (userInput1.equals("QUIT")){
    				out.println(userInput1);
    				break;
    			}
    			if(userInput1.equals("GOOD-BYE")){
    				echoSocket.close();
    			}
    			
    	} 
        	out.close();
        	in.close();
        	stdIn.close();
        	echoSocket.close();
        	
    }
}
