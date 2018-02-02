public class Coordinates {
  private int longitude;
  private int latitude;
  private int height;

  protected Coordinates(int lo, int la, int h) throws LandingException, NegativeException {
    this.longitude = lo;
    this.latitude = la;
    this.height = h;

    if (lo < 0 || la < 0)
        throw new NegativeException();

    if (this.height > 100)
      this.height = 100;
    else if (this.height < 0)
      throw new LandingException();
  }

  public int getLongitude() { return this.longitude; }
  public int getLatitude() { return this.latitude; }
  public int getHeight() { return this.height; }

  public String toString() {
    return "<" + this.longitude + ", " + this.latitude + ", " + this.height + ">";
  }
}
