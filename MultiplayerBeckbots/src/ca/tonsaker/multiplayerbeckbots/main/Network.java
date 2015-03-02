package ca.tonsaker.multiplayerbeckbots.main;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.EndPoint;

// This class is a convenient place to keep things common to both the client and server.
public class Network {
        static public final int port = 54555;

        // This registers objects that are going to be sent over the network.
        static public void register (EndPoint endPoint) {
                Kryo kryo = endPoint.getKryo();
                kryo.register(Login.class);
                kryo.register(RegistrationRequired.class);
                kryo.register(Register.class);
                kryo.register(AddRobot.class);
                kryo.register(UpdateRobot.class);
                kryo.register(RemoveRobot.class);
                kryo.register(RobotNET.class);
                kryo.register(MoveRobot.class);
        }

        static public class Login {
                public String name;
        }

        static public class RegistrationRequired {
        }

        static public class Register {
                public String name;
        }

        static public class UpdateRobot {
                public int id, x, y;
        }

        static public class AddRobot {
                public RobotNET character;
        }

        static public class RemoveRobot {
                public int id;
        }

        static public class MoveRobot {
                public int x, y;
        }
}