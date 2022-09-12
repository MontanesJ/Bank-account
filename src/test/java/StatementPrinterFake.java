import kata.Statement;
import kata.StatementPrinter;

import java.util.ArrayList;
import java.util.List;

public class StatementPrinterFake implements StatementPrinter {

    private List<Statement> statements = new ArrayList<>();
    @Override
    public void print(List<Statement> statements) {
        this.statements = statements;
    }

    public List<Statement> getStatements(){
        return statements;
    }
}
