import java.io.*;
/***
 * Title: ATM interface
 * Author: Arpan
 * Functions: 
 * main () - Invocation method
 * validatepin () , withdraw_cash(), depositbycheque() , chech_balance() , change_pin() - other member methods
 */

public class ATM
{//
    int pins[] = {2222 , 2107 , 4281 };
    String names[] = {"MR. GAMBHIR " , "MR. UTHAPPA" , "MR. PANDEY" };
    String account_numbers[] = {"0000023233" , "0000073733" , "0000022223" };
    int balances[] = {12298 , 73983 , 100028 };
int checkpin ;
    InputStreamReader read = new InputStreamReader(System.in);
    BufferedReader buf = new BufferedReader(read);

    public void main()throws IOException
    {//

        System.out.println("               ****     WELCOME TO STATE BANK OF INDIA     ****   ");

        System.out.println();

        checkpin = validatepin ();

        if(checkpin != 3)
        {

            System.out.println("                            WELCOME  "+names[checkpin]+"!");
            System.out.println("                            Acc no "+account_numbers[checkpin]);
            System.out.println();
            
            for(      ;      ;      )
            {
                System.out.println(" 1. Withdraw Cash                                            2.Deposit by Cheque");
            System.out.println();
            System.out.println(" 3. Check Balance                                            4.Change Pin");
            System.out.println();
            
                System.out.println("Enter your choice -- " );
                int q = Integer.parseInt(buf.readLine());
                System.out.println();
                if( q == 1)
                {
                    withdraw_cash();
                }

                else if(q == 2)
                {
                    deposit_by_cheque();
                }

                else if(q == 3)
                {
                    check_balance();
                }
                else if(q == 4)
                {
                    change_pin();
                }
                else 
                {
                    System.out.println("Wrong choice");break;
                }
                System.out.println("Do you want to continue? Type Y for yes or N for no");
                char ch;
                for(      ;      ;      )
                {
                   // System.out.println("Do you want to continue? Type Y for yes or N for no");
                    ch = (char)buf.read();
                    buf.readLine();
                    
                    if( ch == 'Y')
                    {
                        break;
                    }
                    else if( ch == 'N')
                    {
                        break;
                    } 
                    else
                    {
                        System.out.println("Please enter either Y or N");continue;
                    }
                
                }
                if( ch == 'Y')
                {
                    continue;
                }
                else if ( ch == 'N')
                {
                    System.out.println("                          THANKYOU FOR VISITING      ");
                    break;
                } 
            }
            }
        
        else
        { 
            
        }
    }

    public int validatepin()throws IOException
    {

        int output;  
        for(int i = 1; true ;i++)

        {
            System.out.println(" Please enter your 4 digit PIN -- ");

            int userinput = Integer.parseInt(buf.readLine());

            if( userinput == pins[0] )
            { 
                output = 0; break;
            }
            else if( userinput == pins[1] )
            { 
                output = 1; break;
            }
            else if( userinput == pins[2] )
            { 
                output = 2; break;
            }

            else
            {
                System.out.println("Wrong PIN please try again");
            }

            if ( i == 3)

            {

                System.out.println("Maximum choices exceeded");

                output = 3;
                break;
            }
        }

        return output;
    }

    public void withdraw_cash() throws IOException
    {
        for(   ;true;   )
        {

            System.out.println("Enter the amount to withdraw (multiples of 100)");
            int mon = Integer.parseInt(buf.readLine());
            System.out.println();
            int q1000 = mon/ 1000;
            int q500 = (mon % 1000)/500;
            int q100 = ((mon% 1000)%500)/100;
            
            for ( ; ;)
            {
                if (mon == q1000*1000+q500*500+q100*100) {
                    break;
                } else {
                    System.out.println("Enter a valid amount to withdraw (multiples of 100)");
                    mon = Integer.parseInt(buf.readLine());
                    q1000 = mon/ 1000;
                    q500 = (mon % 1000)/500;
                    q100 = ((mon% 1000)%500)/100;
                    
                }
            }
            
            if(mon > balances[checkpin])
            {
                System.out.println("Insufficient Balance");
                continue;
            }

            else

            {

                System.out.println("YOUR TRANSACTION IS BEING PROCESSED");
                System.out.println();
              if(q1000 != 0)
              System.out.println("You will recieve "+q1000 +" 1000 rupees notes");
                      
               if(q500 != 0)
              
                  System.out.println("You will recieve "+q500 +" 500 rupees notes");
                  if(q100 != 0)
              
                  System.out.println("You will recieve "+q100+ " 100 rupees notes");

                System.out.println();

                System.out.println("Remaining balance is RS. "+(balances[checkpin]-mon));

                System.out.println();


                break;
                

            }
        }
    }

    public void deposit_by_cheque() throws IOException
    {
        System.out.println("Enter the amount to be deposited by cheque");
        int dep = Integer.parseInt(buf.readLine());
        System.out.println("Enter the cheque number");
        String s3 = buf.readLine();
        System.out.println();
        System.out.println("Amount deposited is - RS."+balances[checkpin]);
        System.out.println("Cheque number -"+s3);
        System.out.println("Account number = "+account_numbers[checkpin]);
        System.out.println("New Balance is "+(balances[checkpin] + dep));

    }

    public void check_balance()throws IOException
    {
        System.out.println("Current balance is -"+balances[checkpin]);

    }

    public void change_pin()throws IOException
    {
        System.out.println("Enter old pin");
        int w2 = Integer.parseInt(buf.readLine());

        if(w2 == pins[checkpin])
        {System.out.println("Enter new pin");
            int w3 = Integer.parseInt(buf.readLine());
            System.out.println("Re enter new pin");
            int w4 = Integer.parseInt(buf.readLine());
            if(w3 == w4)
            {
                pins[checkpin] = w2;
                System.out.println("Pin changed");
            }
            else
            {
                System.out.println("Kya kar raha hai be theek se pin dal");
            }
        }

    }

}