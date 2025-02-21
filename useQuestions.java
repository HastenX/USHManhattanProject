public class useQuestions {
    Thread thread;
    public void path() {
        new Intermidiate(
            "\nWelcome, this game is designed to simulate the stress of the US and the alternative outcomes\nthat the Manhattan project could have had.All you have to do is type enter to simulate enacting\na decision into motion, to approve an outcome... or wait the 10 seconds out.\npress Enter when you are ready to proceed:"
            );
        Questions questionOne = new Questions(
            "1939, August 2nd: FDR recieves a letter from Einstein, warning him about the Nazi's Uranverein, nuclear program"
        );
        new Intermidiate(
            "Entered true",
            "Entered false",
            questionOne.getResponse().get());
    }
}