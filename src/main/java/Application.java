import model.Chuck;
import model.Omdb;
import model.Owen;
import model.UselessFacts;
import utils.ApiUtils;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class Application {
    public static void main(String[] args) throws InterruptedException{
        System.out.println("Buscando...");
        omdbAPI();
        chuckNorrisApi();
        owenWilsonWowApi();
        uselessFactsApi();
        TimeUnit.MINUTES.sleep(1);
    }

    private static void uselessFactsApi() {
        CompletableFuture.supplyAsync(() ->
                ApiUtils.serviceCall("https://uselessfacts.jsph.pl/random.json?language=en", UselessFacts.class))
                .thenAccept(u -> System.out.println("Uselessfact: " + u.getText()));
    }

    private static void owenWilsonWowApi() {

        CompletableFuture.supplyAsync(() ->
                ApiUtils.serviceCall("https://owen-wilson-wow-api.herokuapp.com/wows/random?results=1", Owen.class))
                .thenAccept(o -> System.out.println("Owen Wilson says: " + o.getFullLine()));
    }

    private static void omdbAPI(){
        CompletableFuture.supplyAsync(() ->
                        ApiUtils.serviceCall("http://www.omdbapi.com/?t=batman&apikey=412d3ea1", Omdb.class))
                .thenAccept(t -> System.out.println("Filme: " + t.getTitle()));
    }

    private static void chuckNorrisApi(){

        CompletableFuture.supplyAsync(() ->
                ApiUtils.serviceCall("https://api.chucknorris.io/jokes/random", Chuck.class))
                .thenAccept(c -> System.out.println("Chuck Norris joke: " + c.getValue()));
    }

}
