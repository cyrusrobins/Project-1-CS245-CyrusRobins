public class Run { //contains data about various runs in the array
    private int runLength;
    private int startingIndex;
    private int endingIndex;

    public Run(int runLength,int startingIndex){
        this.runLength = runLength;
        this.startingIndex = startingIndex;
        this.endingIndex = startingIndex + runLength - 1;
    }

    public int getStartingIndex() {
        return startingIndex;
    }

    public int getRunLength(){
        return runLength;
    }

    public int getEndingIndex(){
        return endingIndex;
    }

    public String toString(){
        return "This was a run of size " + runLength + " starting at index " + startingIndex;
    }
}
