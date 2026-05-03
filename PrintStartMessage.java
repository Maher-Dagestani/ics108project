public class PrintStartMessage {
    public static void printStartMessage() {
        System.out.print("\033[H\033[2J"); // this is used to clear the terminal
        System.out.flush();             // this is best practace

        String cyan = "\u001B[36m";
        String blue = "\u001B[34m";
        String reset = "\u001B[0m";

        System.out.println(cyan + " _   ________ _   __________  ___                       _       ");
        System.out.println("| | / /|  ___| | | | ___ \\  \\/  |                      | |      ");
        System.out.println("| |/ / | |_  | | | | |_/ / .  . |   _____   _____ _ __ | |_ ___ ");
        System.out.println("|    \\ |  _| | | | |  __/| |\\/| |  / _ \\ \\ / / _ \\ '_ \\| __/ __|");
        System.out.println("| |\\  \\| |   | |_| | |   | |  | | |  __/" + blue + " \\ V /  __/ | | | |_\\__ \\" + cyan);
        System.out.println("\\_| \\_/\\_|    \\___/\\_|   \\_|  |_/  \\___| \\_/ \\___|_| |_|\\__|___/" + reset);
        System.out.println(blue + "-----------------------------------------------------------------------" + reset);
        System.out.println(cyan + "made by: " + blue + "𝕸𝖆𝖍𝖊𝖗 𝕕𝖆𝖌𝖊𝖘𝖙𝖆𝖓𝖎" + cyan + " and " + blue + "𝕸𝖔𝖍𝖆𝖒𝖆𝖉 𝖂𝖆𝖊𝖑" + reset);
        System.out.println();

        System.out.println("Press \u001B[36mENTER\u001B[0m to start...");
        new java.util.Scanner(System.in).nextLine();
    }
}
