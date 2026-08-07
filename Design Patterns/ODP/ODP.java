
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

interface IObservable {
    void addObserver(IObserver o);
    void removeObserver(IObserver o);
    void notifyObservers();
}

interface IObserver {
    void update();
}


// SRP breaks
class WeatherObservable implements IObservable {
    private List<IObserver> observers = new ArrayList<>();
    private double temp;
    private double hum;

    // Observable activities
    @Override
    public void addObserver(IObserver o) {
        observers.add(o);
    }
    @Override
    public void removeObserver(IObserver o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for(IObserver o : observers) {
            o.update();
        }
    }


    // Bussiness logics
    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
        notifyObservers();
    }

    public double getHum() {
        return hum;
    }

    public void setHum(double hum) {
        this.hum = hum;
        notifyObservers();
    }
}

class NewsObservable implements IObservable {
    private List<IObserver> observers = new ArrayList<>();
    private String headline;

    // Observable activities
    @Override
    public void addObserver(IObserver o) {
        observers.add(o);
    }
    @Override
    public void removeObserver(IObserver o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for(IObserver o : observers) {
            o.update();
        }
    }


    // Bussiness logics
    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
        notifyObservers();
    }
}


class WeatherObserver implements IObserver {
    private WeatherObservable weatherObservable;
    private int id;

    public WeatherObserver(int id, WeatherObservable weatherObservable) {
        this.weatherObservable = weatherObservable;
        this.id = id;
    }

    @Override
    public void update () {
        System.out.println("Weather Observer " + this.id);
        System.out.println("New temperature and humidity update ( " + new Date().getTime() + " ):");
        System.out.println("Temperature: " 
        + this.weatherObservable.getTemp() 
        + "Humidity: " 
        + this.weatherObservable.getHum());
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

public class ODP {
    public static void main(String[] args) {
        // observables 
        WeatherObservable weatherObservable = new WeatherObservable();
        NewsObservable newsObservable = new NewsObservable();

        // add observers
        weatherObservable.addObserver(new WeatherObserver(1, weatherObservable));
        newsObservable.addObserver(new NewsObserver(1, newsObservable));

        weatherObservable.addObserver(new WeatherObserver(2, weatherObservable));
        newsObservable.addObserver(new NewsObserver(2, newsObservable));

        // 
        weatherObservable.setTemp(45.20);
        weatherObservable.setHum(78.26);
        weatherObservable.setTemp(25.20);
        weatherObservable.setTemp(29.20);
        weatherObservable.setHum(70.26);
        
        newsObservable.setHeadline("Good boy becomes bad boy.");
        newsObservable.setHeadline("Someone finally comitted.");
    }
}
