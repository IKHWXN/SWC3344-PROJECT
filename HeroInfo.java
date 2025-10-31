import java.util.ArrayList;
import java.util.List;

public class HeroInfo
{
    private String heroId;
    private String heroName;
    private String teamName;
    private List<MissionInfo> missions;
    
    public HeroInfo(String heroId, String heroName, String teamName)
    {
        this.heroId = heroId;
        this.heroName = heroName;
        this.teamName = teamName;
        this.missions = new ArrayList<>();
    }
    
    public void addMission(MissionInfo mission)
    {
        missions.add(mission);
    }
    public List<MissionInfo> getMissions()
    {
        return missions;
    }
    
    public String getHeroId()
    {
        return heroId;
    }
    public String getHeroName()
    {
        return heroName;
    }
    public String getTeamName()
    {
        return teamName;
    }
    
    @Override
    public String toString() {
        return "Hero ID: " + heroId + " | Name: " + heroName + " | Team: " + teamName;
    }

}