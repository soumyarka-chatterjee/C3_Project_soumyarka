import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class RestaurantService {
    private static List<Restaurant> restaurants = new ArrayList<>();

    public Restaurant findRestaurantByName(String restaurantName) throws restaurantNotFoundException{
        Restaurant restaurant =null;
        ListIterator restItr= restaurants.listIterator();
        while(restItr.hasNext()){
            Restaurant tempRestaurant= (Restaurant) restItr.next();
            if(tempRestaurant.getName().equalsIgnoreCase(restaurantName)){
                restaurant = tempRestaurant;
            }
        }
        if(restaurant == null){
            throw new restaurantNotFoundException(restaurantName);
        }
        return restaurant;

        //DELETE ABOVE STATEMENT AND WRITE CODE HERE
    }


    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Restaurant removeRestaurant(String restaurantName) throws restaurantNotFoundException {
        Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
        if(!restaurants.remove(restaurantToBeRemoved)){
            throw  new restaurantNotFoundException(restaurantName);
        }
        return restaurantToBeRemoved;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }
}
