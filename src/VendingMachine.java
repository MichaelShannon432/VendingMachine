import java.util.Scanner;

public class VendingMachine {
	private static Vendable items[][] = {
		{
			new Hershey(),
			new Reese(),
			new Heath()
		},
		{
			new Cocacola(),
			new Sprite(),
			new DrPepper()
		}
	};

	private static Vendable getItem(String row, String Column) {
		int rowIndex;
		int columnIndex = Integer.parseInt(Column);
		char rowChar = row.toLowerCase().charAt(0);
		rowIndex = rowChar - 97;
		return items[rowIndex][columnIndex];
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		while (true) {
			System.out.print("Are you a technician: yes or no");
			String answer = scan.next();

			switch (answer) {
			case "yes":
				System.out.print(
						"Do you want to change the price or add stock: Type 1 for price change or 2 for stock change");
				String response = scan.next();

				switch (response) {
				case "1":
					System.out.print("Which items price do you want to change?");
					String input = scan.next();
					String[] rowAndColumn = input.split("");
					Vendable item = getItem(rowAndColumn[0], rowAndColumn[1]);
					System.out.print("Enter the new price: ");
					Double price2 = scan.nextDouble();
					item.setPrice(price2);
					System.out.print("The price has been changed.");
					break; 
				case "2":
					System.out.print("Which items stock do you want to change?");
					String nput = scan.next();
					String[] columnAndRow = nput.split("");
					Vendable item1 = getItem(columnAndRow[0], columnAndRow[1]);
					System.out.print("How much stock do you want to add?");
					int stock2 = scan.nextInt();
					item1.addStock(stock2);
					System.out.print("The stock has been added.");
					break;
				}
				break;
			case "no":
				double money;
				System.out.print("Please insert your money: ");
				money = scan.nextDouble();
				System.out.print("Which item which you like to select?");
				String input = scan.next();
				String[] rowAndColumn = input.split("");
				Vendable item = getItem(rowAndColumn[0], rowAndColumn[1]);
				if (item.getPrice() <= money) {
					if (item.canVend()) {
						item.vend();
						System.out.print(item + " has vended successfully.");
						System.out.println(" Your change is: " + (money - item.getPrice()));
					} else
						System.out.println(item + " is currently out of stock, Sorry.");
				} else
					System.out.println("You did not insert enough money, your change is: " + money);
				break;
			}
		}
	}
}
