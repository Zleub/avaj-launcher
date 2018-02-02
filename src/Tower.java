class Tower {
  private java.util.Vector<Flyable> observers = new java.util.Vector<Flyable>();

  public void register(Flyable flyable) {
    System.out.println(flyable + " got registered");
    this.observers.add(flyable);
  };
  public void unregister(Flyable flyable) {
    this.observers.remove(flyable);
    System.out.println(flyable + " got unregistered");
  };

  protected void conditionsChanged() {
    if (this.observers.size() > 0)
      System.out.println("conditionsChanged");

    java.util.Vector<Flyable> _observers = new java.util.Vector<Flyable>(this.observers);
    for ( Flyable f : _observers ) {
       f.updateConditions();
    }
  };
}
