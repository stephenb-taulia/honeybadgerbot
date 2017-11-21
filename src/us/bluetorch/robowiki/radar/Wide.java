package us.bluetorch.robowiki.radar;

import robocode.AdvancedRobot;
import robocode.RobotDeathEvent;
import robocode.ScannedRobotEvent;
import robocode.util.Utils;

public class Wide extends Radar {

  public Wide(AdvancedRobot robot) {
    super(robot);
  }

  @Override
  public void run() {
    robot.turnRadarRightRadians(Double.POSITIVE_INFINITY);
    do {
      robot.scan();
    } while (true);
  }

  @Override
  public void onScannedRobot(ScannedRobotEvent e, int enemyCount) {
    double radarTurn =
      robot.getHeadingRadians() + e.getBearingRadians() - robot.getRadarHeadingRadians();

    robot.setTurnRadarRightRadians(2.0 * Utils.normalRelativeAngle(radarTurn));
  }

  @Override
  public void onRobotDeath(RobotDeathEvent e) {

  }
}
