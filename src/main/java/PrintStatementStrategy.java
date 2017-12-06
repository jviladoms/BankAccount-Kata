
public class PrintStatementStrategy {
    public static PrintStatement get(Strategy strategy){
        switch(strategy){
            case STANDARD:
                return new BasePrintStatement();
            case FILE:
                return new FilePrintStatement();
            default:
                throw new RuntimeException("Strategy not found");
        }
    }
}
