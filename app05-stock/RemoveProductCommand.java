/**
 * The command for removing a product from stock list
 * 
 * @author Yavor Yankov
 * @version 10/11/2020
 */
public class RemoveProductCommand implements Command
{
    // The stock manager of the Stock Management Application
    private StockManager manager;
    // Use to get user input
    private InputReader input;

    /**
     * The constructor of this command
     * 
     * @param manager The manager which is the reciever of the Command Design Pattern
     */
    public RemoveProductCommand(StockManager manager) {
        this.manager = manager;
        this.input = new InputReader();
    }

    /**
     * Execute this command as remove the product from stock list.
     * The method is overridden from Command interface.
     */
    @Override
    public void execute() 
    {
        System.out.print("Id: ");
        // Parse the user input from String to int
        int productId = Integer.parseInt(input.getInput());

        manager.deleteProduct(productId);
    }
}
