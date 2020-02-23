lazy val baseSettings: Seq[Setting[_]] = Seq(
  scalaVersion       := "2.13.1",
  resolvers += Resolver.sonatypeRepo("releases")
)

lazy val chaos_and_software = project.in(file("."))
  .settings(moduleName := "chaos_and_software")
  .settings(baseSettings: _*)
  .aggregate(core, slides)
  .dependsOn(core, slides)

lazy val core = project
  .settings(moduleName := "chaos_and_software-core")
  .settings(baseSettings: _*)

lazy val slides = project
  .settings(moduleName := "chaos_and_software-slides")
  .enablePlugins(MdocPlugin)
  .settings(baseSettings: _*)
  .settings(
    mdocIn := baseDirectory.value / "mdoc",
    mdocOut := baseDirectory.value / "docs",
  )
  .dependsOn(core)