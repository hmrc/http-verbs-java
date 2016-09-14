import de.heikoseeberger.sbtheader.license.Apache2_0
import uk.gov.hmrc.HeaderSettings
import play.core.PlayVersion

name := "http-verbs-java"
autoScalaLibrary := false

sources in (Compile, doc) <<= sources in (Compile, doc) map { _.filterNot(_.getName endsWith ".scala") }

testFrameworks := Seq(TestFrameworks.JUnit)

// [START] Temporary solution until release of new version of sbt-auto-build with junit fix
headers += { "java" -> Apache2_0(HeaderSettings.copyrightYear, HeaderSettings.copyrightOwner) }

testOptions in Test := Seq()
testOptions in Test += Tests.Argument(TestFrameworks.Specs2, "sequential", "true", "junitxml", "console")
testOptions in Test += Tests.Argument(TestFrameworks.JUnit, "--ignore-runners=org.specs2.runner.JUnitRunner", "-q", "-v", "-a")
testOptions in Test += Tests.Argument(TestFrameworks.ScalaTest, "-o", "-u", "target/test-reports", "-h", "target/test-reports/html-report")
// [END] Temporary solution until release of new version of sbt-auto-build with junit fix

val plugins = SbtAutoBuildPlugin && SbtGitVersioning

val compileDependencies = Seq(
  "uk.gov.hmrc" %% "http-verbs" % "5.0.0"
)


val testDependencies = Seq(
  "uk.gov.hmrc" %% "http-verbs-test" % "0.1.0",
  "org.pegdown" % "pegdown" % "1.6.0",
  "commons-codec" % "commons-codec" % "1.7",
  "com.novocode" % "junit-interface" % "0.10",
  "com.typesafe.play" %% "play-test" % PlayVersion.current,
  "com.github.tomakehurst" % "wiremock" % "1.52"
).map(d => d % Test)

libraryDependencies ++= compileDependencies
libraryDependencies ++= testDependencies

lazy val `http-verbs-java` = project in file(".") enablePlugins plugins