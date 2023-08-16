import Models.Author;
import Models.Book;
import Models.Library;
import Models.Reader;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        boolean alive=true;

        Book newBook=new Book(0,"zübük",20,"geçerli","özel","20.10.21",new Author(0,"abasıyanık",0));
        newBook.addBook(newBook);
        Reader readerInstance = new Reader(0,"onur",0);
        readerInstance.getBooks().add(newBook);
        Reader readerInstance1=new Reader(0,"onur",0,readerInstance.getBooks());
        readerInstance.addReaderToList(readerInstance1);

        while(alive) {
            System.out.println("0 : Uygulamayı durdur" );
            System.out.println("1 : Kitap işlemleri" );
            System.out.println("2 : Okuyucu işlemleri" );
            System.out.println("3 : Kütüphane işlemleri" );
            System.out.println("4 : Yazar işlemleri" );
            String userInput=scanner.nextLine();
            if (userInput.equals("0")) {
                System.out.println("Uygulama durduruldu!");
                alive = false;
            } else if (userInput.equals("1")) {
                boolean aliveKitap=true;
                while(aliveKitap) {
                    System.out.println("Yapmak istediğin kitap işlemini seç:");
                    System.out.println("0-Üst menü");
                    System.out.println("1-Kitap ekle");
                    System.out.println("2-Kitap sil");
                    System.out.println("3-Kitap listesi");
                    String userInputKitap = scanner.nextLine();
                    if (userInputKitap.equals("0")) {
                       aliveKitap=false;
                    }else if(userInputKitap.equals("1")){
                        System.out.println("Sırasıyla kitap id,kitap ismi, fiyat, durum, edition, satın alım tarihi, yazar bilgilerini arasına virgül koyarak yaz");
                        String userInputKitapEkle=scanner.nextLine();
                        String[] userInputKitapEkleSplitted=userInputKitapEkle.split(",");
                        if (userInputKitapEkleSplitted.length == 7) {
                            Book newBook2 = new Book(
                                    Integer.parseInt(userInputKitapEkleSplitted[0]), // Kitap Adı
                                    userInputKitapEkleSplitted[1], // Yazar Adı
                                    Integer.parseInt(userInputKitapEkleSplitted[2]), // Yayın Tarihi
                                    userInputKitapEkleSplitted[3], // Yayınevi
                                    userInputKitapEkleSplitted[4], // ISBN
                                    userInputKitapEkleSplitted[5], // Kategori
                                    new Author(1,userInputKitapEkleSplitted[6],1) // Dil
                            );
                            newBook.addBook(newBook2);
                        }
                    }else if(userInputKitap.equals("2")){
                        System.out.println("Silinmesini istediğin kitap id sini yaz");
                        String userInputKitapSil=scanner.nextLine();
                        newBook.removeBook(Integer.parseInt(userInputKitapSil));
                    }
                    else if(userInputKitap.equals("3")){
                        System.out.println(newBook.getBooks());
                    }
                    else {
                        System.out.println("Hatalı giriş formatı! Lütfen tüm kitap bilgilerini virgülle ayırarak girin.");
                    }
                }
            }else if(userInput.equals("2")){
                boolean aliveOkuyucu=true;
                while(aliveOkuyucu) {
                    System.out.println("Okuyucu menüsünde yapmak istediğin işlemi seç :");
                    System.out.println("0-Üst menü : ");
                    System.out.println("1-Okuyucu ekle : ");
                    System.out.println("2-Okuyucu sil : ");
                    System.out.println("3-Okuyucu listesi : ");
                    String userInputOkuyucu=scanner.nextLine();
                    if (userInputOkuyucu.equals("0")) {
                        aliveOkuyucu=false;
                    }else if(userInputOkuyucu.equals("1")){
                        System.out.println("Eklemek istediğin okuyucuya ait person_id, name, reader_id, books bilgilerini aralarına virgül koyarak yaz");
                        userInputOkuyucu=scanner.nextLine();
                        String[] splittedOkuyucu=userInputOkuyucu.split(",");
                    }else if(userInputOkuyucu.equals("2")){
                        System.out.println("Silinmesini istediğin okyucu id sini yaz");
                        String userInputReaderSil=scanner.nextLine();
                        readerInstance.removeReaderFromList(Integer.parseInt(userInputReaderSil));
                    }
                    else if(userInputOkuyucu.equals("3")){
                        System.out.println(readerInstance.getReaderArrayList());
                    };
                }
            }   else {
                System.out.println("Hatalı giriş formatı! Lütfen menüdeki değerlerden birini girin!");
            }
        }
    }
}