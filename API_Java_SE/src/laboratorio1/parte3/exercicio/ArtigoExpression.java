package laboratorio1.parte3.exercicio;

public class ArtigoExpression implements Expression {
	private String expression;
	public ArtigoExpression(String expression){
        this.expression=expression;
    }
    @Override
    public String interpret(){
        return expression+"(ART)";
    }
}
