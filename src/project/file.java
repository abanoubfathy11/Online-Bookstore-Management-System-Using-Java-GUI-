/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.Map;
import java.io.*;
import java.util.ArrayList;


import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
public class file {
    
    private Map<String , Book> mapbook=new HashMap<>();
    private Map<String , Admin> mapadmin=new HashMap<>();
    private Map<String , Reader> mapreader=new HashMap<>();

    public file() {
    }
    
    public boolean searchReader(String mail,String Pass)
    {
        Reader r=new Reader();
     for (Iterator<Map.Entry<String, Reader>> i = mapreader.entrySet().iterator(); i.hasNext();) 
    {
        Map.Entry<String, Reader> e = i.next();
        String v = e.getKey();
        if (v.equals(mail)&&e.getValue().getPassword().equals(Pass)){
            return true;
            
            }
        
    }
        return false;
    }
    public boolean checkReader(Reader r){
        if(mapreader.containsKey(r.getEmail()))
            return true;
        return false;
       
    }
    public void loadmapbook()
    {
         try {
         BufferedReader bf=new BufferedReader( new FileReader("books.txt"));
         Scanner sc= new Scanner(bf);
         String line;
         String[] parts;
         
         
         while (sc.hasNextLine())
         {
            Book b1 =new Book();
            
            line = sc.nextLine();
            parts = line.split("#");
            b1.setName(parts[0]);
            b1.setAuther(parts[1]);
            b1.setPrice(parts[2]);
            b1.setQuantity(Integer.valueOf(parts[3]));
            b1.setDescription(parts[4]);
            b1.setStatus(parts[5]);
            b1.setCategory(parts[6]);
            
            mapbook.put(b1.getName(), b1);

         }

     } catch (FileNotFoundException | NumberFormatException e) {
         e.getMessage();
     }
    }
    
    
    
    public void loadmapreader()
    {
         try {
         BufferedReader bf=new BufferedReader( new FileReader("reader.txt"));
         Scanner sc= new Scanner(bf);
         String line;
         String[] parts;
         
         
         while (sc.hasNextLine())
         {
            Reader a1 =new Reader();
            
            line = sc.nextLine();
            parts = line.split("#");
            a1.setEmail(parts[0]);
            a1.setUsername(parts[1]);
            a1.setPassword(parts[2]); 
            
            a1.setAddress(parts[3]);
            a1.setPhone(parts[4]);
            a1.setPayment(parts[5]);
            
            mapreader.put(a1.getEmail(), a1);

         }

     } catch (FileNotFoundException | NumberFormatException e) {
         e.getMessage();
     }
    }
    
    
    
    
    public void loadmapadmin()
    {
         try {
         BufferedReader bf=new BufferedReader( new FileReader("admin.txt"));
         Scanner sc= new Scanner(bf);
         String line;
         String[] parts;
         
         
         while (sc.hasNextLine())
         {
            Admin a1 =new Admin();
            
            line = sc.nextLine();
            parts = line.split("#");
            a1.setEmail(parts[0]);
            a1.setUsername(parts[1]);
            a1.setPassword(parts[2]);
           
            
            mapadmin.put(a1.getEmail(), a1);

         }

     } catch (FileNotFoundException | NumberFormatException e) {
         e.getMessage();
     }
    }
    
    
       public List<String> Searchmapsolidbook(String mail)
    {
        List<String> list=new ArrayList<>();
         try {
         BufferedReader bf=new BufferedReader( new FileReader("solidbook.txt"));
         Scanner sc= new Scanner(bf);
         String line;
         String[] parts;
         
         while (sc.hasNextLine())
         {          
            line = sc.nextLine();
            parts = line.split("#");
            if(parts[0].equals(mail)&&!list.contains(parts[1]))
                list.add(parts[1]);
        }
         
         

     } catch (FileNotFoundException | NumberFormatException e) {
         e.getMessage();
     }
         
         return list;
    }
    
    
       
