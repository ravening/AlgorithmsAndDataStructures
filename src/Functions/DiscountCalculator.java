package Functions;

public class DiscountCalculator {
    public static void main(String[] args) { 
        DiscountService discountService = new DiscountService(); 
        
        double price = 100.0; 
        double seasonDiscountedPrice = discountService.seasDiscount().apply(price); 
        System.out.println("Season Discounted Price: " + seasonDiscountedPrice); 
        double holidayDiscountedPrice = discountService.holidayDiscount().apply(price); 
        System.out.println("Holiday Discounted Price: " + holidayDiscountedPrice); 
        double clearanceDiscountedPrice = discountService.clearanceDiscount().apply(price);
        System.out.println("Clearance Discounted Price: " + clearanceDiscountedPrice); }   
}
