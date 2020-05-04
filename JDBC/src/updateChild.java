import java.util.Scanner;


public class updateChild {

    public updateChild() throws InterruptedException{
        Repository r = new Repository();
        String name;
        String address;
        int id;
        int countryId;

        Scanner sc = new Scanner(System.in);
        while(true){

            System.out.println("Name of child: ");
            name = sc.nextLine();

            System.out.println("Address: ");
            address = sc.nextLine();

            System.out.println("CountryId: ");
            countryId = sc.nextInt();

            System.out.println("id: ");
            id = sc.nextInt();

            r.updateChild(id, name, address, countryId);
            //r.getChildByName(name).printOut();
        }
    }

    public static void main(String args[]) throws InterruptedException {
        updateChild d = new updateChild();
    }
}