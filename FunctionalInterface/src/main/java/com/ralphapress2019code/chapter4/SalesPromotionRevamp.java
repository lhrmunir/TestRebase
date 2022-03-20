package com.ralphapress2019code.chapter4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
/*
        Please visit below page to understand BiFunction + Generic
 */
class CustomerRevamp
{
    String name;
    String phoneNum; 
    String sport;
    String team;
    double gpa;
    String subject;
    int    numFriends;
    String friends;

    public CustomerRevamp(String n, String pn, String sp, String t, double g, String s, int nf, String f)
    {
        name = n;
        phoneNum = pn;
        sport = sp;
        team = t;
        gpa = g;
        subject = s;
        numFriends = nf;
        friends = f;
    }
} // class Customer ends here

abstract class RecordRevamp
{
    String name;
    String phoneNum;
    int index;
    public RecordRevamp(String n, String pn, int i)
    { 
        name = n;
        phoneNum = pn;
        index = i;
    }

    @Override 
    public String toString() { 
        return "name: " + name + " phone number: " + phoneNum; 
    }
} // abstract class Record ends here

class SportRecordRevamp extends RecordRevamp
{
    String team;
    public SportRecordRevamp(String n, String pn, int i, String t)
    {
        super(n, pn, i);
        team = t;
    }
    @Override
    public String toString() { 
        return super.toString() + " favorite team is the " + team; 
    }
} // class SportRecord ends here

class GpaRecordRevamp extends RecordRevamp
{
    String subject;
    public GpaRecordRevamp(String n, String pn, int i, String s)
    {
        super(n, pn, i);
        subject = s;
    }
    @Override
    public String toString() { 
        return super.toString() + " favorite subject is " + subject; 
    }
} // class GpaRecord ends here

class FriendsRecordRevamp extends RecordRevamp
{
    String friends;
    public FriendsRecordRevamp(String n, String pn, int i, String f)
    {
        super(n, pn, i);
        friends = f;
    }

    @Override
    public String toString() { 
        return super.toString() + " friends are " + friends; 
    }
}

public class SalesPromotionRevamp
{
    final static CustomerRevamp[] customers = {
            new CustomerRevamp("John Smith",    "9084321212", "football", "Giants", 3.61, null     , 0, null),
            new CustomerRevamp("Indira Patel" , "7325551234", "tennis" ,  null    , 3.92, "Java"   , 0, null),
            new CustomerRevamp("Sarah Johnson", "2123231245", "football", "Eagles", 3.71, null     , 1, "Jane Hernadez,2017765765"),
            new CustomerRevamp("Javier Jones" , "8568768765", "golf",     null ,    3.85, "Physics", 1, "Maria Regina,9086547654"),
            new CustomerRevamp("Football Man",  "9084321212", "football", "Giants", 3.61, null     , 0, null),
            new CustomerRevamp("Techie Man" ,   "7325551234", "tennis" ,  null    , 3.92, "Java"   , 0, null),
            new CustomerRevamp("Imran Khan" , "8568768765", "golf",     null ,    3.85, "Physics", 1, "Nawaz Sharif,9086547654"),
        };

    //                                                            < BiFunction<CustomerRevamp, Integer, ? extends RecordRevamp> >
    // private static void matchCustomers(CustomerRevamp c, ArrayList< BiFunction<CustomerRevamp,  Integer, ? extends RecordRevamp> > arrListFunc)
    private static void matchCustomers(CustomerRevamp c, BiFunction<CustomerRevamp,  Integer, ? extends RecordRevamp> bif)
    {
        System.out.println("---------------- All Searched Records are Given Below ---------------");
//        for (int j=0; j < arrListFunc.size(); ++j)
//        {
            RecordRevamp record;
            int index = 0;
            do
            {
                // record = arrListFunc.get(j).apply(c, index);  // APPLYING FUNCTION
                record = bif.apply(c, index);  // APPLYING FUNCTION

                if (record != null)
                {
                    System.out.println(".[." + record + ".].");
                    index = record.index + 1;
                }
            } while (record != null);
//        }
        System.out.println("----------- matchCustomers execution completed..... ------------");
    }

    /*
          Please visit https://mkyong.com/java8/java-8-bifunction-examples/
          to see returning generic list from BiFunction
          e.g.

          public <T, U, R> List<R> filterList(List<T> list1, U condition, BiFunction<T, U, R> func) {
     */

