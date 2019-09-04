package laboratorio1.parte3.exercicio;

public class AdjetivoExpression implements Expression {
	private String expression;
	public AdjetivoExpression(String expression){
        this.expression=expression;
    }
    @Override
    public String interpret(){
        return expression+"(ADJ)";
    }
}
