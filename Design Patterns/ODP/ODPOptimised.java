import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ODPOptimised {
    public static void main(String[] args) {
        // observables 
        NewsObservable newsObservable = new NewsObservable();

        // add observers
        newsObservable.addObserver(new NewsObserver(1, newsObservable));
        newsObservable.addObserver(new NewsObserver(2, newsObservable));

        // 
        newsObservable.setHeadline("Good boy becomes bad boy.");
        newsObservable.setHeadline("Someone finally comitted.");
    }
}

// separating common activities of observables from the specific ones --> SRP satisfies
class IObservable {
    private List<IObserver> observers = new ArrayList<>();

    public void addObserver(IObserver o) {
        observers.add(o);
    }
    
    public void removeObserver(IObserver o) {
        observers.remove(o);
    }

    
    public void notifyObservers() {
        for(IObserver o : observers) {
            o.update();
        }
    }
}

interface IObserver {
    void update();
}

class NewsObservable extends IObservable {
    private String headline;

    // Bussiness logics
    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
        notifyObservers();
    }
}


class NewsObserver implements IObserver {
    private NewsObservable newsObservable;
    private int id;

    public NewsObserver(int id, NewsObservable newsObservable) {
        this.id = id;
        this.newsObservable = newsObservable;
    }

    @Override
    public void update() {
        System.out.println("News Observer " + this.id);
        System.out.println("New headline update ( " + new Date().getTime() + " ):");
        System.out.println("Headline: " 
        + this.newsObservable.getHeadline());
    }
}