public enum Plausibility{
    ONE_TRUE("Shortly after reading the letter by Einstein, he appointed a nuclear committee and in late 1941, the Manhattan project had started-- both fueled by the necessity to beat the Japanese and the Uranverein hallow nuclear program (by which received a fraction of the funding that the US had, and was canceled upon the Manhattan’s startup)", false), 
    ONE_FALSE("Although FDR hadn’t received a letter from Einstein about the Uranverein program, word would’ve eventually spread around the globe and spark the Manhattan project. However, it would’ve been most likely delayed in comparison to being directly informed by Einstein. But for the sake of this game, we will continue under the assumption that the program has still started.", false),

    TWO_TRUE("The Manhattan project continued, allowing for the furthering of nuclear weapon development. Depending on later decisions, this sets up the US to face the ethical dilemma of the Trinity testing and the bombing of Japan", false), 
    TWO_FALSE("The Manhattan project was halted. This prevented the furthering of nuclear technology for now-- until the dangerous mantle of nuclear technology is lifted again. This will force the US to have to do a ground invasion of Japan, to slowly finish the war in August 1945-- with mass casualties on both sides…", true),

    THREE_TRUE("The bomb was tested. As predicted it did not light the atmosphere on fire, and the US now has the capacity to use nuclear bombs against Japan. Nuclear warfare has been realized by the US. Not to mention the unforeseen consequences of nearby residences, experiencing  what we now call nuclear sickness.", false), 
    THREE_FALSE("In fear, the Trinity test had never occurred to avoid the death of the world. And although the US could claim to have this power, it would not be used. This will force the US into a ground invasion against Japan in August 1945, which will result in numerous casualties on both sides. ", true),

    FOUR_TRUE("Nagasaki and Hiroshima-- an industrial and port city-- were bombed after Japan’s refusement to complete surrender, by which they then agreed to the terms of surrender. Thousands of citizens were bombed in the crossfire of this conflict, but it had saved American lives and the Japanese soldier lives that would have been lost to a ground invasion. This ended the war in a swift 8 days.", true),
    FOUR_FALSE("The US proceeded to mainland Japan-- ignoring their nuclear weapons-- and defeated Japan with immense casualties on both sides. The conflict was drawn out; not helped by the suicidal morale of Japaneese solidgers. But American and Japanese soldiers alike were killed unnecessarily with the power of nuclear weapons on the US’s fingertips…", true);

    public boolean ending;
    public String txt;
    Plausibility(String txt, boolean ending) {
        this.txt = txt;
        this.ending = ending;
    }
}