    public  void AddNewBook(Book s) {
        
        try {
            
            PrintWriter pr=new PrintWriter(new FileWriter("books.txt",true));
           
            pr.print(s.getName());
            pr.print('#');
            
            pr.print(s.getAuther());
            pr.print('#');
            
            pr.print(s.getPrice());
            pr.print('#');
            
            pr.print(s.getQuantity());
            pr.print('#');
            
            pr.print(s.getDescription());
            pr.print('#');
            
            pr.print(s.getStatus());
            pr.print('#');
            
            pr.print(s.getCategory());
            
            pr.print("\n");
            
            pr.close();
            
            
        } catch (IOException e) {
            System.out.println("Error");
        }
        
    
    }
    
    
    
    public  void AddNewAdmin(Admin s) {
        
        try {
            
            PrintWriter pr=new PrintWriter(new FileWriter("admin.txt",true));
           
            pr.print(s.getEmail());
            pr.print('#');
            
            pr.print(s.getUsername());
            pr.print('#');
            
            pr.print(s.getPassword());
            
            
            pr.print("\n");
            
            pr.close();
            
            
        } catch (IOException e) {
            System.out.println("Error");
        }
        
    
    }
    
    
        public  void AddNewReader(Reader s) {
        
        try {
            
            PrintWriter pr=new PrintWriter(new FileWriter("reader.txt",true));
           
            pr.print(s.getEmail());
            pr.print('#');
            
            pr.print(s.getUsername());
            pr.print('#');
            
            pr.print(s.getPassword());
            pr.print('#');
            
            pr.print(s.getAddress());
            pr.print('#');
            
            pr.print(s.getPhone());
            pr.print('#');
            
            pr.print(s.getPayment());
            
            
            pr.print("\n");
            
            pr.close();
            
            
        } catch (IOException e) {
            System.out.println("Error");
        }
        
    
    }
        
         public  void AddNewSolidBook(String name,String book) {
        
        try {
            
            PrintWriter pr=new PrintWriter(new FileWriter("solidbook.txt",true));
           
            pr.print(name);
            pr.print('#');
            
            pr.print(book);
           
            
            pr.print("\n");
            
            pr.close();
            
            
        } catch (IOException e) {
            System.out.println("Error");
        }
        
    
    }
    
    public void RemoveBook(Book b)
    {
     for (Iterator<Map.Entry<String, Book>> i = mapbook.entrySet().iterator(); i.hasNext();) 
    {
        Map.Entry<String, Book> e = i.next();
        String v = e.getKey();
        if (v.equals(b.getName()))
            i.remove();
        
    }
    
    }
    public void RemoveReader(Reader b)
    {
     for (Iterator<Map.Entry<String, Reader>> i = mapreader.entrySet().iterator(); i.hasNext();) 
    {
        Map.Entry<String,Reader> e = i.next();
        String v = e.getKey();
        if (v.equals(b.getEmail()))
            i.remove();
        
    }
    
    }
    public Reader SearchReader(String mail)
    {  
        Reader r=new Reader();
        try{
         BufferedReader bf=new BufferedReader( new FileReader("reader.txt"));
         Scanner sc= new Scanner(bf);
         String line;
         String[] parts;
         
         while (sc.hasNextLine())
         {          
            line = sc.nextLine();
            parts = line.split("#");
            if(mail.equals(parts[0]))
            {
                r.setEmail(parts[0]);
                r.setUsername(parts[1]);
                r.setPassword(parts[2]);
                r.setAddress(parts[3]);
                r.setPhone(parts[4]);
                r.setPayment(parts[5]);
            }
           
        }}catch(Exception e)
        {
            e.getMessage();
        }
    
         return r;
    
    }
    
    
    
