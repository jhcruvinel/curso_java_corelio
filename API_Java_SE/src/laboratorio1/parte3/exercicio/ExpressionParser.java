package laboratorio1.parte3.exercicio;
import java.util.ArrayList;
import java.util.List;

public class ExpressionParser {
    List<Expression> expressoes=new ArrayList<Expression>();
    public String parse(String str, List<String> artigos, List<String> adjetivos, List<String> substantivos){
        String[] tokenList = str.split(" ");
        for (String symbol : tokenList) {
        	if (ParserUtil.is(symbol, artigos)) {
        		Expression artigoExpression = new ArtigoExpression(symbol);
        		expressoes.add(artigoExpression);
        	} else if (ParserUtil.is(symbol, adjetivos)) {
        		Expression adjetivoExpression = new AdjetivoExpression(symbol);
        		expressoes.add(adjetivoExpression);
            } else if (ParserUtil.is(symbol, substantivos)) {
            	Expression subExpression = new SubstantivoExpression(symbol);
            	expressoes.add(subExpression);
        	} else {
        		Expression textExpression = new TextExpression(symbol);
        		expressoes.add(textExpression);
        	} 
        }
        String result = "";
        for (Expression exp: expressoes) {
        	result += exp.interpret()+ " "; 
        } 
        return result;
    }
}