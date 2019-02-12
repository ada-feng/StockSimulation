import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class ALStock {
	static long start = System.currentTimeMillis();
	
	public static void main(String[] args) throws FileNotFoundException{
		ArrayList<Stock> stocklist=new ArrayList<Stock>();
		File firstday=new File("shuffled_stocks.csv");
		Scanner sc=new Scanner(firstday);
		while (sc.hasNext()) {
			Scanner sclower=new Scanner(sc.next());
			sclower.useDelimiter("\\,");
			String ticker=sclower.next();
			float price= Float.parseFloat(sclower.next());
			Stock newstock=new Stock(ticker,price);
			stocklist.add(newstock);
		}
		File change=new File("price_updates.txt");
		Scanner scn=new Scanner(change);
		while (scn.hasNext()) {
			String name=scn.next();
			float pricec= Float.parseFloat(scn.next());
			for(Stock x:stocklist) {
				if(name.equals(x.getTicker())) {
					x.updatePrice(pricec);
					break;
				}
			}
		}
		long end = System.currentTimeMillis();
		System.out.print(end-start);
//running time 1682 ms
	}
	
}