    public void savebooks()
    {
    
                try 
        {
        BufferedWriter bw = new BufferedWriter(new FileWriter("books.txt"));
        for (Map.Entry<String, Book> entry  : mapbook.entrySet()) 
        {
            bw.write(entry.getKey()+"#"+entry.getValue().getAuther()+"#"+entry.getValue().getPrice()+"#"+
          entry.getValue().getQuantity()+"#"+entry.getValue().getDescription()+"#"+entry.getValue().getStatus()+"#"+entry.getValue().getCategory());
            bw.newLine();
         
        }
           bw.flush();
           bw.close();
        }
        catch(IOException e)
        {   
            e.getMessage();
        }
    
    
    }
    
    
    
    public void saveAdmins()
    {
    
                try 
        {
        BufferedWriter bw = new BufferedWriter(new FileWriter("admin.txt"));
        for (Map.Entry<String, Admin> entry  : mapadmin.entrySet()) 
        {
            bw.write(entry.getKey()+"#"+entry.getValue().getUsername()+"#"+entry.getValue().getPassword());
            bw.newLine();
         
        }
           bw.flush();
           bw.close();
        }
        catch(IOException e)
        {   
            e.getMessage();
        }
                
        
    }
    
    
    public void saveReader()
    {
    
                try 
        {
        BufferedWriter bw = new BufferedWriter(new FileWriter("reader.txt"));
        for (Map.Entry<String, Reader> entry  : mapreader.entrySet()) 
        {
            bw.write(entry.getKey()+"#"+entry.getValue().getEmail()+"#"+entry.getValue().getPhone()+"#"+entry.getValue().getAddress()+"#"
            +entry.getValue().getPhone()+"#"+entry.getValue().getPayment());
            bw.newLine();
         
        }
           bw.flush();
           bw.close();
        }
        catch(IOException e)
        {   
            e.getMessage();
        }
                
                
    
    }
    
    
    
    
    public List<String> SearchCategory(String cat,String status)
    {
        List<String> list=new ArrayList<>();
         try {
         BufferedReader bf=new BufferedReader( new FileReader("books.txt"));
         Scanner sc= new Scanner(bf);
         String line;
         String[] parts;
         boolean flag=false;
         while (sc.hasNextLine())
         {          
            line = sc.nextLine();
            parts = line.split("#");
            if(parts[6].equals(cat)&&parts[5].equals(status)&&!list.contains(parts[1]))
                list.add(parts[1]);
        }
       

     } catch (FileNotFoundException | NumberFormatException e) {
         e.getMessage();
     }
         
         return list;
    
    }
    public List<String> DisplayCategory()
    {
        List<String> list=new ArrayList<>();
         try {
         BufferedReader bf=new BufferedReader( new FileReader("books.txt"));
         Scanner sc= new Scanner(bf);
         String line;
         String[] parts;
         boolean flag=false;
         while (sc.hasNextLine())
         {          
            line = sc.nextLine();
            parts = line.split("#");
          
          
          if(!list.contains(parts[6]))
            list.add(parts[6]);
        }
       

     } catch (FileNotFoundException | NumberFormatException e) {
         e.getMessage();
     }
         
         return list;
    
    }
    public List<String> DisplayCategory(String status)
    {
        List<String> list=new ArrayList<>();
         try {
         BufferedReader bf=new BufferedReader( new FileReader("books.txt"));
         Scanner sc= new Scanner(bf);
         String line;
         String[] parts;
         boolean flag=false;
         while (sc.hasNextLine())
         {          
            line = sc.nextLine();
            parts = line.split("#");
          
          
          if(!list.contains(parts[6])&&parts[5].equals(status))
            list.add(parts[6]);
        }
       

     } catch (FileNotFoundException | NumberFormatException e) {
         e.getMessage();
     }
         
         return list;
    
    }
    public List<String> DisplayAuthers()
    {
        List<String> list=new ArrayList<>();
         try {
         BufferedReader bf=new BufferedReader( new FileReader("books.txt"));
         Scanner sc= new Scanner(bf);
         String line;
         String[] parts;
         boolean flag=false;
         while (sc.hasNextLine())
         {          
            line = sc.nextLine();
            parts = line.split("#");
           for(String s: list)
          {
              if(s.equals(parts[1]))
              flag=true;
          }
          if(!flag)
            list.add(parts[1]);
        }
       

     } catch (FileNotFoundException | NumberFormatException e) {
         e.getMessage();
     }
         
         return list;
    
    }
    
    
    public List<String> DisplayBooks()
    {
        List<String> list=new ArrayList<>();
         try {
         BufferedReader bf=new BufferedReader( new FileReader("books.txt"));
         Scanner sc= new Scanner(bf);
         String line;
         String[] parts;
         
         while (sc.hasNextLine())
         {          
            line = sc.nextLine();
            parts = line.split("#");
           
                list.add(parts[0]);
        }
       

     } catch (FileNotFoundException | NumberFormatException e) {
         e.getMessage();
     }
         
         return list;
    
    }
    
    
    public Book Searchbooks(String name)
       {
        Book a= new Book();
         try {
         BufferedReader bf=new BufferedReader( new FileReader("books.txt"));
         Scanner sc= new Scanner(bf);
         String line;
         String[] parts;
         
         while (sc.hasNextLine())
         {          
            line = sc.nextLine();
            parts = line.split("#");
            if(parts[0].equals(name))
            {
                a.setName(parts[0]);
                a.setAuther(parts[1]);
                a.setPrice(parts[2]);
                a.setQuantity(Integer.valueOf(parts[3]));
                a.setDescription(parts[4]);
                a.setStatus(parts[5]);
                a.setCategory(parts[6]);
            }
              
        }
       

     } catch (FileNotFoundException | NumberFormatException e) {
         e.getMessage();
     }
         
         return a;
    
    }
       public Book Searchbooks(String name,String status)
       {
        Book a= new Book();
         try {
         BufferedReader bf=new BufferedReader( new FileReader("books.txt"));
         Scanner sc= new Scanner(bf);
         String line;
         String[] parts;
         
         while (sc.hasNextLine())
         {          
            line = sc.nextLine();
            parts = line.split("#");
            if(parts[0].equals(name)&&parts[5].equals(status))
            {
                a.setName(parts[0]);
                a.setAuther(parts[1]);
                a.setPrice(parts[2]);
                a.setQuantity(Integer.valueOf(parts[3]));
                a.setDescription(parts[4]);
                a.setStatus(parts[5]);
                a.setCategory(parts[6]);
            }
              
        }
       

     } catch (FileNotFoundException | NumberFormatException e) {
         e.getMessage();
     }
         
         return a;
    
    }
       
       
       
