public class MissionInfo
{
    private String missionId;
    private String missionType;
    private int threatLevel;
    private String missionDate;
    private int expectedDuration;
    private int missionReward;
    
    public MissionInfo(String missionId, String missionType, int threatLevel, String missionDate, int expectedDuration, int missionReward)
    {
        this.missionId = missionId;
        this.missionType = missionType;
        this.threatLevel = threatLevel;
        this.missionDate = missionDate;
        this.expectedDuration = expectedDuration;
        this.missionReward = missionReward;
    }
    
    public String getMissionId()
    {
        return missionId;
    }
    public String getMissionType()
    {
        return missionType;
    }
    public int getThreatLevel()
    {
        return threatLevel;
    }
    public String getMissionDate()
    {
        return missionDate;
    }
    public int getExpectedDuration()
    {
        return expectedDuration;
    }
    public int getMissionReward()
    {
        return missionReward;
    }
    
    @Override
    public String toString() {
        return "[" + missionId + "] " + missionType + " | Threat: " + threatLevel + " | Date: " + missionDate + " | Duration: " + expectedDuration + " hrs" + " | Reward: " + missionReward;
    }

}