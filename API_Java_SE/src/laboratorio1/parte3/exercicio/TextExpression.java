package laboratorio1.parte3.exercicio;

public class TextExpression implements Expression {

	private String expression;
	public TextExpression(String expression){
        this.expression=expression;
    }
    @Override
    public String interpret(){
        return expression;
    }
    
}
