public class Main {
    public static void main(String[] args) {
        Beverage tea = new Tea();
        System.out.println("Przygotowanie herbaty:");
        tea.prepare();

        System.out.println();

        Beverage coffee = new Coffee();
        System.out.println("Przygotowanie kawy:");
        coffee.prepare();
    }
}