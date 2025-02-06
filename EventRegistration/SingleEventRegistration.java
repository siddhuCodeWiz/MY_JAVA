package EventRegistration;

public class SingleEventRegistration extends EventRegistration {
    private int participantNo;
    static int noOfSingleParcs = 0;

    SingleEventRegistration(String name, String nameOfEvent, int participantNo){
        super(name, nameOfEvent, 0);
        this.participantNo = participantNo;
        noOfSingleParcs++;
        this.registerEvent();
    }

    public int getParticipantNo(){
        return this.participantNo;
    }

    public void setParticipantNo(int s){
        this.participantNo = s;
    }

    @Override
    public void registerEvent(){
        // System.out.println("\nShakeALeg  100\nSingAndWin  150\nPlayAway  130");
        int ShakeALeg = 100;
        int SingAndWin = 150;
        int PlayAway = 130;

        if(super.getNameOfEvent() == "ShakeALeg"){
            super.setRegistrationFee(ShakeALeg);
        } else if(super.getNameOfEvent() == "SingAndWin"){
            super.setRegistrationFee(SingAndWin);
        } else if(super.getNameOfEvent() == "PlayAway"){
            super.setRegistrationFee(PlayAway);
        }
    }
}
