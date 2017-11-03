package org.strykeforce.thirdcoast.telemetry.tct.talon.config.enc;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.jline.terminal.Terminal;
import org.strykeforce.thirdcoast.telemetry.tct.Command;
import org.strykeforce.thirdcoast.telemetry.tct.CommandAdapter;
import org.strykeforce.thirdcoast.telemetry.tct.Menu;
import org.strykeforce.thirdcoast.telemetry.tct.talon.config.SubConfigScope;

@Module
public abstract class EncoderMenuModule {

  public final static List<String> MENU_ORDER = Arrays.asList(
      SelectTypeCommand.NAME,
      SetPositionCommand.NAME,
      ReverseSensorCommand.NAME,
      ReverseOutputCommand.NAME,
      VelocityMeasurementPeriodCommand.NAME,
      VelocityMeasurementWindowCommand.NAME
  );

  @SubConfigScope
  @Provides
  @EncoderMenu
  public static CommandAdapter configCommandsAdapter(@EncoderMenu Set<Command> commands) {
    return new CommandAdapter(commands);
  }

  @SubConfigScope
  @Provides
  @EncoderMenu
  public static Menu configMenu(@EncoderMenu CommandAdapter commandAdapter, Terminal terminal) {
    return new Menu(commandAdapter, terminal);
  }

   @SubConfigScope
   @Binds
   @IntoSet
   @EncoderMenu
   public abstract Command selectTypeCommand(SelectTypeCommand command);

  @SubConfigScope
  @Binds
  @IntoSet
  @EncoderMenu
  public abstract Command setPositionCommand(SetPositionCommand command);

  @SubConfigScope
  @Binds
  @IntoSet
  @EncoderMenu
  public abstract Command reverseSensorCommand(ReverseSensorCommand command);

  @SubConfigScope
  @Binds
  @IntoSet
  @EncoderMenu
  public abstract Command reverseOutputCommand(ReverseOutputCommand command);

  @SubConfigScope
  @Binds
  @IntoSet
  @EncoderMenu
  public abstract Command velocityMeasurementWindowCommand(VelocityMeasurementWindowCommand command);

  @SubConfigScope
  @Binds
  @IntoSet
  @EncoderMenu
  public abstract Command velocityMeasurementPeriodCommand(VelocityMeasurementPeriodCommand command);
}