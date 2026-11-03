package hu.bme.mit.spaceship;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TorpedoStoreTest {
  @Test
  void rejectsNonPositiveRequests() {
    TorpedoStore store = new TorpedoStore(3);
    assertThrows(IllegalArgumentException.class, () -> store.fire(0));
    assertThrows(IllegalArgumentException.class, () -> store.fire(-1));
    assertEquals(3, store.getTorpedoCount());
  }

  @Test
  void rejectsRequestsExceedingStock() {
    TorpedoStore store = new TorpedoStore(3);
    assertThrows(IllegalArgumentException.class, () -> store.fire(4));
    assertEquals(3, store.getTorpedoCount());
  }
}
