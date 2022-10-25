//English 1101
//Section: 205
//Term: Fall 2022
//Instructor: Dr. Ferguson
//Name: Asher Graham

import java.util.Scanner;
class Main {

    //Status check method
    public static void statusCheck(int intDay, int intHoursLeft, int intEarned, int intEarnedTotal, int intDebt, float fltInterest) {

        //output and if statement deciding whether to use plural or singular hours
        System.out.print("------------\nIt is day " + intDay + ". There ");
        if (intHoursLeft == 1) {
            System.out.print("is 1 hour");
        }
        else {
            System.out.print("are " + intHoursLeft + " hours");
        }
        System.out.println(" left today. \nYou have earned " + intEarned + " credits today and " + intEarnedTotal + " total. This brings your total debt to " +
                intDebt + " credits, with an interest rate of " + (fltInterest * 100) + "%.\n------------");
    }

    //debt increase method
    public static int debtIncrease(int intDebt, float fltInterest, int intPenalty) {
        float fltDebt = intDebt;
        fltDebt = (fltDebt + (fltDebt * fltInterest) + (intPenalty*50));
        intDebt = (int) fltDebt;
        return intDebt;
    }

    //main method
    public static void main(String[] args){

        //declare scanner and variables
        Scanner scan = new Scanner(System.in);
        int intInputMain, intInputSecond, intSleep, intNewDay;
        int intDay = 1, intHoursLeft = 26, intMeals = 0, intEarned = 0, intEarnedTotal = 0, intDebt = 127000, intPenalty = 0, intEff = 100, intMaxEff = 100, intMods = 0;
        float fltInterest = 0.15f, fltWage = 1000f;
        boolean boolStop = false, boolSecond = false;

        //initial output, get name, and begin
        System.out.println("English 1101\nSection: 205\nTerm: Fall 2022\nInstructor: Dr. Ferguson\nName: Asher Graham\n\n\tRhetorical Analysis Multimodal Project\n");
        System.out.println("\n\n\tThis program is a simulation of the life of a Corpus worker on Venus. You are trying to work off your debt, which has  " +
                "been passed down through your family for generations. As the last of your family, the burden is entirely on your shoulders. \n\tType the "+
                "number associated with what you want to do in order to progress.\n\tEnhancements can be rented from the Corpus, which will increase your " +
                "possible wages.\n\tIt is recommended that you sleep at least 6 hours a day and eat twice a day, which takes 1 hour each time, to keep your " +
                "efficiency up.\n\tInterest is applied daily. Should your debt grow too high, a team of Corpus members will arrest you and replace parts of " +
                "you with robotic ones to increase the profit you create. This will lower your debt however, as body parts are worth a lot of credits.\n\tGood luck!" +
                "\n------------------------\n");

        //main game loop, calling methods for individual choices
        while (!boolStop) {
            System.out.println("\tWhat would you like to do?\n1) Check personal status\n2) Go to work\n3) Go home\n4) Search for enhancements\n5) Quit");
            intInputMain = scan.nextInt();
            switch (intInputMain) {

                //call status method
                case 1:
                    statusCheck(intDay, intHoursLeft, intEarned, intEarnedTotal, intDebt, fltInterest);
                    break;

                //work menu
                case 2:
                    //fill in with work method
                    System.out.println("How many hours would you like to work?");
                    intInputSecond = scan.nextInt();
                    intEarned = (int) (intInputSecond * fltWage * (intEff / 100));
                    System.out.println("You earned " + intEarned + " credits. Well done!");
                    intDebt -= intEarned;
                    intEarnedTotal += intEarned;
                    intHoursLeft -= intInputSecond;

                    //new day check
                    if (intHoursLeft <=0 ) {
                        if (intHoursLeft % 26 == 0 ) {
                            intNewDay = (intHoursLeft / 26);
                        }
                        else {
                            intNewDay = (intHoursLeft / 26) + 1;
                        }
                        intDay += intNewDay;
                        intHoursLeft = (26 + (intHoursLeft % 26));
                        intDebt = intNewDay * debtIncrease(intDebt, fltInterest, intPenalty);
                        intEarned = 0;
                        intEff -= 50;
                        intMeals = 0;
                        System.out.println("A new day has begun.");
                    }
                    System.out.println("\n------------");
                    break;

                //home loop, contains status, sleep, eat, go back, and quit options
                case 3:
                    while (!boolSecond) {
                        System.out.println("\tWhat would you like to do?\n1) Check personal status\n2) Sleep\n3) Eat\n4) Go out\n5) Quit");
                        intInputSecond = scan.nextInt();
                        switch (intInputSecond) {

                            //call status method
                            case 1:
                                statusCheck(intDay, intHoursLeft, intEarned, intEarnedTotal, intDebt, fltInterest);
                                break;

                            //sleep
                            case 2:
                                System.out.println("How many hours would you like to sleep?");
                                intSleep = scan.nextInt();

                                //new day check
                                if (intHoursLeft <=0 ) {
                                    if (intHoursLeft % 26 == 0 ) {
                                        intNewDay = (intHoursLeft / 26);
                                    }
                                    else {
                                        intNewDay = (intHoursLeft / 26) + 1;
                                    }
                                    intDay += intNewDay;
                                    intHoursLeft = (26 + (intHoursLeft % 26));
                                    intDebt = intNewDay * debtIncrease(intDebt, fltInterest, intPenalty);
                                    intEarned = 0;
                                    intEff -= 50;
                                    intMeals = 0;
                                    System.out.println("A new day has begun.");
                                }
                                if (intSleep <= 6) {
                                    intEff += ((50 * intSleep) / 6);
                                } else {
                                    intEff += 50;
                                }
                                if (intEff > intMaxEff) {
                                    intEff = intMaxEff;
                                }
                                System.out.println("You wake up feeling refreshed. Your efficiency has been restored.");
                                intHoursLeft -= intSleep;
                                break;

                            //eat
                            case 3:
                                //new day check
                                if (intHoursLeft <=0 ) {
                                    if (intHoursLeft % 26 == 0) {
                                        intNewDay = (intHoursLeft / 26);
                                    } else {
                                        intNewDay = (intHoursLeft / 26) + 1;
                                    }
                                    intDay += intNewDay;
                                    intHoursLeft = (26 + (intHoursLeft % 26));
                                    intDebt = intNewDay * debtIncrease(intDebt, fltInterest, intPenalty);
                                    intEarned = 0;
                                    intEff -= 50;
                                    intMeals = 0;
                                    System.out.println("A new day has begun.");
                                }
                                if (intMeals < 2) {
                                    intEff += 20;
                                    if (intEff > intMaxEff) {
                                        intEff = intMaxEff;
                                    }
                                    System.out.println("You feel satisfied. Your efficiency has been restored.");
                                }
                                else {
                                    System.out.println("You feel satisfied, but not any more efficient");
                                }
                                intHoursLeft -= 1;
                                intMeals++;
                                break;

                            //end current switch, go back to outer switch
                            case 4:
                                boolSecond = true;
                                break;

                            //quit
                            case 5:
                                boolSecond = true;
                                boolStop = true;
                                break;
                            default:
                                System.out.println("Invalid input. Please try again");
                        }
                    }
                    System.out.println("\n------------");
                    break;

                //enhancement method
                //works
                case 4:
                    System.out.println("You found a shop with modifications and enhancements you can install. Would you like to install one?\n1) Yes\n2) No");
                    intInputSecond = scan.nextInt();
                    if (intInputSecond == 1) {
                        intMods++;
                        intHoursLeft -= 6;
                        switch (intMods) {
                            case 1:
                                System.out.println("You have replaced your legs with robotic enhancements. You can now stand longer and lift more weight, " +
                                        "increasing your productivity.\nThe Corpus have been generous enough to offer this for no cost, apart from an " +
                                        "increased interest rate.");
                                fltInterest = 0.23f;
                                fltWage = 1400f;
                                break;
                            case 2:
                                System.out.println("You have replaced your arms with robotic prosthetics, allowing you to work harder and more accurately.\nThe " +
                                        "Corpus have been generous enough to offer this for no cost, apart from an increased interest rate.\n");
                                fltInterest = 0.28f;
                                fltWage = 1600f;
                                break;
                            case 3:
                                System.out.println("You have replaced your internal organs, apart from your head, with enhanced prosthetics. You are much more " +
                                        "durable, and need no breaks during work hours.\n The Corpus have been generous enough to offer this for no cost, apart " +
                                        "from an increased interest rate.");
                                fltInterest = 0.3f;
                                fltWage = 1800f;
                                break;
                            case 4:
                                System.out.println("You have replaced your head with a robotic apparatus. You will no longer feel tired, or pain, or anything at " +
                                        "all.\n The Corpus have been generous enough to offer this for no cost, apart from an increased interest rate.");
                                fltInterest = 0.34f;
                                fltWage = 2000f;
                                break;
                        }
                        //new day check
                        if (intHoursLeft <=0 ) {
                            if (intHoursLeft % 26 == 0) {
                                intNewDay = (intHoursLeft / 26);
                            } else {
                                intNewDay = (intHoursLeft / 26) + 1;
                            }
                            intDay += intNewDay;
                            intHoursLeft = (26 + (intHoursLeft % 26));
                            intDebt = intNewDay * debtIncrease(intDebt, fltInterest, intPenalty);
                            intEarned = 0;
                            intEff -= 50;
                            intMeals = 0;
                            System.out.println("A new day has begun.");
                            System.out.println("\n------------");
                        }
                    }
                    break;

                //quit
                case 5:
                    boolStop = true;
                    break;
                    //works
                default:
                    System.out.println("Invalid input. Please try again");
            }

            //repos body part if debt is too high
            if (intDebt >= 300000) {
                System.out.println("Your debt has grown too high. The Corpus sent a Reposition team to your house and arrested you.");
                intMods++;
                intHoursLeft -= 6;
                switch (intMods) {
                    case 1:
                        System.out.println("Your legs have been replaced with robotic enhancements. You can now stand longer and lift more weight, " +
                                "increasing your productivity.\nThe Corpus have been generous enough to reduce your debt as a token of thanks. Your " +
                                "legs were worth enough credits to significantly reduce your debt. To ensure you remain motivated to work hard, your " +
                                "interest rate has been raised.");
                        fltInterest = 0.23f;
                        fltWage = 1400f;
                        intDebt = 170000;
                        break;
                    case 2:
                        System.out.println("Your arms have been replaced with robotic prosthetics, allowing you to work harder and more accurately.\n" +
                                "The Corpus have been generous enough to reduce your debt as a token of thanks. Your legs were worth enough credits to " +
                                "significantly reduce your debt. To ensure you remain motivated to work hard, your interest rate has been raised.");
                        fltInterest = 0.28f;
                        fltWage = 1600f;
                        intDebt = 160000;
                        break;
                    case 3:
                        System.out.println("Your internal organs, apart from your head, have been replaced with enhanced prosthetics. You are much more " +
                                "durable, and need no breaks during work hours.\n The Corpus have been generous enough to reduce your debt as a token of " +
                                "thanks. Your organs were worth enough credits to significantly reduce your debt. To ensure you remain motivated to work " +
                                "hard, your interest rate has been raised.");
                        fltInterest = 0.3f;
                        fltWage = 1800f;
                        intDebt = 150000;
                        break;
                    case 4:
                        System.out.println("Your head has been replaced with a robotic apparatus. You will no longer feel tired, or pain, or anything at " +
                                "all.\n The Corpus have been generous enough to reduce your debt as a token of thanks. Your head was worth enough credits " +
                                "to significantly reduce your debt. To ensure you remain motivated to work hard, your interest rate has been raised.");
                        fltInterest = 0.34f;
                        fltWage = 2000f;
                        intDebt = 140000;
                        break;
                }
                //new day check
                if (intHoursLeft <=0 ) {
                    if (intHoursLeft % 26 == 0 ) {
                        intNewDay = (intHoursLeft / 26);
                    }
                    else {
                        intNewDay = (intHoursLeft / 26) + 1;
                    }
                    intDay += intNewDay;
                    intHoursLeft = (26 + (intHoursLeft % 26));
                    intDebt = intNewDay * debtIncrease(intDebt, fltInterest, intPenalty);
                    intEarned = 0;
                    intEff -= 50;
                    intMeals = 0;
                    System.out.println("A new day has begun.");
                }
            }
        }

        //if statement deciding fate and final status message
        if (intMods == 4) {
            System.out.println("You are entirely comprised of robotic parts owned by the Corpus. As none of you is human anymore, and you cannot repay what you owe, " +
                    "you will be regarded as any other robot.\nYou are now the property of the Corpus, and will work until you break and then be melted down " +
                    "for scrap. Your debt will be passed to any heirs you may have.\n------------");
        }
        System.out.println("You made it to day " + intDay + ", and earned " + intEarnedTotal + " credits total. Your final debt was " + intDebt + " credits, with an " +
                "interest rate of " + (fltInterest * 100) + "%.");
    }
}
/*notes
balance eating and sleeping
double check math
test with a large variety of values - debt should never be below 127000 at the start of a new day
 */