       public boolean SearchAutherContains(String name,String status)
       {
        Book a= new Book();
         try {
         BufferedReader bf=new BufferedReader( new FileReader("books.txt"));
         Scanner sc= new Scanner(bf);
         String line;
         String[] parts;
         
         while (sc.hasNextLine())
         {          
            line = sc.nextLine();
            parts = line.split("#");
            if(parts[1].equals(name)&&parts[5].equals(status))
            {
                return true;
            }
              
        }
       

     } catch (FileNotFoundException | NumberFormatException e) {
         e.getMessage();
     }
         
         return false;
    
    }
       
        public boolean SearchCategoryContains(String name,String status)
       {
        Book a= new Book();
         try {
         BufferedReader bf=new BufferedReader( new FileReader("books.txt"));
         Scanner sc= new Scanner(bf);
         String line;
         String[] parts;
         
         while (sc.hasNextLine())
         {          
            line = sc.nextLine();
            parts = line.split("#");
            if(parts[6].equals(name)&&parts[5].equals(status))
            {
                return true;
            }
              
        }
       

     } catch (FileNotFoundException | NumberFormatException e) {
         e.getMessage();
     }
         
         return false;
    
    }
        
        
        public boolean SearchBookContains(String name,String status)
       {
        Book a= new Book();
         try {
         BufferedReader bf=new BufferedReader( new FileReader("books.txt"));
         Scanner sc= new Scanner(bf);
         String line;
         String[] parts;
         
         while (sc.hasNextLine())
         {          
            line = sc.nextLine();
            parts = line.split("#");
            if(parts[0].equals(name)&&parts[5].equals(status))
            {
                return true;
            }
              
        }
       

     } catch (FileNotFoundException | NumberFormatException e) {
         e.getMessage();
     }
         
         return false;
    
    }
       
