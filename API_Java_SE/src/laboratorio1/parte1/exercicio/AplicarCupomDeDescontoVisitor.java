package laboratorio1.parte1.exercicio;

public class AplicarCupomDeDescontoVisitor implements DescontoVisitor {

	private double aniversarioDaLojaDesconto = 0.1;

    @Override
    public void visit(CarrinhoDeCompras carrinhoDeCompras) {
        double valorDesconto = carrinhoDeCompras.getValorASerPago() * aniversarioDaLojaDesconto;
        carrinhoDeCompras.adicionarDesconto("Aniversario da Loja", valorDesconto);
        System.out.println(String.format("Adicionando desconto Aniversario da Loja no valor de %s", valorDesconto));
    }
	
}
