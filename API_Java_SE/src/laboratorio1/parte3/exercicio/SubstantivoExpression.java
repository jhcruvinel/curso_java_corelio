package laboratorio1.parte3.exercicio;

public class SubstantivoExpression implements Expression {
	private String expression;
	public SubstantivoExpression(String expression){
        this.expression=expression;
    }
    @Override
    public String interpret(){
        return expression+"(SUB)";
    }
}
