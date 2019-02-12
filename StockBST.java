import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;
public class StockBST {
	static long start = System.currentTimeMillis();
	public static void main(String[] args) throws FileNotFoundException {
		TreeMap<String,Stock> stockstree=new TreeMap<String,Stock>();	
		File firstday=new File("shuffled_stocks.csv");
		Scanner sc=new Scanner(firstday);
		while (sc.hasNext()) {
			Scanner sclower=new Scanner(sc.next());
			sclower.useDelimiter("\\,");
			String ticker=sclower.next();
			float price= Float.parseFloat(sclower.next());
			Stock newstock=new Stock(ticker,price);
			stockstree.put(ticker, newstock);	
		}
		
		File change=new File("price_updates.txt");
		Scanner scn=new Scanner(change);
		while (scn.hasNext()) {
			String name=scn.next();
			float pricec= Float.parseFloat(scn.next());
			stockstree.get(name).updatePrice(pricec);
		}	
		long end = System.currentTimeMillis();
		System.out.print(end-start);
		//259ms
	}

}