   public void AddRate(String email, String bookname,String rate)
    {
        try {
         
                PrintWriter pr=new PrintWriter(new FileWriter("rate.txt",true));
                
                pr.print(email);
                pr.print('#');
                pr.print(bookname);
                pr.print('#');
                pr.print(rate);

                pr.print("\n");
            
                pr.close();
            
                } catch (IOException e)
                {
                System.out.println("Error");
                }
                
            }     
       
       
       public int BookPrice(String bookname)
       {
           int price=0;
         try {
         BufferedReader bf=new BufferedReader( new FileReader("books.txt"));
         Scanner sc= new Scanner(bf);
         String line;
         String[] parts;
         
         while (sc.hasNextLine())
         {          
            line = sc.nextLine();
            parts = line.split("#");
            if(parts[0].equals(bookname))
            {
                price=Integer.valueOf(parts[2]);
            }
              
        }
       

     } catch (FileNotFoundException | NumberFormatException e) {
         e.getMessage();
     }
         
         return price;
    
    }
       
       public int[] SearchRate(String bookname)
    {
       
        
        
        int[] list=new int[6];
         try {
         BufferedReader bf=new BufferedReader( new FileReader("rate.txt"));
         Scanner sc= new Scanner(bf);
         String line;
         String[] parts;
         int love=0,like=0,haha=0,wow=0,sad=0,angry=0;
         while (sc.hasNextLine())
         {          
            line = sc.nextLine();
            parts = line.split("#");
            if(parts[1].equals(bookname))
            {
                if(parts[2].equals("love"))
                    love++;
                else if(parts[2].equals("like"))
                    like++;
                else if (parts[2].equals("haha"))
                    haha++;
                else if (parts[2].equals("wow"))
                    wow++;
                else if(parts[2].equals("sad"))
                    sad++;
                else if (parts[2].equals("angry"))
                    angry++;
            }          
        }
         
         
         list[0]= like;
         list[1]= love;
         list[2]= haha;
         list[3]= wow;
         list[4]= sad;
         list[5]= angry;
         
     } catch (FileNotFoundException | NumberFormatException e) {
         System.out.println("Erorr");
     }
        
         
         return list;
    
    }
    
    public List<String> SearchAuther(String auther,String status,String cat)
       {
        List<String> list=new ArrayList<>();
         try {
         BufferedReader bf=new BufferedReader( new FileReader("books.txt"));
         Scanner sc= new Scanner(bf);
         String line;
         String[] parts;
         
         while (sc.hasNextLine())
         {          
            line = sc.nextLine();
            parts = line.split("#");
            
            if(parts[1].equals(auther)&&parts[5].equals(status)&&parts[6].equals(cat)&&!list.contains(parts[0]))
                list.add(parts[0]);
        }
       

     } catch (FileNotFoundException | NumberFormatException e) {
         e.getMessage();
     }
         
         return list;
    
    }
    public List<String> SearchAuther(String auther,String status)
       {
        List<String> list=new ArrayList<>();
         try {
         BufferedReader bf=new BufferedReader( new FileReader("books.txt"));
         Scanner sc= new Scanner(bf);
         String line;
         String[] parts;
         
         while (sc.hasNextLine())
         {          
            line = sc.nextLine();
            parts = line.split("#");
            
            if(parts[1].equals(auther)&&parts[5].equals(status)&&!list.contains(parts[0]))
                list.add(parts[0]);
        }
       

     } catch (FileNotFoundException | NumberFormatException e) {
         e.getMessage();
     }
         
         return list;
    
    }
    
