
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SimiBot extends JFrame implements ActionListener
{
	static JTextArea area=new JTextArea();
	JTextField field=new JTextField();
	JScrollPane sp;
	JButton send;
	LocalTime time=LocalTime.now();
	LocalDate date=LocalDate.now();
	Random random=new Random();

	public SimiBot(String title)
	{
		super(title);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		getContentPane().setBackground(Color.WHITE);
		field=new JTextField();
		send=new JButton("Enter");
		send.setFont(new Font("Serif",Font.BOLD,12));
		send.setBackground(Color.white);

		send.setBounds(700,520,70,35);
		add(send);
		//For Text area
		area.setEditable(false);
		area.setBackground(Color.black);
		area.setForeground(Color.green);
		area.setSelectedTextColor(Color.green);
		add(area);
		area.setFont(new Font("Serif",Font.PLAIN,20));
		//scrollbar
		sp=new JScrollPane(area,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sp.setBounds(10,20,765,470);
		add(sp);
			
		//For TextField
		field.setSize(690,35);
		field.setLocation(10,520);
		field.setForeground(Color.black);
		
		field.setFont(new Font("Serif",Font.BOLD,25));
		add(field);
		
		send.addActionListener(this);
		getRootPane().setDefaultButton(send);
		
		
	}
	public void actionPerformed(ActionEvent e)
	{
		String message=field.getText().toLowerCase();

		area.append("You : "+field.getText()+"\n");
		field.setText("");
		Socket sock=new Socket();
		
		
		if(message.contains("how are you"))
		{
			int num=random.nextInt(3);
			if(num==0)
			{
			bot("I'm fine !,What about you ? ");
			}
			else if(num==1)
			{
				bot("I am good , thanks for asking !");
			}
			else 
			{
				bot("I am great ,thanks for asking !");
			}
		
		}
		else if(message.contains("you")&&(message.contains("smart")||message.contains("good")))
		{
			bot("Thank you !");
		}
		else if(message.contains("welcome"))
		{
			bot("You are so polite.How can i help you ?");
		}
		
		else if(message.contains("hi")&&message.charAt(0)=='h'||message.contains("hello")||message.contains("hey"))
		{
			
			int num=random.nextInt(3);
			if(num==0)
			{
			bot("Hii");
			}
			else if(num==1)
			{
				bot("Hello");
			}
			else if(num==2)
			{
				bot("Heyy");
			}
			else if(num==3)
			{
				bot("hello buddy");
			}
		}
		else if(message.contains("by"))
		{
			bot("Byy,See you soon ..!");
		}
		else if(message.contains("i am good")||message.contains("i am great")||message.contains("i am ")&&message.contains("fine"))
		{
			
			bot("Good to hear.");
		}
		else if(message.contains("thank"))
		{
			int num=random.nextInt(3);
			if(num==0)
			{
			bot("Welcome..");
			}
			else if(num==1)
			{
				bot("My plesure");
			}
			else if(num==2)
			{
				bot("Happy to help");
			}
			else if(num==3)
			{
				bot("That's why i'm here for..");
			}
		}
		else if(message.contains("what") || message.contains("name"))
		{
			if(message.contains("your"))
			{
				bot("I'm SimiBot...");
			}

		}
		else if(message.contains("change"))
		{
			bot("Sorry,I can't change anything...");
		}
		else if( message.contains("time"))
		{
		
			String ctime=new String();
			if(time.getHour()>12)
			{
				int hour=time.getHour()-12;
				ctime=ctime+hour+":"+time.getMinute()+":"+time.getSecond()+" PM";
			}
			
			else
			{
				
				ctime=ctime+time.getHour()+":"+time.getMinute()+":"+time.getSecond()+" AM";
			}
			bot(ctime);
			
			
		}
		else if(message.contains("date")||message.contains("month")||message.contains("year")||message.contains("day"))
		{
		
			String cdate=new String();
			cdate=cdate + date.getDayOfWeek()+","+date.getDayOfMonth()+" "+date.getMonth()+" "+date.getYear();
			bot(cdate);
			
			
		}

		else if(message.contains("good morning"))
		{
			
				bot("Good morning,Have a nice day !");
		
		}
		else if(message.contains("good night"))
		{
			
			bot("Good night,Have a nice dreams !");
		
		}
		else if(message.contains("good evening"))
		{
			
			bot("Good Evening ...!");
		
		}
		else if(message.contains("good") && message.contains("noon"))
		{
			
			bot("Good Afternoon ...!");
		
		}
		
		else if(message.contains("clear")&&(message.contains("screen")||message.contains("chat")))
		{
			bot("wait a few second...");
			area.setText("");
		}
		
		else if(message.contains("open youtube")||message.contains("youtube")||message.contains("yt")) {
			bot("Opening youtube");
			Desktop d = Desktop.getDesktop();
			try {
				d.browse(new URI("https://www.youtube.com/"));
			} catch (IOException | URISyntaxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		else 
		{
			
			
				try
				{
					URL url=new URL("https://google.co.in");
					URLConnection connection=url.openConnection();
					connection.connect();
					bot("Sorry can't understand");
					bot("Here some results for you ...");
					java.awt.Desktop.getDesktop().browse(java.net.URI.create("http://www.google.com/search?hl=en&q="+message.replace(" ", "+")+"&btnG=Google+Search"));
			
				}
				catch(Exception ee)
				{
					bot("Connect with internet connection for get better results..."); // No connection 
				}
				
			
		
		}
		
	}
	public static boolean bot(String message)
	{
		area.append("Bot : "+message+"\n");
		return false;
	}
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		SimiBot cb=new SimiBot("Chat Bot");
		cb.setSize(800,605);
		cb.setLocation(50,50);	
		bot("Hi there");
	}
}

   
