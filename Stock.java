
public class Stock {//implements Comparable<Stock> {

    private String ticker_symbol = null;
    private float price =  0.0f;

    public Stock(String _ticker_symbol, float starting_price) {
    	 ticker_symbol=_ticker_symbol;
    	 price=starting_price;
    }
    public String getTicker() {
    	return ticker_symbol;
    }
   
    public float getPrice() {
    	return price;
    }
    
     public void updatePrice(float change) {
    	price=change;
    }
     
    //public int compareTo(Stock other) {
     //return ticker_symbol.compareTo(other.getTicker());
    //}
     
  
}