    public void AddSearch(String email, String bookname)
    {
        try {
         
                PrintWriter pr=new PrintWriter(new FileWriter("search.txt",true));
                
                pr.print(email);
                pr.print('#');
                pr.print(bookname);
                

                pr.print("\n");
            
                pr.close();
            
                } catch (IOException e)
                {
                System.out.println("Error");
                }
                
            }  
    
             public List<String> MostSearch ()
       {
           List<String> list=new ArrayList<>();
           List<String> list2=new ArrayList<>();
           String str;
           int counter=0;
         try {
         BufferedReader bf=new BufferedReader( new FileReader("search.txt"));
         Scanner sc1= new Scanner(bf);
         String line;
         String[] parts;
         
         while (sc1.hasNextLine())
         {          
            line = sc1.nextLine();
            parts = line.split("#");
            str=parts[1];
            list.add(str);
         }
         
         
         
         for(int i=0;i<list.size();i++){
             counter=0;
             for(int j=0;j<list.size();j++)
             {
                 if(list.get(i).equals(list.get(j)))
                     counter++;
             }
             if(counter>1&&!list2.contains(list.get(i)))
                 list2.add(list.get(i));
                 
         }
       

     } catch (FileNotFoundException | NumberFormatException e) {
         e.getMessage();
     }
         
         return list2;
       
       
       }
             
             public List<String> MostSearchUser (String mail)
       {
           List<String> list=new ArrayList<>();
           String str;
         try {
         BufferedReader bf=new BufferedReader( new FileReader("search.txt"));
         Scanner sc1= new Scanner(bf);
         String line;
         String[] parts;
         
         while (sc1.hasNextLine())
         {          
            line = sc1.nextLine();
            parts = line.split("#");
            str=parts[1];
            if(parts[0].equals(mail)&&!list.contains(str)){
            
                list.add(str);
            }
         }
         
       

     } catch (FileNotFoundException | NumberFormatException e) {
         e.getMessage();
     }
         
         return list;
       
       
       }
         
         public List<String> MostSeller ()
       {
           List<String> list=new ArrayList<>();
           List<String> list2=new ArrayList<>();
           String str;
           int counter=0;
         try {
         BufferedReader bf=new BufferedReader( new FileReader("solidbook.txt"));
         Scanner sc= new Scanner(bf);
         String line;
         String[] parts;
         
         while (sc.hasNextLine())
         {          
            line = sc.nextLine();
            parts = line.split("#");
            str=parts[1];
            list.add(str);
         }
           for(int i=0;i<list.size();i++){
             counter=0;
             for(int j=0;j<list.size();j++)
             {
                 if(list.get(i).equals(list.get(j)))
                     counter++;
             }
             if(counter>1&&!list2.contains(list.get(i)))
                 list2.add(list.get(i));
                 
         }}
         
       

      catch (FileNotFoundException | NumberFormatException e) {
         e.getMessage();
     }
         
         return list2;
       
       
       }
//    public List<String> SearchCategoryAvailable(String status)
//    {
//        List<String> list=null;
//         try {
//         BufferedReader bf=new BufferedReader( new FileReader("books.txt"));
//         Scanner sc= new Scanner(bf);
//         String line;
//         String[] parts;
//         
//         while (sc.hasNextLine())
//         {          
//            line = sc.nextLine();
//            parts = line.split("*");
//            
//            if(parts[5].equals(status))
//                list.add(parts[6]);
//        }
//       
//
//     } catch (FileNotFoundException | NumberFormatException e) {
//         e.getMessage();
//     }
//         
//         return list;
//    
//    }

//    void AddNewReader(User user) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
 
}

