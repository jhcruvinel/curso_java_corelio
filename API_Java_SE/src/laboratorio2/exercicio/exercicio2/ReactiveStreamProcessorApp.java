package laboratorio2.exercicio.exercicio2;

import java.util.List;
import java.util.concurrent.SubmissionPublisher;

public class ReactiveStreamProcessorApp {
	public static void main(String[] args) throws InterruptedException {
        // Criando o publisher
        SubmissionPublisher<Artigo> publisher = new SubmissionPublisher<>();

        // Criando o processador que ir� realizar a convers�o dos objetos e atribuindo ao seu construtor a express�o Lambda respons�vel pela convers�o dos objetos
        MyProcessor transformProcessor = new MyProcessor(p -> {
            return new ArtigoCientifico(p.getId(), p.getTitulo(), p.getConteudo());
        });

        // Criando o Subscriber do objeto ArtigoTwitter
        ArtigoCientificoSubscriber subscriber = new ArtigoCientificoSubscriber();

        // Publisher para processor
        publisher.subscribe(transformProcessor);

        // Processor para subscriber
        transformProcessor.subscribe(subscriber);

        // Publicando itens
        List<Artigo> postagens = Artigo.obtemArtigos();
        postagens.stream().forEach(p -> publisher.submit(p));

        // L�gica para aguardar o processamento ser conclu�do.
        while(postagens.size() != subscriber.getCounter()) {
            Thread.sleep(10);
        }

        // Finalizando os objetos Publisher e Processor.
        publisher.close();
        transformProcessor.close();

    }
}
