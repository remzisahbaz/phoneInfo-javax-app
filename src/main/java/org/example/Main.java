package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nTelefon Rehberi Uygulaması");
            System.out.println("1. Kişi Ekle");
            System.out.println("2. Kişi Çıkart");
            System.out.println("3. Kişi Ara");
            System.out.println("4. Çıkış");

            System.out.print("Seçiminiz: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Dummy nextLine to consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("İsim: ");
                    String name = scanner.nextLine();
                    System.out.print("Telefon Numarası: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("E-posta: ");
                    String email = scanner.nextLine();

                    ContactInfo newContact = new ContactInfo(name, phoneNumber, email);
                    phoneBook.addContact(newContact);
                    System.out.println("Kişi eklendi.");
                    break;
                case 2:
                    System.out.print("Aranacak İsim veya Telefon Numarası: ");
                    String searchKey = scanner.nextLine();
                    ContactInfo contactToRemove = phoneBook.searchByName(searchKey);

                    if (contactToRemove == null) {
                        System.out.println("Kişi bulunamadı.");
                    } else {
                        phoneBook.removeContact(contactToRemove);
                        System.out.println("Kişi çıkartıldı.");
                    }
                    break;
                case 3:
                    System.out.print("Aranacak İsim veya Telefon Numarası: ");
                    String searchKey2 = scanner.nextLine();
                    ContactInfo searchResult = phoneBook.searchByName(searchKey2);

                    if (searchResult == null) {
                        System.out.println("Kişi bulunamadı.");
                    } else {
                        System.out.println("Kişi Bilgileri:");
                        System.out.println("İsim: " + searchResult.name);
                        System.out.println("Telefon Numarası: " + searchResult.phoneNumber);
                        System.out.println("E-posta: " + searchResult.email);
                    }
                    break;
                case 4:
                    System.out.println("Çıkış yapılıyor...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Geçersiz seçim. Lütfen tekrar deneyin.");
            }
        }
    }
}