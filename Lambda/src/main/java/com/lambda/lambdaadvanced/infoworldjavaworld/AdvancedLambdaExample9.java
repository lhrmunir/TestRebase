package com.lambda.lambdaadvanced.infoworldjavaworld;
/*
        https://www.infoworld.com/article/3452018/get-started-with-lambda-expressions.html
        https://www.infoworld.com/article/3452018/get-started-with-lambda-expressions.html?page=2
        https://www.infoworld.com/article/3452018/get-started-with-lambda-expressions.html?page=3
*/
import java.util.ArrayList;
import java.util.List;

import java.util.function.Predicate;

class AccountEx9
{
   private int id, balance;

   AccountEx9(int id, int balance)
   {
      this.balance = balance;
      this.id = id;
   }

   int getBalance()
   {
      return balance;
   }

   int getID()
   {
      return id;
   }

   void print()
   {
      System.out.printf("Account: [%d], Balance: [%d]%n", id, balance);
   }
}

public class AdvancedLambdaExample9
{
   static List<AccountEx9> accounts;

   public static void main(String[] args)
   {
      accounts = new ArrayList<>();
      accounts.add(new AccountEx9(1000, 200));
      accounts.add(new AccountEx9(2000, -500));
      accounts.add(new AccountEx9(3000, 0));
      accounts.add(new AccountEx9(4000, -80));
      accounts.add(new AccountEx9(5000, 1000));
      // Print all accounts
      printAccounts(account -> true);
      System.out.println();
      // Print all accounts with negative balances.
      printAccounts(account -> account.getBalance() < 0);
      System.out.println();
      // Print all accounts whose id is greater than 2000 and less than 5000.
      printAccounts(account -> account.getID() > 2000 && 
                               account.getID() < 5000);
   }

   static void printAccounts(Predicate<AccountEx9> tester)
   {
      for (AccountEx9 account: accounts)
         if (tester.test(account))
            account.print();
   }
}