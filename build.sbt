
name := "dude"

version := "0.0"

scalaVersion := "2.11.8"


// //////
// WEB //
// //////
libraryDependencies += "com.gilt" %% "handlebars-scala" % "2.1.1"

resolvers ++= Seq("Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
  Resolver.bintrayRepo("hseeberger", "maven"))

libraryDependencies ++= {
  val AkkaVersion       = "2.3.9"
  val AkkaHttpVersion   = "2.0.1"
  val Json4sVersion     = "3.2.11"
  Seq(
    "com.typesafe.akka" %% "akka-slf4j"      % AkkaVersion,
    "com.typesafe.akka" %% "akka-http-experimental" % AkkaHttpVersion,
    "ch.qos.logback"    %  "logback-classic" % "1.1.2",
    "org.json4s"        %% "json4s-native"   % Json4sVersion,
    "org.json4s"        %% "json4s-ext"      % Json4sVersion,
    "de.heikoseeberger" %% "akka-http-json4s" % "1.4.2"
    )
}


// //////////
// TESTING //
// //////////

// we should have an eye on 3.0(RC) since it has scala.js support
libraryDependencies += "org.scalatest" % "scalatest_2.10" % "2.2.6" % "test"
libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.12.5" % "test"


// ///////
// MISC //
// ///////
libraryDependencies += "org.typelevel" %% "cats" % "0.6.0"

