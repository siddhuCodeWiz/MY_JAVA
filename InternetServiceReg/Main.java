package InternetServiceReg;
import java.util.*;

public class Main {
    public static void main(String args[]){
        Registration newReg;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        long[] telephoneNo = new long[2];
        System.out.print("Enter your 1st Phone Number: ");
        telephoneNo[0] = sc.nextLong();
        System.out.print("Enter your 2nd Phone Number: ");
        telephoneNo[1] = sc.nextLong();
        sc.nextLine();

        System.out.print("Do you have a passport (y/n): ");
        String op = sc.nextLine();
        if(op.charAt(0) == 'y'){
            System.out.print("Enter your passport number: ");
            String pass = sc.nextLine();
            newReg = new Registration(name, pass, telephoneNo);

            long[] t = newReg.getTelephoneNo();

            System.out.println("Congratulations " + newReg.getCustomerName() + "!!! you have been successfully registered for our services with the following details: \n Passport number: "+newReg.getPassportNo()+ "\n Telephone Number: "+ t[0] + "\n" + t[1]);
        }
        else{
            System.out.println("Select a option: \n1. License No and Pan Card No \n2. VoterId and License No \n3. Pan Card No and Voter Id\nChoose a option: ");
            int opt = sc.nextInt();
            sc.nextLine();

            int li;String pan;int vot;long[] t;

            switch(opt){
                case 1:
                    System.out.print("Enter your License number: ");
                    li = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter your Pan Card number: ");
                    pan = sc.nextLine();
                    newReg = new Registration(name, li, pan, telephoneNo);
                    t = newReg.getTelephoneNo();
                    System.out.println("Congratulations " + newReg.getCustomerName() + "!!! you have been successfully registered for our services with the following details: \nLicense number: "+newReg.getLicenseNo()+ "\nPan card Number: "+ newReg.getPanCardNo() + "\nTelephone Number: "+ t[0] + "\n" + t[1]);

                    break;

                case 2:
                    System.out.print("Enter your VoterID number: ");
                    vot = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter your License number: ");
                    li = sc.nextInt();
                    sc.nextLine();
                    newReg = new Registration(name, vot, li, telephoneNo);

                    t = newReg.getTelephoneNo();
                    System.out.println("Congratulations " + newReg.getCustomerName() + "!!! you have been successfully registered for our services with the following details: \nVoterID number: "+newReg.getVoterId()+ "\nLicense Number: "+ newReg.getLicenseNo() + "\nTelephone Number: "+ t[0] + "\n" + t[1]);
                    break;

                case 3:
                    System.out.print("Enter your Pan Card number: ");
                    pan = sc.nextLine();
                    System.out.print("Enter your Voter number: ");
                    vot = sc.nextInt();
                    sc.nextLine();
                    newReg = new Registration(name, pan, vot, telephoneNo);

                    t = newReg.getTelephoneNo();
                    System.out.println("Congratulations " + newReg.getCustomerName() + "!!! you have been successfully registered for our services with the following details: \nPan card number: "+newReg.getPanCardNo()+ "\nVoterID Number: "+ newReg.getVoterId() + "\nTelephone Number: "+ t[0] + "\n" + t[1]);
                    break;

                default:
                    System.out.println("Invalid Option! Registration Unsuccessful..");
            }
        }
        sc.close();
    }
    
}
