/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gts.bst.events.quests;


/**
 *
 * @author Gregory
 */
public enum QuestWild {
  q0,// day 0: not delivered
  q1,// day 1 - 11: Wild on board
  q2;// day 12: Wild delivered
}
//private int _questStatusWild = 0; // 0 = not delivered, 1-11 = on board, 12 = delivered
/*
//case WildArrested:
//  dr = (new FormAlert("Wild Arrested", "Jonathan Wild is arrested, and taken away to stand trial.",
//      "Ok", DialogResult.OK, null, DialogResult.None, args)).ShowDialog(wp);
//  break;
//case WildChatsPirates:
//  dr = (new FormAlert("Wild Chats With Pirates", "The Pirate Captain turns out to be an old associate of Jonathan Wild's. They talk about old times, and you get the feeling that Wild would switch ships if the Pirates had any quarters available.",
//      "Ok", DialogResult.OK, null, DialogResult.None, args)).ShowDialog(wp);
//  break;
//case WildGoesPirates:
//  dr = (new FormAlert("Wild Goes With Pirates", "The Pirate Captain turns out to be an old associate of Jonathan Wild's, and invites him to go to Kravat aboard the Pirate ship. Wild accepts the offer and thanks you for the ride.",
//      "Ok", DialogResult.OK, null, DialogResult.None, args)).ShowDialog(wp);
//  break;
//case WildLeavesShip:
//  dr = (new FormAlert("Wild Leaves Ship", "Jonathan Wild leaves your ship, and goes into hiding on ^1.",
//      "Ok", DialogResult.OK, null, DialogResult.None, args)).ShowDialog(wp);
//  break;
//case WildSculpture:
//  dr = (new FormAlert("Wild Eyes Sculpture", "Jonathan Wild sees the stolen sculpture. \"Wow, I only know of one of these left in the whole Universe!\" he exclaims, \"Geurge Locas must be beside himself with it being stolen.\" He seems very impressed with you, which makes you feel much better about the item your delivering.",
//      "Ok", DialogResult.OK, null, DialogResult.None, args)).ShowDialog(wp);
//  break;
//case WildWontBoardLaser:
//  dr = (new FormAlert("Wild Won't Board Ship", "Jonathan Wild isn't willing to go with you if you're not armed with at least a Beam Laser. He'd rather take his chances hiding out here." + Strings.newline,
//      "Ok", DialogResult.OK, null, DialogResult.None, args)).ShowDialog(wp);
//  break;
//case WildWontBoardReactor:
//  dr = (new FormAlert("Wild Won't Board Ship", "Jonathan Wild doesn't like the looks of that Ion Reactor. He thinks it's too dangerous, and won't get on board.",
//      "Ok", DialogResult.OK, null, DialogResult.None, args)).ShowDialog(wp);
//  break;
//case WildWontStayAboardLaser:
//  dr = (new FormAlert("Wild Won't Stay Aboard", "Jonathan Wild isn't about to go with you if you're not armed with at least a Beam Laser. He'd rather take his chances hiding out here on ^1." + Strings.newline,
//      "Say Goodbye to Wild", DialogResult.OK, "Cancel", DialogResult.Cancel, args)).ShowDialog(wp);
//  break;
//case WildWontStayAboardReactor:
//  dr = (new FormAlert("Wild Won't Stay Aboard", "Jonathan Wild isn't willing to go with you if you bring that Reactor on board. He'd rather take his chances hiding out here on ^1." + Strings.newline,
//      "Say Goodbye to Wild", DialogResult.OK, "Cancel", DialogResult.Cancel, args)).ShowDialog(wp);
//  break;
 */

//private int _questStatusExperiment = 0; // 0 = not given yet, 1-11 = days from start; 12 = performed, 13 = cancelled
//private int _questStatusGemulon = 0; // 0 = not given yet, 1-7 = days from start, 8 = too late, 9 = in time, 10 = done
//private int _questStatusJapori = 0; // 0 = no disease, 1 = Go to Japori (always at least 10 medicine cannisters), 2 = Assignment finished or canceled
//private int _questStatusJarek = 0; // 0 = not delivered, 1-11 = on board, 12 = delivered
//private int _questStatusMoon = 0; // 0 = not bought, 1 = bought, 2 = claimed
//private int _questStatusPrincess = 0; // 0 = not available, 1 = Go to Centauri, 2 = Go to Inthara, 3 = Go to Qonos, 4 = Princess Rescued, 5-14 = On Board, 15 = Princess Returned, 16 = Got Quantum Disruptor
//private int _questStatusReactor = 0; // 0 = not encountered, 1-20 = days of mission (bays of fuel left = 10 - (ReactorStatus / 2), 21 = delivered, 22 = Done
//private int _questStatusScarab = 0; // 0 = not given yet, 1 = not destroyed, 2 = destroyed - upgrade not performed, 3 = destroyed - hull upgrade performed
//private int _questStatusSculpture = 0; // 0 = not given yet, 1 = on board, 2 = delivered, 3 = done
//private int _questStatusSpaceMonster = 0; // 0 = not available, 1 = Space monster is in Acamar system, 2 = Space monster is destroyed, 3 = Claimed reward
