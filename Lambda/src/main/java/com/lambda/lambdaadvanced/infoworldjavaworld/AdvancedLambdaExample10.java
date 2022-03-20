package com.lambda.lambdaadvanced.infoworldjavaworld;
/*
        https://www.infoworld.com/article/3452018/get-started-with-lambda-expressions.html
        https://www.infoworld.com/article/3452018/get-started-with-lambda-expressions.html?page=2
        https://www.infoworld.com/article/3452018/get-started-with-lambda-expressions.html?page=3
*/
import java.util.ArrayList;
import java.util.List;

import java.util.function.Consumer;
import java.util.function.Predicate;

class AccountEx10
{
   private int id, balance;

   AccountEx10(int id, int balance)
   {
      this.balance = balance;
      this.id = id;
   }

   void deposit(int amount)
   {
      balance += amount;
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

public class AdvancedLambdaExample10
{
   static List<AccountEx10> accounts;

   public static void main(String[] args)
   {
      accounts = new ArrayList<>();
      accounts.add(new AccountEx10(1000, 200));
      accounts.add(new AccountEx10(2000, -500));
      accounts.add(new AccountEx10(3000, 0));
      accounts.add(new AccountEx10(4000, -80));
      accounts.add(new AccountEx10(5000, 1000));
      // Deposit enough money in accounts with negative balances so that they 
      // end up with zero balances (and are no longer overdrawn).
      adjustAccounts(account -> account.getBalance() < 0,
                     account -> account.deposit(-account.getBalance()));
   }

   static void adjustAccounts(Predicate<AccountEx10> tester,
                              Consumer<AccountEx10> adjuster)
   {
      for (AccountEx10 account: accounts)
      {
         if (tester.test(account))
         {
            adjuster.accept(account);
            account.print();
         }
      }
   }
}