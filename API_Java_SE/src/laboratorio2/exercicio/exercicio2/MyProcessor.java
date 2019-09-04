package laboratorio2.exercicio.exercicio2;

import java.util.concurrent.Flow.Processor;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.SubmissionPublisher;
import java.util.function.Function;

public class MyProcessor extends SubmissionPublisher<ArtigoCientifico> implements Processor<Artigo, ArtigoCientifico> {

    private Subscription subscription;
    private Function<Artigo, ArtigoCientifico> conversorArtigoParaArtigoCientifico;

    public MyProcessor(Function<Artigo, ArtigoCientifico> conversor) {
        super();
        this.conversorArtigoParaArtigoCientifico = conversor;
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
        this.subscription.request(1);
    }

    @Override
    public void onNext(Artigo Artigo) {
        submit((ArtigoCientifico) conversorArtigoParaArtigoCientifico.apply(Artigo));
        subscription.request(1);
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println("Feito");
    }
}