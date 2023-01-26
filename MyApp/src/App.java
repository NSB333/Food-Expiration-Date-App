import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<Food> shopList = new ArrayList<Food>();
        Menu(shopList);
    }

    public static void Menu(List<Food> shopList){
        int choice = 1;
        while (choice != 0){
            System.out.println("Menu: \n 0. Quit\n 1. Add Item to Food List\n 2. View Food List \n 3. Check Expired Items");
            String sChoice = System.console().readLine("Choice: ");
            System.out.println("/n");
            choice = Integer.parseInt(sChoice);
            if (choice == 1){
                shopList = AddFood(shopList);
            }
            if (choice == 2){
                viewShoppingList(shopList);
            }
            if (choice == 3){
                shopList = viewExFood(shopList);
            }
        }
    }

    public static List<Food> AddFood(List<Food> shopList){
        int choice = 1;
        while (choice != 0){
            System.out.println("\n Menu: \n 0. Quit\n 1. Add Item to Shopping List");
            String sChoice = System.console().readLine("Choice: ");
            choice = Integer.parseInt(sChoice);
            if (choice == 1){
                Food item = new Food();
                item.foodName = item.getName();
                item.expireDate = item.getExpireDate();
                shopList.add(item);
            }
        }
        return shopList;
    }

    public static void viewShoppingList(List<Food> shopList){
        for (Food i: shopList ){
            System.out.println(i.foodName);
        }
    }
    public static List<Food> viewExFood(List<Food> shopList){
        for (Food i: shopList){
            if(i.isExpired(i.expireDate, i.foodName)){
                String sRemove = System.console().readLine("This " + i.foodName + " is expired.\nDo you want to throw it out? (1 = yes, 2 = no) ");
                int remove = Integer.parseInt(sRemove);
                if (remove == 1){
                    if(shopList.size() == 1){
                        System.out.println("Your list is empty! Let's add more items to it!");
                        AddFood(shopList);
                    }
                    shopList.remove(i);
                }
            }
        }
        return shopList;
    }
}
