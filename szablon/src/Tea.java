class Tea extends Beverage {
    @Override
    protected void brew() {
        System.out.println("Zaparzanie herbaty");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Dodawanie cytryny");
    }
}