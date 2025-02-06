package EventRegistration;

public class TeamEventRegistration extends EventRegistration {
    private int noOfParticipants;
    private int teamNo;
    static int noOfGroups = 0;

    TeamEventRegistration(String name, String nameOfEvent, int noOfParticipants, int teamNo){
        super(name, nameOfEvent,0);
        this.noOfParticipants = noOfParticipants;
        this.teamNo = teamNo;
        noOfGroups++;

        this.registerEvent();
    }

    public int getNoOfParticipants(){
        return this.noOfParticipants;
    }

    public void setNoOfParticipants(int s){
        this.noOfParticipants = s;
    }

    public int getTeamNo(){
        return this.teamNo;
    }

    public void setTeamNo(int s){
        this.teamNo = s;
    }

    public void dispaly(){
        System.out.println("Thank You "+ super.getName() + " for your participation. Your registration fee is: "+super.getRegistrationFee()+"\nYou are participant no: "+this.teamNo);
    }

    @Override
    public void registerEvent(){
        // System.out.println("\nShakeALeg  50\nSing&Win  60\nActathon  80\nPlayAway  100");

        int ShakeALeg = 50;
        int SingAndWin = 60;
        int Actathon = 80;
        int PlayAway = 100;

        if(super.getNameOfEvent().equals("ShakeALeg")){
            super.setRegistrationFee(ShakeALeg*this.noOfParticipants);
        } else if(super.getNameOfEvent().equals("SingAndWin")){
            super.setRegistrationFee(SingAndWin*this.noOfParticipants);
        } else if(super.getNameOfEvent().equals("Actathon")){
            super.setRegistrationFee(Actathon*this.noOfParticipants);
        } else if(super.getNameOfEvent().equals("PlayAway")){
            super.setRegistrationFee(PlayAway*this.noOfParticipants);
        }
    }
}
