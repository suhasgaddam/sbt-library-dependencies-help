import sbt.{AutoPlugin, TaskKey, taskKey, Setting, Def}

object HelloPlugin extends AutoPlugin {
  override def trigger = allRequirements

  object autoImport {
    val hello: TaskKey[Unit] = taskKey[Unit]("""Print "Hello World"""")
  }

  import autoImport.hello

  override val projectSettings: Seq[Setting[_]] = Seq(
    hello := Def.task {
      Hello.printer()
    }
  )
}
