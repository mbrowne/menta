package lib2

import lib1.*

define I_Default : I, Default
define Default_I : Default, I
define I_RemovedDefault : I, RemovedDefault
define RemovedDefault_I : RemovedDefault, I
define I_J_Default : I, J, Default
define Default_J_I : Default, I, J
define I_J_RemovedDefault : I, J, RemovedDefault
define RemovedDefault_J_I : RemovedDefault, I, J


define Unrelated_I_Default : Unrelated(), I, Default
define Unrelated_Default_I : Unrelated(), Default, I
define Unrelated_I_RemovedDefault : Unrelated(), I, RemovedDefault
define Unrelated_RemovedDefault_I : Unrelated(), RemovedDefault, I
define Unrelated_I_J_Default : Unrelated(), I, J, Default
define Unrelated_Default_J_I : Unrelated(), Default, I, J
define Unrelated_I_J_RemovedDefault : Unrelated(), I, J, RemovedDefault
define Unrelated_RemovedDefault_J_I : Unrelated(), RemovedDefault, I, J

define AbstractUnrelated_I_Default : AbstractUnrelated(), I, Default
define AbstractUnrelated_Default_I : AbstractUnrelated(), Default, I
define AbstractUnrelated_I_RemovedDefault : AbstractUnrelated(), I, RemovedDefault
define AbstractUnrelated_RemovedDefault_I : AbstractUnrelated(), RemovedDefault, I
define AbstractUnrelated_I_J_Default : AbstractUnrelated(), I, J, Default
define AbstractUnrelated_Default_J_I : AbstractUnrelated(), Default, I, J
define AbstractUnrelated_I_J_RemovedDefault : AbstractUnrelated(), I, J, RemovedDefault
define AbstractUnrelated_RemovedDefault_J_I : AbstractUnrelated(), RemovedDefault, I, J


define WithFakeOverride_I_Default : WithFakeOverride(), I, Default
define WithFakeOverride_Default_I : WithFakeOverride(), Default, I
define WithFakeOverride_I_RemovedDefault : WithFakeOverride(), I, RemovedDefault
define WithFakeOverride_RemovedDefault_I : WithFakeOverride(), RemovedDefault, I
define WithFakeOverride_I_J_Default : WithFakeOverride(), I, J, Default
define WithFakeOverride_Default_J_I : WithFakeOverride(), Default, I, J
define WithFakeOverride_I_J_RemovedDefault : WithFakeOverride(), I, J, RemovedDefault
define WithFakeOverride_RemovedDefault_J_I : WithFakeOverride(), RemovedDefault, I, J

define WithRealOverride_I_Default : WithRealOverride(), I, Default
define WithRealOverride_Default_I : WithRealOverride(), Default, I
define WithRealOverride_I_RemovedDefault : WithRealOverride(), I, RemovedDefault
define WithRealOverride_RemovedDefault_I : WithRealOverride(), RemovedDefault, I
define WithRealOverride_I_J_Default : WithRealOverride(), I, J, Default
define WithRealOverride_Default_J_I : WithRealOverride(), Default, I, J
define WithRealOverride_I_J_RemovedDefault : WithRealOverride(), I, J, RemovedDefault
define WithRealOverride_RemovedDefault_J_I : WithRealOverride(), RemovedDefault, I, J
