abstract class Beverage {
    public final void prepare() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    private void boilWater() {
        System.out.println("Gotowanie wody");
    }

    private void pourInCup() {
        System.out.println("Wlewanie do kubka");
    }

    protected abstract void brew();
    protected abstract void addCondiments();
}