import java.net.*; 
import java.io.*;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EchoServer2b extends Thread { 
	protected static boolean serverContinue = true;
	protected Socket clientSocket;
	
	static int peConnect  = 0;
	static int PORT = 12000;
	//static PrintWriter out;
	static ArrayList<PrintWriter> out = new ArrayList<PrintWriter>();
	static BufferedReader in;
    private static JFrame frame;
	private static TextArea messageArea;
    private static JButton btnNewButton;
    private static JButton btnNewButton_1;
    private static JButton btnNewButton_2;
    private static Label label;
    private static JLabel lblSelect;
    private static TextField textField;
    private static ArrayList<String> nameList = new ArrayList<String>();
    
    EchoServer2b (Socket clientSoc) {
			this.clientSocket = clientSoc;
			//start();
			
				}

	public void run() {
			try { 
				out.add(new PrintWriter(clientSocket.getOutputStream(),true)); 
				in = new BufferedReader( new InputStreamReader( clientSocket.getInputStream())); 
						int loop=out.size();
						for(int i=0;i<loop;++i){
							out.get(i).println("CLASSROOM CLICKER V.1.0");
							out.get(i).println("TEACHER <OK>");	
						}
						
						
					    String inputName;
	        			
	        			  boolean endloop = true;
	        			      	
	        			      while(endloop)
	        			      {
	        			    	  inputName = in.readLine() ;
	        			    	  boolean checkname = true;
	        			    	  
	        			    	  for(int i=0;i<nameList.size();++i )
	        			    	  {
	        			    		if(inputName.equals(nameList.get(i)))
	        			    		{
	        			    			checkname = false;
	        			    		}
	        			    	  }
	        			    	  
	        			    	  if(checkname)
	        			    	  {
	        			    		  
	        			    		  nameList.add(inputName);
	        			    		  int size=nameList.size()-1;
	        			    		  messageArea.append("Student Login is : " + inputName+ "\n");
	        			    		  //int loop=out.size();
	        							//for(int i=0;i<loop;++i){
	        								
	        								out.get(size).println("JOIN OK "+inputName);
	        							//}
	        			    		  
	        			    		  endloop = false;
	        			    	  }
	        			    	  else
	        			    	  {
	        			    		  //for(int i=0;i<loop;++i){
	        								//out.get(i).println("JOIN FAIL "+inputName);
	        								
	        							//}
	        			    		  
	        			    	  }
	        			      }
	        			      String testawser;//wait answer
	        			      String[] array;
	        			      while((testawser=in.readLine())!=null)// in answer	        			    	  
	        			      {
	        			    	  array = testawser.split(" ");
	        			    	  if(array[0].equals("QUIT"))
	        			    	  {
	        			    		  out.get(0).println("GOOD-BYE");
	        			    		 // out.println("KILL");
	        			    		  String test1= in.readLine();
	        			    		  if(test1.equals("TERMINATED"))
	        			    		  {
	        			    			  clientSocket.close();
	        			    		  }
	        			    	  }
	        			    	  else if(array[0].equals("ANSWER"))
	        			    	  messageArea.append(array[2]+"\n");
	        			    	  else
	        			    	  {
	        			    		  out.get(0).println("UNKNOWN");
	        			    	  }
	        			      }
	        			     /*for(int i=0;i<nameList.size();i++){
	        			      		messageArea.append("Online "+"("+nameList.get(i)+")"+"\n");
	        			      	}*/
	        			      		//out.println("JOIN OK "+"["+inputName+"]"); 
  				} 
  			catch (IOException e)  { 
  				messageArea.append("Problem with Communication Server"+ "\n");
  				    System.exit(1); 
  						} 
  				//	peConnect = peConnect;
  				}

		public static void main(String[] args) throws IOException { 
			frame = new JFrame();
			frame.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent arg0) {
					System.exit(0);
				}
			});
			frame.setTitle("T E A C H E R");
			frame.setBounds(100, 100, 534, 398);
			//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			btnNewButton = new JButton("Logout");
			btnNewButton.addActionListener(new ActionListener() {
	           public void actionPerformed(ActionEvent e) {
	            	messageArea.append("Loguot"+ "\n");
	            }
	        });
			btnNewButton.setBounds(376, 326, 119, 23);
			frame.getContentPane().add(btnNewButton);
			
			btnNewButton_1 = new JButton("Yes or No");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					messageArea.append("Click Yes or No"+ "\n");
					for(int i=0;i<out.size();++i){
						out.get(i).println("YN");//out
					}
					
				}
			});
			
			btnNewButton_1.setBounds(376, 285, 119, 40);
			frame.getContentPane().add(btnNewButton_1);	
			
			btnNewButton_2 = new JButton("Multiple Choice");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					messageArea.append("Click Multiple Choice"+ "\n");
					for(int i=0;i<out.size();++i){
						out.get(i).println("MC");//out
					}
	
				}
			});
			btnNewButton_2.setBounds(376, 244, 119, 40);
			frame.getContentPane().add(btnNewButton_2);
			
			lblSelect = new JLabel("Select This");
			lblSelect.setBounds(408, 210, 77, 23);
			frame.getContentPane().add(lblSelect);
			
			messageArea = new TextArea();
			messageArea.setBounds(10, 10, 340, 294);
			frame.getContentPane().add(messageArea);
			
			textField = new TextField();
			textField.setBounds(20, 310, 77, 28);
			textField.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent e) {
	    				}
	         });
			
			frame.getContentPane().add(textField);
			
		    label = new Label("Times");
			label.setBounds(103, 310, 42, 22);
			frame.getContentPane().add(label);
			frame.setVisible(true);
	    	
	    	
			ServerSocket serverSocket = null; 
			try { 
				serverSocket = new ServerSocket(PORT); 
				messageArea.append("Connection Socket Created"+ "\n");
				try { 
						while (serverContinue)
						{
						messageArea.append("Waiting for Connection"+ "\n");
						EchoServer2b  w	= new EchoServer2b (serverSocket.accept());//access
					    Thread t = new Thread(w);
					    t.start();
						peConnect+=1;
						messageArea.append("New  Started  " + peConnect+ " Student\n");
						}
					} catch (IOException e)
						{ 
            	 			messageArea.append("Accept failed."+ "\n");
            	 			System.exit(1); 
						} 
			 } catch (IOException e)
			 			{ 
				 		messageArea.append("Could not listen on port: ."+ "\n");
				 		System.exit(1); 
			 			} 
		finally{
				try {
					serverSocket.close(); 
             		} catch (IOException e){ 
             			messageArea.append("Could not close port: ."+ "\n");
             			System.exit(1); 
             		} 
        		}
   }
} 