    private static  <R> List<R>  matchCustomers2(CustomerRevamp c, BiFunction<CustomerRevamp,  Integer, List<R>> bif)
    {
        System.out.println("---------------- All Searched Records are Given Below ---------------");

        List<R> result = new ArrayList<>();

        // List<RecordRevamp> record;
        List<R> lstRecord; //  = new ArrayList<>();


        int index = 0;
//        do
//        {
            // record = arrListFunc.get(j).apply(c, index);  // APPLYING FUNCTION
            lstRecord = bif.apply(c, index);  // APPLYING FUNCTION

            if (lstRecord != null)
            {
                // System.out.println(".[." + lstRecord + ".].");
                lstRecord.forEach(System.out::println);
                // index = record.index + 1;
                index = 5;
            }
//        } while (lstRecord != null);

        System.out.println("----------- matchCustomers execution completed..... ------------");

        return lstRecord;
    }



    public static void main(String[] args)
    {
        // BiFunction<Customer, Integer, SportRecord> fsport = (x, z) -> {
        BiFunction<CustomerRevamp, Integer, List<SportRecordRevamp>> fsport = (x, z) -> {

            // SportRecordRevamp sport = null;
            List<SportRecordRevamp> lstSport = new ArrayList<>();

            // for (int i=z; i < customers.length && sport == null; ++ i) {
            Arrays.stream(customers).forEach(cust -> {
                if (cust.sport.equals(x.sport)) {
                    // sport = new SportRecordRevamp(customers[i].name, customers[i].phoneNum, i, customers[i].team);
                    lstSport.add(new SportRecordRevamp(cust.name, cust.phoneNum, lstSport.size(), cust.team));
                    System.out.println("SportRecord Found.... for football");
                }
            });
            System.out.println("SportRecord Returned.... for football");
            return lstSport;
        };

        BiFunction<CustomerRevamp, Integer, List<GpaRecordRevamp>> fgpa = (x, z) -> {

            // GpaRecordRevamp gpa = null;
            List<GpaRecordRevamp> lstGpa = new ArrayList<>();

            // for (int i=z; i < customers.length && gpa == null; ++ i) {
            Arrays.stream(customers).forEach(cust -> {
                 if (cust.gpa >= x.gpa) {
                     lstGpa.add(new GpaRecordRevamp(cust.name, cust.phoneNum, lstGpa.size(), cust.subject));
                     System.out.println("GpaRecord Found.... for techie");
                 }
            });
            System.out.println("GpaRecord returned.... for techie");
            return lstGpa;
        };

     BiFunction<CustomerRevamp, Integer, List<FriendsRecordRevamp>> ffriends = (x, z) -> {

          // FriendsRecordRevamp friends = null;
         List<FriendsRecordRevamp> lstFriends = new ArrayList<>();

          // for (int i=z; i < customers.length && friends == null; ++ i) {
         Arrays.stream(customers).forEach(cust -> {
              if (cust.numFriends >= x.numFriends) {
                  lstFriends.add(new FriendsRecordRevamp(cust.name, cust.phoneNum, lstFriends.size(), cust.friends));
                  System.out.println("FriendsRecord found.... for friends");
              }
          });
         System.out.println("FriendsRecord returned.... for friends");
          return lstFriends;
     };

//        ArrayList< BiFunction<CustomerRevamp, Integer, ? extends RecordRevamp> > list = new ArrayList<>();
//
//        list.add(fsport);
//        list.add(fgpa);
//        list.add(ffriends);

        System.out.println("SUNDAY FOOTBALL PROMOTION - Call the following customers:");
        matchCustomers2(new CustomerRevamp(null, null, "football", null, Double.MAX_VALUE, null, Integer.MAX_VALUE, null), fsport);

        System.out.println("TUESDAY HIGH-TECH PROMOTION - Call the following customers:");
        matchCustomers2(new CustomerRevamp(null, null, null, null, 3.75, null, Integer.MAX_VALUE, null), fgpa);

        System.out.println("FRIDAY BRING A FRIEND PROMOTION - Call the following customers:");
        matchCustomers2(new CustomerRevamp(null, null, null, null, Double.MAX_VALUE, null, 1, null), ffriends);
        //   ---- OR ---
        matchCustomers2(new CustomerRevamp(null, null, null, null, Double.MAX_VALUE, null, 1, null), (x, z) -> {

            // FriendsRecordRevamp friends = null;
            List<FriendsRecordRevamp> lstFriends = new ArrayList<>();

            // for (int i=z; i < customers.length && friends == null; ++ i) {
            Arrays.stream(customers).forEach(cust -> {
                if (cust.numFriends >= x.numFriends) {
                    lstFriends.add(new FriendsRecordRevamp(cust.name, cust.phoneNum, lstFriends.size(), cust.friends));
                    System.out.println("FriendsRecord found.... for friends");
                }
            });
            System.out.println("FriendsRecord returned.... for friends");
            return lstFriends;
        });


    }  /* ------- END ---- OF ---- public static void main(String[] args) ------- */

}    /* ------- END ---- OF ---- public class SalesPromotion ------- */
