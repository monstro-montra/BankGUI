import java.awt.*; //import awt
import java.awt.event.ActionListener; //import action listener
import java.awt.event.ActionEvent; //import action event
import javax.swing.*; //import Swing


public class BankGUI extends JFrame{
    //create instance variables
    private JFrame mainMenu = new JFrame();
    private JPanel menuPanel = new JPanel(); // panel that links both button and display panels
    private JPanel buttonPanel = new JPanel(); // panel for the buttons
    private JPanel displayPanel = new JPanel(); //panel to display information
    private String firstName; //for use in user input 
    private String lastName; //for use in user input 
    private int accountID; //for use in user input 
    private JLabel displayBalance, firstNameLabel, lastNameLabel, accountIDLabel; //labels
    private double balance = 1000; //starting balance will be set to 100
    private JButton btn1 = new JButton("Deposit"); //deposit button
    private JButton btn2 = new JButton("Withdraw"); //withdraw button
    private JButton btn3 = new JButton("Display Account Information"); //account info button
    private JButton btn4 = new JButton("Account Setup"); //setup account
    private JButton btn5 = new JButton("Exit"); //exit button
    

    
    
    
    //main method
    public static void main(String[] args){
        run(); //call the run method
    }

    //static run method to run the all of the creation/setup methods. static so it can be passed on to main method 
    //without need for easily creating a new object in main
    public static void run(){
        BankGUI run = new BankGUI();
        run.createMenuFrame(); //first, create frame
        run.menu(); //then create menu panel which contains both the display panel and the button panel. 
        run.displayLabels(); // run displayLabels method, but it won't actually display anything until the btn3 (display button) button is pressed.
        run.setupButtons(); //runs setupButtons method to add functionality to all the buttons
        
    }

    //method used to create the frame
    public void createMenuFrame(){ //step one
        mainMenu.getContentPane();
        final int P_WIDTH = 600; //set width to 600 pixels
        final int P_HEIGHT = 600; //set height to 600 pixels
        mainMenu.setSize(P_WIDTH, P_HEIGHT); //set size to P_WIDTH and P_HEIGHT respectively
        mainMenu.setTitle("Bank Account");
        mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //set default close operation to exit on close
        mainMenu.setVisible(true); //set the frame to visible
        mainMenu.add(menuPanel);

    }


    //method used to create the main panel, display panel, and the button panel
    public void menu(){

        //set top left bottom and right borders of panel
        menuPanel.setBounds(0 ,0 , 600, 600); //the bounds are set in the form: x, y, width, height
        
        /*following linesets the jpanel layout to a grid layout in form rows, columns. setting up as two rows to 
        have two separate panels*/
        menuPanel.setLayout(new GridLayout(2,1)); 
        displayPanel.setBackground(Color.LIGHT_GRAY); //this will set the top panel to a light gray color to show separation

        displayPanel.setLayout(new GridLayout(1,4)); //set the layout so that it has one row and 4 columns
        buttonPanel.setLayout(new GridLayout(5, 1)); //set th e layout so that is has 5 rows and 1 column
        

        menuPanel.add (displayPanel); //add the displayPanel to the menuPanel in row 1
        menuPanel.add(buttonPanel); // add buttonPanel to the menuPanel in row 2

    }       

