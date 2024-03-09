package org.gts.bst.events.quests;


/**
 *
 * @author Gregory
 */
public enum QuestArtifact {
  q0("Quest not started yet."),
  q1("Has artifact on board."),
  q2("Artifact not on board.");
  public final String name;
  public final int id;

  private QuestArtifact(String s) {
    name = s;
    id = ordinal();
  }
}
//private int _questStatusArtifact = 0; // 0 = not given yet, 1 = Artifact on board, 2 = Artifact no longer on board (either delivered or lost)
