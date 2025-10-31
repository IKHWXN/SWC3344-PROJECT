import java.util.*;

public class MissionCompletionPhase {
    private Queue<HeroInfo> gothamQueue;
    private Queue<HeroInfo> metropolisQueue;
    private Queue<HeroInfo> globalQueue;
    private Stack<HeroInfo> completeStack;

    public MissionCompletionPhase(Queue<HeroInfo> gothamQueue, Queue<HeroInfo> metropolisQueue, Queue<HeroInfo> globalQueue) {
        this.gothamQueue = gothamQueue != null ? gothamQueue : new LinkedList<>();
        this.metropolisQueue = metropolisQueue != null ? metropolisQueue : new LinkedList<>();
        this.globalQueue = globalQueue != null ? globalQueue : new LinkedList<>();
        this.completeStack = new Stack<>();
    }

    public void processMissions() {
        System.out.println("\n=== STARTING MISSION PROCESSING (PHASE 3: STACK) ===");

        while (!gothamQueue.isEmpty() || !metropolisQueue.isEmpty() || !globalQueue.isEmpty()) {
            processBatch(gothamQueue, "Gotham City");
            processBatch(metropolisQueue, "Metropolis");
            processBatch(globalQueue, "Global Threat");
        }

        displayCompletedHeroes();
    }

    private void processBatch(Queue<HeroInfo> queue, String cityName) {
        if (queue.isEmpty()) return;

        System.out.println("\n=== Processing next batch for " + cityName + " ===");
        int count = 0;

        while (!queue.isEmpty() && count < 5) {
            HeroInfo hero = queue.poll();
            if (hero != null) {
                System.out.println("Hero " + hero.getHeroName() + " (" + hero.getTeamName() + ") completed all missions.");
                completeStack.push(hero);
                count++;
            }
        }
    }

    private void displayCompletedHeroes() {
        System.out.println("\n===== COMPLETED HEROES STACK (LIFO ORDER) =====");
        if (completeStack.isEmpty()) {
            System.out.println("No heroes have completed missions yet.");
            return;
        }

        while (!completeStack.isEmpty()) {
            HeroInfo hero = completeStack.pop();
            System.out.println("\nHero: " + hero.getHeroName() + " | Team: " + hero.getTeamName());
            System.out.println("Missions Completed:");
            double totalReward = 0;

            List<MissionInfo> missions = hero.getMissions();
            if (missions != null && !missions.isEmpty()) {
                for (MissionInfo mission : missions) {
                    System.out.println("  - " + mission.getMissionType() + " (Threat Level: " + mission.getThreatLevel() + ", Reward: " + mission.getMissionReward() + " Credits)");
                    totalReward += mission.getMissionReward();
                }
            } else {
                System.out.println("  (No missions recorded)");
            }

            System.out.println("Total Reward Earned: " + totalReward + " Credits");
            System.out.println("----------------------------------------------");
        }
    }
}