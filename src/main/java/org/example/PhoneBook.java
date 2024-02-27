package org.example;


class PhoneBook {
    private BinarySearchTree nameTree; // BST for names
    private BinarySearchTree phoneNumberTree; // BST for phone numbers

    public PhoneBook() {
        nameTree = new BinarySearchTree();
        phoneNumberTree = new BinarySearchTree();
    }

    public void addContact(ContactInfo contact) {
        // Eklemek için hem isim hem de telefon numarası ağaçlarına ekleyin.
        nameTree.insert(contact.name, contact);
        phoneNumberTree.insert(contact.phoneNumber, contact);
    }

    public ContactInfo searchByName(String name) {
        // İsim ağacında arama yapın.
        return nameTree.search(name);
    }

    public ContactInfo searchByPhoneNumber(String phoneNumber) {
        // Telefon numarası ağacında arama yapın.
        return phoneNumberTree.search(phoneNumber);
    }
    //metot: Kişi çıkartma
    public void removeContact(ContactInfo contact) {
        nameTree.remove(contact.name);
        phoneNumberTree.remove(contact.phoneNumber);
    }
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        // İki örnek kişi ekleyin.
        ContactInfo person1 = new ContactInfo("Beyza Kazan", "555-5678-8990", "beyza@example.com");
        ContactInfo person2 = new ContactInfo("Remzi ŞAHBAZ", "555-5678-8989", "remzi@example.com");

        phoneBook.addContact(person1);
        phoneBook.addContact(person2);

        // İsim ve telefon numarasıyla kişileri arayın.
        System.out.println("Found  name:"+"Remzi ŞAHBAZ");
        ContactInfo searchResultByName = phoneBook.searchByName("Remzi ŞAHBAZ");

        // Sonuçları yazdırın.
        if (searchResultByName != null) {
            System.out.println("Found  :\n " + searchResultByName.toString());
        } else {
            System.out.println("Not found by name");
        }
        System.out.println("\n *****************************");

        System.out.println("Found  Number :"+"555-5678-8990");
        ContactInfo searchResultByPhoneNumber = phoneBook.searchByPhoneNumber("555-5678-8990");

        if (searchResultByPhoneNumber != null) {
            System.out.println("Found by phone number: \n" + searchResultByPhoneNumber.toString());
        } else {
            System.out.println("Not found by phone number");
        }
    }
}

