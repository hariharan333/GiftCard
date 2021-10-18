import java.util.Scanner;

public class Account {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int ch;
        do{
            System.out.println("1.add account");
            System.out.println("2.get main balance");
            System.out.println("3.create gift card");
            System.out.println("4.view gift card balance");
            System.out.println("5.close gift card");
            System.out.println("6.transaction");
            System.out.println("7.exit");
            ch = scan.nextInt();
            switch (ch)
            {
                case 1:
                {
                    System.out.println("enter your details");
                    System.out.println("enter your name");
                    String name = scan.next();
                    System.out.println("enter your age");
                    int age = scan.nextInt();
                    User u = new User(name,age);
                    u.userDetails(u);
                    break;
                }
                case 2:
                {
                    User u = new User();
                    System.out.println("enter your account number");
                    int accNo = scan.nextInt();
                    u.getMainBalance(accNo);
                    break;
                }
                case 3:
                {
                    User u = new User();
                    System.out.println("enter your account number");
                    int accNo = scan.nextInt();
                    System.out.println("enter gift card pin and amount :");
                    int gcId = scan.nextInt();
                    //int gcPin = scan.nextInt();
                    int gcAmt = scan.nextInt();
                    u.createGiftCard(accNo,gcId,gcAmt);
                    break;
                }
                case 4:
                {
                    User u = new User();
                    System.out.println("enter your account number :");
                    int accNo = scan.nextInt();
                    System.out.println("enter gift card id and pin :");
                    int gcId = scan.nextInt();
                    int gcPin = scan.nextInt();
                    u.getGiftCardBalance(accNo,gcId,gcPin);
                    break;
                }
                case 5:
                {
                    User u = new User();
                    System.out.println("enter your account number :");
                    int accNo = scan.nextInt();
                    System.out.println("enter gift card id and pin :");
                    int gcId = scan.nextInt();
                    int gcPin = scan.nextInt();
                    u.closeGiftCard(accNo,gcId,gcPin);
                    break;
                }
                case 6:
                {
                    User u = new User();
                    System.out.println("enter your account number :");
                    int accNo = scan.nextInt();
                    System.out.println("enter gift card id and pin :");
                    int gcId = scan.nextInt();
                    int gcPin = scan.nextInt();
                    System.out.println("how much amount you want from your gift card");
                    int buyAmt = scan.nextInt();
                    u.transactionGiftCard(accNo,gcId,gcPin,buyAmt);
                    break;
                }
            }
        }while(ch!=7);
    }


}
