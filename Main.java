import java.util.*;

public class Main {
    public static void main(String[] args) {
        DataStorage storage = new DataStorage();
        storage.loadData("superheroes_missions.txt");

        LinkedList<HeroInfo> heroes = storage.getHeroList();

        MissionQueue gothamQueue = new MissionQueue("Gotham City Route");
        MissionQueue metropolisQueue = new MissionQueue("Metropolis Route");
        MissionQueue globalQueue = new MissionQueue("Global Threat Route");
        
        boolean assignToGotham = true;

        for (HeroInfo hero : heroes) {
            int missionCount = hero.getMissions().size();
            if (missionCount > 3) {
                globalQueue.enqueue(hero);
            } else {
                if (assignToGotham) {
                    gothamQueue.enqueue(hero);
                } else {
                    metropolisQueue.enqueue(hero);
                }
                assignToGotham = !assignToGotham;
            }
        }

        gothamQueue.displayQueue();
        metropolisQueue.displayQueue();
        globalQueue.displayQueue();

        MissionCompletionPhase completion = new MissionCompletionPhase(
        gothamQueue.getQueue(),
        metropolisQueue.getQueue(),
        globalQueue.getQueue()
        );

        completion.processMissions();
    }
}