    //method used to setup the buttons
    public void setupButtons(){
        //btn1 deposit setup
        btn1.setSize(100, 20); //set the size of button: width, height
        btn1.addActionListener(new ActionListener(){ //create anonymous ActionListener inner class for this button
            @Override //following method must be overriden
            public void actionPerformed(ActionEvent e){ //boiler plate. required to have this method for AL's
                double userNum = Double.parseDouble(JOptionPane.showInputDialog(displayPanel, "Type in how much you would like to deposit"));
                balance += userNum; // this means balance = balance + userNum
                displayBalance.setText("Balance " + balance); //set the display text of displayBalance label to this
            }

        });
        buttonPanel.add(btn1);// add this button to the main menu panel

        //btn2 withdraw setup
        btn2.setBounds(20, 400, 100, 20); //set the size of button: width, height
        btn2.addActionListener(new ActionListener(){ //create anonymous ActionListener inner class for this button
            @Override //following method must be overriden
            public void actionPerformed(ActionEvent e){ //boiler plate. required to have this method for AL's
                double userNum = Double.parseDouble(JOptionPane.showInputDialog(displayPanel, "Type in how much you would like to withdraw"));
                balance -= userNum; //this means balance = balance - userNum
                displayBalance.setText("Balance " + balance); //set the display text of displayBalance label to this
            }

        });
        buttonPanel.add(btn2);// add this button to the main menu panel

        //btn3 display account infosetup
        btn3.setBounds(20, 400, 100, 20); //set the size of button: width, height
        btn3.addActionListener(new ActionListener(){ //create anonymous ActionListener inner class for this button
            @Override //following method must be overriden
            public void actionPerformed(ActionEvent e){ //boiler plate. required to have this method for AL's
                
                if(!firstNameLabel.isVisible()){ //if firstNameLabel is not visible
                    firstNameLabel.setVisible(true); //set it to visible
                }

                if(!lastNameLabel.isVisible()){ //if lastNameLabel is not visible
                    lastNameLabel.setVisible(true); //set to visible
                }

                if(!accountIDLabel.isVisible()){ //if accountIDLabel is not visible
                    accountIDLabel.setVisible(true); //set to visible
                }

                if(!displayBalance.isVisible()){ //if displayBalance is not visible
                    displayBalance.setVisible(true); //set to visible
                }
            }

        });
        buttonPanel.add(btn3);// add this button to the main menu panel

        //btn4 account setup button 
        btn4.setBounds(20, 400, 100, 20); //set the size of button: width, height
        btn4.addActionListener(new ActionListener(){ //create anonymous ActionListener inner class for this button
            @Override //following method must be overriden
            public void actionPerformed(ActionEvent e){ //boiler plate. required to have this method for AL's
                firstName = (String)JOptionPane.showInputDialog(displayPanel, "Type in your first name");
                lastName = (String)JOptionPane.showInputDialog(displayPanel, "Type in your last name");
                accountID = Integer.parseInt(JOptionPane.showInputDialog(displayPanel, "Type in your account ID"));

                //update the labels with the new values
                firstNameLabel.setText("First Name: "+ firstName);
                lastNameLabel.setText("Last Name: "+ lastName);
                accountIDLabel.setText("Account ID Name: "+ accountID);
            }

        });
        buttonPanel.add(btn4);// add this button to the main menu panel

        //btn 5 exit button
        btn5.setBounds(20, 400, 100, 20); //set the size of button: width, height
        btn5.addActionListener(new ActionListener(){ //create anonymous ActionListener inner class for this button
            @Override //following method must be overriden
            public void actionPerformed(ActionEvent e){ //boiler plate. required to have this method for AL's
                 System.exit(0);
            }

        });
        buttonPanel.add(btn5);
    }



    //method used to display labels
    public void displayLabels(){
        displayBalance = new JLabel("Balance: " + balance); //instantiation
        firstNameLabel = new JLabel("First Name: " + firstName); //instantiation 
        lastNameLabel = new JLabel("Last Name: " + lastName); // instantiation
        accountIDLabel = new JLabel("Account ID: " + accountID); //instantiation

        //set them equal to false initially
        firstNameLabel.setVisible(false);
        lastNameLabel.setVisible(false);
        accountIDLabel.setVisible(false);
        displayBalance.setVisible(false);

        //add all labels to the display panel
        displayPanel.add(firstNameLabel);
        displayPanel.add(lastNameLabel);
        displayPanel.add(accountIDLabel);
        displayPanel.add(displayBalance);
    }

}
