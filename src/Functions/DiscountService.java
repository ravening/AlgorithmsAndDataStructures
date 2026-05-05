package Functions;

public class DiscountService {
    
    public DiscountStrategy seasDiscount() {
        return price -> price * 0.1; // 10% discount 
    } 
    
    public DiscountStrategy holidayDiscount() { 
        return price -> price * 0.9; // 10% discount 
    } 
    public DiscountStrategy clearanceDiscount() { 
        return price -> price * 0.5; // 50% discount 
    }
}
