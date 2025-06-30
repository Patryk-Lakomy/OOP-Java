class Coffee extends Beverage {
    @Override
    protected void brew() {
        System.out.println("Parzenie kawy");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Dodawanie mleka i cukru");
    }
}