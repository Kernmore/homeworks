package academy.prog.reflection.additional;


public class Main {

    public static void main(String[] args) throws IllegalAccessException {
        String[] strings = new String[]{"Hello", "Goodbye", "etc."};
        Data data = new Data("Gleb", "Roker", "Surf", 25, 3, new Person("t4ext", 45, "yes"), strings);

        GsonSerialize<Data> gser = new GsonSerialize<>();

        try {
            gser.run(data);
            Data newData = gser.getFrom();
            System.out.println(newData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
