import java.util.LinkedList;
import java.util.Queue;

public class MissionQueue {
    private Queue<HeroInfo> queue;
    private String cityName;

    public MissionQueue(String cityName) {
        this.cityName = cityName;
        this.queue = new LinkedList<>();
    }

    public void enqueue(HeroInfo hero) {
        queue.add(hero);
    }

    public HeroInfo dequeue() {
        return queue.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void displayQueue() {
        System.out.println("=== " + cityName + " Queue ===");
        for (HeroInfo hero : queue) {
            System.out.println(hero);
        }
        System.out.println();
    }

    public String getCityName() {
        return cityName;
    }
    
    public Queue<HeroInfo> getQueue() {
        return queue;
    }

}