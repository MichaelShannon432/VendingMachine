
public class Cocacola implements Vendable {
	private double price = 1.50;
	private int stock = 10;

	@Override
	public String getName() {
		return "Cocacola";
	}

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public void setPrice(double newPrice) {
		price = newPrice;
	}

	@Override
	public int getStock() {
		return stock;
	}

	@Override
	public void addStock(int newStock) {
		stock = stock + newStock;
	}

	@Override
	public boolean canVend() {
		return stock > 0;
	}

	@Override
	public boolean vend() {
		if(canVend()) {
			stock -= 1;
			return true;
		}
		return false;	
	}
	public String toString() {
		return "Coca-Cola";
}
}
