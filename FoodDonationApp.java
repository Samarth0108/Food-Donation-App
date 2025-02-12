import java.util.*;

class Donor {
    String name;
    String location;

    Donor(String name, String location) {
        this.name = name;
        this.location = location;
    }
}

class NGO {
    String name;
    String location;

    NGO(String name, String location) {
        this.name = name;
        this.location = location;
    }

    // Dummy function to calculate distance
    int calculateDistance(String donorLocation) {
        return new Random().nextInt(10) + 1; // Distance between 1 and 10 km
    }
}
public class FoodDonationApp {
    private static List<NGO> ngos = new ArrayList<>();
    private static List<Donor> donors = new ArrayList<>();

    public static void main(String[] args) {
        // Predefined NGOs
        ngos.add(new NGO("Food for All", "Central Park"));
        ngos.add(new NGO("Helping Hands", "Downtown"));
        ngos.add(new NGO("Feed the Needy", "Uptown"));

        Scanner scanner = new Scanner(System.in);

        // Let user create a Donor Profile
        System.out.println("Welcome to the Food Donation App!");
        System.out.print("Enter your name: ");
        String donorName = scanner.nextLine();
        System.out.print("Enter your location: ");
        String donorLocation = scanner.nextLine();

        Donor donor = new Donor(donorName, donorLocation);
        donors.add(donor);

        System.out.println("\nThank you for deciding to donate food, " + donorName + "!");
        System.out.println("We will now connect you with the nearest NGOs.");

        // Find and display nearest NGOs
        List<NGO> nearbyNgos = findNearestNGOs(donorLocation);

        if (nearbyNgos.isEmpty()) {
            System.out.println("Sorry, no nearby NGOs found.");
        } else {
            System.out.println("\nThe nearest NGOs to you are:");
            for (NGO ngo : nearbyNgos) {
                System.out.println("- " + ngo.name + " (Located at: " + ngo.location + ")");
            }
        }

        scanner.close();
    }

    // This method sorts NGOs by proximity to the donor
    private static List<NGO> findNearestNGOs(String donorLocation) {
        List<NGO> sortedNGOs = new ArrayList<>(ngos);
        sortedNGOs.sort(Comparator.comparingInt(ngo -> ngo.calculateDistance(donorLocation))); // FIXED
        return sortedNGOs;
    }
}
