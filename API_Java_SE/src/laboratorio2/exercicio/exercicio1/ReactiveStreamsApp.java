package laboratorio2.exercicio.exercicio1;

import java.util.List;
import java.util.concurrent.SubmissionPublisher;

public class ReactiveStreamsApp {

   
    public static void main(String[] args) throws InterruptedException {
        SubmissionPublisher<Tweet> publisher = new SubmissionPublisher<>();
        TweetSubscriber TweetSubscriber = new TweetSubscriber();
        publisher.subscribe(TweetSubscriber);
        List<Tweet> postagens = Tweet.obtemListaFicticiaTweets();
        postagens.stream().forEach(p -> publisher.submit(p));

        while (postagens.size() != TweetSubscriber.getCounter()) {
            Thread.sleep(10);
        }

        publisher.close();

    }
    
}