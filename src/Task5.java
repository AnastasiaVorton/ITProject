class Task5 {

    // amount of every type of pills. It corresponds to heights of out team members
    private static final int A = 175;
    private static final int B = 195;
    private static final int C = 160;
    private static final int D = 182;

    // amount of all pills
    private static final int AMOUNT = A + B + C + D;

    // probabilities of death for every type
    private static final double DEATH_PROB_FROM_KILLING = 0.9;
    private static final double DEATH_PROB_FROM_NORMAL  = 0.05;
    private static final double DEATH_PROB_FROM_PLACEBO = 0.007;
    private static final double DEATH_PROB_FROM_VITAMIN = 0.0;

    static double computeFirstSubtask () {

        //compute probability of death with marginal probability formula
        double probabilityOfDeath = DEATH_PROB_FROM_KILLING * (double)A / (double)AMOUNT +
                DEATH_PROB_FROM_NORMAL  * (double)B / (double)AMOUNT +
                DEATH_PROB_FROM_PLACEBO * (double)C / (double)AMOUNT +
                DEATH_PROB_FROM_VITAMIN * (double)D / (double)AMOUNT;

        //compute answer with Bayes formula
        return DEATH_PROB_FROM_KILLING * (double)A / (double)AMOUNT / probabilityOfDeath;
    }

    static double computeSecondSubtask () {
        //compute probability of survival with joint probability formula
        return   (1 - DEATH_PROB_FROM_KILLING) *
                (1 - DEATH_PROB_FROM_NORMAL)  *
                (1 - DEATH_PROB_FROM_PLACEBO) *
                (1 - DEATH_PROB_FROM_VITAMIN);
    }

    static void showSolution () {
        System.out.println("Probability that victim has taken killing pill given that he has died:");
        System.out.printf("%.3f", Task5.computeFirstSubtask());
        System.out.println();
        System.out.println("Probability that victim has survived after taking all types of pills independently:");
        System.out.printf("%.3f", Task5.computeSecondSubtask());
    }
}
