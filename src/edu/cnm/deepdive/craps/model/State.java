package edu.cnm.deepdive.craps.model;

/**
 * <code>State</code> implements a basic state machine for the main play of a
 * game of Craps, starting with the come-out roll and ending with a win or loss
 * of the main bet.
 *
 * @author Nicholas Bennett &amp; Deep Dive Coding Java + Android cohort 6 *
 * @version 1.0
 */
public enum State {
  COME_OUT {
    @Override
    public State change(int roll, int pointValue) {
      switch (roll) {
        case 2:
        case 3:
        case 12:
          return LOSS;
        case 7:
        case 11:
          return WIN;
        default:
          return POINT;
      }
    }
  },
  POINT {
    @Override
    public State change(int roll, int pointValue) {
      if (roll == 7) {
        return LOSS;
      }
      if (roll == pointValue) {
        return WIN;
      }
      return this;
    }
  },
  WIN,
  LOSS;

  /**
   * Applies the specified roll sum to this State and returns the resulting
   * state.  If the game is in a {@link #WIN} or an {@link #LOSS} then no
   * change of state will occur in response to a roll sum value.
   */
  public State change(int roll, int pointValue) {
    return this;
  }

}
