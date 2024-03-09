package org.gts.bst.events.quests;


/**
 *
 * @author Gregory
 */
public enum QuestDragonfly {
  q0(""), // not yet available
  q1(""), // must go to Baratas
  q2(""), // must go to Melina
  q3(""), // must go to Regulas
  q4(""), // must go to Zalkon
  q5(""), // dragonfly destroyed
  q6(""); // quest complete; have shield
  public final String name;
  public final int id;

  private QuestDragonfly(String s) {
    name = s;
    id = ordinal();
  }
}
//private int _questStatusDragonfly = 0;
// 0 = not available, 1 = Go to Baratas, 2 = Go to Melina, 3 = Go to Regulas, 4 = Go to Zalkon, 5 = Dragonfly destroyed, 6 = Got Shield
