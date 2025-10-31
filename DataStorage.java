import java.io.*;
import java.util.*;

public class DataStorage {
    private LinkedList<HeroInfo> heroList = new LinkedList<>();

    public void loadData(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("[,|]");

                String heroId = parts[0];
                String heroName = parts[1];
                String teamName = parts[2];

                String missionId = parts[3];
                String missionType = parts[4];
                int threatLevel = Integer.parseInt(parts[5]);
                String missionDate = parts[6];
                int expectedDuration = Integer.parseInt(parts[7]);
                int missionReward = Integer.parseInt(parts[8]);

                HeroInfo hero = findHeroById(heroId);
                if (hero == null) {
                    hero = new HeroInfo(heroId, heroName, teamName);
                    heroList.add(hero);
                }

                MissionInfo mission = new MissionInfo(missionId, missionType, threatLevel, missionDate, expectedDuration, missionReward);
                hero.addMission(mission);
            }
            System.out.println("Data loaded successfully!");
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }

    private HeroInfo findHeroById(String heroId) {
        for (HeroInfo hero : heroList) {
            if (hero.getHeroId().equals(heroId)) {
                return hero;
            }
        }
        return null;
    }

    public LinkedList<HeroInfo> getHeroList() {
        return heroList;
    }

    public void printAllData() {
        for (HeroInfo hero : heroList) {
            System.out.println(hero);
            for (MissionInfo mission : hero.getMissions()) {
                System.out.println("   → " + mission);
            }
        }
    }
}
