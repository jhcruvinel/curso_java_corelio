package laboratorio2.exercicio.exercicio1;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

public class TweetSubscriber implements Subscriber<Tweet> {

	private Subscription subscription;

	private int counter = 0;

	@Override
	public void onSubscribe(Subscription subscription) {
		System.out.println("Inscrito!");
		this.subscription = subscription;
		this.subscription.request(1);
		System.out.println("Verificando o que h� de novo!");
	}

	@Override
	public void onNext(Tweet tweet) {
		System.out.println("Nova Tweet recebida!");
		System.out.println(
				String.format("O usu�rio %s acabou de Tweetar: %s", tweet.getUsuario(), tweet.getTextoTweet()));
		counter++;
		this.subscription.request(1);
	}

	@Override
	public void onError(Throwable e) {
		e.printStackTrace();
	}

	@Override
	public void onComplete() {
		System.out.println("Isso � tudo por hoje!");
	}

	public int getCounter() {
		return counter;
	}

}