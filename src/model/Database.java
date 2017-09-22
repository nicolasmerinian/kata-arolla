package model;

/** 
 * Pris sur d�veloppez.com
 * Pas de prise en compte du multithreading
 */

public class Database {

   public static Database getInstance() {
       if (null == instance) {
           instance = new Database();
       }
       return instance;
   }

   private Database() {
   }

   private static Database instance;
}