public class Students {
    private String Name;
    private int StudentNumber;
    public Students(){
        Name = "";
        StudentNumber = -1;
    }
    public Students(String name, int stdn){
        Name = name;
        StudentNumber = stdn;
    }
    public String getName(){
        return Name;
    }
    public int getSN(){
        return StudentNumber;
    }

    public void setName(String name){
        Name = name;
    }
    public void setSN(int sn){
        StudentNumber = sn;
    }
}
