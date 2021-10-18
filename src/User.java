import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    int age,amt,bal;String name;static int accNO=0,giftId=100;
    //account
    static Map<Integer,Integer> m = new HashMap<>();
    //gift card
    static Map<Integer,Map<Integer,Integer>> giftCard = new HashMap<>();
    static Map<Integer,Integer>g = new HashMap<>();
    //gift card amount
    static Map<Integer,Integer>amount = new HashMap<>();
    static Map<Integer,Map<Integer,Integer>>gamt = new HashMap<>();
    //list of users
    static List<String> l = new ArrayList<>();

    User(){};
    User(String name,int age)
    {
        this.name = name;
        accNO = accNO+1;
        this.age = age;
        String rec = name+" "+age;
        l.add(rec);
        m.put(accNO,5000);
    }
    public void userDetails(User u)
    {
        System.out.println(u.name +" "+u.age +" "+accNO);
        System.out.println("your account is successfully added");
    }
    public void getMainBalance(int accNO)
    {
        System.out.println("user name and age");
        System.out.println(l.get(accNO-1));
        System.out.println("balance amount = "+m.get(accNO));
    }
    public void createGiftCard(int accNO,int GCpin,int GCAmount)
    {
        if(m.get(accNO)<GCAmount)
            System.out.println("you can't create gift card .because you don't have sufficient amount for in your account");
        else
        {
            m.put(accNO,m.get(accNO)-GCAmount);
            giftId +=1;
            g.put(giftId,GCpin);
            giftCard.put(accNO,g);

            amount.put(giftId,GCAmount);
            gamt.put(accNO,amount);

            System.out.println(giftId+" "+"successfully created");
            System.out.println("main balance = "+m.get(accNO));
        }
    }
    public void getGiftCardBalance(int accNO,int GCid,int GCpin)
    {

        if(m.containsKey(accNO) && giftCard.get(accNO).containsKey(GCid))
        {
            if(GCpin == giftCard.get(accNO).get(GCid))
                System.out.println("gift card balance amount = "+gamt.get(accNO).get(GCid));
            else
                System.out.println("your gift card pin is wrong");
        }
        else
            System.out.println("gift card doesn't exit");
    }
    public void closeGiftCard(int accNO,int GCid,int GCpin)
    {
        if(m.containsKey(accNO) && giftCard.get(accNO).containsKey(GCid))
        {
           // System.out.println(giftCard.get(accNO).get(GCid));
            if(GCpin == giftCard.get(accNO).get(GCid))
            {
                int val = gamt.get(accNO).get(GCid);
                giftCard.get(accNO).remove(GCid);
                gamt.get(accNO).remove(GCid);
                val += m.get(accNO);
                m.put(accNO,val);
                System.out.println("successfully close your gift card");
            }
            else
                System.out.println("your gift card pin is wrong");
        }
        else
            System.out.println("gift card doesn't exit");

    }
    public void transactionGiftCard(int accNO,int GCid,int GCpin,int buyAmt) {
        if(m.containsKey(accNO) && giftCard.get(accNO).containsKey(GCid))
        {
            //System.out.println(giftCard.get(accNO).get(GCid));
            if (GCpin == giftCard.get(accNO).get(GCid)) {
                if(gamt.get(accNO).get(GCid)<buyAmt)
                    System.out.println("your gift don't have sufficient amount for this particular transaction");
                else
                {
                    int val = gamt.get(accNO).get(GCid);
                    amount.put(GCid,val-buyAmt);
                    gamt.put(accNO,amount);
                    System.out.println("Transaction successfully");
                    System.out.println("gift card balance");
                    System.out.println(gamt.get(accNO).get(GCid));
                }
            } else
                System.out.println("your gift card pin is wrong");
        }
        else
            System.out.println("gift card doesn't exit");
    }
}
