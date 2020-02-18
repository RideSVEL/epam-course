package ua.nure.vasilchenko.practice6.part6;

public class Part6 {

    public static void main(String[] args) {
        String path = "";
        String task = "";

            if ("-i".equals(args[0]) || "--input".equals(args[0])) {
                path = args[1];
            } else if ("-i".equals(args[2]) || "--input".equals(args[2])) {
                path = args[3];
            }
            if ("-t".equals(args[0]) || "--task".equals(args[0])) {
                task = args[1];
            } else if ("-t".equals(args[2]) || "--task".equals(args[2])) {
                task = args[3];
            }
            switch (task) {
                case "frequency":
                    Part61 part61 = new Part61(Util.readFile(path));
                    break;
                case "length":
                    Part62 part62 = new Part62(Util.readFile(path));
                    break;
                case "duplicates":
                    Part63 part63 = new Part63(Util.readFile(path));
                    break;
                default:
                    System.out.println("Error");
            }
    }
}
